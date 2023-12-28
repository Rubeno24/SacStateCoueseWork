package com.mycompany.a3;

import java.util.Observable;
import java.util.Observer;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Container;
import com.codename1.ui.Graphics;
import com.codename1.ui.plaf.Border;

public class MapView extends Container implements Observer {
	private GameWorld gw;

	// command Constructor
	public MapView(GameWorld gw) {
		this.gw = gw;
		this.gw.addObserver(this);
		this.getAllStyles().setBorder(Border.createLineBorder(4, ColorUtil.rgb(255, 0, 0)));

	}

	// rewrite code
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		//we create an itterator of gameObjects and a new object name temp
		IIterator iterator = gw.GameObjects.getIterator();
		Object temp = new Object();
		Point pCmpRelPrnt = new Point(getX(), getY());
		while (iterator.hasNext()) {
			temp = iterator.getNext();
			 // Drawing the current object onto the graphics context g, using pCmpRelPrnt as a relative point
			((GameObject) temp).draw(g, pCmpRelPrnt);

		}
	}

	//call when pointer is pressed 
	public void pointerPressed(int x, int y) {
		//if the game is paused we proceed
		if (gw.getPauseStatus() == true) {

			//x and y cords of where clicked
			int xLoc= x - getParent().getAbsoluteX();
			int yLoc= y - getParent().getAbsoluteY();
			
			//create 2 points one for the user clicked and one for the object
			Point pPtrRelPrnt = new Point(xLoc, yLoc);
			Point pCmpRelPrnt = new Point(getX(), getY());
			//create an iterator of gameobjects and keep going untill next is false
			IIterator iterator = gw.GameObjects.getIterator();
			
			while (iterator.hasNext()) {
				GameObject temp = (GameObject) iterator.getNext();
				//assign temp to the next object and check if instance of fixed
				//if it is we create a new object of type fixed then we check if it has pPtrRelPrnt and pCmpRelPrnt
				if (temp instanceof Fixed) {
					Fixed newObject = ((Fixed) temp);
					if (newObject.contains(pPtrRelPrnt, pCmpRelPrnt)) {
						// if it does then we set its selected to ture and postion status to false
						newObject.setSelected(true);
						gw.setPositionStatus(false);
					} 
					//if the newObject is selected is true we get its new cords and move it there
					//and set its position and selected status to false
					else if (newObject.isSelected()) {
						if (gw.getPosition() == true) {
							float newXcord = pPtrRelPrnt.getX() - pCmpRelPrnt.getX();
							float newYcord = pPtrRelPrnt.getY() - pCmpRelPrnt.getY();
							newObject.setNewLocation(newXcord,newYcord);

						}
						gw.setPositionStatus(false);
						newObject.setSelected(false);

					}

					revalidate();

				}

			}
		}
	}

	@Override
	public void update(Observable observable, Object data) {
		this.repaint();
		// calls the map method that was previously the 'm' key
		gw.map();

	}

}
