package com.mycompany.a3;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class BrakeCommand extends Command {
	private GameWorld gw;
	//command Constructor
	public BrakeCommand(GameWorld gw) {
		//sets command name
		super("Break");
		this.gw=gw;
	}
	//when the button or key is pressed the ant speed goes down by in this case
	public void actionPerformed(ActionEvent e) {
		gw.setAntSpeed(-5);
		System.out.println("Ant is Breaking");
	}
}
