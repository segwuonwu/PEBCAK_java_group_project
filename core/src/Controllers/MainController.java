package Controllers;

import java.util.ArrayList;
import java.util.Iterator;

import com.badlogic.gdx.math.Rectangle;

import Factory.BulletFactory;
import Factory.EnemyFactory;
import models.Bullet;
import models.Enemy;
import models.Player;
import view.MainGameClass;

public class MainController {

	private MainGameClass parent;
	float timeAux;
	float BossTimer1;
	float BossTimer2;
	float deathTimer;
	boolean boss1;
	boolean boss2;

	// Creating Factory for enemy's and a list to store them in
	EnemyFactory Efactory;
	BulletFactory Bfactory;
	ArrayList<Enemy> Elist;
	Player player;

	int showtime;
	float deltaTime;
	CharSequence str;

	float shootTimer; // for timing between pressing space and shooting bullets

	// lists to store bullets
	ArrayList<Bullet> bulletsPlayer; // store bullets created
	ArrayList<Bullet> bulletsEnemy;
	
	public MainController(MainGameClass mainGameClass, Player _player,ArrayList<Bullet> _bulletsPlayer, ArrayList<Bullet> _bulletsEnemy, ArrayList<Enemy> _enemyList) {
		parent = mainGameClass;
		player = _player;
		bulletsPlayer = _bulletsPlayer;
		bulletsEnemy = _bulletsEnemy;
		Elist = _enemyList;
		Bfactory = new BulletFactory();
		Efactory = new EnemyFactory();
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
		//Can refactor this to use a single timer.... my bad -Kris
		BossTimer1 += delta;
		BossTimer2 += delta;
		deathTimer += delta;
		
		
		//Make a wave class for this
				//Attach a start time, end timish
				//This will have mid and finial bosses in a wave
				if (timeAux >= 5 && (BossTimer1 <= 60 || BossTimer1 >= 75) && (BossTimer2 <= 120)) { // 10 seconds
					enemyWave(Elist);
					timeAux = 0;
				} else {
					timeAux += delta;
				}
				if (BossTimer1 >= 60 && boss1 == false) {
					Elist.add(Efactory.Create("EnemyMidBoss", "stationary"));
					boss1 = true;
				}
				if (BossTimer2 >= 120  && boss2 == false) {
					Elist.add(Efactory.Create("EnemyFinalBoss", "stationary"));
					boss2 = true;
				}
				if(boss2 == true && Elist.isEmpty())
					parent.changeScreen(MainGameClass.VICTORY);

					

				player.move();
				Iterator<Enemy> enemyiter = Elist.iterator();
				//sweet loop to check for boss timeout and move enemys
				try {

				while (enemyiter.hasNext()) {
					Enemy en = enemyiter.next();
					if(en.bosstimer(BossTimer1))
						enemyiter.remove();
					en.movement.Move();
					//ZIGZAG IS A PLACEHOLDER, CURRENTLY PASSED IN VALUE DOESNT MATTER
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
							Enemy e = i.next();
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
				
				//moves enemy bullets checks collision
				Iterator<Bullet> bulletsIteratorEnemy = bulletsEnemy.iterator();
				try {

				while (bulletsIteratorEnemy.hasNext()) {
					Bullet enemyBullet = bulletsIteratorEnemy.next();
					enemyBullet.movement.Move();
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
	
	private void collistion(ArrayList<Bullet> bullets, ArrayList<Enemy> enemys) {
		
	}
	
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
