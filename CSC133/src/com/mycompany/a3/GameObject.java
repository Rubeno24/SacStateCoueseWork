package com.mycompany.a3;

import java.util.ArrayList;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
//parent of every class we created so far
public abstract class GameObject implements IDrawable,ICollider{
	//Class Fields
	private int size;
	private int color;
	//created a new point which will hold x and y float values
	private Point point;
	private boolean collided = false;
	GameWorld gw;
	private ArrayList<GameObject> collisionList  = new ArrayList<GameObject>();


	//GameObject Constructor with size and x and y Locations
	public GameObject(int size, float x_Location, float y_Location,GameWorld gw) {
		this.size=size;
		point=new Point(x_Location,y_Location);		
		this.gw=gw;
	}
	

		
	//Method that sets a new x_Location
	public void setXLocation(float x) {
		point.setX(x);
	}
	
	//Method that sets a new y_Location
	public void setYLocation(float y) {
		point.setY(y);
	}
	
	//returns the x_Location
	public float getXLocation() {
		return point.getX();
	}
	
	//returns the y_Location
	public float getYLocation() {
		return point.getY();
	}
	
	//sets the color 
	public void setColor(int color) {
		this.color=color;
	}
	
	public int getColor() {
		return color;
	}
	
	//returns the size value
	public int getSize() {
		return size;
	}
	
	@Override
	public void draw(Graphics g, Point pCmpRelPrnt) {

	}
	//returns the right xLocation
	public double getRightPosition() {
		return getXLocation()+(size/2);
	}
	//returns the left xLocation
	public double getLeftPosition() {
		return getXLocation()-(size/2);
	}
	//returns the top getYLocation
	public double getTopPosition() {
		return getYLocation()-(size/2);
	}
	//returns the bottom getYLocation
	public double getBottomPosition() {
		return getYLocation()+(size/2);
	}
	//returns the collided boolean
	public boolean checkCollison() {
		return collided;
	}
	//sets the collided boolean
	public void setCollided(boolean collisionStatus) {
		collided=collisionStatus;
	}
	//method to create a new point at new location
	public void setNewLocation(float x, float y) {
		point = new Point(x,y);
	}
	
	
	
	@Override
	public boolean collidesWith(GameObject otherObject) {
		 // Check if the right edge of this object is to the left of the left edge of the other object
	    // or if the left edge of this object is to the right of the right edge of the other object
		if(getRightPosition()<otherObject.getLeftPosition() || getLeftPosition()>otherObject.getRightPosition()) {
			return false;
		}
		 // Check if the top edge of the other object is below the bottom edge of this object
	    // or if the top edge of this object is below the bottom edge of the other object
		if(otherObject.getTopPosition()>getBottomPosition() || getTopPosition()> otherObject.getBottomPosition()) {
			return false;
		}
		// If both horizontal and vertical conditions are false, the objects are colliding
		return true;
		
	}
	
	@Override
	public void handleCollision(GameObject otherObject) {
		//checks to see if collisionList doesnt cotain the otherObject
		if(!collisionList.contains(otherObject)) {
			//checks to see if instance of Flag
		if(otherObject instanceof Flag) {
			//if otherObject is checkCollison false
			if(!otherObject.checkCollison()) {
				//we call the flag collsion method from the game world and add this object to the collision list
				gw.flagCollison(((Flag) otherObject).getsequenceNumber());
				collisionList.add(otherObject);
				
			}
		}//checks to see if instance of FoodStation
		if(otherObject instanceof FoodStation) {
			//if otherObject is checkCollison false
			if(!otherObject.checkCollison()) {
				//sets the collided boolean to true and call the foodstation collision from gameworld
				otherObject.setCollided(true);
				gw.foodStationCollision(otherObject);
				//add this object to the collision list
				collisionList.add(otherObject);
				
			}
		}//checks to see if instance of Spider
		if(otherObject instanceof Spider) {
			//if otherObject is checkCollison false calls the spider collision from gameworld
			if(!otherObject.checkCollison()) {
				gw.spiderCollision();
				//add this object to the collision list
				collisionList.add(otherObject);
				
			}
		}
		
		}
	}
	//removes an object from collisionList
	public void removeObject(GameObject otherObject) {
		if (collisionList.contains(otherObject)) {
			collisionList.remove(otherObject);
			
		}
	}
@Override	
public String toString() {
		return  " loc= X:" + Math.round(getXLocation()*10.0)/10.0 + " , Y:" + Math.round(getYLocation()*10.0)/10.0 
				+" color=[" + ColorUtil.red(color)+ "," +ColorUtil.green(color) + "," +ColorUtil.blue(color) + "]" 
				+ " size=" + size;
		
	}

}