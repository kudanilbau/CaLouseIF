package router;

import controller.LoginController;
import controller.RegisterController;
import javafx.scene.Node;
import view.LoginView;
import view.RegisterView;

public class PageData {
	public static Node LoginPage() {
		LoginController controller = new LoginController();
		return new LoginView(controller).asNode();
	}

	public static Node RegisterPage() {
		RegisterController controller = new RegisterController();
		return new RegisterView(controller).asNode();
	}
}
