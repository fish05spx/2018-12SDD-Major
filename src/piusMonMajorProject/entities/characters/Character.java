package piusMonMajorProject.entities.characters;

import piusMonMajorProject.Constants;
import piusMonMajorProject.entities.Entity;

public abstract class Character extends Entity {

	protected int health, attack, speed;
	
	public Character(float x, float y, int width, int height) {
		super(x, y, width, height);
		this.health = Constants.DEFAULT_HEALTH;
		this.attack = Constants.DEFAULT_ATTACK;
		this.speed = Constants.DEFAULT_SPEED;
	}
	
	// Getters and Setters
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	
}
