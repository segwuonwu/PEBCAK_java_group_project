package com.cpts.game;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class MainScreen implements Screen {

	public static final float SHOOT_WAIT_TIME = 0.3f; // time in between bullets fired
	float y, x; // to test coordinates of bullets
	
	private MainGameClass parent;
	SpriteBatch batch;
	Texture cat;
	Texture img;
	Rectangle box;

	Player player;

	Enemy test = new TestEnemy();
	Rectangle enemyBox;
		
	float shootTimer; // for timing between pressing space and shooting bullets

	ArrayList<Bullet> bullets; // store bullets created
	 
	public MainScreen(MainGameClass mainGameClass){
		parent = mainGameClass;
		batch = new SpriteBatch();
		player = new Player();
		img = new Texture("konosuba-2-aqua-drinking.png");
		cat = new Texture("cat.jpg");
		
		//draw a box
		box = new Rectangle();
	    box.x = 800 / 2 - 64 / 2;
	    box.y = 20; 
	    box.width = 64;
	    box.height = 64;

		//draw an EnemyBox
	    enemyBox = new Rectangle();
	    enemyBox.x = 800 / 2 - 64 / 2;
	    enemyBox.y = 500; 
	    enemyBox.width = 64;
	    enemyBox.height = 64;
	    
	    // for bullets
	    shootTimer = 0; // to test shooting bullets
	    x = Gdx.graphics.getWidth() / 2; // x pos of bullet
	    bullets = new ArrayList<Bullet>(); // store bullets created

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
			bullets.add(new Bullet(x + 4));
			bullets.add(new Bullet(x - 4));
			  							
		}
	      
	    // store the bullets to remove after shot
		ArrayList<Bullet> bulletsToRemove = new ArrayList<Bullet>();
		for (Bullet bullet : bullets) {
				
			bullet.update(delta); // this updates position of bullet on each render
			
			if (bullet.remove) { // check if bullet out of gameplay, if yes add to bulletsToRemove
				bulletsToRemove.add(bullet);
	      	}
		
		}
			
	    bullets.removeAll(bulletsToRemove); // remove bullets
		
		batch.begin();
		batch.draw(img, 0, 0);

		//batch.draw(cat, box.x, box.y);
		batch.draw(player.sprite, player.sprite.getX(), player.sprite.getY());

		//batch.draw(cat, box.x, box.y);	
		//DRAW ENEMY
	    
	    batch.draw(test.getImg(), enemyBox.x, enemyBox.y);
	    
	    // draw all bullets created
		for (Bullet bullet: bullets) {
			bullet.render(batch);
		}
		

		batch.end();
		
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
	      
	      
	      enemyBox.x+=test.getSpeed();
	      
	      //check bounds
	      if(enemyBox.x > 1038 - 64) {
	    	  enemyBox.x = 1038 - 64;
	    	  //reverse speed (move opposite way)
	    	  test.setSpeed(test.getSpeed()*-1);
	      }
	      
	      if(enemyBox.x < 0) {
	    	  enemyBox.x = 0;
	    	  //reverse speed (move opposite way)
	    	  test.setSpeed(test.getSpeed()*-1);
	      }
	      

		
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
