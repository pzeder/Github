package Rendering;
import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.util.FPSAnimator;

import Input.KeyInput;
import Input.MouseInput;
import Math.PVector;

public class Renderer {
	private static GLWindow window;
	private static MouseInput mouseInput;
	private static KeyInput keyInput;
	private static int width, height;
	private static float unitsWide, unitsTall;

	public static void init() {		
		GLProfile.initSingleton();
		GLProfile profile = GLProfile.get(GLProfile.GL2);
		GLCapabilities caps = new GLCapabilities(profile);	
		window = GLWindow.create(caps);
		mouseInput = new MouseInput();
		window.addMouseListener(mouseInput);
		keyInput = new KeyInput();
		window.addKeyListener(keyInput);
		
		unitsWide = 100;
		refreshResolution(2200, 2200);
		window.setSize(width, height);
		window.setTitle("JOGL Test");
		window.setResizable(true);
		window.addGLEventListener(new EventListener());		
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
	
	public static int getWidth() {
		return width;
	}
	
	public static  int getHeight() {
		return height;
	}
	
	public static float getUnitsWide() {
		return unitsWide;
	}
	
	public static float getUnitsTall() {
		return unitsTall;
	}
	
	public static PVector getPosUnits(int pixelX, int pixelY) {
		float unitsX = (float) pixelX / width * unitsWide;
		float unitsY = (float) pixelY / height * unitsTall;
		return new PVector(unitsX, unitsY);
	}
	
	public static void refreshResolution(int windowWidth, int windowHeight) {
		width = windowWidth;
		height = windowHeight;
		unitsTall = height / (width / unitsWide);
	}
}

