import javax.swing.JFrame;

public class Window extends JFrame {
    private final int WIDTH = 800;
    private final int HEIGHT = 600;
    Window() {
        this.setTitle("Hello world");
        this.setSize(WIDTH, HEIGHT);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
