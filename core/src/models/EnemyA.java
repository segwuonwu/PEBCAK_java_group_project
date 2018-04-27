package models;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.graphics.Texture;

public class EnemyA extends Enemy {
	
	public EnemyA(String movementType, String BulletType, String BulletMovement) {
		//add unique functionality to this class as well
		super("EnemyA", 1, BulletType, BulletMovement);
		Random rand = new Random();
		float x = rand.nextInt(600);
		float y = rand.nextInt(200) + 500;
		this.movement = mFac.Create(movementType, new Texture("Stormtrooper10.png"), x, y, -10f);
	}

}
