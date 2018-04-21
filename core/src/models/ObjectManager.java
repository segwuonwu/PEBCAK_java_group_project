package models;

import java.util.ArrayList;

import Factory.BulletFactory;
import Factory.EnemyFactory;

public class ObjectManager implements ObjectManagerInterface {
	Player player;
	
	EnemyFactory Efactory;
	BulletFactory Bfactory;
	
	ArrayList<Enemy> Elist;
	ArrayList<Bullet> bulletsPlayer;
	ArrayList<Bullet> bulletsEnemy;
	
	public ObjectManager(){
		player = new Player();
		Bfactory = new BulletFactory();
		Efactory = new EnemyFactory();
		Efactory = new EnemyFactory();
		Bfactory = new BulletFactory();
		Elist = new ArrayList<Enemy>();
		bulletsPlayer = new ArrayList<Bullet>();
		bulletsEnemy = new ArrayList<Bullet>();
	}
	
	@Override
	public Player getPlayer() {
		return player;
	}

	@Override
	public ArrayList<Enemy> getEnemyList() {
		return Elist;
	}

	@Override
	public ArrayList<Bullet> getbulletsPlayer() {
		return bulletsPlayer;
	}

	@Override
	public ArrayList<Bullet> getbulletsEnemy() {
		return bulletsEnemy;
	}

	@Override
	public int getGameState() {
		// implement some kind of gamestate
		return 0;
	}

	@Override
	public int getGameScore() {
		// Figure out how we want to score the game
		return 0;
	}

	@Override
	public void addEnemy(String enemyType, String movementType, String BulletType, String BulletMovement) {
		Elist.add(Efactory.Create(enemyType, movementType, BulletType, BulletMovement));

	}

	@Override
	public void removeEnemy(Enemy e) {
		Elist.remove(e);
	}

	@Override
	public void removePlayerBullet(Bullet e) {
		bulletsPlayer.remove(e);
		
	}

	@Override
	public void removeEnemyBullet(Bullet e) {
		bulletsEnemy.remove(e);
		
	}

	@Override
	public void addPlayerBullet(Bullet e) {
		bulletsPlayer.add(e);
	}

	@Override
	public void addEnemyBullet(Bullet e) {
		bulletsEnemy.add(e);
	}

	@Override
	public void removAllEnemyBullets() {
		bulletsEnemy.clear();
	}

}
