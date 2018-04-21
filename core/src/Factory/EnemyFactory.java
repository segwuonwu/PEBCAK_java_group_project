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
		if (enemyType == "EnemyA") {
			 enemy = new EnemyA(movementType, BulletType, BulletMovement);
		}
		else if(enemyType == "EnemyB") {
			 enemy = new EnemyB(movementType, BulletType, BulletMovement);
		}
		else if(enemyType == "EnemyFinalBoss") {
			 enemy = new EnemyFinalBoss(movementType, BulletType, BulletMovement);
		}
		else if(enemyType == "EnemyMidBoss") {
			 enemy = new EnemyMidBoss(movementType, BulletType, BulletMovement);
		}
		return enemy;
	}
}
