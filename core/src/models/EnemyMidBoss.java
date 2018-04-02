package models;

import com.badlogic.gdx.graphics.Texture;

public class EnemyMidBoss extends Enemy {

	public EnemyMidBoss(String movementType) {
		//hard coded test enemy
		//add unique functionality to this class as well
		super("EnemyMidBoss", 10);
		movement = mFac.Create(movementType, new Texture("EnemyMidBoss.jpg"), 300, 500, -5f);
	}
	
	public Bullet shoot(float time) {
		//make it so boss shoots random bullet types on call
		
		Bullet newBullet = null;
		lastShot += time;
		if( (lastShot - time) >= 2f ) {
		newBullet = bFac.Create("zigzag" ,"bulletA", this.movement.sprite.getX() + 10, this.movement.sprite.getY() - 20, -100f);
		lastShot = 0;
		}
		
		return newBullet;
	}
	
}
