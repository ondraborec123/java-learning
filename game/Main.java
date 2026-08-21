import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame("Cau");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(300,300); window.setResizable(false); window.setVisible(true);

        JLabel nadpis = new JLabel("ahoj svete"); nadpis.setFont(new Font("Serif", Font.PLAIN, 24));
        JLabel clanek = new JLabel("Lorem ipsum dolor sit amet"); clanek.setFont(new Font("Serif", Font.PLAIN, 16));

        window.setLayout(new GridLayout(5, 1, 15, 15));

        window.add(nadpis); window.add(clanek);

    }
}
