package main.controllers;

import java.lang.reflect.Parameter;
import java.util.Stack;

import javafx.scene.Node;
import javafx.stage.Stage;
import main.views.AppView;

public class ViewController {
	private static ViewController instance = null;

	private Stage stage;
	private AppView appView;
	private Stack<Node> viewStack;

	private ViewController(Stage stage) {
		this.stage = stage;
		appView = new AppView(stage);
		viewStack = new Stack<>();
	}

	/**
	 * Create {@link ViewController} instance
	 * 
	 * @param stage
	 * @return ViewController singleton instance
	 */
	public static ViewController getInstance(Stage stage) {
		if (instance == null) {
			instance = new ViewController(stage);
		}
		return instance;
	}

	/**
	 * Get {@link ViewController} instance
	 * 
	 * @return ViewController singleton instance
	 */

	public static ViewController getInstance() {
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
