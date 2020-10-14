package GameWorld;

import Input.MouseInput;
import Rendering.Renderer;

public class GameLoop {
	
	private static boolean running;
	
	private static int SEC = 1_000_000_000;
	private static int targetFPS = 60;
	private static int timePerFrame = SEC / targetFPS;
	
	private static boolean paused;
	
	public static void start() {
		Thread thread = new Thread() {
			public void run() {
				
				int fpsCounter = 0;
				long lastFpsCheck = System.nanoTime();
				
				running = true;
				
				while (running) {
					long startTime = System.nanoTime();
					
					// Input
					
					if (!paused) {
						BallPark.update();
					}
					
					Renderer.render();
					
					fpsCounter++;
					if (System.nanoTime() >= lastFpsCheck + SEC) {
						// System.out.println(fpsCounter);
						// System.out.println(BallPark.objectAmount());
						fpsCounter = 0;
						lastFpsCheck = System.nanoTime();
					}
					
					long timeTaken = System.nanoTime() - startTime;
				    if (timeTaken < timePerFrame) {
				    	try {
							Thread.sleep((timePerFrame - timeTaken) / 1_000_000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
				    }
				}
			}
		};
		thread.setName("GameLoop");
		thread.start();
	}
	
	public static void pause() {
		paused = !paused;
	}
}
