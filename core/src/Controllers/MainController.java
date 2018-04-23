package Controllers;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

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
	private ArrayList<ArrayList<Enemy>> waves;

	
	

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
		
		waves = new ArrayList<ArrayList<Enemy>>();

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
	
	
	public void parseJSON() {
		
		EnemyFactory Efactory = new EnemyFactory();

        try {
			Object obj = new JSONParser().parse(new FileReader("config.json"));
	        JSONObject json = (JSONObject) obj;
	        JSONObject waves = (JSONObject) json.get("waves");
	        
	        for(int i=0;i<waves.size();i++) {
	        	JSONObject wave = (JSONObject) waves.values().toArray()[i];
	        	Long waveSize = (Long) wave.get("NumberOfEnemies");
	        	
	        	ArrayList<Enemy> _wave = new ArrayList<Enemy>();
	        	for(int j=0; j<waveSize; j++) {
	        		_wave.add(Efactory.Create((String) wave.get("EnemyType"),(String) wave.get("MovementType"), (String) wave.get("BulletType"), (String) wave.get("BulletMovement")));
	        	}
	        	
	        	//waveBegins is the time during gameplay that wave first appears
	        	//waveLength is their lifespan on screen
	        	//do something with these variables when waves are developed further
	        	Long waveBegins = (Long) wave.get("SpawnTime");
	        	Long waveLength = (Long) wave.get("WaveLength");
	        	
	        	this.waves.add(_wave);
	        }

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		} 

	}

}