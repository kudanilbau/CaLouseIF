package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.controllers.LoginController;
import main.views.LoginView;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		LoginController loginController = new LoginController();
		LoginView loginView = new LoginView(loginController);
		primaryStage.setScene(new Scene(loginView.asParent(), 1280, 720));
		primaryStage.show();
	}

}
