package main;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import router.PageData;
import router.Router;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// set title and icon
		primaryStage.setTitle("CaLouseIF");
		primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/resources/images/logo.png")));

		// initialize stage in view controller
		Router.initInstance(primaryStage);
				
		// launch login at start
		Router.getInstance().navigateTo(PageData.loginPage());
	}
}