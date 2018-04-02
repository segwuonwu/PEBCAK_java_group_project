package models;

import com.badlogic.gdx.graphics.Texture;

public class BulletA extends Bullet{

	public BulletA(String movementType, float _x, float _y, float speed) {
		super(null, _x, _y, speed);
		this.movement = mFac.Create(movementType, new Texture("bullet.png"), _x, _y, speed);

		// TODO Auto-generated constructor stub
	}

}
