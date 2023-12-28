package com.mycompany.a3;

import java.util.Random;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
//Extends Movable since Ant moves
public class Spider extends Moveable{
	private Random random = new Random(); 
	private float XLocation;
	private float YLocation;

	
	public Spider(int size, float x, float y,GameWorld gw) {
		super(size,x,y,gw);
		//sets spider color to black
		super.setColor(ColorUtil.rgb(0, 0, 0));
		//picks a random speed between 5 and 10
		super.setSpeed(randomSpeed());
		super.setHeading(randomInitalHeading());
	}
	@Override
	public void setColor(int color) {
		//no code since they cannot change colors
	}

	//returns a random speed between 5 and 10
	public int randomSpeed() {
		//return 5 + random.nextInt(10);
		return 50 + random.nextInt(55);
	}
	
	//returns a random heading between 0 and 360
	public int randomInitalHeading() {
		return  random.nextInt(359);
	}

	//returns a random number between -7 amd 7
	public int getRandomHeading() {
		 //return random.nextInt(7) * (random .nextBoolean() ? -1 : 1);
		return random.nextInt(359);
	}
	//toString method from the constructor class with added attributes of the spider.
	public String toString() {
		return "Spider: "+super.toString()+" heading="+super.getHeading()+" speed="+getSpeed();
	}
	@Override
	public void setFoodLevel(int food) {
		//no code since they do not have foodLevels
	}
	
	//this method generates the x and y values for the spider then it checks to see if the spider is out of bounds
	//for now our bounds is 1000x1000. so if its out of bounds we change the heading by 180 turning the spider around
	public  void moveSpider(int time, GameWorld gameWorld) {
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
	//draws the spider as unfilled triangle
	public void draw(Graphics g, Point pCmpRelPrnt) {
		//holds x and y cords as ints
		int xLocation = (int) super.getXLocation()+(int)pCmpRelPrnt.getX();
		int yLocation = (int) super.getYLocation()+(int)pCmpRelPrnt.getY();
		//sets color
		g.setColor(super.getColor());
		//cords for the array to draw triangles
		int point1X= xLocation-this.getSize()/2;
		int point2X= xLocation+this.getSize()/2;
		
		int point1Y= yLocation-this.getSize()/2;
		int point2Y= yLocation-this.getSize()/2;
		int point3Y= yLocation+this.getSize()/2;
		
		//array of cords used to draw the triangle
		int xPoints[] = new int[] {point1X,point2X,xLocation};
		int yPoints[] = new int[] {point1Y,point2Y,point3Y};
		g.drawPolygon(xPoints, yPoints, 3);
	}

	
	
}