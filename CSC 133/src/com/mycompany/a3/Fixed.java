package com.mycompany.a3;

import com.codename1.charts.models.Point;

//A type of GameObject that does not move
public abstract class Fixed extends GameObject implements ISelectable {
	//boolean that determines if an item is selected
	private boolean isSelected;
	
	//Fixed Constructor
	public Fixed(int size, float x, float y,GameWorld gw) {
		//Calling the constructor from the GameOject Class
		super(size,x,y,gw);
	
	}
	// a way to mark an object as selected or not
	@Override
	public void setSelected(boolean b) {
		isSelected = b;	
	}
	@Override
	public boolean isSelected() {
		return isSelected;
		//returns true or false
		
	}
	public boolean contains(Point pPtrRelPrnt, Point pCmpRelPrnt) {
		//storing x and y into ints
		int x = (int) pPtrRelPrnt.getX();
		int y = (int) pPtrRelPrnt.getY();
		
		//storing xLococation & xLococation relative to parent 
		int xLococation = (int) (pCmpRelPrnt.getX()+ this.getXLocation());
		int yLococation = (int) (pCmpRelPrnt.getY()+ this.getYLocation());
		//checking if it with in boundaries. if so return true else return false
		if((x>=xLococation) && (x<= xLococation+this.getSize()) && (y>=yLococation) && (y<=yLococation+this.getSize())) {
			return true;
		}else {
			return false;
		}
	}
	
	//Method that sets a new x_Location 
	@Override
	public void setXLocation(float x) {
		//doesn't change location since they are fixed
	}
	//Method that sets a new y_Location 
	@Override
	public void setYLocation(float y) {
		//doesn't change location since they are fixed
	}

}
