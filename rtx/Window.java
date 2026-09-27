import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends JFrame {
    Window() {
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(1600, 900));
        this.setResizable(false);

        Panel panel = new Panel();
        this.add(panel);

        this.pack();

        panel.startThread();
        panel.requestFocusInWindow();
    }
}
