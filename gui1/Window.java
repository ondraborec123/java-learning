import javax.swing.JFrame;
import java.awt.Color;

public class Window extends JFrame {
    Window() {
        this.setSize(600,600);
        this.getContentPane().setBackground(new Color(0,255,0));
        this.setTitle("java je cool");
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
