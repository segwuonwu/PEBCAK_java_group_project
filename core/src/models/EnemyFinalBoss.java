package models;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;

public class EnemyFinalBoss extends Enemy {
	
	float timer;
	
	public EnemyFinalBoss(String movementType, String BulletType, String BulletMovement) {
		//hard coded test enemy
		//add unique functionality to this class as well
		super("EnemyFinalBoss", 10, BulletType, BulletMovement);
		movement = mFac.Create(movementType, new Texture("EnemyFinalBoss.jpg"), 300, 500, -5f);
		timer = 80;
	}

	@Override
	public boolean bosstimer(float delta) {
		timer += delta;
		if (timer > 80)
			return true;
		return false;
	}
}
