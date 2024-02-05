package com.mycompany.a3;

import com.codename1.charts.compat.Paint.Style;
import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;

//extends Fixed since it doesn't move
public class Flag extends Fixed{
	//Class Fields
	private int sequenceNumber;
	private int size;

	
	
	public Flag(int size, float x, float y, int sequenceNumber,GameWorld gw) {
		//Calling the constructor from the GameOject Class
		super(size,x,y,gw);
		this.sequenceNumber=sequenceNumber;
		//uses the setColor method from the GameObject class to set the color to blue
		super.setColor(ColorUtil.rgb(0, 0, 255));
		this.size=size;
	}
	
	//returns sequence number
	public int getsequenceNumber() {
		return sequenceNumber;
	}
	@Override
	public void setColor(int color) {
		//no code since flags can not switch colors
	}
	//draws flag as blue triangle
	public void draw(Graphics g, Point pCmpRelPrnt) {
		
		//storing xLocation & yLocation relative to parent 
		int xLocation = (int) super.getXLocation()+(int)pCmpRelPrnt.getX();
		int yLocation = (int) super.getYLocation()+(int)pCmpRelPrnt.getY();
		//sets the color of the triangle to blue
		g.setColor(super.getColor());
		//stores location into variables to be added into array to be used to draw the triangle
		int point1X= xLocation-this.getSize()/2;
		int point2X= xLocation+this.getSize()/2;
		
		int point1Y= yLocation-this.getSize()/2;
		int point2Y= yLocation-this.getSize()/2;
		int point3Y= yLocation+this.getSize()/2;
		//array of variables to be used to draw triangle
		int xPoints[] = new int[] {point1X,point2X,xLocation};
		int yPoints[] = new int[] {point1Y,point2Y,point3Y};
		
		//if its not selected draw it as normal with the number in the middle
		if(isSelected()==false) {
		g.drawPolygon(xPoints, yPoints, 3);
		g.fillPolygon(xPoints, yPoints, 3);
		g.setColor(ColorUtil.WHITE);
		g.drawString(Integer.toString(sequenceNumber), xLocation-10, (yLocation-this.getSize()/2)+15);
		}
		//if its selected draw as a triangle that is not filled
		else {
			g.drawPolygon(xPoints, yPoints, 3);
		}

	}
	
	
	
	public String toString() {
		String s = super.toString();
		return "Flag: "+s+" seqNum="+sequenceNumber;
		
	}

}
