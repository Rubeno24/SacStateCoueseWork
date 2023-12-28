package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class PauseCommand extends Command {
	private GameWorld gw;
	//command Constructor
	public PauseCommand(GameWorld gw) {
		//sets command name
		super("Pause");
		this.gw=gw;
		// TODO Auto-generated constructor stub
	}
	//when button or key is pressed it will increase the speed of the ant in this case by 5
	public void actionPerformed(ActionEvent e) {
		if(gw.getPauseStatus()==true) {
			System.out.println("Continue the Game");
			gw.setPauseStatus(false);
		}
		else {
			System.out.println("Pause the Game");
			gw.setPauseStatus(true);
		}
	}
}
