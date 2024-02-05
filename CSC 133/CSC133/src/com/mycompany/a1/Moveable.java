package com.mycompany.a1;

public class Moveable  extends GameObject{
	//Class Fields
	private int heading;
	private int speed;
	private int foodLevel;
	
	
	  public Moveable (int size, double x, double y) {
			//Calling the constructor from the GameOject Class
	    	super (size, x, y);
	    }
	  
	  public int getSpeed() {
		  return speed;
	  }
	  public int getHeading() {
		  return heading;
	  }
	
	  public int getFoodLevel() {
		  return foodLevel;
	  }
	  
	  public void setSpeed(int speed) {
		  this.speed=speed;
	  }
	  
	  public void setHeading(int heading) {
		  this.heading=heading;
	  }
	  
	  public void setFoodLevel(int foodlevel) {
		  this.foodLevel=foodlevel;
	  }
	  
	  
	public void move() {
		
	};

}
