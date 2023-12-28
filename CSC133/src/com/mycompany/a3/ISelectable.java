package com.mycompany.a3;

import com.codename1.charts.models.Point;
import com.codename1.ui.Graphics;

public interface ISelectable {
	// Sets the selected state of an object
	public void setSelected(boolean b);
    // Checks if an object is selected or not
	public boolean isSelected();
	 // Checks if a given point is contained within the object's boundaries
	public boolean contains(Point pPtrRelPrnt, Point pCmpRelPrnt);
	  // Draws the object using the specified graphics context and relative points
	public void draw(Graphics g, Point pCmpRelPrnt);
	

}
