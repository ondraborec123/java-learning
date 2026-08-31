import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    static char[] word() {
            File file = new File("slova.txt");
            String[] allWords = new String[127];
            int i = 0;
            try (Scanner reader = new Scanner(file)) {
                while (reader.hasNextLine()) {
                    String row = reader.nextLine();
                    allWords[i] = row;
                    i++;
                }
            } catch (FileNotFoundException e) { e.printStackTrace(); }
            String randomWordString = allWords[(int)(Math.random()*(i))];
            char[] randomWord = randomWordString.toCharArray();
            return randomWord;
    }

    public static void main(String[] args) {
        /* important things idk */


        /* initialize panels */
        Panel1 panel1 = new Panel1();
        Panel2 panel2 = new Panel2();

        /* create window and display panels */
        Window window = new Window();
        window.getContentPane().add(panel1);
        window.getContentPane().add(panel2);
    }
}
