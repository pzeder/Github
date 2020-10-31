package GameWorld;

import Rendering.Animation;
import Rendering.Renderer;

public class GameLoop {
	
	private static boolean running;
	
	private static int updates;
	private static int maxUpdates = 5;
	private static long lastUpdateTime;
	
	private static int SEC = 1000;
	private static int targetFPS = 60;
	private static int timePerFrame = SEC / targetFPS;
	
	private static boolean paused;
	
	public static void start() {
		Thread thread = new Thread() {
			public void run() {
				
				int fpsCounter = 0;
				long lastFpsCheck = System.currentTimeMillis();
				lastUpdateTime = System.currentTimeMillis();				
				running = true;
				
				while (running) {
					long startTime = System.currentTimeMillis();
					
					// Input
					
					if (!paused) {
						updates = 0;
						while (startTime - lastUpdateTime >= timePerFrame) {
							Animation.update();
							BallPark.update();
							lastUpdateTime += timePerFrame;
							if (++updates >= maxUpdates) {
								break;
							}
						}
					}
					
					Renderer.render();
					
					fpsCounter++;
					if (System.currentTimeMillis() >= lastFpsCheck + SEC) {
						System.out.println(fpsCounter);
						System.out.println(BallPark.objectAmount());
						fpsCounter = 0;
						lastFpsCheck = System.currentTimeMillis();
					}
					
					long timeTaken = System.currentTimeMillis() - startTime;
				    if (timeTaken < timePerFrame) {
				    	try {
							Thread.sleep(timePerFrame - timeTaken);
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
		lastUpdateTime = System.currentTimeMillis();
	}
}
