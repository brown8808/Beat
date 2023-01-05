package dynamic_beat;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter {
    @Override
    public void keyPressed(KeyEvent e) {
        if (DynamicBeat.game == null) { // 다이나믹비트 게임이 진행되지 않은 상태라면
            return; // 아래의 작업을 거치지 않도록 무력화
        }

        if (e.getKeyCode() == KeyEvent.VK_S) {
            DynamicBeat.game.pressS();
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            DynamicBeat.game.pressD();
        }
        if (e.getKeyCode() == KeyEvent.VK_F) {
            DynamicBeat.game.pressF();
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            DynamicBeat.game.pressSpace();
        }
        if (e.getKeyCode() == KeyEvent.VK_J) {
            DynamicBeat.game.pressJ();
        }
        if (e.getKeyCode() == KeyEvent.VK_K) {
            DynamicBeat.game.pressK();
        }
        if (e.getKeyCode() == KeyEvent.VK_L) {
            DynamicBeat.game.pressL();
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
        if (DynamicBeat.game == null) { // 다이나믹비트 게임이 진행되지 않은 상태라면
            return; // 아래의 작업을 거치지 않도록 무력화
        }

        if (e.getKeyCode() == KeyEvent.VK_S) {
            DynamicBeat.game.releaseS();
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            DynamicBeat.game.releaseD();
        }
        if (e.getKeyCode() == KeyEvent.VK_F) {
            DynamicBeat.game.releaseF();
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            DynamicBeat.game.releaseSpace();
        }
        if (e.getKeyCode() == KeyEvent.VK_J) {
            DynamicBeat.game.releaseJ();
        }
        if (e.getKeyCode() == KeyEvent.VK_K) {
            DynamicBeat.game.releaseK();
        }
        if (e.getKeyCode() == KeyEvent.VK_L) {
            DynamicBeat.game.releaseL();
        }
    }

}
