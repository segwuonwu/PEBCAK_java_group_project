package models;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

import Movement.StraightLineController;

import com.badlogic.gdx.Input.Keys;

public abstract class Enemy {
	
	private String enemyType;
	private int health;
	//add bulletType type when bullet class implemented
	//Physics speed?
	public StraightLineController movement;
	
	public Enemy(String enemyType, Texture img, int health, int speed) {
		this.enemyType = enemyType;
		this.health = health;
		movement = new StraightLineController( -2f, img);
	}
	
	
	protected String getEnemyType() {
		return enemyType;
	}
	protected void setEnemyType(String enemyType) {
		this.enemyType = enemyType;
	}
	public Texture getImg() {
		return movement.img;
	}
	protected void setImg(Texture img) {
		this.movement.img = img;
	}
	protected int getHealth() {
		return health;
	}
	protected void setHealth(int health) {
		this.health = health;
	}
	public float getSpeed() {
		return movement.ySpeed;
	}
	public void setSpeed(int speed) {
		this.movement.ySpeed = speed;
	}

}
