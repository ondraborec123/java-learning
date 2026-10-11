import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CreditsPanel extends JPanel {
    JLabel cr = new JLabel("<html>OndraBorec123 the best programmer<br> in the world<br> visit ondraborec123.github.io !!! :D</html>");
    JButton b = new JButton("kys");
    CreditsPanel() {
        this.setSize(800,600);

        cr.setFont(new Font("Free bookman", Font.PLAIN, 35));

        b.setFont(new Font("Free bookman", Font.PLAIN, 35));
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { System.exit(0); }
        });

        this.add(cr);
        this.add(b);
    }
}
