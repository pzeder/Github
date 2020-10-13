package Rendering;
import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.util.FPSAnimator;

import Input.MouseInput;

public class Renderer {
	private static GLWindow window;
	private static ScreenResolution screenRes;
	private static MouseInput mouseInput;

	public static void init() {		
		GLProfile.initSingleton();
		GLProfile profile = GLProfile.get(GLProfile.GL2);
		GLCapabilities caps = new GLCapabilities(profile);	
		window = GLWindow.create(caps);
		screenRes = new ScreenResolution(3200,2400,100);
		mouseInput = new MouseInput();
		
		window.setTitle("JOGL Test");
		window.setSize(screenRes.getWidth(), screenRes.getHeight());
		window.setResizable(false);
		window.addGLEventListener(new EventListener());
		window.addMouseListener(mouseInput);
		window.setVisible(true);
	}
	
	public static void render() {
		if (window == null) {
			return;
		}
		window.display();
	}
	
	public static GLWindow getWindow() {
		return window;
	}
	
	public static ScreenResolution getScreenRes() {
		return screenRes;
	}
}

