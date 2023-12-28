package com.mycompany.a3;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;

//Extends Fixed since FoodStation doesn't move
public class FoodStation extends Fixed {
	// Class Fields
	private int capacity;

	public FoodStation(int size, float x, float y, GameWorld gw) {
		// Calling the constructor from the GameOject Class
		super(size, x, y, gw);
		// uses the setColor method from the GameObject class to set the color to green
		super.setColor(ColorUtil.rgb(0, 255, 0));
		// The initial capacity is proportional to the size of the food station
		capacity = size;
	}

	// returns the capacity of the food station
	public int getCapacity() {
		return capacity;
	}

	// sets the capacity to zero when ant eats from the FoodStation
	public void setCapacitytoZero() {
		capacity = 0;
	}

	// Making a food station a filled green square
	public void draw(Graphics g, Point pCmpRelPrnt) {
		// use the cords of pCmpRelPrnt to get cords of parent contained
		int XLocation = (int) (this.getXLocation() + pCmpRelPrnt.getX() - capacity / 2);
		int YLocation = (int) (this.getYLocation() + pCmpRelPrnt.getY() - capacity / 2);
		// set color to green
		g.setColor(super.getColor());
		// if its not selected draw as normal
		if (isSelected() == false) {
			g.fillRect(XLocation, YLocation, capacity * 4, capacity * 4);
			g.setColor(ColorUtil.BLACK);
			if (capacity != 0) {
				g.drawString(Integer.toString(capacity), XLocation + 40, YLocation + 40);
			}
		} 
		//if selected draw as green outline
		else {
			g.drawRect(XLocation, YLocation, capacity * 4, capacity * 4);
		}

	}

	// toString method for FoodSation uses the GameObjects to String and then adds
	// its own attributes
	public String toString() {
		return "FoodStation: " + super.toString() + " capacity: " + capacity;
	}

}