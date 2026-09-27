import java.awt.FlowLayout;
import java.io.File;
import java.time.LocalDateTime;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Panel extends JPanel {
    Panel() {
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 15));

        JLabel label = new JLabel("<html><span style='font-size: 16px;'>Select dir to archive: </span></html>");
        this.add(label);

        JTextField text = new JTextField(16);
        this.add(text);

        JFileChooser fileChooser = new JFileChooser();

        JButton search = new JButton("Find the dir..");
        this.add(search);
        search.addActionListener(event -> {
            fileChooser.showOpenDialog(null);
            File file = fileChooser.getCurrentDirectory();
            text.setText(file.getAbsolutePath());
        });

        JButton archive = new JButton("Create archive! (.7z)");
        this.add(archive);
        archive.addActionListener(event -> {
            LocalDateTime time = LocalDateTime.now();
            String command = "cd $HOME ; 7z a archive_" + time + ".7z " + text.getText();
            Process process = Runtime.getRuntime().exec(command);
            process.getOutputStream();
            process.getInputStream();
            process.getErrorStream();
        });
    }
}
