package com.StackOgreflow.Engine;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.TimeUtils;

public class Time {
    protected static float speed = 1;
    protected static float time = 0;
    public static void setSpeed(float _speed){
        speed = _speed;
    }
	public static float time(){
		return time;
	}
    public static float realTime(){
        return TimeUtils.nanoTime()*0.000000001f;
    }
	public static float deltaTime(){
		return Gdx.graphics.getDeltaTime()*speed;
	}
    public static void update(){
        time += deltaTime();
    }
}
