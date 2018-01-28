package com.cpts.game;

import com.badlogic.gdx.ApplicationAdapter;
isdfsadfmport com.badlogic.gdx.Gdx;
import asdfcom.badlogic.gdx.graphics.GL20;
import com.sadfgbadlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
sadf
publsadic class MainGameClass extends ApplicationAdapter {
f	SpriteBatch batch;
sdaf	Texture img;
asd	
f	@Override
sadf	public void create () {
asdf		batch = new SpriteBatch();
sda		img = new Texture("badlogic.jpg");
f	}
asdf
asdf	@Override
sad	public void render () {
f		Gdx.gl.glClearColor(1, 0, 0, 1);
saddfg		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
asd		batch.begin();
f		batch.draw(img, 0, 0);
sadf		batch.end();
sad	}
fasd	
f	@Override
sdf	public void dispose () {
asd		batch.dispose();
dfds		img.dispose();
af	}
}sadfsdfgdsfa
