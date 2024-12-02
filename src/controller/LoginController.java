package main.controllers;

import javafx.event.ActionEvent;
import main.views.RegisterView;

public class LoginController {

	private static LoginController controller;
	private ViewController viewController;

	private LoginController() {
		viewController = ViewController.getInstance();
	}

	public static LoginController getInstance() {
		if (controller == null) {
			controller = new LoginController();
		}
		return controller;
	}

	public void handleLogin(String username, String password) {
		System.out.println(username + " " + password);
	}

	public void handleCreateAccountHyperLink(ActionEvent e) {
		RegisterView registerView = new RegisterView();
		viewController.navigateTo(registerView.asNode());
	}
}
