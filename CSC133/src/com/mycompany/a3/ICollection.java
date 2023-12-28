package com.mycompany.a3;
//interface that GameObjectCollection will implement
public interface ICollection {	
	//method for adding a an object to the collection
	public void add(Object newObject);
	//method for obtaining an iterator
	public IIterator getIterator();
}
