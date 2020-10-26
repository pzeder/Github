package GameWorld;

import Rendering.Animation;
import Rendering.Renderer;

public class Main {

	public static void main(String[] args) {
		Renderer.init();
		Animation.init();
		GameLoop.start();
	}

}
