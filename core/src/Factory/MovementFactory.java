package Factory;

import com.badlogic.gdx.graphics.Texture;

import Movement.Movement;
import Movement.RandomMovementController;
import Movement.StationaryController;
import Movement.StraightLineController;
import Movement.ZigZagController;

public class MovementFactory {

	public MovementFactory(){}
	
	public Movement Create(String type, Texture _img, float _x, float _y, float speed) {
		Movement mov = null;
		
		if(type.equals("straight")) {
			mov = new StraightLineController(speed, _img);
		}
		else if(type.equals("random")) {
			mov = new RandomMovementController(speed, _img);
		}
		else if(type.equals("stationary")) {
			mov = new StationaryController(speed, _img);
		}
		else if(type.equals("zigzag")) {
			mov = new ZigZagController(speed, _img);
		}
		mov.sprite.setX(_x);
		mov.sprite.setY(_y);
		
		return mov;
	}
	
}
