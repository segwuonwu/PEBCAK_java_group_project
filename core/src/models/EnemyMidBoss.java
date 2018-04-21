package models;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;

public class EnemyMidBoss extends Enemy {

	float timer;

	public EnemyMidBoss(String movementType, String BulletType, String BulletMovement) {
		//hard coded test enemy
		//add unique functionality to this class as well
		super("EnemyMidBoss", 5, BulletType, BulletMovement);
		movement = mFac.Create(movementType, new Texture("EnemyMidBoss.jpg"), 300, 500, -5f);
		timer = 0;
	}

	@Override
	public boolean bosstimer(float delta) {
		timer += delta;
		if (timer > 80)
			return true;
		return false;
	}
	
}
