import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.swing.Timer;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.swing.JPanel;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GamePanel extends JPanel {

    Timer timer;
    KeyHandler keyHandler = new KeyHandler();

    private int panelHeight = Main.getWindowDimension().height; // 4
    private int panelWidth = (panelHeight/4)*3; // 3

    Car mx5 = new Car(panelWidth/2, 1000, getThisDimension().width/6, getThisDimension().height/7);
    Image mx5img;

    Lines line1 = new Lines(panelWidth/2-panelWidth/15, 0, panelWidth/18, panelHeight/6);
    Lines line2 = new Lines(panelWidth/2-panelWidth/15, (0-panelHeight/2)-(panelHeight/6)/2, panelWidth/18, panelHeight/6);

    Random random = new Random();
    Enemy enemy1 = new Enemy(random.nextInt(panelWidth-getThisDimension().width/6), -10, getThisDimension().width/6, getThisDimension().height/7);
    Enemy enemy2 = new Enemy(random.nextInt(panelWidth-getThisDimension().width/6), -450, getThisDimension().width/6, getThisDimension().height/7);
    Image enemyImg;

    public int score = 0;
    public int counter = 0;

    GamePanel() {
        this.setPreferredSize(new Dimension(panelWidth, panelHeight));
        this.setBackground(new Color(40, 40, 40));
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
        try {
            playSongs(playlist);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void startTimer() {
        timer = new Timer(1000/60, e -> {
            updatePanel();

            mx5.update(keyHandler);
            mx5.y = panelHeight-(mx5.height+(mx5.height/2));

            line1.update(); //line1.updateLnSpeed();
            line2.update(); //line2.updateLnSpeed();

            repaint();
        });
        timer.start();
    }
    public void stopTimer() {
        timer.stop();
    }
    public void loseScreen(Graphics g) {
        g.setColor(Color.RED);
        g.setFont(new Font("Z003", Font.PLAIN, 40));
        g.drawString("YOU CRASHED!!!", panelWidth/3, panelHeight/2);
    }

    public void updatePanel() {
        panelHeight = Main.getWindowDimension().height;
        panelWidth = (panelHeight/4)*3;
        this.setPreferredSize(new Dimension(panelWidth, panelHeight));

        counter++;
        if (counter % 60 == 0) {
            score++;
        }

        mx5.width = getThisDimension().width/6;
        mx5.height = getThisDimension().height/7;
        mx5.updateSpeed();

        enemy1.lnSpeed += 0.001;
        enemy2.lnSpeed += 0.001;
        line1.lnSpeed += 0.001;
        line2.lnSpeed += 0.001;

        line1.x = panelWidth/2-panelWidth/15;
        line2.x = panelWidth/2-panelWidth/15;

        enemy1.width = getThisDimension().width/6;
        enemy1.height = getThisDimension().height/7;
        enemy1.update();
        //enemy1.updateLnSpeed();

        enemy2.width = getThisDimension().width/6;
        enemy2.height = getThisDimension().height/7;
        enemy2.update();


        if (mx5.intersects(enemy1)) { stopTimer(); }
        if (mx5.intersects(enemy2)) { stopTimer(); }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        line1.draw(g);
        line2.draw(g);

        try {
            mx5img = ImageIO.read(new File("images/mx5-top.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        mx5.draw(g, mx5img, this);

        try {
            enemyImg = ImageIO.read(new File("images/enemy1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        enemy1.draw(g, enemyImg, this);
        enemy2.draw(g, enemyImg, this);

        /* now playing */
        g.setColor(new Color(12, 14, 150, 128));
        g.fillRect(0, 0, panelWidth, 15);
        g.setColor(Color.WHITE);
        g.drawString("Now Playing: " + currentlyPlaying, 20, 10);

        g.setColor(Color.GREEN);
        g.drawString("Score: " + score, panelWidth/2, 10);

        if (mx5.intersects(enemy1)) { loseScreen(g); }
        if (mx5.intersects(enemy2)) { loseScreen(g); }
    }

    public Dimension getThisDimension() {
        return this.getSize();
    }

    /* music aka hudba */
    private String[] returnPlaylist() {
        String[] playlist = {"songs/one-step-closer.wav", "songs/with-you.wav", "songs/runaway.wav", "songs/forgotten.wav"};
        List<String> l = Arrays.asList(playlist);
        Collections.shuffle(l);
        playlist = l.toArray(new String[0]);
        return playlist;
    }
    String[] playlist = returnPlaylist();

    volatile String currentlyPlaying;

    public void playSongs(String[] songs) throws Exception {
        Clip[] clips = new Clip[songs.length];

        for (int n = 0; n < songs.length; n++) {
            clips[n] = AudioSystem.getClip();
            clips[n].open(AudioSystem.getAudioInputStream(
                getClass().getResource(songs[n])));
        }

        int[] i = {1};
        currentlyPlaying = songs[0];

        for (Clip clip : clips) {
            clip.addLineListener(e -> {
                if (e.getType() == LineEvent.Type.STOP
                        && clip.getFramePosition() >= clip.getFrameLength()) {
                    int next = i[0];
                    currentlyPlaying = songs[next];
                    clips[next].setFramePosition(0);
                    clips[next].start();
                    i[0] = (next + 1) % clips.length;
                }
            });
        }

        clips[0].start();
    }
}
