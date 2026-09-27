import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Pad extends Rectangle {
    final int WIDTH = 80;
    final int HEIGHT = 20;
    final int SPEED = 10;

    Pad(int x, int y, int width, int height) {
        super(x,y,width,height);
    }

    public void draw(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillRect(x, y, width, height);
    }
}
