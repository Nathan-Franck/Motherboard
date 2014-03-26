package com.StackOgreflow.Engine;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Container extends Entity {
	public ArrayList<Entity> children = new ArrayList<Entity>();
	
	public void add(Entity e){
		children.add(e);
		e.parent = this;
	}
	
	public void remove(Entity e){
		children.remove(e);
		e.parent = null;
	}
	
	public void update(){
		for (int i = 0; i < children.size(); i ++){
			Entity e = children.get(i);
			e.update();
			if (e.isDestroyed()) i --;
		}
	}
	
	public void drawSprite(SpriteBatch batch){
		for (int i = 0; i < children.size(); i ++){
			children.get(i).drawSprite(batch);
		}
	}

    public void drawText(SpriteBatch batch){
        for (int i = 0; i < children.size(); i ++){
            children.get(i).drawText(batch);
        }
    }
	
	public void destroy(){
		super.destroy();
		while (!children.isEmpty()) children.get(children.size()-1).destroy();
	}
	
	public void debugDraw(ShapeRenderer shapeRenderer){
		for (int i = 0; i < children.size(); i ++){
			children.get(i).debugDraw(shapeRenderer);
		}
	}
}
