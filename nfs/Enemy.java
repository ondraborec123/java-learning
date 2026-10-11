import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;
import java.util.Random;

public class Enemy extends Rectangle {
    Enemy(int x, int y, int width, int height) {
        super(x, y, width, height);
    }
    public double lnSpeed = ((Main.getWindowDimension().height/4)*3)/90;
    Random random = new Random();
    public void update() {
        this.y += lnSpeed;
        if (this.y >= Main.getWindowDimension().height) {
            this.y = 0-this.height;
            this.x = random.nextInt(((Main.getWindowDimension().height/4)*3)-50);
        }
    }
    public void updateLnSpeed() {
        lnSpeed = ((Main.getWindowDimension().height/4)*3)/90;
    }
    public void draw(Graphics g, Image img, ImageObserver observer) {
        g.drawImage(img, x, y, width, height, observer);
    }
}
