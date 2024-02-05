package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.table.TableLayout;

public class AboutCommandd extends Command {
	private GameWorld gw;
	//command Constructor
	public AboutCommandd(GameWorld gw) {
		//sets command name
		super("About");
		this.gw=gw;
	}
	//when button is pressed it will create a dialog box and display the about information below
	public void actionPerformed(ActionEvent e) {
		Dialog about = new Dialog("About", new BoxLayout(BoxLayout.Y_AXIS));
		Command ok= new Command("ok");
		about.add(new Label ("Created by: Ruben Daniel Ortega"));
		about.add(new Label ("Course: CSC133"));
		about.add(new Label ("Version Number: 3"));
		about.add(new Label ("Date 11/20/23"));
		Dialog.show("",about,ok);
	}

}
