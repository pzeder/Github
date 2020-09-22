package GameWorld;
import java.util.ArrayList;

public class BallPark {
	private static ArrayList<Ball> balls = new ArrayList<Ball>();
		
	public static void createBalls(int n, float posX, float posY) {
		for (int i = 0; i < n; i++) { 
			balls.add(new Ball(posX, posY));
		}
	}
	
	public static void draw() {
		for (int i = 0; i < balls.size(); i++) {
			balls.get(i).move();
			balls.get(i).paint();
		}
	}
}

