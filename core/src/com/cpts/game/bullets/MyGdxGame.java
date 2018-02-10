package com.cpts.game.bullets;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.cpts.game.bullets.screens.GameScreen;
import com.cpts.game.bullets.screens.MainScreen;

public class MyGdxGame extends Game {
	
	
	public static final int WIDTH = 480;
	public static final int HEIGHT = 720;
	
	public SpriteBatch batch;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		//this.setScreen(new GameScreen(this));
		this.setScreen(new MainScreen(this));
	}

	@Override
	public void render () {
		
		super.render();
	}
	
	@Override
	public void dispose () {
		
	}
}
