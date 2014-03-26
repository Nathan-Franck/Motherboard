package com.StackOgreflow.Motherboard;

import com.StackOgreflow.Engine.PhysicsEntity;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Nathan on 3/25/2014.
 */
public class Debris extends PhysicsEntity {
    public Debris(){
        super();
        setVelocity(new Vector2(.1f, .1f)).setTexture(Resources.manager.get("data/Video Adapter.png", Texture.class)).setScale(1);
    }
}
