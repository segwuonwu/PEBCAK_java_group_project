package view;

import java.io.Console;
import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;

import Factory.EnemyFactory;
import models.Bullet;
import models.Enemy;
import models.EnemyA;
import models.EnemyB;
import models.EnemyFinalBoss;
import models.EnemyMidBoss;
import models.Player;

public class MainScreen implements Screen {

	public static final float SHOOT_WAIT_TIME = 0.3f; // time in between bullets fired
	float y, x; // to test coordinates of bullets
	
	private MainGameClass parent;
	SpriteBatch batch;
	Texture cat;
	Texture img;
	Rectangle box;
	BitmapFont font;
	BitmapFont timerfont;
	BitmapFont space;
	
	
	//Creating Factory for enemy's and a list to store them in
	EnemyFactory Efactory = new EnemyFactory();
	ArrayList<Enemy> Elist = new ArrayList<Enemy>(); 

	//player object does not need a factory
	Player player;

	int showtime = 0;
	float deltaTime = 0;
	CharSequence str;
	
	float shootTimer; // for timing between pressing space and shooting bullets

	//lists to store bullets
	ArrayList<Bullet> bulletsPlayer; // store bullets created
	ArrayList<Bullet> bulletsEnemy;
	 
	public MainScreen(MainGameClass mainGameClass){
		parent = mainGameClass;
		batch = new SpriteBatch();
		player = new Player();
		img = new Texture("galaxy.png");
		
		//draw a box
		box = new Rectangle();
	    box.x = 800 / 2 - 64 / 2;
	    box.y = 20; 
	    box.width = 64;
	    box.height = 64;
	    
	    //add some test enemy's
	    Elist.add(Efactory.Create("EnemyA"));
	    Elist.add(Efactory.Create("EnemyB"));
	    Elist.add(Efactory.Create("EnemyFinalBoss"));
	    Elist.add(Efactory.Create("EnemyMidBoss"));


	    font = new BitmapFont();
	    
	    timerfont = new BitmapFont();
	    
	    space = new BitmapFont();
	    // for bullets
	    shootTimer = 0; // to test shooting bullets
	    x = Gdx.graphics.getWidth() / 2; // x pos of bullet
	    bulletsPlayer = new ArrayList<Bullet>(); // store bullets created
	    bulletsEnemy = new ArrayList<Bullet>();
	}


	
	
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void render(float delta) {
		player.move();
		for(Enemy en : Elist) {
			en.movement.Move();
		}
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		
		
		shootTimer += delta; // for timing when space btn pressed and bullet fired
		
	    // if press space button, shoot two bullets
		if (Gdx.input.isKeyJustPressed(Keys.SPACE) && shootTimer >= SHOOT_WAIT_TIME) {
				
			shootTimer = 0;				
			bulletsPlayer.add(new Bullet(player.movement.sprite.getX() + 4,player.movement.sprite.getY()));
			bulletsPlayer.add(new Bullet(player.movement.sprite.getX()- 4,player.movement.sprite.getY()));
			  							
		}
	      
		
		batch.begin();
		batch.draw(img, 0, 0);
		
		deltaTime += Gdx.graphics.getDeltaTime();
		showtime = (int)deltaTime;
	    str = "TIMER: " + Float.toString(showtime);
	    timerfont.draw(batch, str, 300, 300);
		
		//batch.draw(cat, box.x, box.y);
		batch.draw(player.movement.sprite, player.movement.sprite.getX(), player.movement.sprite.getY());

		//Draw all enemys
		for(Enemy en : Elist) {
			batch.draw(en.getImg(), en.movement.sprite.getX(), en.movement.sprite.getY());
		}

   // draw all bullets created
		for (Bullet bullet: bulletsPlayer) {
			bullet.render(batch);
		}
		
		font.draw(batch, "Toggle between slow mode using Z ", 400, 400);
		
		space.draw(batch,"Spacebar to shoot !",500,500);
		
		
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		batch.dispose();
		img.dispose();
		
	}
	

}
