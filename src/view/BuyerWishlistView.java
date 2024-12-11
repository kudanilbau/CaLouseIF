package view;

import java.util.Arrays;

import controller.BuyerWishlistController;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import model.Item;

public class BuyerWishlistView extends BorderPane{
	private Label titleLabel;
	private TableView<Item> wishlistTable;
	private TableColumn<Item, String> itemNameColumn, itemCategoryColumn, itemSizeColumn, itemPriceColumn;
	private HBox actionBarBottomContainer;
	private BorderPane actionBarTopContainer;
	private Button removeButton, refreshButton;
	
	private BuyerWishlistController controller;
	
	private ObservableList<Item> wishlistItemList;
	
	public BuyerWishlistView(BuyerWishlistController controller) {
		super();
		this.controller = controller;
		this.wishlistItemList = this.controller.getWishlistItems();
		initComponents();
		addComponents();
		styleComponents();
		setActionNode();
	}
    private void setActionNode() {
		removeButton.setOnMouseClicked(e -> {
			if(e.getButton() == MouseButton.PRIMARY) {
				Item item = wishlistTable.getSelectionModel().getSelectedItem();
				controller.handleRemoveButton(item);
			}
		});
		
		refreshButton.setOnMouseClicked(e -> {
			if(e.getButton() == MouseButton.PRIMARY) {
				wishlistItemList = controller.getWishlistItems();
			}
		});
	}
	private void styleComponents() {
		titleLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");
		actionBarTopContainer.setPadding(new Insets(0, 15, 10, 15));
		actionBarBottomContainer.setAlignment(Pos.CENTER);
		actionBarBottomContainer.setPadding(new Insets(10));
		
		wishlistTable.setColumnResizePolicy(TableView.UNCONSTRAINED_RESIZE_POLICY);
		itemNameColumn.prefWidthProperty().bind(wishlistTable.widthProperty().multiply(0.4));
		itemCategoryColumn.prefWidthProperty().bind(wishlistTable.widthProperty().multiply(0.387));
		itemSizeColumn.prefWidthProperty().bind(wishlistTable.widthProperty().multiply(0.1));
		itemPriceColumn.prefWidthProperty().bind(wishlistTable.widthProperty().multiply(0.1));
        
        removeButton.setStyle("-fx-background-color: red; -fx-text-fill: white;");
	}
	private void addComponents() {
		wishlistTable.getColumns().addAll(Arrays.asList(itemNameColumn, itemCategoryColumn, itemSizeColumn, itemPriceColumn));
		
		actionBarBottomContainer.getChildren().add(removeButton);
		actionBarTopContainer.setCenter(titleLabel);
		actionBarTopContainer.setLeft(refreshButton);
		
		this.setTop(actionBarTopContainer);
		this.setCenter(wishlistTable);
		this.setBottom(actionBarBottomContainer);
		
	}
	private void initComponents() {
		titleLabel = new Label("Your Wishlist");
		wishlistTable = new TableView<>();
		
		itemNameColumn = new TableColumn<>("Item Name");
		itemCategoryColumn = new TableColumn<>("Category");
		itemSizeColumn = new TableColumn<>("Size");
		itemPriceColumn = new TableColumn<>("Price");
		
		itemNameColumn.setCellValueFactory(new PropertyValueFactory<>("item_name"));
		itemCategoryColumn.setCellValueFactory(new PropertyValueFactory<>("item_category"));
		itemSizeColumn.setCellValueFactory(new PropertyValueFactory<>("item_size"));
		itemPriceColumn.setCellValueFactory(new PropertyValueFactory<>("item_price"));
		
		wishlistTable.setItems(wishlistItemList);
		
		removeButton = new Button("Remove Selected Item");
		refreshButton = new Button("Refresh Table");
		
		actionBarBottomContainer = new HBox();
		actionBarTopContainer = new BorderPane();
	}
}
