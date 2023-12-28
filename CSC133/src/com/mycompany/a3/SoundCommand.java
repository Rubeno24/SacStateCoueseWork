package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class SoundCommand extends Command {
	private GameWorld gw;
	//command Constructor
	public SoundCommand(GameWorld gw) {
		//sets command name
		super("Sound");
		this.gw=gw;
		// TODO Auto-generated constructor stub
	}
	//when the checkbox is checked or unchecked the sound is turned on or off
	public void actionPerformed(ActionEvent e) {
		gw.toggleSound();
		System.out.println("Sound status: "+ gw.getSoundStatus());
	}

}
