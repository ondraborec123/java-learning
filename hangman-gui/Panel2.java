import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Panel2 extends JPanel {
    char[] usedChars = {};

    Panel2() {
        String usedCharsString = new String();
        for (char i : usedChars ) { usedCharsString = usedCharsString + i + ", "; }
        JLabel text = new JLabel("<html><div style='width:220px; font-size:16px;'>Used Chars:<br><i>"+usedCharsString+"</i></div></html>");

        text.setHorizontalAlignment(JLabel.LEFT); text.setVerticalAlignment(JLabel.TOP);

        this.setBounds(400,0,400,600);
        this.setLayout(new BorderLayout());
        this.setBorder(new EmptyBorder(80, 30, 80, 10));
        this.setBackground(new Color(252,250,116));
        this.add(text);
        this.repaint();
    }
}
