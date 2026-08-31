import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.Timer;

import javax.swing.JPanel;

public class Panel extends JPanel {
    private Timer timer;
    KeyHandler keyHandler = new KeyHandler();

    final int GAME_HEIGHT = 600;
    final int GAME_WIDTH = 1080;

    int leftPadY = GAME_HEIGHT / 2;
    int rightPadY = GAME_HEIGHT / 2;

    final int padWidth = 20;
    final int padHeight = 100; //60
    final int padSpeed = 10;

    Ball ball = new Ball((GAME_WIDTH/2)-10, (GAME_HEIGHT/2)-10, 20, 20);

    Panel() {
        this.setPreferredSize(new Dimension(GAME_WIDTH, GAME_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);

        this.addKeyListener(keyHandler);
        this.setFocusable(true);
    }

    public final int fps = 60;
    public void startThread() {
        timer = new Timer(1000 / fps, e -> {
            update();
            repaint();
        });
        timer.start();
    }

    public void update() {
        ball.go();
        if (ball.x >= (GAME_WIDTH-(padWidth/2)*3)-20 && ball.y >= rightPadY && ball.y <= rightPadY+padHeight) {
            ball.xVel = -ball.xVel;
        }
        if (ball.x <= (0+padWidth/2)+padWidth && ball.y >= leftPadY && ball.y <= leftPadY+padHeight) {
            ball.xVel = -ball.xVel;
        }
        /***************************** */
        if (keyHandler.sDown && leftPadY+padHeight < GAME_HEIGHT) {
            leftPadY += padSpeed;
        } else if (keyHandler.wDown && leftPadY > 0) {
            leftPadY -= padSpeed;
        }
        if (keyHandler.doleDown && rightPadY+padHeight < GAME_HEIGHT) {
            rightPadY += padSpeed;
        } else if (keyHandler.horeDown && rightPadY > 0) {
            rightPadY -= padSpeed;
        }
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.GRAY);
        g.drawLine(GAME_WIDTH/2, 0, GAME_WIDTH/2, GAME_HEIGHT);

        g.setColor(Color.WHITE);
        g.fillRect(0+padWidth/2, leftPadY, padWidth, padHeight);
        g.fillRect(GAME_WIDTH-(padWidth/2)*3, rightPadY, padWidth, padHeight);

        ball.draw(g);
    }
}
