package com.StackOgreflow.Engine;

import com.StackOgreflow.Motherboard.Debris;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

/**
 * Created by Nathan on 3/25/2014.
 */
public class Layer extends Container{
    private float depth = 0;
    public Layer(){
        super();
        for (int i = 0; i < 1; i ++){
            add(new Debris());
        }
    }
    public Layer setDepth(float depth){
        this.depth = depth;
        return this;
    }
    public void drawSprite(SpriteBatch batch){
        batch.end();
        batch.getTransformMatrix().translate(0, 0, depth);
        batch.begin();
        super.drawSprite(batch);
        batch.end();
        batch.getTransformMatrix().translate(0, 0, -depth);
        batch.begin();
    }
}
