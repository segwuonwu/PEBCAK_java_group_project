package Factory;

import models.Enemy;
import models.EnemyA;
import models.EnemyB;
import models.EnemyFinalBoss;
import models.EnemyMidBoss;

public class EnemyFactory {

	public EnemyFactory() {

	}
	
	public Enemy Create(String enemyType, String movementType) {
		Enemy enemy = null;
		if (enemyType == "EnemyA") {
			 enemy = new EnemyA(movementType);
		}
		else if(enemyType == "EnemyB") {
			 enemy = new EnemyB(movementType);
		}
		else if(enemyType == "EnemyFinalBoss") {
			 enemy = new EnemyFinalBoss(movementType);
		}
		else if(enemyType == "EnemyMidBoss") {
			 enemy = new EnemyMidBoss(movementType);
		}
		return enemy;
	}
}
