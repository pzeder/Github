package Input;
import Math.PVector;
import GameWorld.BallPark;
import Rendering.Renderer;
import com.jogamp.newt.event.MouseEvent;
import com.jogamp.newt.event.MouseListener;

public class MouseInput implements MouseListener {
	private PVector pos;
	private boolean leftPressed, rightPressed;
	
	@Override
	// triggers only if the the mouse was on the window during press and release
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	// triggers whenever the mouse is pressed on the window
	public void mousePressed(MouseEvent e) {
		int button = e.getButton();
		switch (button) {
		case 1:
			leftPressed = true;
			break;
		case 3:
			rightPressed = true;
			break;
		}
	}

	@Override
	// triggers whenever the mouse is released after mousePressed() was triggered
	public void mouseReleased(MouseEvent e) {
		int button = e.getButton();
		switch (button) {
		case 1:
			leftPressed = false;
			BallPark.createBalls(3000, pos.x, pos.y);
			break;
		case 3:
			rightPressed = false;
			BallPark.deleteBalls(pos);
			break;
		}
		
	}
	
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		mouseMoved(e);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		pos = Renderer.getPosUnits(e.getX(), e.getY());
	}

	@Override
	public void mouseWheelMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	
	public boolean leftPressed() {
		return leftPressed;
	}
	
	public boolean rightPressed() {
		return rightPressed;
	}
	
	public PVector getPos() {
		if (pos == null) {
			return new PVector(-1,-1);
		}
		return new PVector(pos);
	}
}
