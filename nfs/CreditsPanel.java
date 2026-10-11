import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.Timer;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JPanel;

public class CreditsPanel extends JPanel {

    Timer timer;

    Image bg;

    MenuButton backBtn = new MenuButton((int)(Main.getWindowDimension().width/2), (Main.getWindowDimension().height)/(Main.getWindowDimension().height/8), "back to menu");

    CreditsPanel() {
        this.setPreferredSize(new Dimension((Main.getWindowDimension().height/4)*3, Main.getWindowDimension().height));
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (backBtn.contains(e.getPoint())) { backToMenu(); }
            }
        });
        playLoop();
    }
    public void startMenuTimer() {
        timer = new Timer(1000/60, e -> {
            this.setPreferredSize(new Dimension((Main.getWindowDimension().height/4)*3, Main.getWindowDimension().height));
        });
        timer.start();
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        try {
            bg = ImageIO.read(new File("images/credits.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.drawImage(bg, 0, 0, (Main.getWindowDimension().height/4)*3, Main.getWindowDimension().height, this);

        backBtn.draw(g);
    }

    /* music */
    Clip clip;
    public void playLoop() {
        this.addNotify();
        try {
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(
                getClass().getResource("songs/intro.wav")));
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void stopLoop() {
        if (clip != null) {
            clip.stop();
            clip.close();
            clip = null;
        }
    }
    /* end music */

    public void backToMenu() {
        Container p = this.getParent();
        p.remove(this);

        MenuPanel menuPanel = new MenuPanel();
        p.add(menuPanel);
        menuPanel.startMenuTimer();
        menuPanel.requestFocusInWindow();

        p.revalidate();
        p.repaint();

        stopLoop();
    }
}
