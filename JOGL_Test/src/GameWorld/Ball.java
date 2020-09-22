package GameWorld;
import Math.*;
import Rendering.*;

public class Ball {
	private PVector pos;
	private PVector velo;
	private float radius;
	private Color color;
	private float rotation;
	
	public Ball(float x, float y) {
		this.pos = new PVector(x, y);
		this.velo = PVector.random(0, 0.3f);
		this.radius = (float) (Math.random() * 2 + 2);
		this.color = Color.random();
	}
	
	public void move() {
		pos.add(velo);
		float width = Renderer.getScreenRes().getUnitsWide();
		float height = Renderer.getScreenRes().getUnitsTall();
		if ((pos.x < radius) || (pos.x > width - radius)) {
			velo.x *= -1;
		}
		if ((pos.y < radius) || (pos.y > height - radius)) {
			velo.y *= -1;
		}
		rotation += 0.01;
	}
	
	public void paint() {
		Graphics.noStroke();
		Graphics.fill(color);
		Graphics.rotate(pos.x, pos.y, rotation);
		Graphics.ellipse(pos.x, pos.y, 2 * radius, 2 * radius);
	}
}
