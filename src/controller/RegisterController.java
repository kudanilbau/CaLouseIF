package controller;

import javafx.event.ActionEvent;
import router.PageData;
import router.Router;

public class RegisterController {
	private Router router;

	public RegisterController() {
		router = Router.getInstance();
	}

	public void handleRegister(String username, String password, String phoneNumber, String address) {
		System.out.println(username + " " + password + " " + phoneNumber + " " + address);
	}

	public void handleLoginHyperLink(ActionEvent e) {
		router.navigateTo(PageData.LoginPage());
	}
}
