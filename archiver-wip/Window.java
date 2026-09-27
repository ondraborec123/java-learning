import javax.swing.JFrame;

public class Window extends JFrame {
    Window() {
        this.setSize(600,400);
        this.setTitle("Archiver");
        this.setResizable(true);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Panel panel = new Panel();
        this.add(panel);
    }
}
