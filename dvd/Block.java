import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;

import javax.imageio.ImageIO;

import java.awt.Color;
import java.awt.Font;

public class Block extends Rectangle {
    private final int speed = 4;
    int x;
    int y;
    int size;
    Color clr;
    int xVel = speed+1;
    int yVel = speed;
    Block(int x, int y, int size, Color clr) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.clr = clr;
    }
    public void updateColor() {
        // Source - https://stackoverflow.com/a/20032024
        // Posted by Boann
        // Retrieved 2026-10-04, License - CC BY-SA 3.0
        this.clr = new Color((int)(Math.random() * 0x1000000));

    }
    public void update() {
        if (this.x <= 0) { xVel = -xVel; updateColor(); }
        if (this.x >= Window.WIDTH-this.size) { xVel = -xVel; updateColor(); }
        if (this.y <= 0) { yVel = -yVel; updateColor(); }
        if (this.y + this.size+25 >= Window.HEIGHT) { yVel = -yVel; updateColor(); }

        this.x = this.x + xVel;
        this.y = this.y + yVel;
    }
    public void draw(Graphics g) {
        Image img = ImageIO.read(new File("dvd.png"));
        g.drawImage(img, x, y, null);
    }
}
