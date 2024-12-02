package controller;

import javafx.event.ActionEvent;
import router.PageData;
import router.Router;

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
		viewController.navigateTo(PageData.LoginPage());
	}
}
