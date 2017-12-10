package character;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import utility.Pair;

public abstract class Animal {
	
	public Pair index;
	public double speed;  
	public int direction;
	public int z;
	public Queue<Pair> runPath;
	
	public Thread animationThread;
	public Thread runThread;
	public ImageView body;
	public boolean isRunning;
	public boolean inverse;
	public long angle;
	public static int angles[]= {-30,30,90,150,210,270};
	
	public Animal(Pair index, double speed, int direction, int z,boolean inverse)
	{
		this.index = index;
		this.speed = speed;
		this.direction = direction;
		this.angle = angles[direction];
		this.z = z;
		this.inverse = inverse;
		this.body = new ImageView();
		this.runPath = new LinkedBlockingQueue<Pair>();
	}
	
	public abstract void startRunning();
	public abstract void stopRunning();
	public abstract void animateLoop();
	public abstract void runLoop();
	public abstract boolean isVisible();
	
	public abstract Pair nextBlock();
	public void turnLeft()
	{
		this.direction = (this.direction - 1 + 6 ) % 6;
		this.angle -= 60;
	}
	public void turnRight()
	{
		this.direction = (this.direction + 1 + 6 ) % 6;
		this.angle += 60;
	}
	public Pair getIndex() {
		return index;
	}
	public void setIndex(Pair index) {
		this.index = index;
	}
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double d) {
		this.speed = d;
	}
	public int getDirection() {
		return direction;
	}
	public void setDirection(int direction) {
		this.direction = direction;
	}
	public int getZ() {
		return z;
	}
	public void setZ(int z) {
		this.z = z;
	}

	public boolean isInverse() {
		return inverse;
	}

	public void setInverse(boolean inverse) {
		this.inverse = inverse;
	}

	public void setAngle(int newDirection) {
		int x = (newDirection - this.direction+6)%6;
		if(x == 4)	x=-2;
		else if(x == 5) x = -1;
		this.angle += x*60;
	}



	
	
	
}
