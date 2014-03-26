package com.StackOgreflow.Motherboard;

import com.StackOgreflow.Engine.Entity;
import com.StackOgreflow.Engine.World;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.TextureLoader;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Resources extends Entity {
	float progress;
    public static AssetManager manager = new AssetManager();
	public Resources(){
		super();
        // Load all the things
		System.out.println("Resources progress...");
        TextureLoader.TextureParameter param = new TextureLoader.TextureParameter();
        param.minFilter = Texture.TextureFilter.MipMapLinearLinear;
        param.magFilter = Texture.TextureFilter.MipMapLinearLinear;
        param.genMipMaps = true;
		manager.load("data/Video Adapter.png", Texture.class, param);
	}
	public void update(){
		// display loading information
		progress = manager.getProgress();
		System.out.println(progress);
		if(manager.update()) {
			parent.add(new World());
			destroy();
		}
	}
	public void drawSprite(SpriteBatch batch){
		
	}
}
