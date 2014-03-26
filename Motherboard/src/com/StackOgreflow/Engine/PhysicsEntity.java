package com.StackOgreflow.Engine;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Physical entity following Newtonian physics and ball collisions
 * @author nathan
 */
public class PhysicsEntity extends Container{
	
	protected Vector2 velocity;
	protected Vector2 acceleration;
	protected float radius;
	
	public PhysicsEntity(){
		super();
	}

    public PhysicsEntity setVelocity(Vector2 velocity){
        this.velocity = velocity;
        return this;
    }

    public PhysicsEntity setAcceleration(Vector2 acceleration){
        this.acceleration = acceleration;
        return this;
    }

    public PhysicsEntity setRadius(float radius){
        this.radius = radius;
        return this;
    }
	
	public void update(){
		// Movement and Momentum
		position.add(velocity.cpy().scl(Time.deltaTime()));
		velocity.add(acceleration.cpy().scl(Time.deltaTime()));
        //superclass updating
        super.update();
	}
	
	public void checkCollisions(){
		for(Entity e : parent.children){
            if (!(e instanceof PhysicsEntity)) continue;
            if (((PhysicsEntity)e).checkCollision(this)) return;
		}
	}
	
	public boolean checkCollision(PhysicsEntity other){
		if (other == this) return false;
		if (position.cpy().sub(other.position).len() < radius + other.radius){
			onCollide();
			other.onCollide();
			return true;
		} 
		return false;
	}
	
	public void drawSprite(SpriteBatch batch){
	}
	
	public void onCollide(){
		
	}
	
	public void destroy(){
		super.destroy();
	}
}