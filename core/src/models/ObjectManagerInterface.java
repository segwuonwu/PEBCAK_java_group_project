package models;

import java.util.ArrayList;

public interface ObjectManagerInterface {
	
	Player getPlayer();
	
	ArrayList<Enemy> getEnemyList();
	ArrayList<Bullet> getbulletsPlayer();
	ArrayList<Bullet> getbulletsEnemy();
	ArrayList<Wave> getWave();
	
	int getGameState();
	int getGameScore();
	
	void addEnemy(String enemyType, String movementType, String BulletType, String BulletMovement);
	void addEnemy(Enemy e);
	void removeEnemy(Enemy e);
	void removePlayerBullet(Bullet e);
	void removeEnemyBullet(Bullet e);
	void addPlayerBullet(Bullet e);
	void addEnemyBullet(ArrayList<Bullet> e);
	void removAllEnemyBullets();
	void addWave(Wave w);
	void removeWave(Wave current);
	//Maybe getWave() ??
}
