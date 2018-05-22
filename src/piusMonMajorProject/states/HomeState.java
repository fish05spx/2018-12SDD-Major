	package piusMonMajorProject.states;

import java.awt.Graphics;

import piusMonMajorProject.Handler;
import piusMonMajorProject.gfx.Assets;
import piusMonMajorProject.ui.ClickListener;
import piusMonMajorProject.ui.UIImageButton;
import piusMonMajorProject.ui.UIManager;

public class HomeState extends State{

	private UIManager uiManager;
	
	public HomeState(final Handler handler) {
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);
		
		uiManager.addObject(new UIImageButton(200, 200, 128, 64, Assets.btnStart, new ClickListener() {

			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				State.setState(handler.getGame().gameState);
			}
		}));
		uiManager.addObject(new UIImageButton(400, 200, 128, 64, Assets.btnStats, new ClickListener() {

			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				State.setState(handler.getGame().statisticsState);
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
