package view;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import router.PageData;
import router.Router;
import session.UserSession;

public class AppNavbar extends HBox {
	private Router router;
	private HBox customComponentContainer;

	public AppNavbar() {
		super();
		this.router = Router.getInstance();
		defaultComponent();
	}

	/**
	 * Sets up the default components of the navigation bar.
	 * <p>
	 * This method adds a back button and a logout button to the navigation bar. The
	 * back button navigates to the previous page, and the logout button redirects
	 * the user to the login page when clicked.
	 * </p>
	 */
	private void defaultComponent() {
		HBox defaultComponentContainer = new HBox(15);
		customComponentContainer = new HBox(15);

		Button backButton = new Button("Back");
		Button logoutButton = new Button("Logout");

		defaultComponentContainer.getChildren().addAll(backButton, logoutButton);
		this.getChildren().addAll(customComponentContainer, defaultComponentContainer);

		this.setPadding(new Insets(5, 10, 5, 10));
		HBox.setHgrow(customComponentContainer, Priority.ALWAYS);

		backButton.setOnMouseClicked(e -> {
			if (e.getButton() == MouseButton.PRIMARY) {
				router.back();
			}
		});

		logoutButton.setOnMouseClicked(e -> {
			if (e.getButton() == MouseButton.PRIMARY) {
				UserSession.getInstance().logout();
				router.navigateTo(PageData.loginPage());
			}
		});
		
//		((HBox)(this.getChildren().get(0))).getChildren().clear();
	}

	/**
	 * Inserts a custom component at the beginning of the navigation bar.
	 * <p>
	 * This method allows additional UI elements (such as a logo or custom buttons)
	 * to be inserted into the navigation bar. The component is added at the start
	 * of the layout.
	 * </p>
	 *
	 * @param node the {@code Node} to insert into the navigation bar
	 */
	public void insertComponent(Node node) {
		customComponentContainer.getChildren().add(0, node);
	}
	
	public void clearComponent() {
		customComponentContainer.getChildren().clear();
	}
}
