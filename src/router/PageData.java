package router;

import controller.LoginController;
import controller.RegisterController;
import controller.UserController;
import javafx.scene.Node;
import view.LoginView;
import view.RegisterView;
import view.SellerEditView;
import view.SellerUploadView;

/**
 * Provides static methods to retrieve various pages as {@code Node} objects.
 * <p>
 * This class contains methods that create and return the corresponding views
 * for different pages of the application. Each method initializes the necessary
 * controllers and views, and returns the view as a {@code Node}.
 * </p>
 */
public class PageData {

	/**
	 * Returns the login page as a {@code Node}.
	 *
	 * @return a {@code Node} representing the login page view
	 */
	public static Node loginPage() {
		LoginController controller = new LoginController(new UserController());
		return new LoginView(controller).asNode();
	}

	/**
	 * Returns the register page as a {@code Node}.
	 * 
	 * @return a {@code Node} representing the register page view
	 */
	public static Node registerPage() {
		RegisterController controller = new RegisterController(new UserController());
		return new RegisterView(controller).asNode();
	}

	/**
	 * Returns the seller upload page as a {@code Node}.
	 *
	 * @return a {@code Node} representing the seller upload page view
	 */
	public static Node sellerUploadPage() {
		return new SellerUploadView().asNode();
	}

	/**
	 * Returns the seller edit page as a {@code Node}.
	 * 
	 * @return a {@code Node} representing the seller edit page view
	 */
	public static Node sellerEditPage() {
		return new SellerEditView().asNode();
	}
}
