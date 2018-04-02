package models;

import java.util.Random;

import com.badlogic.gdx.graphics.Texture;

public class EnemyA extends Enemy {
	
	public EnemyA() {
		//hard coded test enemy
		//add unique functionality to this class as well
		super("EnemyA", 200);
		Random rand = new Random();
		movement = mFac.Create("straight", new Texture("EnemyA.jpg"), rand.nextInt(400), 400, -10f);
		this.movement.sprite.setX(500f);
		this.movement.sprite.setY(500f);
	}
}
