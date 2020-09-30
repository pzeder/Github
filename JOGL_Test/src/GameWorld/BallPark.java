package GameWorld;
import java.util.ArrayList;

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
	
	public static void render() {
		for (int i = 0; i < balls.size(); i++) {
			balls.get(i).paint();
		}
	}
}

