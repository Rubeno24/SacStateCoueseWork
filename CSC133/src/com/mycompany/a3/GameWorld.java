package com.mycompany.a3;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;

public class GameWorld extends Observable {
	// class fields
	// changed from an arraylist to a collection of GameObjects
	GameObjectCollection GameObjects = new GameObjectCollection();
	private boolean Exit = false;

	private int antSize = 40;
	private Ant ant = new Ant(antSize, 600, 100, 0, this);

	private Random rand = new Random();
	private int clock = 0;
	private int lives = 3;
	private int flagSize = 80;
	private boolean sound = false;
	private int width;
	private int height;
	private Sound foodStationCol, flagSound, spiderCollision;
	private BGSound backgroundSong;
	private boolean pause = false;
	private boolean position = false;

	/*
	 * disclaimer if my ants health is at 0 or the lives is at 0 is wont lose a life
	 * until the t command is pressed. Same if it has 0 lives it wont display the
	 * game over until the game has ticked again.also I left in print statements
	 * that are meant to help the user visualize what has changed. For example if
	 * the speed is increased it will print the increased speed to the console. All
	 * the data is still updated in the 'm' and 'd' commands. If this bothers you
	 * please let me know and I can remove it.
	 */

	// init method where all game objects are created
	public void init() {

		// Flag(size,x_location,y_location,sequence_number)
		GameObjects.add(new Flag(flagSize, 600, 100, 1, this));
		//sets a random location for the flags except the first 1
		GameObjects.add(new Flag(flagSize, getRandomXLocation(), getRandomYLocation(), 2, this));
		GameObjects.add(new Flag(flagSize, getRandomXLocation(), getRandomYLocation(), 3, this));
		GameObjects.add(new Flag(flagSize, getRandomXLocation(), getRandomYLocation(), 4, this));

		// Spider(size,x_location,y_location)
		GameObjects.add(new Spider(getRandomSpiderSize(), getRandomXLocation(), getRandomYLocation(), this));
		GameObjects.add(new Spider(getRandomSpiderSize(), getRandomXLocation(), getRandomYLocation(), this));

		// FoodStation(size,x_location,y_location)
		GameObjects.add(new FoodStation(getRandomSize(), getRandomXLocation(), getRandomYLocation(), this));
		GameObjects.add(new FoodStation(getRandomSize(), getRandomXLocation(), getRandomYLocation(), this));
		// Adds a single instance of ant to the ArrayList named GameObjects
		GameObjects.add(ant);

		callnotifyObservers();
	}

	// all sounds are made here and called in appropriate methods
	public void createSounds() {
		foodStationCol = new Sound("eating2.wav");
		backgroundSong = new BGSound("song.wav");
		flagSound = new Sound("FlagCol.wav");
		spiderCollision = new Sound("screamm.wav");

	}

	// this method is used for command 'a' and command 'b' it adjusts the speed of
	// the ant
	// by adding positive or negative values to the speed
	public void setAntSpeed(int i) {
		ant.adjustSpeed(i);
		System.out.println("Ant speed set to: " + ant.getSpeed());

	}

	// this method is used for command 'L' and command 'r' it adjusts the heading of
	// the ant
	// by adding positive or negative values to the heading
	public void changeHeading(char x) {
		ant.changeAntHeading(x);
	}

	// returns the ants heading
	public int getHeading() {
		return ant.getHeading();
	}

	// this method sets the food consumption rate of the ant to its default value of
	// 5 and is command 'c'
	public void setAntFoodConsuptionRate() {
		ant.setFoodConsumption();
		System.out.println("Food consumption set to: " + ant.getFoodConsumption());
	}

	/*
	 * public void simulateFlagCollision () { //create 2 command objects ok and
	 * cancel and we store them in an array Command cOk = new Command("Ok"); Command
	 * cCancel = new Command("Cancel"); Command[] cmds = new Command[]{cOk,
	 * cCancel}; //textfield for user input TextField myTF = new TextField();
	 * //prompts the user to enter a number between 1 and 9 Command c =
	 * Dialog.show("Enter the last Flag reached between 1-9: ",myTF,cmds); //if ok
	 * is selected we check if its a number between 9 and passes it to the
	 * ant.lastflagreached method //that method check is the flag is in the correct
	 * order. If its not it prints it to the console if(c==cOk) { try {
	 * if(Integer.parseInt(myTF.getText())>=0 ||
	 * Integer.parseInt(myTF.getText())<=9) {
	 * ant.checkFlagCollision(Integer.parseInt(myTF.getText()));
	 * System.out.println("Flag number: "+ant.getLastFlagReached()); } } //if a
	 * string in entered it will prompt the user to enter a number between 1 and 9
	 * catch(Exception e) { String message
	 * =("please enter a number between 1 and 9 ");
	 * Dialog.show("",message,"ok",null);
	 * 
	 * 
	 * }
	 * 
	 * }
	 * 
	 * callnotifyObservers(); }
	 */
	// flagCollison method call the method in the ant claass
	public void flagCollison(int flagNum) {
		ant.checkFlagCollision(flagNum);

		callnotifyObservers();
	}

	// method to play flag sound
	public void flagSound() {
		flagSound.play();
	}

	// we create an iterator named iterator that is returned from the
	// GameObjectCollection
	// we keeping looping until iterator.hasNext = false
	// we than create a temp variable of type GameObjects and we check if its an
	// instance of foodStation
	public void simulatefoodStationCollision() {
		IIterator iterator = GameObjects.getIterator();
		while (iterator.hasNext()) {
			GameObject temp = (GameObject) iterator.getNext();
			if (temp instanceof FoodStation) {
				if (((FoodStation) temp).getCapacity() != 0) {
					ant.addTofoodLevel(((FoodStation) temp).getCapacity());
					((FoodStation) temp).setCapacitytoZero();
					// sets color to light green
					temp.setColor(ColorUtil.rgb(144, 238, 144));
					break;
				}
			}
		}
		// adds a new foodStation with a random size and location
		GameObjects.add(new FoodStation(getRandomSize(), getRandomXLocation(), getRandomYLocation(), this));
		System.out.println("Food Station Consumed");
		System.out.println("Ant food level: " + ant.getFoodLevel());
		System.out.println("Ant speed level: " + ant.getSpeed());

		callnotifyObservers();
	}

	// this method is for command 'g' and calls a method in the ant class that
	// simulates a collision with an ant
	public void spiderCollision() {
		ant.simulateSpiderCollison();
		callnotifyObservers();

	}

	// method to play flag sound
	public void SpiderSound() {
		if (sound == true) {
			spiderCollision.play();
		} else {

		}
	}

	/*
	 * this method is for the command 't' it means that the clock has ticked. Which
	 * means spiders update their heading(1), all moveable objects update their
	 * positions according to their and speed(2) in this case its only spider and
	 * the ant, the ants foodLevel is reduced(3), the gameclock is incremented by
	 * 1(4),
	 */
	// we create an iterator named iterator that is returned from the
	// GameObjectCollection
	// we keeping looping until iterator.hasNext = false
	// we than create a temp variable of type GameObjects and we check if its an
	// instance of Moveable, Spider and Ant
	public void tick(int time) {

		logic();
		incrementgameClock();// (4)
		ant.conusumeFood();// (3)
		IIterator iterator = GameObjects.getIterator();
		while (iterator.hasNext()) {
			GameObject temp = (GameObject) iterator.getNext();
			if (temp instanceof Moveable) {
				if (temp instanceof Spider) {
					((Spider) temp).setHeading(((Spider) temp).getRandomHeading());// (1)
					((Spider) temp).moveSpider(time, this);
				} else
					((Ant) temp).moveAnt(time, this); // (2)
			}

		}
		//this method handles all object collisions
		handleCollsions();

		callnotifyObservers();
	}
	/*
	 *create an iteraator to iterate through game objects storewe than create a
	 * temp variable of type GameObjects and we check if its an instance of Ant
	 * creaate another iterator and another temp object of type game objects then
	 * we check if temp and temp2 collide if so we call the handle collsions method
	 */
	public void handleCollsions() {
		IIterator iterator1 = GameObjects.getIterator();
		while (iterator1.hasNext()) {
			GameObject temp = (GameObject) iterator1.getNext();
			if (temp instanceof Ant) {
				IIterator iterator2 = GameObjects.getIterator();
				while (iterator2.hasNext()) {
					GameObject temp2 = (GameObject) iterator2.getNext();
					if ((temp != temp2) && (temp.collidesWith(temp2))) {
						temp.handleCollision(temp2);
					}
					// Otherwise the objects are not colliding so we can make sure that they are not
					// in the collision list
					else {
						temp.removeObject(temp2);

					}

				}

			}

		}

	}

	// logic helper method is called when the game ticks and checks to see if the
	// spider
	// needs to have a life removed
	public void logic() {
		// if health =0 we subtract a life and reset the ant
		if (ant.getHealthLevel() == 0) {
			lives = lives - 1;
			ant.reset();

		}
		// if foodLevel =0 we subtract a life and reset the ant
		if (ant.getFoodLevel() <= 0) {
			lives = lives - 1;
			ant.reset();

		}
		// prompts the user if they want to restart after their lives =0
		Dialog about = new Dialog("About", new BoxLayout(BoxLayout.Y_AXIS));
		Command yes = new Command("Yes");
		Command no = new Command("No");
		Label label = new Label("Do you want to restart?");

		// once lives =0 we print Game over, you failed! and show how many times the
		// clock has ticked
		if (lives <= 0) {
			System.out.println("Game over, you failed! Total Time: " + clock);
			Command decsion = Dialog.show("Game over, you failed! Total Time: " + clock, label, yes, no);
			// if the user selects yes the game restarts as new but if they select no the
			// game will close
			if (decsion == yes) {
				ant.reset();
				lives = 3;
				this.resetClock();
			} else if (decsion == no) {
				System.exit(0);

			}
		}
		// this happens when the player has reached all 9 flags consecutively
		// we print Game over, you win! and the amount of times the clock has ticked
		if (ant.getLastFlagReached() == 4) {
			System.out.println("Game over, you win! Total time: " + clock);
			Command decsion = Dialog.show("Game over, you win! Total time: " + clock, label, yes, no);
			// if the user selects yes the game restarts as new but if they select no the
			// game will close
			if (decsion == yes) {
				ant.reset();
				lives = 3;
				this.resetClock();
			} else if (decsion == no) {
				System.exit(0);

			}

		}
	}

	// this method is for the 'd' command and it displays the lives, flag, food and
	// health
	// level of the ant and the clock.
	public void display() {
		System.out.println("Remaining Ant Lives: " + lives);
		System.out.println("Clock value: " + clock);
		System.out.println("Higest Flag Reached: " + ant.getLastFlagReached());
		System.out.println("Ant Food Level: " + ant.getFoodLevel());
		System.out.println("Ant Health level: " + ant.getHealthLevel());

	}

	// this method is used for the 'm' command and prints the x and y location
	// of the game objects and the color,size and other object specific information
	public void map() {
		IIterator iterator = GameObjects.getIterator();
		while (iterator.hasNext()) {
			GameObject temp = (GameObject) iterator.getNext();

			System.out.println(temp.toString());
		}
	}

	// this method is used for the 'x' command it quies the game if the boolean exit
	// is true
	public void exit() {
		if (Exit)
			System.exit(0);
	}

	// asks the user to enter 'y or Y' exit boolean is true and game is quit
	public void quitGame() {
		System.out.println("Do you want to exit? Press y or n!");
		Exit = true;
	}

	// if user enters 'n or N' the game continues
	public void dontQuit() {
		Exit = false;
		System.out.println("Enter a command");
	}

	// random helper methods
	// returns a random x location between 20 and 1000
	public int getRandomXLocation() {
		return rand.nextInt(1200 - 20) + 20;
	}

	// returns a random y location between 20 and 1000
	public int getRandomYLocation() {
		return rand.nextInt(1200 - 20) + 20;
	}

	// returns a random number between 10 and 20 and used for the size variable of
	// objects
	int getRandomSize() {
		return rand.nextInt((40 - 25) + 1) + 25;
	}

	int getRandomSpiderSize() {
		return rand.nextInt(125 - 100 + 1) + 100;
	}

	// clock helper methods
	// increments the clock by 1
	public void incrementgameClock() {
		clock += 1;
	}

	// resets the clock
	public void resetClock() {
		clock = 0;
	}

	// returns the current value of the clock
	public int getClock() {
		return clock;
	}

	// returns the value of the last flag reached
	public int getLastFlagReached() {
		return ant.getLastFlagReached();
	}

	// returns the health of the ant
	public int getHelthLevel() {
		return ant.getHealthLevel();
	}

	// calls the set changed and notifyObservers methods
	private void callnotifyObservers() {
		setChanged();
		this.notifyObservers();

	}

	// changes the status of the sound if sound is true we play BG music if not dont play it
	public void toggleSound() {
		sound = !sound;

		if (sound == true) {

			backgroundSong.play();

		}
		if (sound == false) {
			backgroundSong.pause();
		}
		callnotifyObservers();
	}

	// returns the status of the sound, if its on or off
	public String getSoundStatus() {
		if (sound == true) {
			return "ON";
		} else {
			return "OFF";
		}
	}

	// returns food level
	public int getFoodLevel() {
		return ant.getFoodLevel();
	}

	// returns the amount of lives
	public int getLives() {
		return lives;
	}

	// sets the width to the width variable
	public void setMapWidth(int width) {
		this.width = width;
	}

	// sets the height to the height variable
	public void setMapHeight(int height) {
		this.height = height;
	}

	// returns the width
	public int getMapWidth() {
		return width;
	}

	// returns the height
	public int getMapHeight() {
		return height;
	}

	//returns GameObjcts
	public GameObjectCollection getGameObjectList() {
		return GameObjects;

	}

	//returns sound boolean
	public boolean getSound() {
		return sound;
	}

	//method to simulate a food station collision
	public void foodStationCollision(GameObject otherObject) {

		//if food station capacity not 0 then the capacity is added to ant food level and we set foodstation back to 0
		if (((FoodStation) otherObject).getCapacity() != 0) {
			ant.antAddFood(((FoodStation) otherObject).getCapacity());
			((FoodStation) otherObject).setCapacitytoZero();
			otherObject.setColor(ColorUtil.rgb(0, 255, 191));

		}
		//we then create a new foodstation
		GameObjects.add(new FoodStation(getRandomSize(), getRandomXLocation(), getRandomYLocation(), this));

		callnotifyObservers();
		//if sound is on we play the foodstation sound
		if (sound == true) {
			foodStationCol.play();
		} else {

		}

	}

	//returns the bg song
	public BGSound getBGSound() {
		return backgroundSong;
	}
	//returns the pause booelan
	public boolean getPauseStatus() {
		return pause;
	}
	//allows us to set pause boolean to true or false
	public void setPauseStatus(boolean pause) {
		this.pause = pause;

	}
	//allows us to set position boolean to true or false
	public void setPositionStatus(boolean position) {
		this.position = position;

	}
	//changes position boolean to true or false
	public void altPosition() {
		if (position == true) {

			position = false;
		} else {
			position = true;
		}
	}
	//returns position
	public boolean getPosition() {
		return position;
	}
	//pause background song 
	public void pauseBG() {
		backgroundSong.pause();
	}
	//plays bg song if x is true
	public void playBG(boolean x) {
		if (x) {
			backgroundSong.play();
		} else {

		}
	}

}
