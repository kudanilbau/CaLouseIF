package controller;

import javafx.event.ActionEvent;
import repository.UserRepository;
import router.PageData;
import router.Router;

public class RegisterController {
	private Router router;
	private UserRepository userRepository;

	public RegisterController(UserRepository userRepository) {
		router = Router.getInstance();
		this.userRepository = userRepository;
	}

	public void handleRegister(String username, String password, String phoneNumber, String address, String role) throws Exception {
		if (username.isEmpty() || password.isEmpty() || phoneNumber.isEmpty() || address.isEmpty() || role.isEmpty()) {
			throw new Exception("Field must be filled");
		}
		userRepository.createUser(username, password, phoneNumber, address, role);
		router.navigateTo(PageData.loginPage());
	}

	public void handleLoginHyperLink(ActionEvent e) {
		router.navigateTo(PageData.loginPage());
	}
}
