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
		Animation.render();
		BallPark.render();
		gl.glFlush();
	}

	@Override
	public void dispose(GLAutoDrawable drawable) {
		System.exit(0);
	}

	@Override
	public void init(GLAutoDrawable drawable) {
		gl = drawable.getGL().getGL2();
		gl.setSwapInterval(0);
		gl.glClearColor(0.2f, 0.2f, 0.2f, 1);
		gl.glEnable(GL2.GL_TEXTURE_2D);
	}

	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
		gl = drawable.getGL().getGL2();
		GLWindow window = Renderer.getWindow();
		Renderer.refreshResolution(window.getWidth(), window.getHeight());
		gl.glMatrixMode(GL2.GL_PROJECTION);
		gl.glLoadIdentity();
		gl.glOrtho(0, Renderer.getUnitsWide(), Renderer.getUnitsTall(), 0, -1, 1);
		gl.glMatrixMode(GL2.GL_MODELVIEW);
	}
}
