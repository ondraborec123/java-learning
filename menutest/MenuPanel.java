import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MenuPanel extends JPanel {

    Image menuImg;
    public void loadImage() {
        try {
            menuImg = ImageIO.read(new File("images/salmon.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    MenuButton creditsBtn = new MenuButton(100, 150, "Credits");
    MenuButton quitBtn = new MenuButton(100, 200, "Exit");

    MenuPanel() {
        this.setSize(800, 600);
        this.setBackground(new Color(19, 156, 24));

        loadImage();

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (creditsBtn.contains(e.getPoint())) { moveToCreditsScreen(); }
                if (quitBtn.contains(e.getPoint())) { System.exit(0); }
            }
        });
    }

    public void moveToCreditsScreen() {
        Container p = this.getParent();
        p.remove(this);
        p.add(new CreditsPanel());
        p.revalidate();
        p.repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Serif", Font.PLAIN, 45));
        g.drawString("Welcome", 100, 100);

        creditsBtn.draw(g);
        quitBtn.draw(g);

        g.drawImage(menuImg, 400, 100, 300, 450, this);
    }
}
