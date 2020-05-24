package utils;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * A key adapter that logs key activity and returns current key state.
 * @author 钄¤緣瀹�
 */
public class BaseRaidenKeyAdapter extends KeyAdapter {
    public final int LEFT = 1, RIGHT = 2, UP = 4, DOWN = 8;
    public final int SHOOT = 1;
    public final int BOMB = 1;
    int left_key, right_key, up_key, down_key, shoot_key, bomb_key;
    private int motionState, weaponState, bombState;

    public BaseRaidenKeyAdapter(int left_key, int right_key, int up_key, int down_key, int shoot_key, int bomb_key) {
        this.left_key = left_key;
        this.right_key = right_key;
        this.up_key = up_key;
        this.down_key = down_key;
        this.shoot_key = shoot_key;
        this.bomb_key = bomb_key;
    }

    public int getMotionState() {
        return motionState;
    }

    public int getWeaponState() {
        return weaponState;
    }
    public int getBombState() {
        return bombState;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == left_key)
            motionState |= LEFT;
        else if (keyCode == right_key)
            motionState |= RIGHT;
        else if (keyCode == up_key)
            motionState |= UP;
        else if (keyCode == down_key)
            motionState |= DOWN;
        else if (keyCode == shoot_key)
            weaponState |= SHOOT;
        else if (keyCode == bomb_key)
        	bombState |= BOMB;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == left_key)
            motionState &= ~LEFT;
        else if (keyCode == right_key)
            motionState &= ~RIGHT;
        else if (keyCode == up_key)
            motionState &= ~UP;
        else if (keyCode == down_key)
            motionState &= ~DOWN;
        else if (keyCode == shoot_key)
            weaponState &= ~SHOOT;
        else if (keyCode == bomb_key)
        	bombState &= ~BOMB;
    }
}
