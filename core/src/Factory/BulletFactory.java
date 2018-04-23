package Factory;

import models.Bullet;
import models.BulletA;
import models.BulletB;

public class BulletFactory {
	
	MovementFactory mFac = new MovementFactory();

	
	public BulletFactory() {}
	
	//change to pass in just a string and the sprite, get locations from sprite, type of bullet determines speed
	public Bullet Create(String movementType, String bulletType, float _x, float _y, float speed) {
		Bullet bullet = null;
		if(bulletType.equals("bulletA")) {
			bullet = new BulletA(movementType,_x, _y, speed);
		}
		else if(bulletType.equals("bulletB")) {
			bullet = new BulletB(movementType,_x, _y, speed);
		}
		return bullet;
	}

}
