package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class FoodConsumptionCommand extends Command {
	private GameWorld gw;
	//command Constructor
	public FoodConsumptionCommand(GameWorld gw) {
		//sets command name
		super("FoodConsumption");
		this.gw=gw;
		// TODO Auto-generated constructor stub
	}
	//when the c key is pressed the ant's food consuption rate is set
	public void actionPerformed(ActionEvent e) {
		gw.setAntFoodConsuptionRate();
		
	}

}
