package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class AccelerateCommand extends Command{
	private GameWorld gw;
	//command Constructor
	public AccelerateCommand(GameWorld gw) {
		//sets command name
		super("Accelerate");
		this.gw=gw;
		// TODO Auto-generated constructor stub
	}
	//when button or key is pressed it will increase the speed of the ant in this case by 5
	public void actionPerformed(ActionEvent e) {
		gw.setAntSpeed(5);
		System.out.println("Ant is Acclerating");
	}

}
