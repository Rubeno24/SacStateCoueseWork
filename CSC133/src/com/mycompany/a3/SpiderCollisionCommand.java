package com.mycompany.a3;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class SpiderCollisionCommand extends Command {
	private GameWorld gw;
	public SpiderCollisionCommand(GameWorld gw) {
		//sets command name
		super("Collide with Spider");
		this.gw=gw;
		// TODO Auto-generated constructor stub
	}

	public void actionPerformed(ActionEvent e) {
		//calls the spiderCollision method when the collide with spider button is pressed
		gw.spiderCollision();
		System.out.println("Ant colided with a spider");
	}
}
