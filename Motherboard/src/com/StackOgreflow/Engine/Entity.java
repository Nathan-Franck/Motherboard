package com.StackOgreflow.Engine;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class Entity {
	public Container parent;
    protected Vector2 position = new Vector2(0, 0);
    protected float rotation = 0;
    protected float scale = 1;
    protected Color color = new Color(1, 1, 1, 1);
	private boolean destroyed = false;
    protected Sprite sprite;

	public Entity(){
		
	}

    public Entity setParent(Container parent){
        this.parent = parent;
        return this;
    }

    public Entity setPosition(Vector2 position){
        this.position = position;
        return this;
    }

    public Entity setRotation(float rotation){
        this.rotation = rotation;
        return this;
    }

    public Entity setScale(float scale){
        this.scale = scale;
        return this;
    }

    public Entity setColor(Color color){
        this.color = color;
        return this;
    }

    public Entity setSprite(Sprite sprite){
        this.sprite = sprite;
        return this;
    }

    public Entity setTexture(Texture texture){
        this.sprite = new Sprite(texture);
        return this;
    }
    public float worldRotation(){
        if (parent == null) return rotation;
        return parent.worldRotation()+rotation;
    }
    public Vector2 worldPosition(){
        if (parent == null || parent.position == null) return position;
        return parent.worldPosition().cpy().add(position.cpy().scl(parent.scale).rotate(parent.rotation));
    }
    public Color worldColor(){
        if (parent == null || parent.color == null) return color;
        return parent.worldColor().cpy().mul(color);
    }
	
	public void update(){
		
	}
	public void drawSprite(SpriteBatch batch){
        if (sprite == null) return;
        Vector2 absPos = worldPosition();
        sprite.setScale(scale / sprite.getTexture().getWidth());
        sprite.setPosition(absPos.x - sprite.getWidth() / 2.0f, absPos.y - sprite.getHeight() / 2.0f);
        sprite.setOrigin(sprite.getWidth() / 2.0f, sprite.getHeight() / 2.0f);
        sprite.setRotation(rotation);
        sprite.setColor(worldColor());
        sprite.draw(batch);
	}
    public void drawText(SpriteBatch batch){

    }

	public void destroy(){
		destroyed = true;
		if (parent != null) parent.remove(this);
	}
	public boolean isDestroyed(){
		return destroyed;
	}
	public void debugDraw(ShapeRenderer shapeRenderer){
		
	}
}
