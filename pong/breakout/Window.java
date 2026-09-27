import javax.swing.JFrame;

public class Window extends JFrame {
    Window() {
        this.setTitle("Breakout");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);

        Panel panel = new Panel();
        this.add(panel);

        this.pack();

        panel.startThread();
        panel.requestFocusInWindow();
    }
}
