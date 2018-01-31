package com.cpts.game;

import com.badlogic.gdx.Screen;

public class LoadingScreen implements Screen {

	private MainGameClass parent;
	 
	public LoadingScreen(MainGameClass mainGameClass){
		parent = mainGameClass;     
	}
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		parent.changeScreen(MainGameClass.MENU);
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
