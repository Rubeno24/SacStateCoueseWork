package com.mycompany.a3;
import java.util.ArrayList;
//this class satisfies the Iterator requirement
public class GameObjectCollection implements  ICollection {
	//class fields
	//defined an arrayList of type GameObject
	private ArrayList<GameObject> GameObjects = new ArrayList<GameObject>();
	
	
	@Override
	//adds an object to our arraylist
	public void add(Object newObject) {
		//adds a object to our game GameObjects list but first we have to cast 
		//it to a type of GameObject
		GameObjects.add((GameObject)newObject);
		
	}

	@Override
	public IIterator getIterator() {
		//returns a new instance of the iterator class
		return new Iterator();
	}
	
	//Iterator is a private inner class inside GameObjectCollection
	private class Iterator implements IIterator{
		//index variable that will be used to keep track of what element we are at in the arraylist
		private int index=0;

		@Override
		public boolean hasNext() {
			//returns false since list is empty
			if(GameObjects.size()<=0) {
				return false;
			}
			//returns false since index is at the end of the list
			if(index==GameObjects.size()) {
				return false;
			}
			//returns true if conditions above are not met
			return true;
		}

		@Override
		public Object getNext() {
			//increment index by 1 since we are getting an element
			index+=1;
			//returns the element at the GameObjects at index-1 since we incremented index
			return GameObjects.get(index-1);
		}
	}
}