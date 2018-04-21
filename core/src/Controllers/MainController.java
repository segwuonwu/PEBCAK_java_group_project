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
	private ShootingControllerInterface SC;
	

	float shootTimer; // for timing between pressing space and shooting bullets
	
	//FOR TESTING UNTIL WAVES ARE IMPLEMENTED
	float waveTimer;

	
	public MainController(MainGameClass mainGameClass, ObjectManagerInterface om) {
		
		OM = om;
		CC = new CollisionController(om);
		MC = new MovementController(om);
		SC = new ShootingController(om);
		parent = mainGameClass;
		waveTimer = 0;

	}
	
	
	public void update(float delta) {
		
		waveTimer += delta;
		
		ArrayList<Enemy> eList = OM.getEnemyList();

		//Update collision check if death
		//Pretty sure we can access delta time from anywhere, consider removing it from methods
		if(!CC.update(delta)) {
			//Change view if dead, FIND WAY TO PUSH THAT TO VIEW
			parent.changeScreen(MainGameClass.PREFERENCES);
		}
		//Update movement of all objects
		MC.update();
		SC.update(delta);
		
		if(waveTimer >= 3) {
			waveTimer = 0;
			enemyWave();
		}

	}
	
	
	//TRASH 
	public void enemyWave() {
		OM.addEnemy("EnemyA", "random", "bulletA", "straight");
		OM.addEnemy("EnemyA", "straight", "bulletA", "straight");
		OM.addEnemy("EnemyA", "zigzag", "bulletA", "straight");
		OM.addEnemy("EnemyA", "random", "bulletA", "straight");
		OM.addEnemy("EnemyA", "straight", "bulletA", "straight");
		OM.addEnemy("EnemyA", "zigzag", "bulletA", "straight");
		OM.addEnemy("EnemyA", "random", "bulletA", "straight");
		OM.addEnemy("EnemyA", "straight", "bulletA", "straight");
		OM.addEnemy("EnemyA", "zigzag", "bulletA", "straight");
		OM.addEnemy("EnemyA", "random", "bulletA", "straight");
		OM.addEnemy("EnemyA", "straight", "bulletA", "straight");
	}

}
