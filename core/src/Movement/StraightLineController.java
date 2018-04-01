package Movement;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class StraightLineController implements iMovementController {
	
	public float ySpeed;
	public Texture img;
	public Sprite sprite;

	public StraightLineController(float speed, Texture _img)
	{
		img = _img;
		ySpeed = speed;
		sprite = new Sprite(img);
	}

	@Override
	public void Move() {
		sprite.translateY(ySpeed);
	}

}
