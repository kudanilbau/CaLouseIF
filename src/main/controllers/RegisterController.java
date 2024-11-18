package main.controllers;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.views.LoginView;

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

	public void handleLoginHyperLink(ActionEvent e) {
		Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		LoginView lv = new LoginView();
		stage.setScene(new Scene(lv.asParent()));
		stage.show();
		
	}
}
