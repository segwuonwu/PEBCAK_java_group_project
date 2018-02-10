
package com.cpts.game.desktop.Bullets;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.cpts.game.bullets.MyGdxGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.foregroundFPS = 30;
		config.width = MyGdxGame.WIDTH;
		config.height = MyGdxGame.HEIGHT;
		
		config.resizable = false;
		
		new LwjglApplication(new MyGdxGame(), config);
	}
}
