package models;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;

import Factory.BulletFactory;
import Factory.MovementFactory;
import Movement.Movement;

public abstract class Enemy {
	
	private String enemyType;
	private int health;
	protected float lastShot;
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
	public Boolean death() {
		this.health = this.health - 1;
		if(this.health <= 0)
			return true;
		return false;
	}
	protected void setHealth(int health) {
		this.health = health;
	}

	public void shoot(float time, String bulletType, String MovementType,ArrayList<Bullet> bulletList ) {
		Bullet newBullet = null;
		lastShot += time;
		if( (lastShot - time) >= 2f ) {
		newBullet = bFac.Create(MovementType, bulletType, this.movement.sprite.getX() + 10, this.movement.sprite.getY() - 20, -100f);
		lastShot = 0;
		bulletList.add(newBullet);

		}		}

}
