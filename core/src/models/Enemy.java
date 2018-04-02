package models;

import com.badlogic.gdx.graphics.Texture;

import Factory.BulletFactory;
import Factory.MovementFactory;
import Movement.Movement;

public abstract class Enemy {
	
	private String enemyType;
	private int health;
	private float lastShot;
	//add bulletType type when bullet class implemented
	//Physics speed?
	MovementFactory mFac;
	BulletFactory bFac;
	public Movement movement;
	
	public Enemy(String enemyType, int health) {
		mFac = new MovementFactory();
		bFac = new BulletFactory();
		this.enemyType = enemyType;
		this.health = health;
		this.lastShot = 0;
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
	public Bullet shoot(float time) {
		Bullet newBullet = null;
		lastShot += time;
		if( (lastShot - time) >= .5f ) {
		newBullet = bFac.Create("bulletA", this.movement.sprite.getX() + 10, this.movement.sprite.getY() - 20, -100f);
		}
		
		return newBullet;
	}

}
