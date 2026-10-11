import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

public class Car extends Rectangle {
    Car(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public double speed = ((Main.getWindowDimension().height/4)*3)/100;
    public void updateSpeed() {
        speed = ((Main.getWindowDimension().height/4)*3)/100;
    }

    public void update(KeyHandler kh) {
        if (kh.left && this.x >= 0) {
            this.x -= speed;
        }
        if (kh.right && this.x <= ((Main.getWindowDimension().height/4)*3)-this.width) {
            this.x += speed;
        }
    }

    public void draw(Graphics g, Image img, ImageObserver observer) {
        g.drawImage(img, x, y, width, height, observer);
    }
}
