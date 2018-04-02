package models;

import com.badlogic.gdx.graphics.Texture;

public class EnemyFinalBoss extends Enemy {
	
	public EnemyFinalBoss() {
		//hard coded test enemy
		//add unique functionality to this class as well
		super("EnemyFinalBoss", 20);
		movement = mFac.Create("straight", new Texture("EnemyFinalBoss.jpg"), 600, 400, -5f);
	}
	
}
