package com.mygdx.project;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.project.screens.MainGameScreen;
import com.mygdx.project.screens.MainMenuScreen;

public class SpaceGame extends Game {
	public static final int WIDTH = 480;
	public static final int HEIGHT = 720;
	
	public SpriteBatch batch;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		//this.setScreen(new MainMenuScreen(this));
		this.setScreen(new MainGameScreen(this));
	}

	@Override
	public void render () {
		super.render();
	
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		
	}
}
