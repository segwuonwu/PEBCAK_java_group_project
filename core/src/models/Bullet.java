package models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.TimeUtils;

import Factory.MovementFactory;
import Movement.Movement;
import Movement.StraightLineController;

public abstract class Bullet {
	
	public Movement movement;
	MovementFactory mFac;


	float stopTimer;

	
	boolean hasStopped = false;
	
	public boolean remove = false;
	
	public Bullet(String movementType, float _x, float _y, float speed) {
		mFac = new MovementFactory();
	}

	public Texture getImg() {
		return this.movement.img;
	}
	
}
