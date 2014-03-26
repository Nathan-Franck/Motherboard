package com.StackOgreflow.Motherboard;

import com.StackOgreflow.Engine.Entity;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Resources extends Entity {
	float progress;
    AssetManager manager = new AssetManager();
	public Resources(){
		super();
        // Load all the things
		System.out.println("Resources progress...");
		manager.load("data/background_tiling.png", Texture.class);
	}
	public void update(){
		// display loading information
		/*progress = SinkyFish.manager.getProgress();
		System.out.println(progress);
		if(SinkyFish.manager.update()) {
			parent.add(new Gameplay());
			destroy();
		}*/
	}
	public void drawSprite(SpriteBatch batch){
		
	}
}
