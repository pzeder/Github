import com.jogamp.newt.event.MouseEvent;
import com.jogamp.newt.event.MouseListener;

public class MouseInput implements MouseListener { // extends MouseAdapter {
	private static boolean leftButton, rightButton;
	private static PVector pos;

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
			leftButton = true;
			break;
		case 3:
			rightButton = true;
			break;
		}
	}

	@Override
	// triggers whenever the mouse is released after mousePressed() was triggered
	public void mouseReleased(MouseEvent e) {
		int button = e.getButton();
		switch (button) {
		case 1:
			leftButton = false;
			break;
		case 3:
			rightButton = false;
			break;
		}
		for (int i = 0; i < 1; i++) { 
			BallPark.balls.add(new Ball(pos.x, pos.y));
		}
	}
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		pos = Renderer.getScreenRes().getPosUnits(e.getX(), e.getY());
	}

	@Override
	public void mouseWheelMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	
	public static boolean leftButtonPressed() {
		return leftButton;
	}
	
	public static boolean rightButtonPressed() {
		return rightButton;
	}
	
	public static PVector getPos() {
		if (pos == null) {
			return new PVector(-1,-1);
		}
		return pos;
	}
}
