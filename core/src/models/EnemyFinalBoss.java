package models;

import com.badlogic.gdx.graphics.Texture;

public class EnemyFinalBoss extends Enemy {
	
	public EnemyFinalBoss(String movementType) {
		//hard coded test enemy
		//add unique functionality to this class as well
		super("EnemyFinalBoss", 20);
		movement = mFac.Create(movementType, new Texture("EnemyFinalBoss.jpg"), 300, 500, -5f);
	}
	
}
