package com.ey.training.oop.interfaces;

public class TaskManager {

	private MobileApp[] runningApps = new MobileApp[100];
	private int index;
	
	public void appLoaded(MobileApp mobileApp) {
		runningApps[index++] = mobileApp;
	}
	
	public void closeAllApps() {
		for(int i=0; i<index; i++)
			runningApps[i].stop();
	}
}
