import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;
import java.awt.Font;

/* random.nextInt((2 - (-2) + 1) - 2);*/

public class Ball extends Rectangle {
    Random random;
    final int DIAMETER = 20;
    final int SPEED = 6;
    int xVel;
    int yVel;

    int leftPlayerScore = 0;
    int rightPlayerScore = 0;
    String scoreStringer = leftPlayerScore + " : " + rightPlayerScore;

    Ball (int x, int y, int width, int height) {
        super(x,y,width,height);
		random = new Random();
		xVel = random.nextInt(2);
		yVel = random.nextInt(2);
		if (xVel == 0) { xVel = 1; }
		if (yVel == 0) { yVel = 1; }
    }

    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval(x, y, width, height);
        g.setColor(Color.RED);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        g.drawString(scoreStringer, 20, 20);
    }

    public void go() {
        /* odrazeni od spoda a vrchu */
        if (y <= 0) {
            yVel = -yVel;
        }
        if (y >= 600 - DIAMETER) {
            yVel = -yVel;
        }

        /* dotyk prave a leve strany */
        if (x <= 0) {
            xVel = -xVel;
            rightPlayerScore++;
            scoreStringer = leftPlayerScore + " : " + rightPlayerScore;
            x = (1080/2)-10; y = (600/2)-10;
        }
        if (x >= 1080 - DIAMETER) {
            xVel = -xVel;
            leftPlayerScore++;
            scoreStringer = leftPlayerScore + " : " + rightPlayerScore;
            x = (1080/2)-10; y = (600/2)-10;
        }

        x += xVel * SPEED;
        y += yVel * SPEED;
    }
}
