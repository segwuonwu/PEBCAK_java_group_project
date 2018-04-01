package models;

import com.badlogic.gdx.graphics.Texture;

public class EnemyMidBoss extends Enemy {

	public EnemyMidBoss() {
		//hard coded test enemy
		//add unique functionality to this class as well
		super("EnemyMidBoss", new Texture("EnemyMidBoss.jpg"), 100, 3);
		this.movement.sprite.setX(500f);
		this.movement.sprite.setY(500f);
	}
	
}
