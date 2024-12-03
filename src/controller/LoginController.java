package controller;

import javafx.event.ActionEvent;
import repository.UserRepository;
import router.PageData;
import router.Router;

public class LoginController {
	private Router router;
	private UserRepository userRepository;

	public LoginController(UserRepository userRepository) {
		router = Router.getInstance();
		this.userRepository = userRepository;
	}

	public void handleLogin(String username, String password) throws Exception {
		userRepository.getUserByUsernameAndPassword(username, password);
		
	}

	public void handleCreateAccountHyperLink(ActionEvent e) {
		router.navigateTo(PageData.registerPage());
	}
}
