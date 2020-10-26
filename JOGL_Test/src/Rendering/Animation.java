package Rendering;

import Math.PVector;

public class Animation {
	private static ImageResource image;
	private static PVector pos;
	private static PVector size;
	private static float rotation;

	public static void init() {
		image = new ImageResource("/Resources/harold.jpg");
		pos = new PVector(50,45);
		size = new PVector(90,60);
	}
	
	public static void update() {
		rotation += 0.01;
	}

	public static void render() {
		if (image != null) {
			Graphics.fill(255, 255, 255);
			Graphics.rotate(pos.x, pos.y , rotation);
			Graphics.image(image, pos.x, pos.y, size.x, size.y);
		}
	}
}
