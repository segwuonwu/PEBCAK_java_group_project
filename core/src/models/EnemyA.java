package models;

import java.util.Random;

import com.badlogic.gdx.graphics.Texture;

public class EnemyA extends Enemy {
	
	public EnemyA(String movementType) {
		//add unique functionality to this class as well
		super("EnemyA", 1);
		Random rand = new Random();
		float x = rand.nextInt(600);
		float y = rand.nextInt(200) + 500;
		this.movement = mFac.Create(movementType, new Texture("minion.jpg"), x, y, -10f);
	}
	@Override
	public Bullet shoot(float time, String bulletType, String MovementType) {
		Bullet newBullet = null;
		lastShot += time;
		if( (lastShot - time) >= 2f ) {
		newBullet = bFac.Create("straight", "bulletA", this.movement.sprite.getX() + 10, this.movement.sprite.getY() - 20, -100f);
		lastShot = 0;
		}
		return newBullet;
	}
}
