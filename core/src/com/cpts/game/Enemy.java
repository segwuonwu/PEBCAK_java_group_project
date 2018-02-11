package com.cpts.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.Input.Keys;

public abstract class Enemy {
	
	private String enemyType;
	private Texture img;
	private int health;
	//add bulletType type when bullet class implemented
	//Physics speed?
	private int speed;
	
	public Enemy(String enemyType, Texture img, int health, int speed) {
		this.enemyType = enemyType;
		this.img = img;
		this.health = health;
		this.speed = speed;
	}
	
	protected void reverseSpeed(){
		this.speed = speed*=-1;		
	}
	
	protected String getEnemyType() {
		return enemyType;
	}
	protected void setEnemyType(String enemyType) {
		this.enemyType = enemyType;
	}
	protected Texture getImg() {
		return img;
	}
	protected void setImg(Texture img) {
		this.img = img;
	}
	protected int getHealth() {
		return health;
	}
	protected void setHealth(int health) {
		this.health = health;
	}
	protected int getSpeed() {
		return speed;
	}
	protected void setSpeed(int speed) {
		this.speed = speed;
	}
	
	
	
	
	

}
