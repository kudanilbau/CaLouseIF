package main.controllers;

public class LoginController {
	
	private static LoginController controller;
	
	private LoginController() {
		
	}
	
	public static LoginController getInstance() {
		if(controller == null) {
			controller = new LoginController();
		}
		return controller;
	}
	
	public void handleLogin(String username, String password) {
		System.out.println(username + " " + password);
	}
}
