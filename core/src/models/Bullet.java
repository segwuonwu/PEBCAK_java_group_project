package models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.TimeUtils;

public class Bullet {
	

	public static final int SPEED = 500;
	public static final int ENEMY_SPEED = 300;
	public static final int DEFAULT_Y = 400;
	//public static final int DEFAULT_Y = 40;
	private static Texture texture;
		
	float x, y;
	
	float stopTimer;
	

	
	boolean hasStopped = false;
	
	public boolean remove = false;
	
	public Bullet(float x, float y) {
		this.x = x;
		this.y = y;
		
		if (texture == null) {
			texture = new Texture("bullet.png");
		}
		

		
	}
	
	
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public void updateforPlayer (float deltaTime) {
				
		y += SPEED * deltaTime;
	
		if (y > Gdx.graphics.getHeight()) {
			remove = true;
		}
		
		
		
	}
	
	public void updateforEnemy (float deltaTime) {
		
		y -= ENEMY_SPEED * deltaTime;
	
		if (y < Gdx.graphics.getHeight()) {
			remove = true;
		}
		
	}
		
	public void render (SpriteBatch batch) {
		
		batch.draw(texture, x, y);
		
	}

}
