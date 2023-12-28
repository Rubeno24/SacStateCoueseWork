package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class FoodStationCollisionCommand extends Command {
	private GameWorld gw;
	//command Constructor
	public FoodStationCollisionCommand(GameWorld gw) {
		//sets command name
		super("Collide with FoodStations");
		this.gw=gw;
		// TODO Auto-generated constructor stub
	}
	//when the button or key is pressed the method simulatefoodStationCollision is called
	public void actionPerformed(ActionEvent e) {
		gw.simulatefoodStationCollision();
		System.out.println("Ant colided with a Food Station");
	}
}
