import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    public boolean wDown, sDown, horeDown, doleDown;
    @Override
    public void keyTyped(KeyEvent e) {
    }
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == 87) { wDown = true; }
        if (keyCode == 83) { sDown = true; }
        if (keyCode == 38) { horeDown = true; }
        if (keyCode == 40) { doleDown = true; }
    }
    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == 87) { wDown = false; }
        if (keyCode == 83) { sDown = false; }
        if (keyCode == 38) { horeDown = false; }
        if (keyCode == 40) { doleDown = false; }
    }
}
