public class Main {
    public static void main(String[] args) {
        final int height = 4;

        for (int i = 0 ; i <= height-1 ; i++) {
            for (int j = 0 ; j < height-i ; j++) {
                System.out.print(" ");
            }
            for (int k = 1 ; k != i+2 ; k++) {
                System.out.print(k+i);
            }
            for (int m = i+1 ; m > 1 ; m--) {
                System.out.print(m+i-1);
            }
            System.out.println("");
        }
    }
}
