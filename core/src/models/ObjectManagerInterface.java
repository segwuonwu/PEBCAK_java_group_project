package models;

import java.util.ArrayList;

public interface ObjectManagerInterface {
	
	Player getPlayer();
	
	ArrayList<Enemy> getEnemyList();
	ArrayList<Bullet> getbulletsPlayer();
	ArrayList<Bullet> getbulletsEnemy();
	
	int getGameState();
	int getGameScore();
	
	void addEnemy(String enemyType, String movementType, String BulletType, String BulletMovement);
	
	void removeEnemy(Enemy e);
	void removePlayerBullet(Bullet e);
	void removeEnemyBullet(Bullet e);
	void addPlayerBullet(Bullet e);
	void addEnemyBullet(Bullet e);
	void removAllEnemyBullets();
	//Maybe getWave() ??
}
