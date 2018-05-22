package piusMonMajorProject.entities.characters;

import java.awt.Graphics;

import piusMonMajorProject.Constants;
import piusMonMajorProject.gfx.Assets;

public class Player extends Character{

	public Player(float x, float y) {
		super(x, y, Constants.DEFAULT_CREATURE_WIDTH, Constants.DEFAULT_CREATURE_HEIGHT);
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.monLatham[0], (int) x, (int) y, width, height, null);
	}

}
