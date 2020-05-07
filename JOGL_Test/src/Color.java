public class Color {
	private float red, green, blue;
	
	public Color(float red, float green, float blue) {
		this.red = (float) Math.max(0, Math.min(red, 255));
		this.green = (float) Math.max(0, Math.min(green, 255));
		this.blue = (float) Math.max(0, Math.min(blue, 255));
	}
	
	public float getRed() {
		return red;
	}
	
	public float getGreen() {
		return green;
	}
	
	public float getBlue() {
		return blue;
	}
	
	public static Color random() {
		float randomRed = (float) Math.random() * 255;
		float randomGreen = (float) Math.random() * 255;
		float randomBlue = (float) Math.random() * 255;
		return new Color(randomRed, randomGreen, randomBlue);
	}
}
