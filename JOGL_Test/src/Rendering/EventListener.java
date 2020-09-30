package Rendering;
import GameWorld.BallPark;
import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;

public class EventListener implements GLEventListener {
	public static GL2 gl;

	@Override
	public void display(GLAutoDrawable drawable) {
		gl = drawable.getGL().getGL2();
		// Uncomment for screen clear
		gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
		BallPark.render();
		gl.glFlush();
	}

	@Override
	public void dispose(GLAutoDrawable drawable) {
		drawable.getAnimator().stop();
	}

	@Override
	public void init(GLAutoDrawable drawable) {
		gl = drawable.getGL().getGL2();
		gl.glClearColor(0.2f, 0.2f, 0.2f, 1);
	}

	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
		gl = drawable.getGL().getGL2();
		ScreenResolution screenRes = Renderer.getScreenRes();
		GLWindow window = Renderer.getWindow();
		screenRes.refresh(window.getWidth(), window.getHeight());
		gl.glMatrixMode(GL2.GL_PROJECTION);
		gl.glLoadIdentity();
		gl.glOrtho(0, screenRes.getUnitsWide(), screenRes.getUnitsTall(), 0, -1, 1);
		gl.glMatrixMode(GL2.GL_MODELVIEW);
	}
}
