package view;

import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.HBox;
import router.PageData;
import router.Router;

public class BuyerNavbar extends HBox {

	private Button homepageButton, wishlistButton, purchaseHistoryButton;
	private Router router;

	public BuyerNavbar() {
		super();
		initComponent();
		addComponent();
		styleComponent();
		setActionComponent();
		router = Router.getInstance();
	}

	private void initComponent() {
		homepageButton = new Button("Homepage");
		wishlistButton = new Button("Wishlist");
		purchaseHistoryButton = new Button("Purchase History");
	}

	private void addComponent() {
		this.getChildren().addAll(homepageButton, wishlistButton, purchaseHistoryButton);
	}

	private void styleComponent() {
		this.setSpacing(15);
	}

	private void setActionComponent() {
		wishlistButton.setOnMouseClicked(e -> {
			if (e.getButton() == MouseButton.PRIMARY) {
				router.navigateTo(PageData.buyerWishlistPage());
			}
		});

		purchaseHistoryButton.setOnMouseClicked(e -> {
			if (e.getButton() == MouseButton.PRIMARY) {
				router.navigateTo(PageData.loginPage());
			}
		});

		homepageButton.setOnMouseClicked(e -> {
			if (e.getButton() == MouseButton.PRIMARY) {
				router.navigateTo(PageData.buyerHomePage());
			}
		});
	}

}
