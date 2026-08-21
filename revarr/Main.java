public class Main {
    public static int[] revArr(int[] arr) {
        int[] tempArr = new int[arr.length];
        int pos = arr.length;
        for (int i : arr) {
            tempArr[pos-1] = i;
            pos--;
        }
        return tempArr;
    }
    public static void main(String[] args) {
        int[] array = {4, 7, 8, 12, 52};
        for (int i : array) { System.out.print(i + " "); }
        System.out.print("\n");
        for (int i : revArr(array)) { System.out.print(i + " "); }
        System.out.print("\n");
    }
}
