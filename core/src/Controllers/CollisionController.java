package Controllers;

import java.util.ArrayList;
import java.util.Iterator;

import com.badlogic.gdx.math.Rectangle;

import models.Bullet;
import models.Enemy;
import models.ObjectManagerInterface;
import models.Player;
import view.MainGameClass;

public class CollisionController implements CollisionControllerInterface{ 
	float deathTimer = 0;
	private ObjectManagerInterface OM;
	SoundController sc = SoundController.getSC();

	CollisionController(ObjectManagerInterface om){
		OM = om;
	}
	
	@Override
	public boolean update(float delta) {
		//moves enemy bullets checks collision
		deathTimer += delta;
		
		Player player = OM.getPlayer();		
		
		ArrayList<Enemy> eList = OM.getEnemyList();
		ArrayList<Bullet> pBullets = OM.getbulletsPlayer();
		ArrayList<Bullet> eBullets = OM.getbulletsEnemy();
	
		
		ArrayList<Bullet> BulletobjectsToRemove = new ArrayList<Bullet>();
		ArrayList<Enemy> EnemyobjectsToRemove = new ArrayList<Enemy>();

		
		//loop that moves player bullets and checks collision
		try {
		Iterator<Bullet> bulletsIterator = pBullets.iterator();
		while (bulletsIterator.hasNext()) {
			Bullet b = bulletsIterator.next();
			Iterator<Enemy> i = eList.iterator();
			
				while (i.hasNext()) {
					Enemy e = i.next();
					if (e.movement.sprite.getBoundingRectangle().overlaps(b.movement.sprite.getBoundingRectangle())) {
						if(e.damage(1, delta)) {
							EnemyobjectsToRemove.add(e);
							sc.playenemyDestroy();
						}
						
						OM.removePlayerBullet(b);

					}
					
					//ADD THIS TO MOVEMENT!!!
					if(b.movement.sprite.getY() <= 0) {
						bulletsIterator.remove();
					}
				}
		}
			} catch (Exception e) {
			}
		

		try {
		for(Enemy e : EnemyobjectsToRemove)
			OM.removeEnemy(e);
		}catch (Exception e) {
		}
		
		//clear list for re-use
		BulletobjectsToRemove.clear();
		
		
		//Check for player collision agains enemey bullets
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
				BulletobjectsToRemove.add(enemyBullet);
				if(deathTimer >= 3f) {
				if(player.death()) {
					return false;
				}
					deathTimer = 0;
				}
				
				//ADD TO MOVEMENT CONTROLLER
			if(enemyBullet.movement.sprite.getY() <= 0)
				bulletsIteratorEnemy.remove();

				}
			}
		} catch (Exception e) {
		}
		
		try {
		for(Bullet b : BulletobjectsToRemove)
			OM.removeEnemyBullet(b);
		}catch (Exception e) {
		}
		
	return true;
	}
}

