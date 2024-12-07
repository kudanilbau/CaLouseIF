package view;

import controller.BuyerItemDetailsController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import model.Item;

public class BuyerItemDetailsView extends VBox {
	private Item item;
	private GridPane itemDetailGridPane;
	private HBox offerInputHBox;
	private TextField offerInputTextField;
	private Label nameLabel, categoryLabel, sizeLabel, priceLabel, offerLabel;
	private Label nameDetailLabel, categoryDetailLabel, sizeDetailLabel, priceDetailLabel, offerDetailLabel;
	private Label errorMessageLabel;
	private Button addToWishlistButton, purchaseButton, offerButton;

	private BuyerItemDetailsController buyerItemDetailsController;

	public BuyerItemDetailsView(BuyerItemDetailsController buyerItemDetailsController, Item item) {
		super();
		this.item = item;
		initComponents();
		addComponents();
		styleComponents();
		setActionNode();
	}

	private void initComponents() {
		offerInputHBox = new HBox(10);

		itemDetailGridPane = new GridPane();

		nameLabel = new Label("Item Name: ");
		categoryLabel = new Label("Category: ");
		sizeLabel = new Label("Size: ");
		priceLabel = new Label("Price: ");
		offerLabel = new Label("Current Offer: ");
		errorMessageLabel = new Label();

		nameDetailLabel = new Label(item.getItem_name());
		categoryDetailLabel = new Label(item.getItem_category());
		sizeDetailLabel = new Label(item.getItem_size());
		priceDetailLabel = new Label(item.getItem_price());
		offerDetailLabel = new Label(itemOfferPrice());

		addToWishlistButton = new Button("Add to Wishlist");
		purchaseButton = new Button("Purchase");
		offerButton = new Button("Make Offer");

		offerInputTextField = new TextField();
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

		offerInputHBox.getChildren().addAll(offerButton, offerInputTextField, errorMessageLabel);

		this.getChildren().addAll(itemDetailGridPane, addToWishlistButton, purchaseButton, offerInputHBox);
	}

	private void styleComponents() {
		this.setAlignment(Pos.CENTER_LEFT);
		this.setPadding(new Insets(20));
		this.setSpacing(10);

		itemDetailGridPane.setHgap(10);
		itemDetailGridPane.setVgap(10);

		errorMessageLabel.setTextFill(Color.RED);

		offerInputTextField.setPromptText("offer price");
	}

	private void setActionNode() {
		purchaseButton.setOnMouseClicked(e -> {
			if (e.getButton() == MouseButton.PRIMARY) {
				buyerItemDetailsController.handlePurchaseButton(item);

			}
		});

		offerButton.setOnMouseClicked(e -> {
			if (e.getButton() == MouseButton.PRIMARY) {
				try {
					buyerItemDetailsController.handleOfferButton(item, offerInputTextField.getText());
					errorMessageLabel.setText("");
				} catch (Exception ex) {
					errorMessageLabel.setText(ex.getMessage());
				}
			}
		});

		addToWishlistButton.setOnMouseClicked(e -> {
			if (e.getButton() == MouseButton.PRIMARY) {
				buyerItemDetailsController.handleAddToWishlist(item);
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
