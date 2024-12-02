package controller;

import javafx.event.ActionEvent;
import router.Router;
import view.LoginView;

public class RegisterController {

	private static RegisterController controller;
	private Router viewController;

	private RegisterController() {
		viewController = Router.getInstance();
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
