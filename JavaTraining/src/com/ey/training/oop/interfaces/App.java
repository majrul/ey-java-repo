package com.ey.training.oop.interfaces;

public class App {

	public static void main(String[] args) {
		MobileApp app1 = new CarRacingGame();
		MobileApp app2 = new BankingApp();
		
		TaskManager taskManager = new TaskManager();
		
		Launcher launcher = new Launcher(taskManager);
		launcher.launch(app1);
		launcher.launch(app2);
		
		taskManager.closeAllApps();
		
	}
}
