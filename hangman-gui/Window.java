import javax.swing.JFrame;

public class Window extends JFrame {
    Window() {
        this.setSize(800,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Hangman");
        this.setResizable(false);
        this.setLayout(null);
        this.setVisible(true);
    }
}
