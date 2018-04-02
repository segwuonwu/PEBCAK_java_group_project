package Movement;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class ZigZagController extends Movement{
	float timer;
	
	public ZigZagController(float speed, Texture _img) {
		super(speed, _img);
		this.timer = 0;
		this.xSpeed = speed + 10f;
		this.ySpeed = speed;
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Move() {
		timer += Gdx.graphics.getDeltaTime();
		if (timer >= 2) {
			xSpeed = (xSpeed * -1);
			timer = 0;
		}
		
		this.sprite.translate(xSpeed * Gdx.graphics.getDeltaTime(), ySpeed * Gdx.graphics.getDeltaTime());
	}

}
