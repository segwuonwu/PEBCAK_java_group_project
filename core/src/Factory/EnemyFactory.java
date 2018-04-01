package Factory;

import java.util.List;

import com.badlogic.gdx.graphics.Texture;

import models.Bullet;
import models.Enemy;
import models.EnemyA;
import models.EnemyB;
import models.EnemyFinalBoss;
import models.EnemyMidBoss;

public class EnemyFactory {
	//future use
	//List<Enemy> _enemys;
	//List<Bullet> _bullets;
	//BulletFactory _bulletfactory;
	
	public EnemyFactory(/*List<Enemy> enemys, List<Bullet> bullets, BulletFactory bulletfactory*/ ) {
		//_enemys = enemys;
		//_bullets = bullets;
		//_bulletfactory = bulletfactory;
	}
	
	public Enemy Create(String enemyType) {
		Enemy enemy = null;
		if (enemyType == "EnemyA") {
			 enemy = new EnemyA();
		}
		else if(enemyType == "EnemyB") {
			 enemy = new EnemyB();
		}
		else if(enemyType == "EnemyFinalBoss") {
			 enemy = new EnemyFinalBoss();
		}
		else if(enemyType == "EnemyMidBoss") {
			 enemy = new EnemyMidBoss();
		}
		return enemy;
	}
}
