package com.StackOgreflow.Motherboard;

import com.StackOgreflow.Engine.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Matrix4;

/**
 * Created by nathan on 25/03/14.
 */
public class Graphics {
    private PerspectiveCamera camera;
    private SpriteBatch batch = new SpriteBatch();
    private Color backgroundColor = Color.BLACK;
    private float width;
    private float height;

    Matrix4 pixelSpace;
    public Graphics(){

    }
    public Graphics(float width, float height){
        super();
        this.width = width;
        this.height = height;
    }
    public float getWidth(){
        return width;
    }
    public float getHeight(){
        return height;
    }
    public Graphics setWidth(float width){
        this.width = width;
        recalculate();
        return this;
    }
    public Graphics setHeight(float height){
        this.height = height;
        recalculate();
        return this;
    }
    public void recalculate(){
        camera = new PerspectiveCamera(90, 1, height/width);
        pixelSpace = new Matrix4().setToOrtho2D(0, 0, width, height);
    }
    public Graphics setBackgroundColor(Color color){
        backgroundColor = color;
        return this;
    }
    public void destroy(){
        batch.dispose();
    }
    public void render(Entity ent){
        renderBackground();
        renderSprites(ent);
        renderText(ent);
    }
    public void renderBackground(){
        Gdx.gl.glClearColor(backgroundColor.r, backgroundColor.g, backgroundColor.b, backgroundColor.a);
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
    }

    public void renderSprites(Entity ent){
        batch.setProjectionMatrix(camera.combined);
        batch.getTransformMatrix().idt().translate(0, 0, -1);
        batch.begin();
        ent.drawSprite(batch);
        batch.end();
    }

    public void renderText(Entity ent){
        batch.setProjectionMatrix(pixelSpace);
        batch.begin();
        ent.drawText(batch);
        batch.end();
    }
}
