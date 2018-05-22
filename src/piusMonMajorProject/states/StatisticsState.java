package piusMonMajorProject.states;

import java.awt.Graphics;

import piusMonMajorProject.Handler;
import piusMonMajorProject.gfx.Assets;
import piusMonMajorProject.ui.ClickListener;
import piusMonMajorProject.ui.UIImageButton;
import piusMonMajorProject.ui.UIManager;

public class StatisticsState extends State {

	private UIManager uiManager;
	
	public StatisticsState(final Handler handler) {
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);
		
		uiManager.addObject(new UIImageButton(200, 600, 128, 64, Assets.btnHome, new ClickListener() {

			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				State.setState(handler.getGame().homeState);
			}
		}));
	
	}
	
	
	@Override
	public void tick(){
		uiManager.tick();
	}

	@Override
	public void render(Graphics g){
		uiManager.render(g);
	}
}
