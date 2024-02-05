package com.mycompany.a3;

//interface with 2 methods that gameobject will implement
public interface ICollider {
	boolean collidesWith(GameObject otherObject);
	void handleCollision(GameObject otherObject);

}
