package router;

import java.lang.reflect.Parameter;
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
	 * Create {@link Router} instance
	 * 
	 * @param stage
	 */
	public static void initInstance(Stage stage) {
		instance = new Router(stage);
	}

	/**
	 * Get {@link Router} instance
	 * 
	 * @return ViewController singleton instance
	 */

	public static Router getInstance() {
		if (instance == null) {
			System.err.println("Stage is not initialized");
		}
		return instance;
	}

	/**
	 * Change center node to the node provided in {@link Parameter} node and the
	 * title of the stage
	 * 
	 * @param node  Center node
	 * @param title Sets the value of the property title in stage.
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
	 * Change center node to the node provided in {@link Parameter} node
	 * 
	 * @param node Center node
	 */
	public void navigateTo(Node node) {
		navigateTo(node, stage.getTitle());
	}

	/**
	 * Set the center node to the last center node
	 */
	public void back() {
		if (viewStack.empty()) {
			return;
		}
		Node lastCenterNode = viewStack.pop();
		appView.getContainer().setCenter(lastCenterNode);
	}
}
