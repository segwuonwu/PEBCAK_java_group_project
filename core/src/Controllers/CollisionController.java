package Controllers;

import java.util.ArrayList;
import java.util.Iterator;

import com.sun.javafx.geom.Rectangle;

import models.Bullet;
import models.Enemy;
import models.Player;
import view.MainGameClass;

public class CollisionController implements CollisionControllerInterface{ 
	float deathTimer = 0;
	
	@Override
	public boolean update(Player player, ArrayList<Enemy> eList, ArrayList<Bullet> pBullets, ArrayList<Bullet> eBullets, float delta) {
		//moves enemy bullets checks collision
		deathTimer += delta;
		
		Iterator<Bullet> bulletsIteratorEnemy = eBullets.iterator();
		try {

		while (bulletsIteratorEnemy.hasNext()) {
			Bullet enemyBullet = bulletsIteratorEnemy.next();
			Rectangle bounds = player.movement.sprite.getBoundingRectangle();
			float w = bounds.getWidth();
			float h = bounds.getHeight();
			bounds.setSize(bounds.width*0.7f, bounds.height*.7f);
			bounds.setPosition( bounds.x+(w-bounds.width)/2F, bounds.y+(h-bounds.height)/2);
			if (enemyBullet.movement.sprite.getBoundingRectangle().overlaps(bounds)) {
				bulletsIteratorEnemy.remove();
				if(deathTimer >= 3f) {
				if(player.death()) {
					parent.changeScreen(MainGameClass.PREFERENCES);
					}
					deathTimer = 0;
				}
			if(enemyBullet.movement.sprite.getY() <= 0)
				bulletsIteratorEnemy.remove();

				}
			}
		} catch (Exception e) {
		}
		
		
	}
}

