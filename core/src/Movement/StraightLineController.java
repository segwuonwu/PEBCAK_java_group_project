package Movement;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class StraightLineController extends Movement {
	 public final float ySpeed;

	public StraightLineController(float speed, Texture _img) {
		super(speed, _img);
		this.ySpeed = speed;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Move() {
		this.sprite.translateY(this.ySpeed *  Gdx.graphics.getDeltaTime());
	}

}
