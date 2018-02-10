package com.cpts.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class MainScreen implements Screen {

	private MainGameClass parent;
	SpriteBatch batch;
	Texture cat;
	Texture img;
	Rectangle box;
	Enemy test = new EnemyFinalBoss();
	Rectangle enemyBox;
		

	 
	public MainScreen(MainGameClass mainGameClass){
		parent = mainGameClass;
		batch = new SpriteBatch();
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
	    enemyBox.x = (Gdx.graphics.getWidth() / 2) - (test.getImg().getWidth() / 2);
	    enemyBox.y = 500; 
	    enemyBox.width = test.getImg().getWidth();
	    enemyBox.height = test.getImg().getWidth();

	}
	
	
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.draw(cat, box.x, box.y);

		// DRAW ENEMY
		batch.draw(test.getImg(), enemyBox.x, enemyBox.y);
		batch.end();

		// process user input
		if (Gdx.input.isTouched()) {
			Vector3 touchPos = new Vector3();
			touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			box.x = touchPos.x - 64 / 2;
		}
		
		if (Gdx.input.isKeyPressed(Keys.LEFT))
			box.x -= 200 * Gdx.graphics.getDeltaTime();
		if (Gdx.input.isKeyPressed(Keys.RIGHT))
			box.x += 200 * Gdx.graphics.getDeltaTime();

		// make sure the bucket stays within the screen bounds
		if (box.x < 0)
			box.x = 0;
		if (box.x > Gdx.graphics.getWidth() - 64)
			box.x = Gdx.graphics.getWidth() - box.width;

		// enemy
		enemyBox.x += test.getSpeed();
		System.out.println();
		// check bounds
		if (enemyBox.x > Gdx.graphics.getWidth() - enemyBox.getWidth()) {
			enemyBox.x = Gdx.graphics.getWidth() - enemyBox.getWidth();
			// reverse speed (move opposite way)
			System.out.println(enemyBox.x);
			test.reverseSpeed();
		}

		if (enemyBox.x < 0) {
			enemyBox.x = 0;
			test.reverseSpeed();
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
