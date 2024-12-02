package main.controllers;

import javafx.event.ActionEvent;
import main.views.LoginView;

public class RegisterController {

	private static RegisterController controller;
	private ViewController viewController;

	private RegisterController() {
		viewController = ViewController.getInstance();
	}

	public static RegisterController getInstance() {
		if (controller == null) {
			controller = new RegisterController();
		}
		return controller;
	}

	public void handleRegister(String username, String password, String phoneNumber, String address) {
		System.out.println(username + " " + password + " " + phoneNumber + " " + address);
	}

	public void handleLoginHyperLink(ActionEvent e) {
		LoginView loginView = new LoginView();
		viewController.navigateTo(loginView.asNode());
	}
}
