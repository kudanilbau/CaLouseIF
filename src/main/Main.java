package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import main.controllers.LoginController;
import main.views.LoginView;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		LoginView loginView = new LoginView();
		primaryStage.setTitle("CaLouseIF");
		primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/resources/images/logo.png")));
		primaryStage.setScene(new Scene(loginView.asParent()));
		primaryStage.show();
	}

}
