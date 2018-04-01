package models;

import com.badlogic.gdx.graphics.Texture;

public class EnemyA extends Enemy {
	
	public EnemyA() {
		//hard coded test enemy
		//add unique functionality to this class as well
		super("EnemyA", new Texture("EnemyA.jpg"), 200, 3);
		this.movement.sprite.setX(100f);
		this.movement.sprite.setY(100f);
	}
}
