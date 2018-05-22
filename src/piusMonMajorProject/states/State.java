package piusMonMajorProject.states;

import java.awt.Graphics;

import piusMonMajorProject.Handler;

public abstract class State {
	//state manager
	private static State currentState = null;
	public Handler handler;
	
	public State(Handler handler) {
		this.handler = handler;
	}
		
	public static void setState(State state) {
		 currentState = state;
	}
	
	public static State getState() {
		return currentState;
	}
	
	public abstract void tick();
		
	public abstract void render(Graphics g);
	
}
