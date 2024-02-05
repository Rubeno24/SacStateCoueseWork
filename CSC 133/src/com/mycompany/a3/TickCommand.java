package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class TickCommand extends Command {
	private GameWorld gw;
	//command Constructor
	public TickCommand(GameWorld gw) {
		//sets command name
		super("Tick");
		this.gw=gw;
		
	}
	//when the button or key is pressed the game clock is incremented by 1
	public void actionPerformed(ActionEvent e) {
		gw.tick(20);
		System.out.println("Game Ticked");
	}

}
