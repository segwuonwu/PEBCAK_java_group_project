package com.cpts.game.bullets.screens;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.cpts.game.bullets.entities.Bullet;
import com.cpts.game.bullets.MyGdxGame;

public class GameScreen implements Screen {
	
	public static final float SPEED = 300;
	
	public static final float SHIP_ANIMATION_SPEED = 0.5f;
	public static final int SHIP_WIDTH_PIXEL = 17;
	public static final int SHIP_HEIGHT_PIXEL = 32;
	
	public static final int SHIP_WIDTH = SHIP_WIDTH_PIXEL * 3;
	public static final int SHIP_HEIGHT = SHIP_HEIGHT_PIXEL * 3;
	
	public static final float ROLL_TIMER_SWITCH_TIME = 0.15f;
	public static final float SHOOT_WAIT_TIME = 0.3f;
	
	
	
	
	Animation[] rolls;
	
	//Texture img;
	float y, x;
	int roll;
	float stateTime;
	float rollTimer;
	float shootTimer;
	float pauseTime;
	long startTime;
	
	
	MyGdxGame game;
	
	ArrayList<Bullet> bullets;
	
	public GameScreen(MyGdxGame game) {
		this.game = game;
		y = 15;
		x = MyGdxGame.WIDTH / 2 - SHIP_WIDTH / 2;
		bullets = new ArrayList<Bullet>();
		
		
		
		roll = 2;
		rollTimer = 0;
		rolls = new Animation[5];
		shootTimer = 0;
		
		
		TextureRegion[][] rollSpriteSheet = TextureRegion.split(new Texture("ship.png"), SHIP_WIDTH_PIXEL, SHIP_HEIGHT_PIXEL);
		
		rolls[0] = new Animation(SHIP_ANIMATION_SPEED, rollSpriteSheet[2]);
		rolls[1] = new Animation(SHIP_ANIMATION_SPEED, rollSpriteSheet[1]);
		rolls[2] = new Animation(SHIP_ANIMATION_SPEED, rollSpriteSheet[0]);
		rolls[3] = new Animation(SHIP_ANIMATION_SPEED, rollSpriteSheet[3]);
		rolls[4] = new Animation(SHIP_ANIMATION_SPEED, rollSpriteSheet[4]);

	}
	
	@Override
	public void show() {
		//img = new Texture("badlogic.jpg");		
	}

	@Override
	public void render(float delta) {
		
		/*
		if (Gdx.input.isKeyPressed(Keys.UP)) {
			y += SPEED * Gdx.graphics.getDeltaTime();
		}
		if (Gdx.input.isKeyPressed(Keys.DOWN)) {
			y -= SPEED *  Gdx.graphics.getDeltaTime();
		}
		*/
		
		shootTimer += delta;
		
		
		//Shooting Code
		if (Gdx.input.isKeyJustPressed(Keys.SPACE) && shootTimer >= SHOOT_WAIT_TIME) {
			
			//startTime = System.currentTimeMillis();
			shootTimer = 0;
			
			int offset = 4;
			if (roll == 1 || roll == 3) { // slightly tilted
				offset = 8;
			}
			
			if (roll == 0 || roll == 4) { // fully tilted
				offset = 16;
			}
			//startTime = System.currentTimeMillis();
			//bullets.add(new Bullet(x + (SHIP_WIDTH / 2), 0, 250, 20));
			
			//bullets.add(new Bullet(x + offset, 10 * delta, 200, 13));
			//bullets.add(new Bullet(x + SHIP_WIDTH - offset, 10 * delta, 200, 13));
			
			bullets.add(new Bullet(x + offset, 0, 200));
			bullets.add(new Bullet(x + SHIP_WIDTH - offset, 0, 200));
			
			//bullets.add(new Bullet(x + offset - 25, 20 * delta, 150, 6));
			//bullets.add(new Bullet(x + (SHIP_WIDTH / 2), 20 * delta, 150, 6));
			//bullets.add(new Bullet(x + SHIP_WIDTH - offset + 25, 20 * delta, 150, 6));
			
			
		}
		
		ArrayList<Bullet> bulletsToRemove = new ArrayList<Bullet>();
		for (Bullet bullet : bullets) {
			
			bullet.update(delta);
			
			if (bullet.remove) {
				bulletsToRemove.add(bullet);
			}
			
		}
		
		bullets.removeAll(bulletsToRemove);
		
		
		if (Gdx.input.isKeyPressed(Keys.LEFT)) {
			x -= SPEED *  Gdx.graphics.getDeltaTime();
			
			if (x < 0) {
				x = 0;
			}
			
			if (Gdx.input.isKeyPressed(Keys.LEFT) && !Gdx.input.isKeyPressed(Keys.RIGHT) && roll > 0) {
				rollTimer = 0;
				roll--;
			}
			
			// update roll
			rollTimer -= Gdx.graphics.getDeltaTime(); // switch to next roll frame
			if (Math.abs(rollTimer) > ROLL_TIMER_SWITCH_TIME) {
				rollTimer -= ROLL_TIMER_SWITCH_TIME;
				roll--;
				
				if (roll < 0) {
					roll = 0;
				}
			}
			
					
		} else {
			
			if (roll < 2) {
				
				rollTimer += Gdx.graphics.getDeltaTime(); // switch to next roll frame
				if (Math.abs(rollTimer) > ROLL_TIMER_SWITCH_TIME) {
					rollTimer -= ROLL_TIMER_SWITCH_TIME;
					roll++;
					
					if (roll > 4) {
						roll = 4;
					}
				}
				
			}
			
		}
		
		if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
			x += SPEED *  Gdx.graphics.getDeltaTime();
			
			if (x + SHIP_WIDTH > Gdx.graphics.getWidth()) {
				x = Gdx.graphics.getWidth() - SHIP_WIDTH;
				
			}
			
			/*
			if (Gdx.input.isKeyPressed(Keys.RIGHT) && !Gdx.input.isKeyPressed(Keys.LEFT) && roll > 0) {
				rollTimer = 0;
				roll--;
			}
			*/
			// update roll
			rollTimer += Gdx.graphics.getDeltaTime(); // switch to next roll frame
			if (Math.abs(rollTimer) > ROLL_TIMER_SWITCH_TIME && roll < 4) {
				rollTimer -= ROLL_TIMER_SWITCH_TIME;
				roll++;
			}
			
		} else {
			
			if (roll > 2) {
				// update roll
				rollTimer -= Gdx.graphics.getDeltaTime(); // switch to next roll frame
				if (Math.abs(rollTimer) > ROLL_TIMER_SWITCH_TIME && roll > 0) {
					rollTimer -= ROLL_TIMER_SWITCH_TIME;
					roll--;
				}
			}
		}
		
		stateTime += delta;
		
		Gdx.gl.glClearColor(0.15f, 0.15f, 0.3f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stateTime += delta;
		
		game.batch.begin();
		
		for (Bullet bullet: bullets) {
			
			if (bullet.pauseTime <= 0) {
				bullet.render(game.batch);
			}
		}
		
		
		//game.batch.draw(img, x, y);
		game.batch.draw((TextureRegion) rolls[roll].getKeyFrame(stateTime, true), x, y, SHIP_WIDTH, SHIP_HEIGHT);
		game.batch.end();
	}

	@Override
	public void resize(int width, int height) {}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {		
	}

	@Override
	public void hide() {		
	}

	@Override
	public void dispose() {		
		game.batch.dispose();
		//img.dispose();
	}

}
