import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Lines extends Rectangle {
    Lines(int x, int y, int width, int height) {
        super(x, y, width, height);
    }
    public double lnSpeed = ((Main.getWindowDimension().height/4)*3)/75;
    public void update() {
        this.y += lnSpeed;
        if (this.y >= Main.getWindowDimension().height) {
            this.y = 0-this.height;
        }
    }
    public void updateLnSpeed() {
        lnSpeed = ((Main.getWindowDimension().height/4)*3)/75;
    }
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, width, height);
    }
}
