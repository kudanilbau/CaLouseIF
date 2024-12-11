package view;

import controller.BuyerItemDetailsController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Popup;
import model.Item;

public class BuyerItemDetailsView extends VBox {
	private GridPane itemDetailGridPane, actionGridPane;
	private VBox confirmationVBox;
	private HBox confirmationActionHBox;
	private TextField offerInputTextField;
	private Label nameLabel, categoryLabel, sizeLabel, priceLabel, offerLabel;
	private Label nameDetailLabel, categoryDetailLabel, sizeDetailLabel, priceDetailLabel, offerDetailLabel;
	private Label offerMessageLabel, purchaseMessageLabel, addToWishlistMessageLabel, confirmTitleLabel,
			confirmDescriptionLabel;
	private Button addToWishlistButton, purchaseButton, offerButton, confirmButton, cancelButton;
	private Popup confirmationPopup;

	private BuyerItemDetailsController buyerItemDetailsController;
	private Item item;

	public BuyerItemDetailsView(BuyerItemDetailsController buyerItemDetailsController, Item item) {
		super();
		this.item = item;
		this.buyerItemDetailsController = buyerItemDetailsController;
		initComponents();
		addComponents();
		styleComponents();
		setActionNode();
	}

	private void initComponents() {
		itemDetailGridPane = new GridPane();
		actionGridPane = new GridPane();

		confirmationVBox = new VBox(20);
		confirmationActionHBox = new HBox(20);

		nameLabel = new Label("Item Name: ");
		categoryLabel = new Label("Category: ");
		sizeLabel = new Label("Size: ");
		priceLabel = new Label("Price: ");
		offerLabel = new Label("Current Offer: ");

		offerMessageLabel = new Label();
		purchaseMessageLabel = new Label();
		addToWishlistMessageLabel = new Label();
		confirmTitleLabel = new Label("Purchase Item?");
		confirmDescriptionLabel = new Label(
				String.format("Do you want to buy %s for %s", item.getItem_name(), item.getItem_price()));

		nameDetailLabel = new Label(item.getItem_name());
		categoryDetailLabel = new Label(item.getItem_category());
		sizeDetailLabel = new Label(item.getItem_size());
		priceDetailLabel = new Label(item.getItem_price());
		offerDetailLabel = new Label(itemOfferPrice());

		addToWishlistButton = new Button("Add to Wishlist");
		purchaseButton = new Button("Purchase");
		offerButton = new Button("Make Offer");
		confirmButton = new Button("Confirm");
		cancelButton = new Button("Cancel");

		offerInputTextField = new TextField();

		confirmationPopup = new Popup();
	}

	private void addComponents() {
		itemDetailGridPane.add(nameLabel, 0, 0);
		itemDetailGridPane.add(categoryLabel, 0, 1);
		itemDetailGridPane.add(sizeLabel, 0, 2);
		itemDetailGridPane.add(priceLabel, 0, 3);
		itemDetailGridPane.add(offerLabel, 0, 4);

		itemDetailGridPane.add(nameDetailLabel, 1, 0);
		itemDetailGridPane.add(categoryDetailLabel, 1, 1);
		itemDetailGridPane.add(sizeDetailLabel, 1, 2);
		itemDetailGridPane.add(priceDetailLabel, 1, 3);
		itemDetailGridPane.add(offerDetailLabel, 1, 4);

		actionGridPane.add(addToWishlistButton, 0, 0);
		actionGridPane.add(purchaseButton, 0, 1);
		actionGridPane.add(offerButton, 0, 2);
		actionGridPane.add(addToWishlistMessageLabel, 1, 0);
		actionGridPane.add(purchaseMessageLabel, 1, 1);
		actionGridPane.add(offerInputTextField, 1, 2);
		actionGridPane.add(offerMessageLabel, 2, 2);

		confirmationVBox.getChildren().addAll(confirmTitleLabel, confirmDescriptionLabel, confirmationActionHBox);

		confirmationActionHBox.getChildren().addAll(confirmButton, cancelButton);

		confirmationPopup.getContent().add(confirmationVBox);

		this.getChildren().addAll(itemDetailGridPane, actionGridPane);
	}

	private void styleComponents() {
		this.setAlignment(Pos.CENTER_LEFT);
		this.setPadding(new Insets(20));
		this.setSpacing(10);

		itemDetailGridPane.setHgap(10);
		itemDetailGridPane.setVgap(10);

		actionGridPane.setHgap(10);
		actionGridPane.setVgap(10);

//		Set padding to 30, background color to white, set border to black, and add drop shadow
		confirmationVBox.setStyle("-fx-padding: 30;" + "-fx-background-color: white;" + "-fx-border-color: black;"
				+ "-fx-border-width: 1;" + "-fx-alignment: center;"
				+ "-fx-effect: dropshadow(gaussian, gray, 10, 0.5, 5, 5);");

		confirmationActionHBox.setAlignment(Pos.CENTER);
		confirmButton.setStyle("-fx-background-color: green;" + "-fx-text-fill: white;" + "-fx-background-radius: 10px;"
				+ "-fx-padding: 10 20 10 20");
		cancelButton.setStyle("-fx-background-color: red;" + "-fx-text-fill: white;" + "-fx-background-radius: 10px;"
				+ "-fx-padding: 10 20 10 20");

		offerInputTextField.setPromptText("offer price");
	}

	private void setActionNode() {
		purchaseButton.setOnMouseClicked(e -> {
			if (e.getButton() == MouseButton.PRIMARY) {
				if (!confirmationPopup.isShowing()) {
					confirmationPopup.show(((Node) (e.getSource())).getScene().getWindow());
				}
			}
		});

		cancelButton.setOnMouseClicked(e -> {
			if (e.getButton() == MouseButton.PRIMARY) {
				if (confirmationPopup.isShowing()) {
					confirmationPopup.hide();
				}
			}
		});

		confirmButton.setOnMouseClicked(e -> {
			if (e.getButton() == MouseButton.PRIMARY) {
				try {
					buyerItemDetailsController.handlePurchaseButton(item);
					purchaseMessageLabel.setTextFill(Color.GREEN);
					purchaseMessageLabel.setText("Purchase successfull");
				} catch (IllegalArgumentException ex) {
					purchaseMessageLabel.setTextFill(Color.RED);
					purchaseMessageLabel.setText(ex.getMessage());
				}
				if (confirmationPopup.isShowing()) {
					confirmationPopup.hide();
				}
			}
		});

		offerButton.setOnMouseClicked(e -> {
			if (e.getButton() == MouseButton.PRIMARY) {
				try {
					String offerInput = offerInputTextField.getText();
					buyerItemDetailsController.handleOfferButton(item, offerInput);
					offerMessageLabel.setTextFill(Color.GREEN);
					offerDetailLabel.setText(offerInput);
					offerMessageLabel.setText("Success");
				} catch (IllegalArgumentException ex) {
					offerMessageLabel.setTextFill(Color.RED);
					offerMessageLabel.setText(ex.getMessage());
				}
			}
		});

		addToWishlistButton.setOnMouseClicked(e -> {
			if (e.getButton() == MouseButton.PRIMARY) {
				try {
					buyerItemDetailsController.handleAddToWishlist(item);
					addToWishlistMessageLabel.setTextFill(Color.GREEN);
					addToWishlistMessageLabel.setText("Added to wishlist");
				} catch (IllegalArgumentException ex) {
					addToWishlistMessageLabel.setTextFill(Color.RED);
					addToWishlistMessageLabel.setText(ex.getMessage());
				}
			}
		});
	}

	private String itemOfferPrice() {
		String[] itemOfferStatus = item.getItem_offer_status().split(",");
		if (itemOfferStatus[0].equals("offer")) {
			return itemOfferStatus[1];
		}
		return "-";
	}
}
