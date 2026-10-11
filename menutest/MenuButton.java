import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

public class MenuButton extends Rectangle {
    String label;

    MenuButton(int x, int y, String label) {
        this.setBounds(x, y, label.length() * 15, 30);
        this.label = label;
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, width, height);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Z003", Font.PLAIN, 30));
        g.drawString(this.label, x+5, y+25);
    }
}
