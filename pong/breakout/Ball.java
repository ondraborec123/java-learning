import java.awt.Rectangle;
import java.util.Random;
import java.awt.Graphics;
import java.awt.Color;

public class Ball extends Rectangle {
    final int DIAMETER = 15;
    final int SPEED = 10;

    int xVel;
    int yVel;

    Random random = new Random();

    Ball(int x, int y, int width, int height) {
        super(x, y, width, height);
        xVel = random.nextInt(2);
        if (xVel == 0) { xVel = -1; }
        yVel = random.nextInt(2);
        if (yVel == 0) { yVel = -1; }
    }

    public void draw(Graphics g) {
        g.setColor(Color.CYAN);
        g.fillOval(x, y, width, height);
    }

    public void go() {
        x += xVel * SPEED;
        y += yVel * SPEED;
        if (x <= 0 || x >= 800-DIAMETER) {
            xVel = -xVel;
        }
        if (y <= 0 || y >= 1000-DIAMETER) {
            yVel = -yVel;
        }
    }
}
