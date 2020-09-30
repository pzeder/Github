package GameWorld;

import Rendering.Renderer;
import IOStream.MouseInput;

public class GameLoop {
	
	private static boolean running;
	
	private static int targetFPS = 60;
	private static int tagetTime = 1_000_000_000;
	
	public static void start() {
		Thread thread = new Thread() {
			public void run() {
				running = true;
				while (running) {
					long startTime = System.nanoTime();
					// Input
					
					// Update Game
					BallPark.update();
					
					Renderer.render();
					long timeTaken = System.nanoTime() - startTime;
					// if (timeTaken < targetTime)
				}
			}
		};
		thread.setName("GameLoop");
		thread.start();
	}
}
