package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class RightCommand extends Command {
	private GameWorld gw;
	//command Constructor
	public RightCommand(GameWorld gw) {
		//sets command name
		super("Right");
		this.gw=gw;
		// TODO Auto-generated constructor stub
	}
	//when the button or key is pressed the ant turns to the right
	public void actionPerformed(ActionEvent e) {
		gw.changeHeading('r');
		System.out.println("Ant turned right. Current heading:  "+gw.getHeading());
		
	}
}
