package Controllers;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;

import models.Bullet;
import models.Enemy;
import models.ObjectManagerInterface;
import models.Player;

public class MovementController implements MovementControllerInterface{

	private ObjectManagerInterface OM;
	
	int x = Gdx.graphics.getWidth();
	int y = Gdx.graphics.getHeight();

	MovementController(ObjectManagerInterface om){
		OM = om;
	}	
	
	@Override
	public void update() {

		Player player = OM.getPlayer();		
		
		ArrayList<Enemy> eList = OM.getEnemyList();
		ArrayList<Bullet> pBullets = OM.getbulletsPlayer();
		ArrayList<Bullet> eBullets = OM.getbulletsEnemy();
		
		ArrayList<Bullet> bulletToRemove = new ArrayList<Bullet>();
		ArrayList<Enemy> EnemyToRemove = new ArrayList<Enemy>();
		
		player.move();
		
		for(Bullet pb : pBullets) {
			pb.movement.Move();
			if(pb.movement.sprite.getY() >= y)
				bulletToRemove.add(pb);
		}
		
		for(Bullet eb : eBullets) {
			eb.movement.Move();
			if(eb.movement.sprite.getY() <= 0)
				bulletToRemove.add(eb);
		}
		
		for(Enemy e : eList) {
			e.movement.Move();
			if(e.movement.sprite.getX() <= -10 || e.movement.sprite.getX() <= x + 10 || e.movement.sprite.getY() <= 0)
				EnemyToRemove.add(e);	
		}
		
		
		for(Enemy er: EnemyToRemove) {
			OM.removeEnemy(er);
		}
		
		for(Bullet br: bulletToRemove) {
			OM.removeEnemyBullet(br);
		}
		
	}
}
