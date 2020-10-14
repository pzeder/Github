package Input;

import com.jogamp.newt.event.KeyEvent;
import com.jogamp.newt.event.KeyListener;

import GameWorld.GameLoop;
import Rendering.Graphics;

public class KeyInput implements KeyListener {
	private boolean[] keys = new boolean[256];
	
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.isAutoRepeat()){
		     return;
		}
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.isAutoRepeat()){
		     return;
		}
		int keyCode = e.getKeyCode();
		keys[keyCode] = false;
		if (keyCode == 32) {
			GameLoop.pause();
		}
		if (keyCode == 82) {
			Graphics.switchRedFilter();
		}
		if (keyCode == 71) {
			Graphics.switchGreenFilter();
		}
		if (keyCode == 66) {
			Graphics.switchBlueFilter();
		}
		// Uncomment to print keyCode
		// System.out.println(keyCode);
	}

	public boolean getKey(int keyCode) {
		return keys[keyCode];
	}
}
