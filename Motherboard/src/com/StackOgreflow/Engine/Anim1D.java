package com.StackOgreflow.Engine;

/**
 * Created by nathan on 07/03/14.
 */
public class Anim1D {
    public static float linear(float target, float current, float speed){
        float diff = target-current;
        float absDiff = Math.abs(diff);
        if (absDiff < speed) current = target;
        else current += diff/absDiff*speed;
        return current;
    }
}
