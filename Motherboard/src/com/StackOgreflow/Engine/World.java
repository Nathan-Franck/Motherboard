package com.StackOgreflow.Engine;

import com.StackOgreflow.Engine.Container;
import com.StackOgreflow.Engine.Layer;
import com.StackOgreflow.Engine.PhysicsEntity;
import com.StackOgreflow.Motherboard.Debris;
import com.StackOgreflow.Motherboard.Resources;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

/**
 * Created by Nathan on 3/25/2014.
 */
public class World extends Container {
    public World() {
        super();
        for (int i = 9; i >= 0; i --)
            add(new Layer().setDepth(-1-i));
    }
}
