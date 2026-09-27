import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.Timer;
import java.util.Iterator;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class Panel extends JPanel {
    final int GAME_WIDTH = 800;
    final int GAME_HEIGHT = 1000;

    KeyHandler keyHandler = new KeyHandler();

    Pad pad = new Pad(GAME_WIDTH/2-(40), GAME_HEIGHT-20, 80, 10);
    Ball ball = new Ball(GAME_WIDTH/2-(9), GAME_HEIGHT-40, 18, 18);
    Brick brick;
    List<Brick> bricks = new ArrayList<>();

    Timer timer;

    Panel() {
        this.setBackground(Color.DARK_GRAY);
        this.setPreferredSize(new Dimension(GAME_WIDTH, GAME_HEIGHT));
        this.setDoubleBuffered(true);

        this.addKeyListener(keyHandler);
        this.setFocusable(true);
    }

    public void startThread() {
        timer = new Timer(1000 / 60, e -> {
            update();
            repaint();
        });
        timer.start();
    }

    public void update() {
        ball.go();
        if (ball.intersects(pad)) {
            ball.yVel = -ball.yVel;
        }
        for (Brick brick : bricks) {
            if (ball.intersects(brick)) {
                ball.yVel = -ball.yVel;
                break;
            }
        }
        if (keyHandler.leftDown && pad.x >= 0) { pad.x -= pad.SPEED; }
        if (keyHandler.rightDown && pad.x <= GAME_WIDTH-pad.WIDTH) { pad.x += pad.SPEED; }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        pad.draw(g);
        ball.draw(g);

        int placeX = 25;
        int placeY = 25;
        for (int i = 0; i <= 14; i++) {
            for (int y = 0; y <= 5; y++) {
                bricks.add(new Brick(placeX, placeY, 40, 20));
                placeY += 25;
            }
            placeX += 50;
            placeY = 25;
        }

        for (Brick brick : bricks) {
            brick.draw(g);
        }
    }
}
