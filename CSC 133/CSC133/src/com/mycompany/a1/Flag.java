package com.mycompany.a1;

import com.codename1.charts.util.ColorUtil;

//extends Fixed since it doesn't move
public class Flag extends Fixed{
	//Class Fields
	private int sequenceNumber;
	
	
	public Flag(int size, int x, int y, int sequenceNumber) {
		//Calling the constructor from the GameOject Class
		super(size,x,y);
		this.sequenceNumber=sequenceNumber;
		//uses the setColor method from the GameObject class to set the color to blue
		super.setColor(ColorUtil.rgb(0, 0, 255));
		
	}
	
	//returns sequence number
	public int getsequenceNumber() {
		return sequenceNumber;
	}

}
