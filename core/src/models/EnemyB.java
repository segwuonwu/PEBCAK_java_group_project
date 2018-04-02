package models;

import java.util.Random;

import com.badlogic.gdx.graphics.Texture;


public class EnemyB extends Enemy {
	
	public EnemyB() {
		//hard coded test enemy
		//add unique functionality to this class as well
		super("EnemyB", 300);
		Random rand = new Random();
		movement = mFac.Create("straight", new Texture("EnemyB.jpg"), rand.nextInt(400), 400, -10f);
	}

}
