package Factory;

import models.Bullet;
import models.BulletA;

public class BulletFactory {
	
	public BulletFactory() {}
	
	//change to pass in just a string and the sprite, get locations from sprite, type of bullet determines speed
	public Bullet Create(String bulletType, float _x, float _y, float speed) {
		Bullet bullet = new BulletA(_x, _y, speed);
		//if statements for bullet types
		
		return bullet;
	}

}
