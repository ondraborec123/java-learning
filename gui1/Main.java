import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Main {
    public static void main(String[] args) {
        ImageIcon image = new ImageIcon("computer_off.png");
        JLabel label = new JLabel("hello world");
        label.setIcon(image);
        label.setHorizontalTextPosition(JLabel.CENTER); label.setVerticalTextPosition(JLabel.BOTTOM);
        label.setHorizontalAlignment(JLabel.CENTER); label.setVerticalAlignment(JLabel.CENTER);
        label.setForeground(Color.RED);

        JLabel text = new JLabel("<html><div style='width:200px;'>ahoj<br><h1>Hello world</h1> </div></html>");
        text.setHorizontalAlignment(JLabel.LEFT); text.setVerticalAlignment(JLabel.TOP);

        Panel leftPanel = new Panel(); leftPanel.setBounds(0,0,300,600);
        leftPanel.setLayout(new BorderLayout());
        leftPanel.setBackground(Color.YELLOW);
        Panel rightPanel = new Panel(); rightPanel.setBounds(300,0,300,600);
        rightPanel.setLayout(new BorderLayout());
        rightPanel.setBackground(Color.GREEN);

        Window window = new Window();
        window.add(leftPanel);
        leftPanel.add(label);
        rightPanel.add(text);
        window.add(rightPanel);
    }
}
