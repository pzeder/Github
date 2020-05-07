public class ScreenResolution {
	private int width, height;
	private float unitsWide, unitsTall;
	
	public ScreenResolution(int width, int height, float unitsWide) {
		this.unitsWide = unitsWide;
		refresh(width, height);
	}
	
	public void refresh(int width, int height) {
		this.width = width;
		this.height = height;
		unitsTall = height / (width / unitsWide);
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public float getUnitsWide() {
		return unitsWide;
	}
	
	public float getUnitsTall() {
		return unitsTall;
	}
	
	public PVector getPosUnits(int pixelX, int pixelY) {
		float unitsX = (float) pixelX / width * unitsWide;
		float unitsY = (float) pixelY / height * unitsTall;
		return new PVector(unitsX, unitsY);
	}
}
