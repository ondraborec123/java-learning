/*
Still under construction this is not done
*/


import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Main {
    public static void main(String[] args) {

        ImageIcon image = new ImageIcon("computer_off.png");

        JLabel label = new JLabel("hello world");
        label.setIcon(image);
        label.setHorizontalTextPosition(JLabel.CENTER); label.setVerticalTextPosition(JLabel.BOTTOM);
        label.setForeground(new Color(0,0,255));
        label.setHorizontalAlignment(JLabel.CENTER);

        Window window = new Window();
        window.add(label);
    }
}
