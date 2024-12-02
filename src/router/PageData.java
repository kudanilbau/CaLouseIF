package router;

import javafx.scene.Node;
import view.LoginView;
import view.RegisterView;

public class PageData {
	public static Node LoginPage() {
		return new LoginView().asNode();
	}

	public static Node RegisterPage() {
		return new RegisterView().asNode();
	}
}
