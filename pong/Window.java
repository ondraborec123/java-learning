import javax.swing.JFrame;

public class Window extends JFrame {
    Window() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Pong");
        this.setResizable(false);
        Panel panel = new Panel();
        this.add(panel);
        this.setVisible(true);
        this.pack();

        panel.requestFocusInWindow();
        panel.startThread();
    }
}
