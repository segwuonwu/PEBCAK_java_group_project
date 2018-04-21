package models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import Factory.BulletFactory;
import Movement.Movement;
import Movement.PlayerMovementController;



//Instantiate with Player p = new Player();
//draw with batch.draw(p.sprite, p.sprite.getX(), p.sprite.getY());

public class Player{

	int health;
	private boolean bomb;
	float lastShot;
	String currentBulletType;
	String currentBulletMovement;
	float currentBulletSpeed;

	public Movement movement;
	BulletFactory bFac;
	
	public Player()
	{
		health = 5;
		lastShot = 0;
		movement = new PlayerMovementController(1f, new Texture("icon_32.png"));
		bFac = new BulletFactory();
		currentBulletType = "bulletB";
		currentBulletMovement = "straight";
		currentBulletSpeed = 300f;
		bomb = true;

	}
	
	public void move() {
		movement.Move();
	}
	
	public boolean death() {
		this.health = this.health - 1;
		if(this.health <= 0)
			return true;
		this.movement.sprite.setX(300);
		this.movement.sprite.setY(5);
		return false;
		
	}
	public String getHealth() {
		return Integer.toString(this.health);
	}
	
	public boolean hasBomb() {
		return bomb;
	}
	
	public Bullet shoot(){

		Bullet newBullet = bFac.Create(currentBulletMovement, currentBulletType, this.movement.sprite.getX() + 10, this.movement.sprite.getY() + 22, currentBulletSpeed);
		
		return newBullet;
	}
	public void setBomb(boolean b) {
		bomb = b;
	}
	
}
