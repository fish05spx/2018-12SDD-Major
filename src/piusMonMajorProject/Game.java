package piusMonMajorProject;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import piusMonMajorProject.display.Display;
import piusMonMajorProject.gfx.Assets;
import piusMonMajorProject.input.MouseManager;
import piusMonMajorProject.states.GameState;
import piusMonMajorProject.states.HomeState;
import piusMonMajorProject.states.State;
import piusMonMajorProject.states.StatisticsState;

public class Game implements Runnable {

	private Display display;
	public int width, height;
	public String title;

	private boolean running = false;
	private Thread thread;

	private BufferStrategy bs;
	private Graphics g;

	// States
	public State gameState;
	public State homeState;
	public State statisticsState;

	// Input
	private MouseManager mouseManager;
	
	// Handler
	private Handler handler;
	
	/**
	 * Constructor for Game
	 * @param title title of the game
	 * @param width width of the window
	 * @param height height of the window
	 */
	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
		mouseManager = new MouseManager();
	}

	/**
	 * Initializes the game
	 */
	
	private void init() {
		display = new Display(title, width, height);
		display.getFrame().addMouseListener(mouseManager);
		display.getFrame().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);
		Assets.init();

		handler = new Handler(this);
		
		gameState = new GameState(handler);
		homeState = new HomeState(handler);
		statisticsState = new StatisticsState(handler);

		State.setState(statisticsState);
	}

	private void tick() {
		if (State.getState() != null) {
			State.getState().tick();
		}

	}

	/**
	 * renders the game
	 */
	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if (bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		// clear screen
		g.clearRect(0, 0, width, height);

		// draw here

		if (State.getState() != null) {
			State.getState().render(g);
		}

		// end drawing

		bs.show();
		g.dispose();
	}

	public void run() {
		init();

	
		// Frame Counter (limits frame rate)
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;

		while (running) {
			now = System.nanoTime();
			delta += (now - lastTime) / Constants.TIME_PER_TICK;
			timer += now - lastTime;
			lastTime = now;
			if (delta >= 1) {
				tick();
				render();
				ticks++;
				delta--;
			}
			if (timer >= 1000000000) {
				//System.out.println("Ticks and Frames: " + ticks);
				ticks = 0;
				timer = 0;
			}

		}
		stop();

	}

	public MouseManager getMouseManager(){
		return mouseManager;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public synchronized void start() {
		if (running) {
			return;
		}
		running = true;
		thread = new Thread(this);
		thread.start();
	}

	public synchronized void stop() {
		if (!running) {
			return;
		}
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
