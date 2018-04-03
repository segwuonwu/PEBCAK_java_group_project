package models;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;

public class EnemyMidBoss extends Enemy {

	public EnemyMidBoss(String movementType) {
		//hard coded test enemy
		//add unique functionality to this class as well
		super("EnemyMidBoss", 5);
		movement = mFac.Create(movementType, new Texture("EnemyMidBoss.jpg"), 300, 500, -5f);
	}
	
	@Override
	public void shoot(float time,String bulletType, String MovementType, ArrayList<Bullet> bulletList ) {
		//make it so boss shoots random bullet types on call
		
		Bullet newBullet = null;
		lastShot += time;
		if( (lastShot - time) >= 1f ) {
			newBullet = bFac.Create("zigzag" ,"bulletA", this.movement.sprite.getX() + 10, this.movement.sprite.getY() - 20, -100f);
			lastShot = 0;
			bulletList.add(newBullet);
			newBullet = bFac.Create("zigzag" ,"bulletA", this.movement.sprite.getX() + 60, this.movement.sprite.getY() - 20, -100f);
			bulletList.add(newBullet);
			newBullet = bFac.Create("straight" ,"bulletA", this.movement.sprite.getX() + 30, this.movement.sprite.getY() - 20, -100f);
			bulletList.add(newBullet);
			newBullet = bFac.Create("zigzag" ,"bulletA", this.movement.sprite.getX() + 80, this.movement.sprite.getY() - 20, -100f);
			lastShot = 0;
			bulletList.add(newBullet);
			newBullet = bFac.Create("zigzag" ,"bulletA", this.movement.sprite.getX() + 70, this.movement.sprite.getY() - 20, -100f);
			bulletList.add(newBullet);
			newBullet = bFac.Create("straight" ,"bulletA", this.movement.sprite.getX() + 100, this.movement.sprite.getY() - 20, -100f);
			bulletList.add(newBullet);
			lastShot = 0;
		}
		
	}
	@Override
	public boolean bosstimer(float timer) {
		if (timer > 80)
			return true;
		return false;
	}
	
}
