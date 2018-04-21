package Controllers;

import java.util.ArrayList;

import models.Bullet;
import models.Enemy;
import models.Player;

public interface CollisionControllerInterface {
	public boolean update(Player player, ArrayList<Enemy> eList, ArrayList<Bullet> pBullets, ArrayList<Bullet> eBullets, float delta);
}