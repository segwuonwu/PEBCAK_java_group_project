package com.cpts.game.bullets.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.TimeUtils;

public class Bullet {
	

	public static final int SPEED = 500;
	//public static final int DEFAULT_Y = 400;
	public static final int DEFAULT_Y = 40;
	private static Texture texture;
	private static final float WAIT_TIME = 3f;
		
	float x, y;
	public float pauseTime;
	
	float stopTimer;
	float distanceTravled;
	float distanceToTravel;
	double distanceAdjust;
	float dT;
	long elapsedTime;
	long startTime;
	
	
	boolean hasStopped = false;
	
	public boolean remove = false;
	
	public Bullet(float x, float pauseTime, float distanceToTravel) {
		this.x = x;
		this.y = DEFAULT_Y;
		this.pauseTime = pauseTime;
		this.distanceToTravel = distanceToTravel;
		
		this.startTime = TimeUtils.millis();
		
		if (texture == null) {
			texture = new Texture("bullet.png");
		}
		
	}
	
	public void update (float deltaTime) {
		
		//dT += deltaTime;
		
		//System.out.println(distanceToTravel);
		//if (TimeUtils.timeSinceMillis(startTime) < 300) {
			y += SPEED * deltaTime;
		//} 
		
		//if (y >= 200  && dT >= WAIT_TIME) {
			//dT -= WAIT_TIME;
			//hasStopped = true;
		//}
		
		//y += SPEED * deltaTime;
	
		if (y > Gdx.graphics.getHeight()) {
			remove = true;
		}
		
	}
	
	/*
	public void update (float deltaTime) {
		
	
		if (pauseTime <= 0) {
			
			if (!hasStopped) {
				
				if (distanceTravled >= distanceToTravel) {
					
					if (stopTimer > distanceAdjust * deltaTime) {
						hasStopped = true;
					}
					
					stopTimer += deltaTime;
					
				} else {
					y += SPEED * deltaTime;
					distanceTravled = y;
					System.out.println(distanceTravled);
				}
				
			} else {
				y += SPEED * deltaTime;
			}
		} else {
			pauseTime -= deltaTime;
		}
		

				
		//y -= SPEED * deltaTime;
		
		if (y > Gdx.graphics.getHeight()) {
			remove = true;
		}
		
	}*/
	
	public void render (SpriteBatch batch) {
		
		batch.draw(texture, x, y);
		
	}
	
	

}
