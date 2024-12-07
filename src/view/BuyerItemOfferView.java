package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class BuyerItemOfferView extends VBox{
    private Label nameLabel, categoryLabel, sizeLabel, priceLabel;
    private Button wishlistButton, purchaseButton, offerButton;

    public BuyerItemOfferView() {
		super();
        initComponents();
        addComponents();
        styleComponents();
    }

    private void initComponents() {

        nameLabel = new Label("Item Name: ");
        categoryLabel = new Label("Category: ");
        sizeLabel = new Label("Size: ");
        priceLabel = new Label("Price: ");

        wishlistButton = new Button("Add to Wishlist");
        purchaseButton = new Button("Purchase");
        offerButton = new Button("Make Offer");
    }

    private void addComponents() {
        this.getChildren().addAll(nameLabel, categoryLabel, sizeLabel, priceLabel, wishlistButton, purchaseButton, offerButton);
    }

    private void styleComponents() {
        this.setAlignment(Pos.CENTER_LEFT);
        this.setPadding(new Insets(20));
    }   
}
