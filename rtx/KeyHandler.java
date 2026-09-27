import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    public boolean leftDown, rightDown, upDown, downDown;
    @Override
    public void keyTyped(KeyEvent e) {
        int keyCode = e.getKeyCode();
        System.out.println(keyCode);
    }
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == 37) { leftDown = true; }
        if (keyCode == 39) { rightDown = true; }
        if (keyCode == 38) { upDown = true; }
        if (keyCode == 40) { downDown = true; }
    }
    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == 37) { leftDown = false; }
        if (keyCode == 39) { rightDown = false; }
        if (keyCode == 38) { upDown = false; }
        if (keyCode == 40) { downDown = false; }
    }
}
