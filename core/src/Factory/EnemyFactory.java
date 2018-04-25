package Factory;

import models.Enemy;
import models.EnemyA;
import models.EnemyB;
import models.EnemyFinalBoss;
import models.EnemyMidBoss;

public class EnemyFactory {

	public EnemyFactory() {

	}
	
	public Enemy Create(String enemyType, String movementType, String BulletType, String BulletMovement) {
		Enemy enemy = null;
		if (enemyType.equals("EnemyA")) {
			 enemy = new EnemyA(movementType, BulletType, BulletMovement);
		}
		else if(enemyType.equals("EnemyB")) {
			 enemy = new EnemyB(movementType, BulletType, BulletMovement);
		}
		else if(enemyType.equals("EnemyFinalBoss")) {
			 enemy = new EnemyFinalBoss(movementType, BulletType, BulletMovement);
		}
		else if(enemyType.equals("EnemyMidBoss")) {
			 enemy = new EnemyMidBoss(movementType, BulletType, BulletMovement);
		}
		return enemy;
	}
}
