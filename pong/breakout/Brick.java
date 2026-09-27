import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Brick extends Rectangle {
    final int WIDTH = 40;
    final int HEIGHT = 20;

    boolean destroyed = false;

    Brick(int x, int y, int width, int height) {
        super(x,y,width,height);
    }

    public void draw(Graphics g) {
        g.setColor(Color.ORANGE);
        g.fillRect(x, y, width, height);
    }

    public void destroy() {
        this.destroyed = true;
    }

    public boolean isDestroyed() {
        return destroyed;
    }
}
