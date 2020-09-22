package Rendering;
import IOStream.MouseInput;
import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.util.FPSAnimator;

public class Renderer {
	private static GLWindow window;
	private static ScreenResolution screenRes;
	private static MouseInput mouseInput;
	
	public static void main(String[] args) {
		init();
	}

	public static void init() {		
		GLProfile.initSingleton();
		GLProfile profile = GLProfile.get(GLProfile.GL2);
		GLCapabilities caps = new GLCapabilities(profile);	
		window = GLWindow.create(caps);
		screenRes = new ScreenResolution(1600,1200,100);
		mouseInput = new MouseInput();
		
		window.setTitle("Look at my balls!");
		window.setSize(screenRes.getWidth(), screenRes.getHeight());
		window.setResizable(false);
		window.addGLEventListener(new EventListener());
		window.addMouseListener(mouseInput);
		window.setVisible(true);
		
		window.setAnimator(new FPSAnimator(window, 60));
		window.getAnimator().setUpdateFPSFrames(10, null);
		window.getAnimator().start();
	}
	
	public static GLWindow getWindow() {
		return window;
	}
	
	public static ScreenResolution getScreenRes() {
		return screenRes;
	}
	
	public static float getFPS() {
		if (window.getAnimator() == null) {
			return 0;
		}
		return window.getAnimator().getLastFPS();
	}
}

