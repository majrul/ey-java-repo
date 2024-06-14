package com.ey.training.oop.interfaces;

/*public interface MobileApp {

	void start();
	void pause();
	void stop();
}*/

//Suppose Google wants to make pause method
//optional for developers to implement
//we can use Java 8's default method in the interface
public interface MobileApp {

	void start();
	void stop();

	default void pause() {
		
	}
}
