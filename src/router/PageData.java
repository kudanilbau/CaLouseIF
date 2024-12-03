package router;

import controller.LoginController;
import controller.RegisterController;
import javafx.scene.Node;
import view.LoginView;
import view.RegisterView;
import view.SellerEditView;
import view.SellerUploadView;

public class PageData {
	public static Node loginPage() {
		LoginController controller = new LoginController();
		return new LoginView(controller).asNode();
	}

	public static Node registerPage() {
		RegisterController controller = new RegisterController();
		return new RegisterView(controller).asNode();
	}
	
	public static Node sellerUploadPage() {
		return new SellerUploadView().asNode();
	}
	
	public static Node sellerEditPage() {
		return new SellerEditView().asNode();
	}
}
