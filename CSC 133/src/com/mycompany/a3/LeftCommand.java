package com.mycompany.a3;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class LeftCommand extends Command {
	private GameWorld gw;
	//command Constructor
	public LeftCommand(GameWorld gw) {
		//sets command name
		super("Left");
		this.gw=gw;
		// TODO Auto-generated constructor stub
	}
	//when the button or key is pressed the ant turns to the left
	public void actionPerformed(ActionEvent e) {
		gw.changeHeading('l');
		System.out.println("Ant turned left. Current heading:  "+gw.getHeading());
		
	}

}