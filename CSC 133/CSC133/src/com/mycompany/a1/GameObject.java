package com.mycompany.a1;

public class GameObject {
	//Class Fields
	private int size;
	private double x_Location;
	private double y_Location;
	private int color;
	//use the point class
	
	//GameObject Constructor
	public GameObject(int size, double x, double y) {
		this.size=size;
		this.x_Location=x;
		this.y_Location=y;
		
	}
	
	//Method that sets a new x_Location
	public void setXLocation(int x) {
		this.x_Location=x;
	}
	//Method that sets a new y_Location
	public void setYLocation(int y) {
		this.y_Location=y;
	}
	
	//returns the x_Location
	public double getXLocation() {
		return x_Location;
	}
	
	//returns the y_Location
	public double getYLocation() {
		return y_Location;
		
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

}
