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

public class MenuPanel extends JPanel {

    Timer timer;

    Image bg;

    MenuButton startBtn = new MenuButton(Main.getWindowDimension().height/4, (Main.getWindowDimension().height/2)-100, "START");
    MenuButton creditsBtn = new MenuButton(Main.getWindowDimension().height/4, (Main.getWindowDimension().height/2)-50, "CREDITS");
    MenuButton exitBtn = new MenuButton(Main.getWindowDimension().height/4, Main.getWindowDimension().height/2, "EXIT");

    MenuPanel() {
        this.setPreferredSize(new Dimension((Main.getWindowDimension().height/4)*3, Main.getWindowDimension().height));
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (startBtn.contains(e.getPoint())) { startTheGame(); }
                if (creditsBtn.contains(e.getPoint())) { toCredits(); }
                if (exitBtn.contains(e.getPoint())) { System.exit(0); }
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
            bg = ImageIO.read(new File("images/menu.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.drawImage(bg, 0, 0, (Main.getWindowDimension().height/4)*3, Main.getWindowDimension().height, this);

        startBtn.draw(g);
        creditsBtn.draw(g);
        exitBtn.draw(g);
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

    public void startTheGame() {
        Container p = this.getParent();
        p.remove(this);

        GamePanel gamePanel = new GamePanel();
        p.add(gamePanel);
        gamePanel.startTimer();
        gamePanel.requestFocusInWindow();

        p.revalidate();
        p.repaint();

        stopLoop();
    }

    public void toCredits() {
        Container p = this.getParent();
        p.remove(this);

        CreditsPanel creditsPanel = new CreditsPanel();
        p.add(creditsPanel);
        creditsPanel.startMenuTimer();
        creditsPanel.requestFocusInWindow();

        p.revalidate();
        p.repaint();

        stopLoop();
    }
}
