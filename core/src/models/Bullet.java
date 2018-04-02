package models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.TimeUtils;

import Movement.Movement;
import Movement.StraightLineController;

public abstract class Bullet {
	
	public Movement movement;

	float stopTimer;

	
	boolean hasStopped = false;
	
	public boolean remove = false;
	
	public Bullet(float _x, float _y, float speed) {
		this.movement = new StraightLineController( speed, new Texture("bullet.png"));
		this.movement.sprite.setY(_y);
		this.movement.sprite.setX(_x);
	}

	public Texture getImg() {
		return this.movement.img;
	}
	
}
