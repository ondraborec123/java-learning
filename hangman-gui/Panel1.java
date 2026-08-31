import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Panel1 extends JPanel {
    JLabel secretWord = new JLabel();

    JLabel text = new JLabel("<html><span style='font-size: 12px;'>"+"Zadejte pismeno: "+"</span></html>");
    JTextField field = new JTextField();
    JButton button = new JButton("OK");
    Panel1() {
        this.setBounds(0,400,400,200);
        this.setBorder(new EmptyBorder(80, 30, 80, 10));
        this.setLayout(new GridLayout(1,3));
        this.setBackground(new Color(47,175,80));
        /* add widgets */
        this.add(text);
        this.add(field);
        this.add(button);
    }
}
