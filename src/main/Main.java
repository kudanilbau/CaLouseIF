package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import main.views.LoginView;
import main.views.RegisterView;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		LoginView loginView = new LoginView();
		RegisterView registerView = new RegisterView();
		primaryStage.setTitle("CaLouseIF");
		primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/resources/images/logo.png")));
//		primaryStage.setScene(new Scene(loginView.asParent()));
		primaryStage.setScene(new Scene(registerView.asParent()));
		primaryStage.show();
	}

}
