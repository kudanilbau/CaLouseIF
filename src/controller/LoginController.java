package controller;

import javafx.event.ActionEvent;
import router.PageData;
import router.Router;

public class LoginController {
	private Router router;

	public LoginController() {
		router = Router.getInstance();
	}

	public void handleLogin(String username, String password) {
		System.out.println(username + " " + password);
	}

	public void handleCreateAccountHyperLink(ActionEvent e) {
		router.navigateTo(PageData.RegisterPage());
	}
}
