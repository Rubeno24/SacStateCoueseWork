package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class FlagCommand extends Command {
	//command Constructor
	private GameWorld gw;
	public FlagCommand(GameWorld gw) {
		//sets command name
		super("Collide with Flag");
		this.gw=gw;
		// TODO Auto-generated constructor stub
	}
	//when the user presses this button it will call the simulateFlagCollision method
	public void actionPerformed(ActionEvent e) {
		
		
	}
}
