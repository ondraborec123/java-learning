public class Main {
    public static void main(String[] args) {
        Window window = new Window();
        Panel panel = new Panel();
        window.add(panel);
        panel.startThread();
    }
}
