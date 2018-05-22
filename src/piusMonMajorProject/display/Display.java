package piusMonMajorProject.display;
import java.awt.Canvas;// canvas/images buttons etc
import java.awt.Dimension;

import javax.swing.JFrame; //frame itself

import piusMonMajorProject.Constants;

public class Display {
	
	private JFrame frame;
	private Canvas canvas;
	
	
	// for frame creation
	private String title;
	private int width;
	private int height;
	
	/**
	 * display constructor
	 * @param title title of the game
	 * @param width width of the window
	 * @param height height of the window
	 */
	public Display(String title, int width, int height){
		this.title = title;
		this.width = width;
		this.height = height;
		
		createDisplay();
	}
	
	
	private void createDisplay() {//frame & canvas
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(Constants.IS_WINDOW_RESIZEABLE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		//this was for animation?
		canvas.setFocusable(false);
		
		frame.add(canvas);
		frame.pack();// keeps all graphics visible
	}
	
	public Canvas getCanvas() {
		return canvas;
	}
	public JFrame getFrame() {
		return frame;
	}
}
