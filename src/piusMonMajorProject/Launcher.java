package piusMonMajorProject;

public class Launcher {
		public static void main(String[] args) {
			
			Game game = new Game(Constants.WINDOW_TITLE, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT); //calls game class to create a frame
			game.start();
		}
	
}
