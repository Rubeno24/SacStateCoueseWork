package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class PostitionCommand extends Command{
	
	private GameWorld gw;
	//command Constructor
	public PostitionCommand(GameWorld gw) {
		//sets command name
		super("Position");
		this.gw = gw;
		
			}
	//when the button or key is pressed the position is alternated 
	@Override
	public void actionPerformed(ActionEvent ev) {

		gw.altPosition();
	}


}
