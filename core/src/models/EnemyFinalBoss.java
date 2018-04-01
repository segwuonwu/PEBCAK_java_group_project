package models;

import com.badlogic.gdx.graphics.Texture;

public class EnemyFinalBoss extends Enemy {
	
	public EnemyFinalBoss() {
		//hard coded test enemy
		//add unique functionality to this class as well
		super("EnemyFinalBoss", new Texture("EnemyFinalBoss.jpg"), 100, 3);
		this.movement.sprite.setX(400f);
		this.movement.sprite.setY(400f);
	}
	
}
