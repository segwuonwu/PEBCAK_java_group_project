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
import models.Wave;
import view.MainGameClass;

public class MainController implements MainControllerInterface{

	private MainGameClass parent;
	private ObjectManagerInterface OM;
	private CollisionControllerInterface CC;
	private MovementControllerInterface MC;
	private ShootingControllerInterface SC;
	private WaveControllerInterface WC;


	float shootTimer; // for timing between pressing space and shooting bullets
	

	
	public MainController(MainGameClass mainGameClass, ObjectManagerInterface om) {
		
		OM = om;
		CC = new CollisionController(om);
		MC = new MovementController(om);
		SC = new ShootingController(om);
		WC = new WaveController(om);
		parent = mainGameClass;
				
		parseJSON();

	}
	
	
	public void update(float delta) {
		
		
		//Update collision check if death
		//Pretty sure we can access delta time from anywhere, consider removing it from methods
		if(!CC.update(delta)) {
			//Change view if dead, FIND WAY TO PUSH THAT TO VIEW
			parent.changeScreen(MainGameClass.PREFERENCES);
		}
		//Update movement of all objects
		MC.update();
		SC.update(delta);
		WC.update(delta);
		


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
	        		        	
	        	Wave w = new Wave(_wave, waveBegins, waveLength);
	        	OM.addWave(w);
				System.out.println("ADD WAVE");

	        }

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		} 

	}

}
