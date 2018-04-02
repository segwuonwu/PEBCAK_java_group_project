package models;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import Movement.Movement;
import Movement.PlayerMovementController;

import com.badlogic.gdx.graphics.g2d.Sprite;



//Instantiate with Player p = new Player();
//draw with batch.draw(p.sprite, p.sprite.getX(), p.sprite.getY());

public class Player{

	int health;
	public Movement movement;
	
	public Player()
	{
		health = 5;
		movement = new PlayerMovementController(1f, new Texture("player.png"));	
	}
	
	public void move() {
		movement.Move();
	}
	
	public boolean death() {
		this.health = this.health - 1;
		if(this.health <= 0)
			return true;
		return false;
	}
	
}
