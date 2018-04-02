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
		this.img = _img;
		this.ySpeed = speed;
		this.xSpeed = 0;
		this.sprite = new Sprite(img);
	}
}
