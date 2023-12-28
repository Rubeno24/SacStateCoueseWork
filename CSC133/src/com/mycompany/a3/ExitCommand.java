package com.mycompany.a3;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;

public class ExitCommand extends Command {
	private GameWorld gw;
	//command Constructor
	public ExitCommand(GameWorld gw) {
		//sets command name
		super("Exit");
		this.gw=gw;
		// TODO Auto-generated constructor stub
	}

	//prompts the user if they want exit the program
	public void actionPerformed(ActionEvent e) {
		Command yes = new Command("Yes");
		Command no = new Command("No");
		Label label = new Label("");
		//if the users selects yes the program closes
		Command decsion = Dialog.show("Do you want to exit?", label, yes, no);
		if(decsion==yes) {
			System.exit(0);
		}
		//if the user selects no the program will not exit
		else if(decsion==no) {
			return;
			
		}
	}


}
