package router;

import controller.BuyerHomepageController;
import controller.BuyerItemDetailsController;
import controller.ItemController;
import controller.LoginController;
import controller.RegisterController;
import controller.UserController;
import javafx.scene.Node;
import javafx.scene.Parent;
import model.Item;
import view.AdminDashboardView;
import view.BuyerHomepageView;
import view.BuyerItemDetailsView;
import view.BuyerNavbar;
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
		return new LoginView(controller);
	}

	/**
	 * Returns the register page as a {@code Node}.
	 * 
	 * @return a {@code Node} representing the register page view
	 */
	public static Node registerPage() {
		RegisterController controller = new RegisterController(new UserController());
		return new RegisterView(controller);
	}

	/**
	 * Returns the seller upload page as a {@code Node}.
	 *
	 * @return a {@code Node} representing the seller upload page view
	 */
	public static Node sellerUploadPage() {
		return new SellerUploadView();
	}

	/**
	 * Returns the seller edit page as a {@code Node}.
	 * 
	 * @return a {@code Node} representing the seller edit page view
	 */
	public static Node sellerEditPage() {
		return new SellerEditView();
	}

	/**
	 * Returns the {@code Node} for the admin dashboard page.
	 *
	 * @return the {@code Node} representing the admin dashboard page
	 */
	public static Node adminDashboardPage() {
		return new AdminDashboardView();
	}

	/**
	 * Returns the {@code Node} for the buyer's homepage.
	 *
	 * @return the {@code Node} representing the buyer's homepage
	 */
	public static Node buyerHomePage() {
		return new BuyerHomepageView(new BuyerHomepageController(new ItemController()));
	}

	/**
	 * Returns the {@code Node} for the item details page for a buyer.
	 *
	 * @return the {@code Node} representing the buyer's item details page
	 */
	public static Node buyerItemDetailsPage(Item item) {
		return new BuyerItemDetailsView(new BuyerItemDetailsController(new ItemController()), item);
	}

	public static Parent buyerNavbar() {
		return new BuyerNavbar();
	}
}
