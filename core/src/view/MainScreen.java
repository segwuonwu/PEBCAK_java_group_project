package view;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

import java.awt.print.Printable;
import java.io.Console;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

import Controllers.MainController;
import Factory.BulletFactory;
import Factory.EnemyFactory;
import models.Bullet;
import models.Enemy;
import models.ObjectManager;
import models.ObjectManagerInterface;
import models.Player;

public class MainScreen implements Screen {

	public static final float SHOOT_WAIT_TIME = 0.3f; // time in between bullets fired

	private MainGameClass parent;
	SpriteBatch batch;
	Texture img;
	Rectangle box;
	BitmapFont font;
	BitmapFont timerfont;
	BitmapFont space;
	MainController controller;
	
	//list of enemny lists (waves)
	
	int showtime = 0;
	float deltaTime = 0;
	CharSequence str;
	int gamestate;


	ObjectManagerInterface OM;
	
	public MainScreen(MainGameClass mainGameClass) {
		parent = mainGameClass;
		batch = new SpriteBatch();
		img = new Texture("galaxy.png");

		// draw a box
		box = new Rectangle();
		box.x = 800 / 2 - 64 / 2;
		box.y = 20;
		box.width = 64;
		box.height = 64;

		font = new BitmapFont();
		timerfont = new BitmapFont();
		space = new BitmapFont();

		OM = new ObjectManager();
		controller = new MainController(parent, OM);
		gamestate = 0;
		

	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(float delta) {

			
		gamestate = controller.update(delta);
		if(gamestate == 1) {
			//win
			parent.changeScreen(MainGameClass.VICTORY);

			
		}
		else if(gamestate == -1) {
			//lose
			parent.changeScreen(MainGameClass.PREFERENCES);
		}
			//keep going
		
		
		
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
		batch.draw(img, 0, 0);

		deltaTime += Gdx.graphics.getDeltaTime();
		showtime = (int) deltaTime;
		str = "TIMER: " + Float.toString(showtime);
		timerfont.draw(batch, str, 300, 300);

		Player p = OM.getPlayer();
		ArrayList<Enemy> Elist = OM.getEnemyList();
		ArrayList<Bullet> bulletsPlayer = OM.getbulletsPlayer();
		ArrayList<Bullet> bulletsEnemy = OM.getbulletsEnemy();
	
		
		batch.draw(p.movement.sprite, p.movement.sprite.getX(), p.movement.sprite.getY());

		// Draw all enemy's
		for (Enemy en : Elist) {
			batch.draw(en.getImg(), en.movement.sprite.getX(), en.movement.sprite.getY());
		}

		// draw all bullets created
		for (Bullet bullet : bulletsPlayer) {
			batch.draw(bullet.getImg(), bullet.movement.sprite.getX(), bullet.movement.sprite.getY());
		}
		for (Bullet ebullet : bulletsEnemy) {
			batch.draw(ebullet.getImg(), ebullet.movement.sprite.getX(), ebullet.movement.sprite.getY());
		}

		font.draw(batch, "Toggle between slow mode using Z ", 400, 400);
		font.draw(batch, "HEALTH: " + p.getHealth(), 10, 550);
		space.draw(batch, "Spacebar to shoot !", 500, 500);

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
