package com.mycompany.a3;
//A type of object that can move
public abstract class Moveable  extends GameObject{
	//Class Fields
	private int heading=0;
	private int Speed=100;
	private int foodLevel=1000;

	
	
	  public Moveable (int size, float x, float y,GameWorld gw) {
			//Calling the constructor from the GameOject Class
	    	super (size, x, y,gw);
	    }
	  //returns the speed value checks that is less than 100 and greater than 0
	  public int getSpeed() {
		  if(Speed>=100) {
			  Speed=100;
		  }
		  if(Speed<=0) {
			  Speed=0;
		  }
		  return Speed;
	  }
	  //returns the heading
	  public int getHeading() {
		  return heading;
	  }
	//sets the speed
	  public void setSpeed(int speed) {
		  this.Speed=speed;
	  }
	  //adjusts speed by adding positive or negative numbers to the speed
	  public void adjustSpeed(int speed) {
		  this.Speed+=speed;
		 
	  }
	  //sets the heading
	  public void setHeading(int x) {
		  this.heading=x;
	  }
	  //Adjusts the heading by adding or subtracting to it.
	  public void adjustHeading(int x) {
		  this.heading+=x;
	  }
	  //returns the foodLevel and makes sure it is not less than 0 or greater than 100
	  public int getFoodLevel() {
			if(foodLevel<=0) {
				foodLevel= 0;
			}
			 if(foodLevel>1000) {
					foodLevel=1000;
					}
			return foodLevel;
		}
	  //adds to the food level used when colliding with food station
		public void addTofoodLevel(int food) {
			foodLevel+=food;
	}
	  //sets the food level
		public void setFoodLevel(int food) {
			this.foodLevel=food;
		}
	  
	 
	 
	  //other classes send in values of type float and this method calls the setXLocation
	  //setYLocation in the GameObject class which cause the location to be moved
	public void move(float x,float y) {
			setXLocation(x);
			setYLocation(y);
		}
	}

	

