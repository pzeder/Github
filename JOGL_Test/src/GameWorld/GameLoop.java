package GameWorld;

import Rendering.Renderer;
import IOStream.MouseInput;

public class GameLoop {
	
	private static boolean running;
	
	private static int SEC = 1_000_000_000;
	private static int targetFPS = 60;
	private static int targetTime = SEC / targetFPS;
	
	private static int fps;
	
	public static void start() {
		Thread thread = new Thread() {
			public void run() {
				
				int fpsCounter = 0;
				long lastFpsCheck = System.nanoTime();
				
				running = true;
				
				while (running) {
					long startTime = System.nanoTime();
					
					// Input
					
					BallPark.update();
					
					Renderer.render();
					
					fpsCounter++;
					if (System.nanoTime() >= lastFpsCheck + SEC) {
						System.out.println(fpsCounter);
						fpsCounter = 0;
						lastFpsCheck = System.nanoTime();
					}
					
					long timeTaken = System.nanoTime() - startTime;
				    if (timeTaken < targetTime) {
				    	try {
							Thread.sleep((targetTime - timeTaken) / SEC);
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
}
