package controller;

import javafx.event.ActionEvent;
import model.User;
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

	public boolean handleLogin(String username, String password) {
		User user = userRepository.getUserByUsernameAndPassword(username, password);
		if(user == null) {
			return false;		
		}
		return true;
	}

	public void handleCreateAccountHyperLink(ActionEvent e) {
		router.navigateTo(PageData.registerPage());
	}
}
