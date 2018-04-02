package models;

import com.badlogic.gdx.graphics.Texture;

public class EnemyMidBoss extends Enemy {

	public EnemyMidBoss() {
		//hard coded test enemy
		//add unique functionality to this class as well
		super("EnemyMidBoss", 100);
		movement = mFac.Create("straight", new Texture("EnemyMidBoss.jpg"), 500, 400, -5f);
	}
	
}
