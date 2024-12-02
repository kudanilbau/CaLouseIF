package controller;

import javafx.event.ActionEvent;
import router.PageData;
import router.Router;

public class LoginController {

	private static LoginController controller;
	private Router router;

	private LoginController() {
		router = Router.getInstance();
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
		router.navigateTo(PageData.RegisterPage());
	}
}
