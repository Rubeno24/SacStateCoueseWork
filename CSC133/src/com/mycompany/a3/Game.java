package com.mycompany.a3;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.util.UITimer;
import com.codename1.ui.Label;
import java.lang.String;

public class Game extends Form implements Runnable{
	private GameWorld gw;
	private MapView mv; // new in A2
	private ScoreView sv; // new in A2
	private MyButton pauseButton;//
	
	private MyButton accelerateButton ;
	private MyButton brakeButton ;
	private MyButton leftButton ;
	private MyButton rightButton ;
	private MyButton	positionButton;
	
	private Toolbar toolbar = new Toolbar();
	
	private Command accelerateCommand ;
	private Command brakeCommand ;
	private Command leftCommand ;
	private Command rightCommand ;
	private Command foodConsumptionCommand ;
	private Command exitCommand ;
	private Command soundCommand ;
	private Command aboutCommand ;
	private Command helpCommand ;
	private Command pauseCommand ;
	private Command postionCommand ;
	private CheckBox soundCheck ;
	UITimer timer;
	
	

	// GameWorld instance in instantiated in the Game Constructor
	public Game() {
		gw = new GameWorld(); // create Observable GameWorld
		mv = new MapView(gw); // create an Observer for the map
		sv = new ScoreView(gw); // create an Observer for the game/ant state data
		gw.addObserver(mv); // register the map observer
		gw.addObserver(sv);// register the score observer

		// set the layout to BorderLayout be divided into five areas: one for score
		// information, three for commands, and
		// one for the map (which will be an empty container) for now
		this.setLayout(new BorderLayout());

		// Command Objects
		 accelerateCommand = new AccelerateCommand(gw);
		 brakeCommand = new BrakeCommand(gw);
		 leftCommand = new LeftCommand(gw);
		 rightCommand = new RightCommand(gw);
		 foodConsumptionCommand = new FoodConsumptionCommand(gw);
		 exitCommand = new ExitCommand(gw);
		 soundCommand = new SoundCommand(gw);
		 aboutCommand = new AboutCommandd(gw);
		 helpCommand = new HelpCommand(gw);
		 pauseCommand = new PauseCommand(gw);
		 postionCommand = new PostitionCommand(gw);
		
		// key bindings
	

		

		// buttons used for the on screen commands
		
		accelerateButton  = new MyButton();
		 brakeButton  =new MyButton();
		 leftButton  =new MyButton();
		 rightButton  =new MyButton();
		positionButton =new MyButton();
		pauseButton = new MyButton();
		positionButton = new MyButton();
		 

		// on screen commands
		accelerateButton.setCommand(accelerateCommand);
		brakeButton.setCommand(brakeCommand);
		leftButton.setCommand(leftCommand);
		rightButton.setCommand(rightCommand);
		pauseButton.setCommand(pauseCommand);
		positionButton.setCommand(postionCommand);
		
	
		// side menu items
		this.setToolbar(toolbar);
		toolbar.addCommandToSideMenu(aboutCommand);
		toolbar.addCommandToSideMenu(exitCommand);
		toolbar.addCommandToRightBar(helpCommand);
		
		
		
		
		toolbar.setTitle("The Journey Game ");
		 soundCheck = new CheckBox("Sound");
		soundCheck.getStyle().setFgColor(ColorUtil.WHITE);
		soundCheck.setCommand(soundCommand);
		
		toolbar.addComponentToSideMenu(soundCheck);
		
		toolbar.addCommandToSideMenu(accelerateCommand);
		

		// west container
		Container westContainer = new Container();
		westContainer.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.BLACK));
		westContainer.setLayout(new BoxLayout(2));
		westContainer.add(accelerateButton);
		this.add(BorderLayout.WEST, westContainer);
		westContainer.add(leftButton);


		// center container
		this.add(BorderLayout.CENTER, mv);

		// South Container
		Container southContainer = new Container();
		southContainer.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.BLACK));
		southContainer.setLayout(new FlowLayout(Component.CENTER));
		this.add(BorderLayout.SOUTH, southContainer);

		southContainer.add(pauseButton);
		southContainer.add(positionButton);

		// East Container
		Container eastContainer = new Container();
		eastContainer.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.BLACK));
		eastContainer.setLayout(new BoxLayout(2));
		eastContainer.add(brakeButton);
		this.add(BorderLayout.EAST, eastContainer);
		eastContainer.add(rightButton);

		// North Container
		Container North = new Container();
		sv.getAllStyles().setBorder(Border.createLineBorder(0, ColorUtil.WHITE));
		sv.getAllStyles().setMarginLeft(300);
		North.add(sv);
		this.add(BorderLayout.NORTH, North);
		
		gw.setMapHeight(mv.getComponentForm().getHeight());//created a method
		gw.setMapWidth(mv.getComponentForm().getWidth());//created a method
		

		this.show();
		gw.setMapHeight(mv.getHeight());//created a method
		gw.setMapWidth(mv.getWidth());//created a method
		
		gw.init();
		gw.createSounds();
		revalidate();
		//without show method being called nothing will be displayed
		
		//created a timer
		timer = new UITimer(this);
		timer.schedule(20, true, this);
		
	}
	
	
	@Override
	public void run() {
		//if the pause status is true change the text to play and call the pauseBG method which pause BG music
		//game doesnt move because we dont call the tick method and dont send in a time
		if(gw.getPauseStatus()==true) {
		
			pauseButton.setText("Play");
			gw.pauseBG();
			
			//if the game is paused only the positionButton will be able to be used
			positionButton.setEnabled(true);

			accelerateButton.setEnabled(false);
			brakeButton.setEnabled(false);
			leftButton.setEnabled(false);
			rightButton.setEnabled(false);
			soundCheck.setEnabled(false);
			
			accelerateButton.getDisabledStyle().setBgColor(ColorUtil.GRAY);
			brakeButton.getDisabledStyle().setBgColor(ColorUtil.GRAY);
			leftButton.getDisabledStyle().setBgColor(ColorUtil.GRAY);
			rightButton.getDisabledStyle().setBgColor(ColorUtil.GRAY);
			
			removeKeyListener('r', rightCommand);
			removeKeyListener('l', leftCommand);
			removeKeyListener('a', accelerateCommand);
			removeKeyListener('b', brakeCommand);
			removeKeyListener('n', pauseCommand);
			removeKeyListener('c', foodConsumptionCommand);
			
			toolbar.setEnabled(false);
			revalidate();
			
			
			
			
			
		}else {
			//if the pause status is false change the text to Pause and call the playBG method and send in true and the BG music plays
			// game moves because we  call the tick method and send in a time
			pauseButton.setText("Pause");
			gw.playBG( gw.getSound());
			
			//if the game is paused only the positionButton will not be available
			positionButton.setEnabled(false);

			accelerateButton.setEnabled(true);
			brakeButton.setEnabled(true);
			leftButton.setEnabled(true);
			rightButton.setEnabled(true);
			soundCheck.setEnabled(true);
			
			toolbar.setEnabled(true);

			
			
			
			
			
			addKeyListener('r', rightCommand);
			addKeyListener('l', leftCommand);
			addKeyListener('a', accelerateCommand);
			addKeyListener('b', brakeCommand);
			addKeyListener('n', pauseCommand);
			addKeyListener('c', foodConsumptionCommand);
			
			
			positionButton.getDisabledStyle().setBgColor(ColorUtil.GRAY);
			revalidate();
			
			gw.tick(20);
			
		}
			
		 
		  }
		
		
	
			
		
		
	}
	//play method commented out because no longer used.
	// play method provided for us. We had to correctly implement a command for each
	// switch case when ever the user presses the corresponding key
	/*
	 * @SuppressWarnings("unused") private void play() { Label myLabel = new
	 * Label("Enter a Command:"); this.addComponent(myLabel); final TextField
	 * myTextField = new TextField(); this.addComponent(myTextField); this.show();
	 * myTextField.addActionListener(new ActionListener() { public void
	 * actionPerformed(ActionEvent evt) { String sCommand =
	 * myTextField.getText().toString(); myTextField.clear(); if (sCommand.length()
	 * != 0) { switch (sCommand.charAt(0)) { case 'a': gw.setAntSpeed(5); break;
	 * case 'b': gw.setAntSpeed(-5); break; case 'l': gw.changeHeading('l'); break;
	 * case 'r': gw.changeHeading('r'); break; case 'c':
	 * gw.setAntFoodConsuptionRate(); break; case '1': //flag 1
	 * gw.simulateFlagCollision(1); break; case '2': //flag 2
	 * gw.simulateFlagCollision(2); break; case '3': //flag 3
	 * gw.simulateFlagCollision(3); break; case '4': //flag 4
	 * gw.simulateFlagCollision(4); break; case '5': //flag 5
	 * gw.simulateFlagCollision(5); break; case '6': //flag 6
	 * gw.simulateFlagCollision(6); break; case '7': //flag 7
	 * gw.simulateFlagCollision(7); break; case '8': //flag 8
	 * gw.simulateFlagCollision(8); break; case '9': //flag 9
	 * gw.simulateFlagCollision(9); break; case 'f':
	 * gw.simulatefoodStationCollision(); break; case 'g': gw.spiderCollision();
	 * break; case 't': gw.tick(); break; case 'd': gw.display(); break; case 'm':
	 * gw.map(); break; case 'x':
	 * myLabel.setText("Do you want to exit? Press y or n!"); gw.quitGame(); break;
	 * case 'y': gw.exit(); break; case 'n': myLabel.setText("Enter a command!");
	 * gw.dontQuit(); break;
	 * 
	 * 
	 * } } // add code to handle rest of the commands // switch } // actionPerformed
	 * } // new ActionListener() ); // addActionListener } // play}
	 */

