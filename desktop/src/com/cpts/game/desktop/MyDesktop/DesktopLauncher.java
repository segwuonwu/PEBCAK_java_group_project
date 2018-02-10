package com.mygdx.project.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.project.SpaceGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.foregroundFPS = 60;
		config.width = SpaceGame.WIDTH;
		config.height = SpaceGame.HEIGHT;
		config.resizable = false;
		new LwjglApplication(new SpaceGame(), config);
	}
}
