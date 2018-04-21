package Controllers;

import java.util.ArrayList;

import models.Bullet;
import models.Enemy;
import models.Player;

public interface CollisionControllerInterface {
	public boolean update(float delta);
}