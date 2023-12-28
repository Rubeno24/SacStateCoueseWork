package com.mycompany.a3;

import java.util.Observable;
import java.util.Observer;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;

public class ScoreView extends Container implements Observer  {
	//class fields
	private  GameWorld gameWorld ;
	private Label clockLabel;
	private Label clockValue;
	private Label flagLabel;
	private Label flagValue;
	private Label healthLabel;
	private Label healtValue;
	private Label soundLabel;
	private Label soundValue;
	private Label foodLabel;
	private Label foodValue;
	private Label livesLabel;
	private Label livesValue;
	
	
	public ScoreView(Observable gw) {
		gameWorld= ((GameWorld) gw);
		gw.addObserver(this);
		this.setLayout(new FlowLayout(Component.CENTER));
		
		//displays the time which is the amount of ticks
		clockLabel = new Label("Time: ");
		clockValue = new Label("" + gameWorld.getClock());
		clockLabel.getAllStyles().setFgColor(ColorUtil.BLUE);
		clockValue.getAllStyles().setFgColor(ColorUtil.BLUE);
		
		//displays the last flag that is reached
		flagLabel = new Label("Last Flag Reached: ");
		flagValue = new Label(""+gameWorld.getLastFlagReached());
		flagLabel.getAllStyles().setFgColor(ColorUtil.BLUE);
		flagValue.getAllStyles().setFgColor(ColorUtil.BLUE);
		
		//displays the health of the ant
		healthLabel = new Label("Health: ");
		healtValue = new Label(""+gameWorld.getHelthLevel());
		healthLabel.getAllStyles().setFgColor(ColorUtil.BLUE);
		healtValue.getAllStyles().setFgColor(ColorUtil.BLUE);
		
		//displays the current status of the sound
		soundLabel = new Label("Sound: ");
		soundValue =  new Label(""+gameWorld.getSoundStatus());
		soundLabel.getAllStyles().setFgColor(ColorUtil.BLUE);
		soundValue.getAllStyles().setFgColor(ColorUtil.BLUE);
		
		//displays the food level of the ant
		foodLabel = new Label("Food Level: ");
		foodValue = new Label(""+gameWorld.getFoodLevel());
		foodLabel.getAllStyles().setFgColor(ColorUtil.BLUE);
		foodValue.getAllStyles().setFgColor(ColorUtil.BLUE);
		
		//displays the lives left of the ant
		livesLabel = new Label("Lives Left: ");
		livesValue = new Label(""+gameWorld.getLives());
		livesLabel.getAllStyles().setFgColor(ColorUtil.BLUE);
		livesValue.getAllStyles().setFgColor(ColorUtil.BLUE);
		
		//adds all the labels 
		this.add(clockLabel);
		this.add(clockValue);
		this.add(livesLabel);
		this.add(livesValue);
		this.add(flagLabel);
		this.add(flagValue);
		this.add(foodLabel);
		this.add(foodValue);
		this.add(healthLabel);
		this.add(healtValue);
		this.add(soundLabel);
		this.add(soundValue);
		

		

		
		
	}
	public void update1() {
		//sets the labels with updates values
		clockValue.setText("" + gameWorld.getClock());
		clockValue.getParent().revalidate();
		flagValue.setText(""+gameWorld.getLastFlagReached());
		healtValue.setText(""+gameWorld.getHelthLevel());
		healtValue.getParent().revalidate();
		soundValue.setText(""+gameWorld.getSoundStatus());
		foodValue.setText(""+gameWorld.getFoodLevel());
		livesValue.setText(""+gameWorld.getLives());
		
	}
	@Override
	public void update(Observable observable, Object data) {
		update1();
		
	}

}
