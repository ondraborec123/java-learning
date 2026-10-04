import javax.swing.JFrame;

public class Window extends JFrame {
    public static final int WIDTH = 1600;
    public static final int HEIGHT = 900;
    Window() {
        this.setTitle("DVD");
        this.setSize(WIDTH,HEIGHT);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
