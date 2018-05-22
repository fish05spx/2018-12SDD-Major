package piusMonMajorProject.states;

import java.awt.Graphics;

import piusMonMajorProject.Handler;
import piusMonMajorProject.entities.characters.Player;
import piusMonMajorProject.gfx.Assets;
import piusMonMajorProject.ui.ClickListener;
import piusMonMajorProject.ui.UIImageButton;
import piusMonMajorProject.ui.UIManager;

public class GameState extends State {
	
	private UIManager uiManager;
	
	private Player player;

	public GameState(final Handler handler) {
		super(handler);
		player = new Player(100,100);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);
	
		uiManager.addObject(new UIImageButton(600, 200, 128, 64, Assets.btnStats, new ClickListener() {

			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				State.setState(handler.getGame().statisticsState);
			}
		}));
	}
	
	
	@Override
	public void tick(){
		player.tick();
		uiManager.tick();
	}

	@Override
	public void render(Graphics g){
		player.render(g);
		uiManager.render(g);
	}
			
}
