package main.controllers;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.views.RegisterView;

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
	
	public void handleCreateAccountHyperLink(ActionEvent e) {
		Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		RegisterView rv = new RegisterView();
		stage.setScene(new Scene(rv.asParent()));
		stage.show();
	}
}
