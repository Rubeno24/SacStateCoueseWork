package com.mycompany.a3;
import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
//Extends Movable since Ant moves and implements IFoodie since it consumes food
public class Ant extends Moveable implements IFoodie{
	//class fields
	private int maximumSpeed = 100;
	private int foodConsumptionRate;
	private int healthLevel = 10;
	private int lastFlagReached=0;
	private int red = 255;
	private float XLocation;
	private float YLocation;
	private  int antSize;
	private  GameWorld gw;
	
	private  Ant theAnt;
	//Ant Constructor 
	Ant(int size, float x, float y,int heading,GameWorld gw) {
		super(size,x,y,gw);
		super.setColor(ColorUtil.rgb(255, 0, 0));
		this.gw=gw;
		antSize=size;
	}
	


	//Ant Constructor uses the parent or for the size, xLocation, YLocation and the the color 

	//this methods is Overrided from the IFoodie interface and it subtracts from
	// the foodLevel variable in the moveable class every time the game ticks
	@Override
	public void setFoodConsumption() {
		foodConsumptionRate=1;		
	}
	//returns food consumption rate
	public int getFoodConsumption() {
		return foodConsumptionRate;
	}
	
	//returns the health level which starts at 10. Makes sure the health is not negative
	public int getHealthLevel() {
		if(healthLevel<=0) {
			return 0;
		}
		return healthLevel;
	}
	/*Simulates collision with a spider. We reduce the health by 1, call the calculate speed
	method which calculates the max speed based on the health. If the health is 9 the max speed
	is 90, the ant is supposed to fade into lighter shades of red so we subtract 20 from the red rgb value
	every time it collides with a spider and lastly we check if the health is 0 then we set the speed =0
	using a method from the parent class moveable
	*/
	public void simulateSpiderCollison() {
			
			healthLevel-=1;
			calcSpeed(healthLevel);
			red=red-15;
			setColor(ColorUtil.rgb(red, 0, 0));
			if(healthLevel==0) {
				super.setSpeed(0);
			}
			gw.SpiderSound();
			
		}
	/*takes the health and calculates the max speed example if the health is 7 the 
	 * max speed is 70. Then it checks if the speed is less than the maximumSpeed
	 * if so it calls the parents setSpeed method and sets the speed
	*/
	public void calcSpeed(int healthLevel) {
		maximumSpeed= (int) (10000*(healthLevel/1000.00));
		if(getSpeed()>maximumSpeed) {
			super.setSpeed(maximumSpeed);
		}		
	}
	
	//returns the last flag reached
	public int getLastFlagReached() {
		return lastFlagReached;
		
		
	}
	//simulates food consumption by passing in foodConsumptionRate with a minus sign
	//therefore it subtracts from the foodLevel variable
	public void conusumeFood() {
		addTofoodLevel(-foodConsumptionRate);
	}
	
	//method that adds to the food level calls the parent to do so
	public void antAddFood(int food) {
		addTofoodLevel(food);
	}
	//sets the speed only if its less than maximumSpeed and greater than 0
	//calls the moveable setSpeed method to set the speed;
	public void setSpeed(int speed) {
		if(speed<=maximumSpeed && speed>=0) {
			super.setSpeed(speed);
			
		}	
	}
	//Overrides the adjustSpeed method in moveable. It first sets the speed and then
	//it checks if the speed is greater then the maximumSpeed. If thats the case it sets
	//maximumSpeed as the speed. So speed will never go over the maximumSpeed 
	  public void adjustSpeed(int speed) {
		  super.adjustSpeed(speed);
		  if(super.getSpeed()>maximumSpeed) {
			  super.setSpeed(maximumSpeed);
		  }
	  }

	//this method takes in a char and adjusts the heading accordingly
	//char l stands for left and subtracts 5 from the heading by calling the 
	//adjustHeading method from the moveable class. Same thing goes
	// for adjusting the heading to the right but we add 5 to the heading instead
	public void changeAntHeading(char x) {
		if(x=='l') {
			adjustHeading(-25);
		}
		if(x=='r') {
			adjustHeading(25);
	}
	}
	
	//returns the maximumSpeed and checks makes sure that values are between 0 and 100
	public int getmaximumSpeed() {
		if(maximumSpeed>=100) {
			return 100;
		}
		else if (maximumSpeed<=0) {
			return 0;
			}
		return maximumSpeed;
	}
	
	//checks flag collision
	public void checkFlagCollision(int flag) {
		if(flag== (lastFlagReached+1)) {
			lastFlagReached=flag;
			if(gw.getSoundStatus().equals("ON")) {
			gw.flagSound();
			}
			else {
				
			}
		}
	}

	//when the ant loses a life this method resets all the ant values to start the game like nothing happened
	public void reset() {
		lastFlagReached=0;
		setXLocation(100);
		setYLocation(100);
		setFoodLevel(100);
		healthLevel=10;
		maximumSpeed=100;
		super.setSpeed(100);
		setFoodLevel(1000);
		super.setColor(ColorUtil.rgb(255, 0, 0));
	}
	
	 /*Formula to make moveable object move
	   newLocation(x,y) = oldLocation(x,y) + (deltaX, deltaY), where
	  deltaX = cos(theata)*speed,
	  deltaY = sin(theata)*speed,
	  and where theata = 90 - heading (90 minus the heading). 
	  */
	
	
	//this method is responsible moving the ant. It calculates the x and y location from the formula we were given
	//then it calls the move method and passes in the x and y values to the moveable class to make the ant move
	public void moveAnt(int time, GameWorld gameWorld) {
		double timerSpeed = ((getSpeed() / (1000.00/(time+100))));
		XLocation =  (float) (getXLocation()+(Math.cos(Math.toRadians(90-getHeading())))*timerSpeed);
		YLocation = (float) (getYLocation()+(Math.sin(Math.toRadians(90-getHeading())))*timerSpeed);
		 if(YLocation>=1150.0) {
				super.setHeading(super.getHeading()-180);
				
				super.move(XLocation,YLocation);
			}
		 
		 if(YLocation<=-20.0) {
				super.setHeading(super.getHeading()-180);
				
				super.move(XLocation,YLocation);
			}
		 
		 if(XLocation>=1500.0) {
				super.setHeading(super.getHeading()-180);
				
				super.move(XLocation,YLocation);
			}
		 
		 if(XLocation<=1.0) {
				super.setHeading(super.getHeading()-180);
				
				super.move(XLocation,YLocation);
			}
		 else {
		
		super.move(XLocation,YLocation);
			}
	}
	
	
	//sets the food level by calling the parents method and passes in what it recived
	public void setFoodLevel(int x) {
		super.setFoodLevel(x);
	}
	
	
	
	//toString method from the constructor class with added attributes of the ant.
	public String toString() {
		String s = super.toString();
		return "Ant:"+s+" heading="+super.getHeading()+" speed="+super.getSpeed()+" maxSpeed="+getmaximumSpeed()+" foodConsumptionRate="+foodConsumptionRate;
		
	}
	//draws the ant as a red circle
	public void draw(Graphics g, Point pCmpRelPrnt) {
		int xLocation = (int) super.getXLocation()+(int)pCmpRelPrnt.getX();
		int yLocation = (int) super.getYLocation()+(int)pCmpRelPrnt.getY();
		g.setColor(super.getColor());
		g.fillArc(xLocation, yLocation, 2*antSize, 2*antSize, 0, 360);

	}
	
}