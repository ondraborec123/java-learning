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
        char[] slovo = word();
        char[] pismena = new char[1000];

        byte pocetSpatne = 0;
        byte pokusCislo = 0;
        boolean win = false;
        while (true) {
            boolean pokracujeme = false;
            /* */
            System.out.println("\nPocet spatnych pokusu: " + pocetSpatne + "/10");
            for (char x : slovo) {
                boolean souhlas = false;
                for (char y : pismena) {
                    if (x == y) {
                        souhlas = true;
                    } else if (x == ' ') {
                        souhlas = true;
                        System.out.print("");
                        break;
                    }
                }
                if (souhlas) {
                    System.out.print(x + " ");
                } else {
                    pokracujeme = true;
                    System.out.print("_ ");
                }
            }
            /* */
            if (!pokracujeme) { win = true; break; }
            if (pocetSpatne >= 10) { break; }

            Scanner scanner = new Scanner(System.in);
            System.out.print("\nZadejte pismeno: ");
            String mujInputNepreveden = scanner.nextLine();
            char mujInput = mujInputNepreveden.charAt(0);
            pismena[pokusCislo] = mujInput;
            /* */
            boolean test = true;
            for (char i : slovo) {
                if (i == Character.MIN_VALUE) { break; };
                if (mujInput == i) { test = false; break; }
            } if (test) { pocetSpatne++; }
            /* */

            pokusCislo++;
        }
        if (win) { System.out.println("\n\nGratuluji, vyhral/a jste!"); }
        if (!win) {
            System.out.print("\n\n\nJe mi lito, prohral/a jste!\nSpravna odpoved: ");
            for (char p : slovo) { System.out.print(p); }
            System.out.print("\n");
        }
    }
}
