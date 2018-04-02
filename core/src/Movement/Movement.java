package Movement;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public abstract class Movement implements iMovementController{
	public float ySpeed;
	public float xSpeed;
	public Texture img;
	public Sprite sprite;

	public Movement(float speed, Texture _img)
	{
		img = _img;
		ySpeed = speed;
		xSpeed = 0;
		sprite = new Sprite(img);
	}
}
