import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Enter a decimal number: ");
        Scanner scanner = new Scanner(System.in);
        int dec = scanner.nextInt();
        System.out.println(Integer.toBinaryString(dec));

        scanner.close();
    }
}
