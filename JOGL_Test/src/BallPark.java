import java.util.ArrayList;

public class BallPark {
	public static ArrayList<Ball> balls = new ArrayList<Ball>();
	
	public static void draw() {
		for (int i = 0; i < balls.size(); i++) {
			balls.get(i).move();
			balls.get(i).paint();
		}
	}
}

