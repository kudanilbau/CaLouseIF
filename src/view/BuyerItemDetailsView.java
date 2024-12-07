package view;

import controller.BuyerItemDetailsController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.VBox;
import model.Item;

public class BuyerItemDetailsView extends VBox{
	private Item item;
    private Label nameLabel, categoryLabel, sizeLabel, priceLabel;
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

        nameLabel = new Label("Item Name: ");
        categoryLabel = new Label("Category: ");
        sizeLabel = new Label("Size: ");
        priceLabel = new Label("Price: ");

        addToWishlistButton = new Button("Add to Wishlist");
        purchaseButton = new Button("Purchase");
        offerButton = new Button("Make Offer");
    }

    private void addComponents() {
        this.getChildren().addAll(nameLabel, categoryLabel, sizeLabel, priceLabel, addToWishlistButton, purchaseButton, offerButton);
    }

    private void styleComponents() {
        this.setAlignment(Pos.CENTER_LEFT);
        this.setPadding(new Insets(20));
    }
    
	private void setActionNode() {
		purchaseButton.setOnMouseClicked(e -> {
			if (e.getButton() == MouseButton.PRIMARY) {
				buyerItemDetailsController.handlePurchaseButton(item);
				
			}
		});

		offerButton.setOnMouseClicked(e -> {
			if (e.getButton() == MouseButton.PRIMARY) {
				buyerItemDetailsController.handleOfferButton(item);
			}
		});
		
		addToWishlistButton.setOnMouseClicked(e -> {
			if(e.getButton() == MouseButton.PRIMARY) {
				buyerItemDetailsController.handleAddToWishlist(item);
			}
		});
	}
}
