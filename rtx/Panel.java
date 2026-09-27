import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Panel extends JPanel {
    /* technicke konstanty */
    private final int WIDTH = 1650;
    private final int HEIGHT = 900;

    private final int FOV = 60;

    KeyHandler keyHandler = new KeyHandler();

    /* herni konstanty */
    int[][] map = {
        {1,1,1,1,1,1,1,2,2,1,2,1},
        {1,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,2,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,2},
        {1,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,1,1,1,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,2},
        {1,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,1},
        {1,1,1,1,1,1,1,2,2,1,2,1}
    };

    double playerX = 1;
    double playerY = 1;

    double rotation = Math.PI / 4;

    public void startThread() {
        Timer timer = new Timer(1000/60, e -> {
            update();
            repaint();
        });
        timer.start();
    }

    Panel() {
        this.setSize(WIDTH,HEIGHT);
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
    }

    public void update() {
        if (keyHandler.upDown) {
            playerX += 0.1*Math.cos(rotation);
            playerY += 0.1*Math.sin(rotation);
        }
        if (keyHandler.downDown) {
            playerX -= 0.1*Math.cos(rotation);
            playerY -= 0.1*Math.sin(rotation);
        }
        if (keyHandler.leftDown) {
            rotation -= Math.PI / 64;
        }
        if (keyHandler.rightDown) {
            rotation += Math.PI / 64;
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(27));

        /* zem a strop */
        g2.setColor(new Color(160, 160, 160));
        g2.fillRect(0, 0, WIDTH, HEIGHT/2);
        g2.setColor(new Color(80, 80, 80));
        g2.fillRect(0, HEIGHT/2, WIDTH, HEIGHT/2);

        // basic render
        for (int i = 0 ; i < FOV ; i++) {
            double rotationIndex = rotation + Math.toRadians(i - 30);
            double tx = playerX;
            double ty = playerY;
            int n = 0;
            double h;
            while (true) {
                tx += 0.02 * Math.cos(rotationIndex);
                ty += 0.02 * Math.sin(rotationIndex);
                n++;
                if (map[(int)tx][(int)ty] == 1) {
                    g2.setColor(new Color(0, 0, 0));
                    h = (1 / (0.04 * n)) * 1500;
                    break;
                }
                if (map[(int)tx][(int)ty] == 2) {
                    g2.setColor(new Color(50, 50, 50));
                    h = (1 / (0.04 * n)) * 1500;
                    break;
                }
            }
            g2.drawLine(i*(WIDTH/FOV), (int)(HEIGHT/2)+(int)(h/2), i*(WIDTH/FOV), (int)(HEIGHT/2)-(int)(h/2));
        }
    }
}
