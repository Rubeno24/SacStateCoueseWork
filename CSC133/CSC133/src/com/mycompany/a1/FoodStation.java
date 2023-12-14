package com.mycompany.a1;

import com.codename1.charts.util.ColorUtil;

//Extends Fixed since FoodStation doesn't move
public class FoodStation extends Fixed{
	//Class Fields
	private int capacity =0;

	public FoodStation(int size, double x, double y) {
		//Calling the constructor from the GameOject Class
		super(size,x,y);
		//uses the setColor method from the GameObject class to set the color to blue
		super.setColor(ColorUtil.rgb(0, 0, 255));
		
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public void setCapacity(int capacity) {
		this.capacity=capacity;
	}

}
