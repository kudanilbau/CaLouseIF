package main.controllers;

public class RegisterController {
	
	private static RegisterController controller;
	
	private RegisterController() {
		
	}
	
	public static RegisterController getInstance() {
		if(controller == null) {
			controller = new RegisterController();
		}
		return controller;
	}
	
	public void handleRegister(String username, String password, String phoneNumber, String address) {
		System.out.println(username + " " + password + " " + phoneNumber + " " + address);
	}
}
