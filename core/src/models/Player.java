package models;

import com.badlogic.gdx.graphics.Texture;
import Movement.Movement;
import Movement.PlayerMovementController;



//Instantiate with Player p = new Player();
//draw with batch.draw(p.sprite, p.sprite.getX(), p.sprite.getY());

public class Player{

	int health;
	public Movement movement;
	
	public Player()
	{
		health = 5;
		movement = new PlayerMovementController(1f, new Texture("icon_32.png"));	
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
	public String getHealth() {
		return Integer.toString(this.health);
	}
	
}
