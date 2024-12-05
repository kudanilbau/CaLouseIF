package controller;

import javafx.event.ActionEvent;
import model.User;
import router.PageData;
import router.Router;
import session.UserSession;

public class LoginController {
	private Router router;
	private UserController userController;

	public LoginController(UserController userController) {
		router = Router.getInstance();
		this.userController = userController;
	}
	
    /**
     * Handles the login process by calling the {@code Login} method in the 
     * {@code UserController}.
     * <p>
     * This method attempts to log in the user using the provided credentials. If the 
     * credentials are valid, the user is logged in. Otherwise, an exception is thrown.
     * </p>
     *
     * @param username the username of the user attempting to log in
     * @param password the password of the user attempting to log in
     * @throws Exception if the login credentials are incorrect or an error occurs during login
     */
	public void handleLogin(String username, String password) throws Exception {
		User user = userController.Login(username, password);
		UserSession.initInstance(user);
		
	}

    /**
     * Navigates the user to the registration page when the "Create Account" hyperlink is clicked.
     *
     * @param e the {@code ActionEvent} triggered by the user clicking the create account hyperlink
     */
	public void handleCreateAccountHyperLink(ActionEvent e) {
		router.navigateTo(PageData.registerPage());
	}
}
