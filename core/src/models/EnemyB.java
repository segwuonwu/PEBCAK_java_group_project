package models;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.graphics.Texture;


public class EnemyB extends Enemy {
	
	public EnemyB(String movementType) {
		//hard coded test enemy
		//add unique functionality to this class as well
		super("EnemyB", 1);
		Random rand = new Random();
		float x = rand.nextInt(600);
		float y = rand.nextInt(200) + 500;
		movement = mFac.Create(movementType, new Texture("cat.jpg"), x, y, -40f);
	}

	@Override
	public void shoot(float time, String bulletType, String MovementType, ArrayList<Bullet> bulletList) {
		Bullet newBullet = null;
		lastShot += time;
		if( (lastShot - time) >= 2f ) {
		newBullet = bFac.Create("zigzag", "bulletA", this.movement.sprite.getX() + 10, this.movement.sprite.getY() - 20, -100f);
		lastShot = 0;
		bulletList.add(newBullet);
		}
	}
}
