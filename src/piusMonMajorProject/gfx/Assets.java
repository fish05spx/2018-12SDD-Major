package piusMonMajorProject.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int CHARACTER_WIDTH = 125, CHARACTER_HEIGHT = 160; 
	private static final int BUTTON_WIDTH = 215, BUTTON_HEIGHT = 92;
	
	public static BufferedImage[] monLatham;
	public static BufferedImage[] monJoyce;
	public static BufferedImage[] monPalmer;
	public static BufferedImage[] monKoch;
	public static BufferedImage[] monSpears;
	public static BufferedImage[] monBrandis;
	public static BufferedImage[] monTurnbull;
	public static BufferedImage[] monAly;
	
	public static BufferedImage[] btnStart;
	public static BufferedImage[] btnHome;
	public static BufferedImage[] btnStats;
	
	public static void init() {	
		
		// calls for each character
		monLatham = createBufCharacter("/textures/markLatham.png");
		monJoyce = createBufCharacter("/textures/barnabyJoyce.png");
		monPalmer = createBufCharacter("/textures/clivePalmer.png");
		monKoch = createBufCharacter("/textures/davidKoch.png");
		monSpears = createBufCharacter("/textures/davidSpears.png");
		monBrandis = createBufCharacter("/textures/georgeBrandis.png");
		monTurnbull = createBufCharacter("/textures/malcolmTurnbull.png");
		monAly = createBufCharacter("/textures/walleedAly.png");
		
		// calls for each button
		btnStats = createBufButton("/textures/statsButton.png");
		btnStart = createBufButton("/textures/playButton.png");
		btnHome = createBufButton("/textures/homeButton.png");
	}
	
	
	
	// Cuts the character Sprites
	public static BufferedImage[] createBufCharacter(String path) {
		SpriteSheet temp = new SpriteSheet(ImageLoader.loadImage(path));
		BufferedImage[] bf = new BufferedImage[4];
		bf[0] = temp.crop(0, 0, CHARACTER_WIDTH, CHARACTER_HEIGHT);
		bf[1] = temp.crop(CHARACTER_WIDTH, 0, CHARACTER_WIDTH, CHARACTER_HEIGHT);
		bf[2] = temp.crop(2*CHARACTER_WIDTH, 0, CHARACTER_WIDTH, CHARACTER_HEIGHT);
		bf[3] = temp.crop(3*CHARACTER_WIDTH, 0, CHARACTER_WIDTH, CHARACTER_HEIGHT);
	
		return bf;
	}
	
	// Cuts the button Sprites
	public static BufferedImage[] createBufButton(String path) {
		SpriteSheet temp = new SpriteSheet(ImageLoader.loadImage(path));
		BufferedImage[] bf = new BufferedImage[2];
		bf[0] = temp.crop(0,0, BUTTON_WIDTH, BUTTON_HEIGHT);
		bf[1] = temp.crop(0, BUTTON_HEIGHT, BUTTON_WIDTH, BUTTON_HEIGHT);
		
		return bf;
	}

}
