package com.mycompany.a3;
//interface that GameObjectCollection will implement
public interface IIterator {
	//method to check if collection has next element
	public boolean hasNext();
	//method that returns the next element
	public Object getNext();
}
