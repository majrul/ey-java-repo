package com.ey.training.oop.interfaces;

public class Launcher {

	private TaskManager taskManager;
	
	public Launcher(TaskManager taskManager) {
		this.taskManager = taskManager;
	}

	public void launch(MobileApp mobileApp) {
		mobileApp.start();
		taskManager.appLoaded(mobileApp);
		//mobileApp.pause();
		//mobileApp.stop();
	}
}
