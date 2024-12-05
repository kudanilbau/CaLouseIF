package router;

import java.util.Stack;

import javafx.scene.Node;
import javafx.stage.Stage;
import view.AppView;

public class Router {
	private static Router instance = null;

	private Stage stage;
	private AppView appView;
	private Stack<Node> viewStack;

	private Router(Stage stage) {
		this.stage = stage;
		appView = new AppView(stage);
		viewStack = new Stack<>();
	}

	/**
	 * Initializes the {@code Router} instance with the specified stage.
	 *
	 * @param stage the primary stage to be used by the router
	 */
	public static void initInstance(Stage stage) {
		instance = new Router(stage);
	}

	/**
	 * Returns the current {@code Router} instance.
	 *
	 * @return the current {@code Router} instance, or {@code null} if not
	 *         initialized
	 */
	public static Router getInstance() {
		if (instance == null) {
			System.err.println("Stage is not initialized");
		}
		return instance;
	}

	/**
	 * Navigates to the specified {@code Node} and sets the stage title.
	 * 
	 * @param node  the {@code Node} to display as the center content
	 * @param title the title to set for the stage
	 */
	public void navigateTo(Node node, String title) {
		Node centerNode = appView.getContainer().getCenter();
		if (centerNode != null) {
			viewStack.add(centerNode);
		}
		appView.getContainer().setCenter(node);
		stage.setTitle(title);
	}

	/**
	 * Navigates to the specified {@code Node} while keeping the current stage
	 * title.
	 * 
	 * @param node the {@code Node} to display as the center content
	 */
	public void navigateTo(Node node) {
		navigateTo(node, stage.getTitle());
	}

	/**
	 * Navigates back to the previous view.
	 */
	public void back() {
		if (viewStack.empty()) {
			return;
		}
		Node lastCenterNode = viewStack.pop();
		appView.getContainer().setCenter(lastCenterNode);
	}
}
