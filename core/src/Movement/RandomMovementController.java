package Movement;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class RandomMovementController extends Movement { 

	public RandomMovementController(float speed, Texture _img) {
		super(speed, _img);
	}

	@Override
	public void Move() {
		
		Random rand = new Random();
		ySpeed += (rand.nextInt(20) - 20) * Gdx.graphics.getDeltaTime();
		xSpeed += (rand.nextInt(20) - 10) * Gdx.graphics.getDeltaTime();
		if (ySpeed > 20)
			ySpeed = 0;
		if ( xSpeed > 20)
			xSpeed = 0;
		if (ySpeed < -20)
			ySpeed = 0;
		if ( xSpeed < -20)
			xSpeed = 0;
		sprite.translateY(ySpeed * Gdx.graphics.getDeltaTime());
		sprite.translateX(xSpeed * Gdx.graphics.getDeltaTime());

	}

}
