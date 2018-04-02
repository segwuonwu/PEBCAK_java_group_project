package models;

import java.util.Random;

import com.badlogic.gdx.graphics.Texture;

public class EnemyA extends Enemy {
	
	public EnemyA(String movementType) {
		//hard coded test enemy
		//add unique functionality to this class as well
		super("EnemyA", 1);
		Random rand = new Random();
		float x = rand.nextInt(600);
		float y = rand.nextInt(200) + 500;
		this.movement = mFac.Create(movementType, new Texture("EnemyA.jpg"), x, y, -10f);
	}
}
