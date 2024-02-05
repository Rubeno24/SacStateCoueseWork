package com.mycompany.a3;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.layouts.BoxLayout;

public class HelpCommand extends Command {
	private GameWorld gw;
	public HelpCommand(GameWorld gw) {
		//sets command name
		super("Help");
		this.gw=gw;
		// TODO Auto-generated constructor stub
	}
	//when the help button is clicked all the key bindings and functions will be displayed for the user
	public void actionPerformed(ActionEvent e) {
		Dialog help = new Dialog("Help", new BoxLayout(BoxLayout.Y_AXIS));
		Command ok= new Command("ok");
		help.add(new Label("Key Bindings"));
		help.add(new Label("'A' key - makes the ant INCREASE SPEED"));
		help.add(new Label("'B' key - makes the ant DECREASE SPEED"));
		help.add(new Label("'L' key - makes the ant TURN to the LEFT"));
		help.add(new Label("'R' key - makes the ant TURN to the RIGHT"));
		help.add(new Label("'C' key - set FOOD CONSUMPTION"));
		help.add(new Label("'F' key - COLLIDE with FOOD STATION"));
		help.add(new Label("'T' key - cause the game to TICK"));
		Dialog.show("",help,ok);
	}
}
