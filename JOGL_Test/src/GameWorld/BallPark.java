package GameWorld;
import java.util.ArrayList;

import Math.PVector;
import Rendering.Graphics;
import Rendering.Renderer;

public class BallPark {
	private static ArrayList<Ball> balls = new ArrayList<Ball>();
	
	public static void update() {
		for (int i = 0; i < balls.size(); i++) {
			balls.get(i).move();
		}
	}
		
	public static void createBalls(int n, float posX, float posY) {
		for (int i = 0; i < n; i++) { 
			balls.add(new Ball(posX, posY));
		}
	}
	
	public static void deleteBalls(PVector mousePos) {
		for (int i = balls.size()-1; i >= 0; i--) {
			Ball ball = balls.get(i);
			if (PVector.sub(ball.getPos(), mousePos).mag() < ball.getRadius()) {
				balls.remove(i);
			}
		}
	}
	
	public static int objectAmount() {
		return balls.size();
	}
	
	public static void render() {
		for (int i = 0; i < balls.size(); i++) {
			balls.get(i).paint();
		}
	}
	
	public static void clear() {
	  balls.clear();
	}
}

