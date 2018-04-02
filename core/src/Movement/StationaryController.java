package Movement;

import com.badlogic.gdx.graphics.Texture;

public class StationaryController extends Movement{

	public StationaryController(float speed, Texture _img) {
		super(speed, _img);
	}

	@Override
	public void Move() {
		//DO NOTHING CAUSE WE DONT MOVE!!!!!!!!!!!!!!!!!!!!!!!!!
	}

}
