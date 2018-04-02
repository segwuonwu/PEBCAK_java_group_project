package models;

import com.badlogic.gdx.graphics.Texture;

public class EnemyMidBoss extends Enemy {

	public EnemyMidBoss(String movementType) {
		//hard coded test enemy
		//add unique functionality to this class as well
		super("EnemyMidBoss", 10);
		movement = mFac.Create(movementType, new Texture("EnemyMidBoss.jpg"), 300, 500, -5f);
	}
	
}
