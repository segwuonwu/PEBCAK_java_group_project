package Movement;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class PlayerMovementController extends Movement{


	float xSpeed, xSpeedSlow, ySpeedSlow;
	boolean slowMotionEnabled;
	int slowMotionToggleCooldown;

	
	public PlayerMovementController(float speed, Texture _img) {
		super(speed, _img);
		this.sprite.setX(0f);
		this.sprite.setY(0f);
		this.xSpeed = 5f;
		this.ySpeed = 3f;
		this.xSpeedSlow = 2f;
		this.ySpeedSlow = 1f;
		this.slowMotionToggleCooldown = 10;	}
	
	@Override
	public void Move() {
		// TODO Auto-generated method stub
		if (Gdx.input.isKeyPressed(Input.Keys.Z) && slowMotionToggleCooldown <= 0)
		{
			this.slowMotionEnabled = !slowMotionEnabled;
			this.slowMotionToggleCooldown = 1;
		}
		if (!Gdx.input.isKeyPressed(Input.Keys.Z))
		{
			this.slowMotionToggleCooldown--;
		}
		
		
		if (slowMotionEnabled)
		{
			moveSlowly();
		}
		else
		{
			moveNormal();
		}
		
	}
	
	public void clampPlayerToScreen()
	{
		//the farthest the player is allowed to move to the right
		float RightBound = Gdx.graphics.getWidth() - sprite.getWidth();
		//the farthest the player is allowed to move up
		float UpperBound = Gdx.graphics.getHeight() - sprite.getHeight();
		
		
		
		if (sprite.getX() < 0f)                 //left
		{
			this.sprite.setX(0f);
		}
		else if (sprite.getX() > RightBound)    //right
		{
			this.sprite.setX(RightBound);
		}
		
		
		if (sprite.getY() < 0f)                 //bottom
		{
			this.sprite.setY(0f);
		}
		
		if (sprite.getY() > UpperBound)         //top
		{
			this.sprite.setY(UpperBound);
		}
		
	}
	

	public void moveNormal()
	{
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
		{
			this.sprite.translateX(-xSpeed);
		}
		else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT))
		{
			this.sprite.translateX(xSpeed);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.UP))
		{
			this.sprite.translateY(ySpeed);
		}
		else if (Gdx.input.isKeyPressed(Input.Keys.DOWN))
		{
			this.sprite.translateY(-ySpeed);
		}
		clampPlayerToScreen();
	}
	
	public void moveSlowly()
	{
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
		{
			this.sprite.translateX(-xSpeedSlow);
		}
		else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT))
		{
			this.sprite.translateX(xSpeedSlow);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.UP))
		{
			this.sprite.translateY(ySpeedSlow);
		}
		else if (Gdx.input.isKeyPressed(Input.Keys.DOWN))
		{
			this.sprite.translateY(-ySpeedSlow);
		}
		clampPlayerToScreen();
	}

}
