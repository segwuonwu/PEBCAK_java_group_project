package models;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;

import Factory.BulletFactory;
import Factory.MovementFactory;
import Movement.Movement;

public abstract class Enemy {
	
	private String enemyType;
	private String bulletType;
	private String bulletMovement;
	protected int health;
	protected float lastShot;
	//add bulletType type when bullet class implemented
	//Physics speed?
	MovementFactory mFac;
	BulletFactory bFac;
	public Movement movement;
	
	public Enemy(String enemyType, int health, String bullet, String bulletMov) {
		
		mFac = new MovementFactory();
		bFac = new BulletFactory();
		this.enemyType = enemyType;
		this.health = health;
		this.lastShot = 0;
		setBulletType(bullet);
		setBulletMovement(bulletMov);
		
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
	public Boolean death(float delta) {
		if(health <= 0)
			return true;
		return false;
	}
	public Boolean damage(int damage, float delta) {
		health -= damage;
		return death(delta);
	}
	protected void setHealth(int health) {
		this.health = health;
	}
	
	public boolean bosstimer(float timer) {
		return false;
	}
	
	public ArrayList<Bullet> shoot(float delta) {
		ArrayList<Bullet> b = new ArrayList<Bullet>();
		Bullet newBullet = null;
		lastShot += delta;
		if( (lastShot - delta) >= 2f ) {
		newBullet = bFac.Create(getBulletMovement(), getBulletType(), this.movement.sprite.getX() + 10, this.movement.sprite.getY() - 20, -100f);
		lastShot = 0;
		}
		if(newBullet != null)
			b.add(newBullet);
		return b;
	}

	public String getBulletMovement() {
		return bulletMovement;
	}

	public void setBulletMovement(String bulletMovement) {
		this.bulletMovement = bulletMovement;
	}

	public String getBulletType() {
		return bulletType;
	}

	public void setBulletType(String bulletType) {
		this.bulletType = bulletType;
	}

}
