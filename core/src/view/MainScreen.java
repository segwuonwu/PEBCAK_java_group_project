package view;

import java.util.ArrayList;
import java.util.Iterator;

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

	// Creating Factory for enemy's and a list to store them in
	EnemyFactory Efactory = new EnemyFactory();
	BulletFactory Bfactory = new BulletFactory();
	ArrayList<Enemy> Elist = new ArrayList<Enemy>();

	// player object does not need a factory
	Player player;

	int showtime = 0;
	float deltaTime = 0;
	CharSequence str;

	float shootTimer; // for timing between pressing space and shooting bullets

	// lists to store bullets
	ArrayList<Bullet> bulletsPlayer; // store bullets created
	ArrayList<Bullet> bulletsEnemy;

	public MainScreen(MainGameClass mainGameClass) {
		parent = mainGameClass;
		batch = new SpriteBatch();
		player = new Player();
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
		
		// for bullets
		bulletsPlayer = new ArrayList<Bullet>(); // store bullets created
		bulletsEnemy = new ArrayList<Bullet>();
		controller = new MainController(parent, player, bulletsPlayer, bulletsEnemy, Elist);
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(float delta) {

				
		controller.update(delta);
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		shootTimer += delta; // for timing when space btn pressed and bullet fired

		// if press space button, shoot two bullets
		if (Gdx.input.isKeyJustPressed(Keys.SPACE) && shootTimer >= .1f) {

			shootTimer = 0;
			bulletsPlayer.add(Bfactory.Create("straight", "bulletB", player.movement.sprite.getX() + 15, player.movement.sprite.getY() + 22, 300f));

		}

		batch.begin();
		batch.draw(img, 0, 0);

		deltaTime += Gdx.graphics.getDeltaTime();
		showtime = (int) deltaTime;
		str = "TIMER: " + Float.toString(showtime);
		timerfont.draw(batch, str, 300, 300);

		batch.draw(player.movement.sprite, player.movement.sprite.getX(), player.movement.sprite.getY());

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
		font.draw(batch, "HEALTH: " + player.getHealth(), 10, 550);
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
