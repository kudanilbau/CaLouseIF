package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class BuyerItemDetailsView {
    private VBox root;
    private Label nameLabel, categoryLabel, sizeLabel, priceLabel;
    private Button wishlistButton, purchaseButton, offerButton;

    public BuyerItemDetailsView() {
        initComponents();
        addComponents();
        styleComponents();
    }

    private void initComponents() {
        root = new VBox(10);

        nameLabel = new Label("Item Name: ");
        categoryLabel = new Label("Category: ");
        sizeLabel = new Label("Size: ");
        priceLabel = new Label("Price: ");

        wishlistButton = new Button("Add to Wishlist");
        purchaseButton = new Button("Purchase");
        offerButton = new Button("Make Offer");
    }

    private void addComponents() {
        root.getChildren().addAll(nameLabel, categoryLabel, sizeLabel, priceLabel, wishlistButton, purchaseButton, offerButton);
    }

    private void styleComponents() {
        root.setAlignment(Pos.CENTER_LEFT);
        root.setPadding(new Insets(20));
    }
    public Node asNode() {
    	return root;
    }
   
}
