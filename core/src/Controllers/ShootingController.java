package Controllers;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

import models.Bullet;
import models.Enemy;
import models.ObjectManagerInterface;
import models.Player;

public class ShootingController implements ShootingControllerInterface {

	private ObjectManagerInterface OM;
	private float shootTimer = 0;
	private float bombTimer = 0;

	ShootingController(ObjectManagerInterface om){
		OM = om;
	}
	
	@Override
	public boolean update(float delta) {
		//shoot timer is used to slow down rate of player bullets
		shootTimer += delta;
		bombTimer += delta;
		Player player = OM.getPlayer();
		ArrayList<Enemy> eList = OM.getEnemyList();
		
		//ADD HEALTH CHEAT
		if (Gdx.input.isKeyJustPressed(Keys.P)) {
			player.health += 10;
		}

		if(bombTimer > 30f)
			player.setBomb(true);

		//UPDATE PLAYER BULLET LIST
		if (Gdx.input.isKeyJustPressed(Keys.SPACE) && shootTimer >= .1f) {
			shootTimer = 0;
			Bullet p = player.shoot();
			OM.addPlayerBullet(p);
		}
		
		//DO MASSIVE DAMAGE TO ALL ENEMYS AND REMOVE ALL ENEMY BULLETS
		if (Gdx.input.isKeyJustPressed(Keys.B) && player.hasBomb()) {
			player.setBomb(false);
			ArrayList<Enemy> eToRemove = new ArrayList<Enemy>();

			OM.removAllEnemyBullets();
			for(Enemy e : eList) {
				if(e.damage(50, delta)) {
					eToRemove.add(e);
				}
			}
			for(Enemy e: eToRemove)
				OM.removeEnemy(e);
		}

		//UPDATE ENEMY BULLET LIST
			for(Enemy e : eList) {
				Bullet b = e.shoot(delta);
				if(b != null) {
					OM.addEnemyBullet(b);
				}
			}
			if(eList.isEmpty()) {
				return true;
			}
	return false;
	}

}
