import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;

public class Window extends JFrame {
    Window() {
        this.setTitle("Need for Speed: Swing");
        this.setSize(600, 800);
        this.setMinimumSize(new Dimension(600, 800));
        this.getContentPane().setBackground(Color.BLACK);
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
