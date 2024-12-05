package view;

import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import router.Router;

public class AppView extends BorderPane {
	private Scene scene;
	
	public BorderPane getContainer() {
		return this;
	}

	private void setSceneAction() {
		scene.setOnMouseClicked(e -> {
			if (e.getButton() == MouseButton.BACK) {
				Router.getInstance().back();
			}
		});
	}
	
	public AppView(Stage stage) {
		super();
		scene = new Scene(this, 1280, 720);
		setSceneAction();

		stage.setScene(scene);
		stage.show();
	}
}
