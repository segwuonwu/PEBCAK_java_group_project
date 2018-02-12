package com.cpts.game;

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
	
	
	// Creating four level enemies , The plan is to create lists of enemy A and B 
	// Movement and particulars will be done later
	Enemy boss = new EnemyFinalBoss();
	Enemy a = new EnemyA();
	Enemy b = new EnemyB();
	Enemy midboss = new EnemyMidBoss();

	Player player;
	
	Rectangle enemyBox;
	Rectangle enemyA;
	Rectangle enemyB;
	Rectangle enemyMid;
	
	Boolean enemyBossTest = false;
	Boolean enemyATest = true;
	Boolean enemyBTest = false;
	Boolean enemyMidTest = false;
	

	int showtime = 0;
	float deltaTime = 0;
	CharSequence str;
	
	float shootTimer; // for timing between pressing space and shooting bullets

	ArrayList<Bullet> bulletsPlayer; // store bullets created
	ArrayList<Bullet> bulletsEnemy;
	 
	public MainScreen(MainGameClass mainGameClass){
		parent = mainGameClass;
		batch = new SpriteBatch();
		player = new Player();
		img = new Texture("galaxy.png");
		cat = new Texture("cat.jpg");
		
		//draw a box
		box = new Rectangle();
	    box.x = 800 / 2 - 64 / 2;
	    box.y = 20; 
	    box.width = 64;
	    box.height = 64;

		//draw an EnemyBox
	    enemyA = new Rectangle();
	    enemyA.x = (Gdx.graphics.getWidth() / 2) - (a.getImg().getWidth() / 2);
	    enemyA.y = 500; 

	    enemyA.width = 16;
	    enemyA.height = 16;
	    
	    enemyB = new Rectangle();
	    enemyB.x = (Gdx.graphics.getWidth() / 2) - (b.getImg().getWidth() / 2);
	    enemyB.y = 500; 

	    enemyB.width = 16;
	    enemyB.height = 16;
	    
	    enemyMid = new Rectangle();
	    enemyMid.x = (Gdx.graphics.getWidth() / 2) - (midboss.getImg().getWidth() / 2);
	    enemyMid.y = 500; 

	    enemyMid.width = 32;
	    enemyMid.height = 32;
	    
	    
	    enemyBox = new Rectangle();
	    enemyBox.x = (Gdx.graphics.getWidth() / 2) - (boss.getImg().getWidth() / 2);
	    enemyBox.y = 500; 

	    enemyBox.width = 64;
	    enemyBox.height = 64;
	    
	    font = new BitmapFont();
	    
	    timerfont = new BitmapFont();
	    
	    space = new BitmapFont();
	    // for bullets
	    shootTimer = 0; // to test shooting bullets
	    x = Gdx.graphics.getWidth() / 2; // x pos of bullet
	    bulletsPlayer = new ArrayList<Bullet>(); // store bullets created
	    bulletsEnemy = new ArrayList<Bullet>();

	    Timer.schedule(new Task() {
	    	  	@Override
	    	  	public void run()
	    	  	{
	    	  		enemyATest = false;
	    	  		enemyBTest = true;
	    	  	}
	    },20);
	    
	    Timer.schedule(new Task() {
	    	  	@Override
	    	  	public void run()
	    	  	{
	    	  		enemyBTest = false;
	    	  		enemyMidTest = true;
	    	  	}
	    },48);
	    
	    
	    Timer.schedule(new Task() {
	    	  	@Override
	    	  	public void run()
	    	  	{
	    	  		enemyMidTest = false;
	    	  		enemyBossTest = true;
	    	  	}
	    },80);
	    
	    
	    Timer.schedule(new Task() {
	    	  	@Override
	    	  	public void run()
	    	  	{
	    	  		if(enemyATest == true) {	    	  			
	    	  			bulletsEnemy.add(new Bullet((int)enemyA.x + 32,(int)enemyA.y));
	    	  			
				}
				else if(enemyBTest == true) {
					bulletsEnemy.add(new Bullet((int)enemyB.x,(int)enemyB.y));
					bulletsEnemy.add(new Bullet((int)enemyB.x + 32,(int)enemyB.y));
				}
				else if(enemyMidTest == true) {
					bulletsEnemy.add(new Bullet((int)enemyMid.x,(int)enemyMid.y));
					bulletsEnemy.add(new Bullet((int)enemyMid.x + 32,(int)enemyMid.y));
					bulletsEnemy.add(new Bullet((int)enemyMid.x + 64,(int)enemyMid.y));
				}
				else if(enemyBossTest == true) {
					bulletsEnemy.add(new Bullet((int)enemyBox.x,(int)enemyBox.y));
					bulletsEnemy.add(new Bullet((int)enemyBox.x + 22,(int)enemyBox.y));
					bulletsEnemy.add(new Bullet((int)enemyBox.x + 44,(int)enemyBox.y));
					bulletsEnemy.add(new Bullet((int)enemyBox.x + 64,(int)enemyBox.y));
				}
	    	  		System.out.println(bulletsEnemy.size());
	    	  	}
	    },0,1);
	}
	
	
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void render(float delta) {
		player.handleMovement();
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		
		
		shootTimer += delta; // for timing when space btn pressed and bullet fired
		
	    // if press space button, shoot two bullets
		if (Gdx.input.isKeyJustPressed(Keys.SPACE) && shootTimer >= SHOOT_WAIT_TIME) {
				
			shootTimer = 0;				
			bulletsPlayer.add(new Bullet(player.sprite.getX() + 4,player.sprite.getY()));
			bulletsPlayer.add(new Bullet(player.sprite.getX()- 4,player.sprite.getY()));
			  							
		}
	      
	    // store the bullets to remove after shot
		ArrayList<Bullet> bulletsToRemove = new ArrayList<Bullet>();
		for (Bullet bullet : bulletsPlayer) {
				
			bullet.updateforPlayer(delta); // this updates position of bullet on each render
			
			if (bullet.remove) { // check if bullet out of gameplay, if yes add to bulletsToRemove
				bulletsToRemove.add(bullet);
	      	}
		
		}
		
		
			
	    bulletsPlayer.removeAll(bulletsToRemove); // remove bullets
		
		batch.begin();
		batch.draw(img, 0, 0);
		
		deltaTime += Gdx.graphics.getDeltaTime();
		showtime = (int)deltaTime;
	    str = "TIMER: " + Float.toString(showtime);
	    timerfont.draw(batch, str, 300, 300);
		
		//batch.draw(cat, box.x, box.y);
		batch.draw(player.sprite, player.sprite.getX(), player.sprite.getY());

		//batch.draw(cat, box.x, box.y);	
		//DRAW ENEMY
		if(enemyATest == true)
		{
			batch.draw(a.getImg(), enemyA.x,enemyA.y);
		}
		
		if(enemyBTest == true)
		{
			batch.draw(b.getImg(), enemyB.x,enemyB.y);
		}
		
		if(enemyMidTest == true)
		{
			batch.draw(midboss.getImg(), enemyMid.x,enemyMid.y);
			 enemyMid.x+=midboss.getSpeed();
		      
		      //check bounds
		    if(enemyMid.x > 1038 - 64) {
		    	  enemyMid.x = 1038 - 64;
		    	  //reverse speed (move opposite way)
		    	  midboss.setSpeed(midboss.getSpeed()*-1);
		    }
		      
		    if(enemyMid.x < 0) {
		    	  enemyMid.x = 0;
		    	  //reverse speed (move opposite way)
		    	  midboss.setSpeed(midboss.getSpeed()*-1);
		    }
		}
		
		
		
	    if(enemyBossTest == true)
	    {
		    batch.draw(boss.getImg(), enemyBox.x, enemyBox.y);
		    enemyBox.x+=boss.getSpeed();
		      
		      //check bounds
		    if(enemyBox.x > 1038 - 64) {
		    	  enemyBox.x = 1038 - 64;
		    	  //reverse speed (move opposite way)
		    	  boss.setSpeed(boss.getSpeed()*-1);
		    }
		      
		    if(enemyBox.x < 0) {
		    	  enemyBox.x = 0;
		    	  //reverse speed (move opposite way)
		    	  boss.setSpeed(boss.getSpeed()*-1);
		    }
	    }   
	    // draw all bullets created
		for (Bullet bullet: bulletsPlayer) {
			bullet.render(batch);
		}
		
		font.draw(batch, "Toggle between slow mode using Z ", 400, 400);
		
		space.draw(batch,"Spacebar to shoot !",500,500);
		
		for (Bullet bullet: bulletsEnemy) {
			// This is a temporary set up
			// Plan is to attach bullets to each enemy class and make them initialize them
			
			bullet.updateforEnemy(delta);
			
			if (bullet.remove) { // check if bullet out of gameplay, if yes add to bulletsToRemove
				bulletsToRemove.add(bullet);
	      	}
		}
		
		for (Bullet bullet: bulletsEnemy) {
			bullet.render(batch);
		}

		batch.end();

		// process user input
		if (Gdx.input.isTouched()) {
			Vector3 touchPos = new Vector3();
			touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			box.x = touchPos.x - 64 / 2;
		}
		

	      // process user input
	      if(Gdx.input.isTouched()) {
	         Vector3 touchPos = new Vector3();
	         touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
	         box.x = touchPos.x - 64 / 2;
	      }
	      if(Gdx.input.isKeyPressed(Keys.LEFT)) box.x -= 200 * Gdx.graphics.getDeltaTime();
	      if(Gdx.input.isKeyPressed(Keys.RIGHT)) box.x += 200 * Gdx.graphics.getDeltaTime();
	      
	      // make sure the bucket stays within the screen bounds
	      if(box.x < 0) box.x = 0;
	      if(box.x > 1038 - 64) box.x = 1038 - 64;
	      
	      
	      
	     
	     

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
