package models;

import java.util.ArrayList;

public interface ObjectManagerInterface {
	
	Player getPlayer();
	
	ArrayList<Enemy> getEnemyList();
	ArrayList<Bullet> getbulletsPlayer();
	ArrayList<Bullet> getbulletsEnemy();
	
	int getGameState();
	int getGameScore();
	
	void addEnemy(String type, String movement, String bullets);
	//Maybe getWave() ??
}
