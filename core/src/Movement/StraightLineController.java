package Movement;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class StraightLineController extends Movement {
	

	public StraightLineController(float speed, Texture _img) {
		super(speed, _img);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Move() {
		sprite.translateY(ySpeed *  Gdx.graphics.getDeltaTime());
	}

}
