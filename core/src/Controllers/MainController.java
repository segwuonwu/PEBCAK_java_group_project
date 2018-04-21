package Controllers;

import java.util.ArrayList;
import java.util.Iterator;

import com.badlogic.gdx.math.Rectangle;

import Factory.BulletFactory;
import Factory.EnemyFactory;
import models.Bullet;
import models.Enemy;
import models.ObjectManagerInterface;
import models.Player;
import view.MainGameClass;

public class MainController implements MainControllerInterface{

	private MainGameClass parent;
	private ObjectManagerInterface OM;
	private CollisionControllerInterface CC;
	private MovementControllerInterface MC;
	
	float timeAux;
	float BossTimer1;
	float BossTimer2;
	float deathTimer;
	boolean boss1;
	boolean boss2;



	int showtime;
	float deltaTime;
	CharSequence str;

	float shootTimer; // for timing between pressing space and shooting bullets


	
	public MainController(MainGameClass mainGameClass, ObjectManagerInterface om) {
		
		OM = om;
		CC = new CollisionController(om);
		parent = mainGameClass;
		
		showtime = 0;
		deltaTime = 0;
		shootTimer = 0;
		timeAux = 0;
		BossTimer2 = 0;
		BossTimer2 = 0;
		boss1 = false;
		boss2 = false;
		deathTimer = 0;
	}
	
	
	public void update(float delta) {
		
		//Update collision check if death
		//Change view if dead, FIND WAY TO PUSH THAT TO VIEW
		if(!CC.update(player, Elist, PlayerBullet, EnemyBullet, delta)) {
			parent.changeScreen(MainGameClass.PREFERENCES);
		}

		Iterator<Enemy> enemyiter = Elist.iterator();
				//sweet loop to check for boss timeout and move enemys
				try {

				while (enemyiter.hasNext()) {
					Enemy en = enemyiter.next();
					en.movement.Move();
					en.shoot(delta, "bulletA", "zigzag", bulletsEnemy);
					if(en.movement.sprite.getY() <= 0)
						enemyiter.remove();
				}
				} catch (Exception e) {
				}
				
				//loop that moves player bullets and checks collision
				Iterator<Bullet> bulletsIterator = bulletsPlayer.iterator();
				while (bulletsIterator.hasNext()) {
					Bullet b = bulletsIterator.next();
					b.movement.Move();
					Iterator<Enemy> i = Elist.iterator();
					try {
						while (i.hasNext()) {
							Enemy e = i.next();c
							if (e.movement.sprite.getBoundingRectangle().overlaps(b.movement.sprite.getBoundingRectangle())) {
								bulletsIterator.remove();
									if(e.death(BossTimer1))
										i.remove();
							}
							if(b.movement.sprite.getY() <= 0) {
								bulletsIterator.remove();
							}
						}
					} catch (Exception e) {
					}
				}
				


	
	}
	
	
	//TRASH 
	public void enemyWave(ArrayList<Enemy> enemyList) {
		Elist.add(Efactory.Create("EnemyA", "random"));
		Elist.add(Efactory.Create("EnemyB", "straight"));
		Elist.add(Efactory.Create("EnemyA", "straight"));
		Elist.add(Efactory.Create("EnemyA", "straight"));
		Elist.add(Efactory.Create("EnemyB", "random"));
		Elist.add(Efactory.Create("EnemyA", "straight"));
		Elist.add(Efactory.Create("EnemyB", "straight"));
		Elist.add(Efactory.Create("EnemyA", "random"));

	}

}
