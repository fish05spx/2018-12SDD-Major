package piusMonMajorProject.states;

import java.awt.Graphics;

import piusMonMajorProject.Handler;

public abstract class State {
	//state manager
	private static State currentState = null;	
	public static void setState(State state) {
		currentState = state;
	}
	
	public static State getState() {
		System.out.println(currentState);
		return currentState;
	}
	
	// CLASS
	public Handler handler;
	
	public State(Handler handler) {
		this.handler = handler;
	}
		
		
	public abstract void tick();
		
	public abstract void render(Graphics g);
	
}
