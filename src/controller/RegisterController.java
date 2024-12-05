package controller;

import javafx.event.ActionEvent;
import router.PageData;
import router.Router;

public class RegisterController {
	private Router router;
	private UserController userController;

	public RegisterController(UserController userController) {
		this.router = Router.getInstance();
		this.userController = userController;
	}
	
    /**
     * Handles the registration process by calling the {@code Register} method in 
     * {@code UserController} and then navigates to the login page.
     *
     * @param Username the username for the new user
     * @param Password the password for the new user
     * @param Phone_Number the phone number for the new user
     * @param Address the address for the new user
     * @param Role the role for the new user
     * @throws Exception if there is an issue during registration
     */
	public void handleRegister(String Username, String Password, String Phone_Number, String Address, String Role) throws Exception {
		userController.Register(Username, Password, Phone_Number, Address, Role);
		router.navigateTo(PageData.loginPage());
	}
	
    /**
     * Navigates the user to the login page when the login hyperlink is clicked.
     *
     * @param e the {@code ActionEvent} triggered by the user clicking the login hyperlink
     */
	public void handleLoginHyperLink(ActionEvent e) {
		router.navigateTo(PageData.loginPage());
	}
}
