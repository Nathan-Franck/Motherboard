package com.StackOgreflow.Motherboard;

import android.content.res.AssetManager;
import com.StackOgreflow.Engine.Container;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;

public class Game extends Container implements ApplicationListener {

    public static Graphics graphics;

	@Override
	public void create() {
        graphics = new Graphics()
                .setHeight(Gdx.graphics.getHeight())
                .setWidth(Gdx.graphics.getWidth())
                .setBackgroundColor(new Color(.1f, .1f, .1f, 1));
	}

	@Override
	public void dispose() {
        graphics.destroy();
	}

	@Override
	public void render() {
        graphics.render(this);
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
}
