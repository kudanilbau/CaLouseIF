package main.views;

import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import main.controllers.ViewController;

public class AppView {
	private BorderPane container;
	private Scene scene;

	public BorderPane getContainer() {
		return container;
	}

	private void init() {
		container = new BorderPane();
	}

	private void setLayout() {
//		container.setTop(container);
	}

	private void setSceneAction() {
		scene.setOnMouseClicked(e -> {
			if (e.getButton() == MouseButton.BACK) {
				ViewController.getInstance().back();
			}
		});
	}

	public AppView(Stage stage) {
		init();
		setLayout();

		scene = new Scene(container, 1280, 720);
		setSceneAction();

		stage.setScene(scene);
		stage.show();
	}
}
