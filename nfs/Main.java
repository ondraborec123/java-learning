import java.awt.Dimension;

public class Main {
    static Window window;
    public static void main(String[] args) {
        window = new Window();

        MenuPanel menuPanel = new MenuPanel();
        window.add(menuPanel);

        window.pack();

        menuPanel.startMenuTimer();

        // GamePanel gamePanel = new GamePanel();
        // window.add(gamePanel);

        // window.pack();
        // gamePanel.startTimer();
        // gamePanel.requestFocusInWindow();
    }
    public static Dimension getWindowDimension() {
        return window.getSize();
    }
}
