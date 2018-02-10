package com.cpts.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.Sprite;



//Instantiate with Player p = new Player();
//draw with batch.draw(p.sprite, p.sprite.getX(), p.sprite.getY());

public class Player {
	
	Texture img;
	Sprite sprite;
	
	float xSpeed, ySpeed;
	
	//Bullet bulletType1, bulletType2;
	//The bullet types to be used by the player for firing,
	//Bullet class is not yet implemented
	
	Player()
	{
		img = new Texture("player.png");
		sprite = new Sprite(img);
		sprite.setX(0f);
		sprite.setY(0f);
		xSpeed = 5f;
		ySpeed = 3f;
	}

	public void clampPlayerToScreen()
	{
		//the farthest the player is allowed to move to the right
		float RightBound = Gdx.graphics.getWidth() - sprite.getWidth();
		//the farthest the player is allowed to move up
		float UpperBound = Gdx.graphics.getHeight() - sprite.getHeight();
		
		
		
		if (sprite.getX() < 0f)                 //left
		{
			sprite.setX(0f);
		}
		else if (sprite.getX() > RightBound)    //right
		{
			sprite.setX(RightBound);
		}
		
		
		if (sprite.getY() < 0f)                 //bottom
		{
			sprite.setY(0f);
		}
		
		if (sprite.getY() > UpperBound)         //top
		{
			sprite.setY(UpperBound);
		}
		
	}
	

	public void handleMovement()
	{
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
		{
			sprite.translateX(-xSpeed);
		}
		else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT))
		{
			sprite.translateX(xSpeed);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.UP))
		{
			sprite.translateY(ySpeed);
		}
		else if (Gdx.input.isKeyPressed(Input.Keys.DOWN))
		{
			sprite.translateY(-ySpeed);
		}
		clampPlayerToScreen();
	}
	

}
