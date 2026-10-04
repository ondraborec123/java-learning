import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Panel extends JPanel {
    Timer timer;
    Block block = new Block(380, 380, 120, Color.BLUE);

    Panel() {
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
    }
    public void startThread() {
        timer = new Timer(1000/60, e -> {
            update();
            repaint();
        });
        timer.start();
    }
    public void update() {
        block.update();
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        block.draw(g);
    }
}
