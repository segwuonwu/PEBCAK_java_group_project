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
	SoundController sc = SoundController.getSC();
	
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
			sc.playHealth();
		}

		if(bombTimer > 30f)
			player.setBomb(true);

		//UPDATE PLAYER BULLET LIST
		if (Gdx.input.isKeyJustPressed(Keys.SPACE) && shootTimer >= .1f) {
			shootTimer = 0;
			Bullet p = player.shoot();
			OM.addPlayerBullet(p);
			sc.playBullet();
		}
		
		//DO MASSIVE DAMAGE TO ALL ENEMYS AND REMOVE ALL ENEMY BULLETS
		if (Gdx.input.isKeyJustPressed(Keys.B) && player.hasBomb()) {
			player.setBomb(false);
			
			ArrayList<Enemy> eToRemove = new ArrayList<Enemy>();

			OM.removAllEnemyBullets();
			sc.playCheatCode();
			for(Enemy e : eList) {
				if(e.damage(5, delta)) {
					eToRemove.add(e);
				}
			}
			for(Enemy e: eToRemove)
				OM.removeEnemy(e);
		}

		//UPDATE ENEMY BULLET LIST
			for(Enemy e : eList) {
				ArrayList<Bullet> b = new ArrayList<Bullet>();
				ArrayList<Bullet> bleh = e.shoot(delta);
				if(!bleh.isEmpty())
					b.addAll(bleh);
				if(!b.isEmpty()) {
					OM.addEnemyBullet(b);
				}
			}
			if(eList.isEmpty()) {
				return true;
			}
	return false;
	}

}
