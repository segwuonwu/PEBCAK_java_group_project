package view;

import com.badlogic.gdx.Game;

public class MainGameClass extends Game {
	
	private LoadingScreen loadingScreen;
	private PreferencesScreen preferencesScreen;
	private MenuScreen menuScreen;
	private MainScreen mainScreen;
	private EndScreen endScreen;
	private VictoryScreen victory;

	
	 
	public final static int MENU = 0;
	public final static int PREFERENCES = 1;
	public final static int APPLICATION = 2;
	public final static int ENDGAME = 3;
	public final static int VICTORY = 4;

	
	@Override
	public void create () {
		loadingScreen = new LoadingScreen(this);
		setScreen(loadingScreen);
		
	}
	
	public void changeScreen(int screen){
		switch(screen){
			case MENU:
				menuScreen = new MenuScreen(this);
	                        this.setScreen(menuScreen);
				break;
			case PREFERENCES:
				preferencesScreen = new PreferencesScreen(this);
				this.setScreen(preferencesScreen);
				break;
			case APPLICATION:
				mainScreen = new MainScreen(this);
				this.setScreen(mainScreen);
				break;
			case ENDGAME:
				endScreen = new EndScreen(this);
				this.setScreen(endScreen);
				break;
			case VICTORY:
				victory = new VictoryScreen(this);
				this.setScreen(victory);
				break;
				
		}
	}
	

}
