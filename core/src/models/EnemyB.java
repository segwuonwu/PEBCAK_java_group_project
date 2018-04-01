package models;

import com.badlogic.gdx.graphics.Texture;


public class EnemyB extends Enemy {
	
	public EnemyB() {
		//hard coded test enemy
		//add unique functionality to this class as well
		super("EnemyB", new Texture("EnemyB.jpg"), 300, 3);
		this.movement.sprite.setX(200f);
		this.movement.sprite.setY(200f);
	}

}
