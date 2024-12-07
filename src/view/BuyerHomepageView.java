package view;

import java.util.Arrays;

import controller.ItemController;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import model.Item;
import router.Router;

public class BuyerHomepageView extends BorderPane {
	private TableView<Item> itemTable;
	private Button wishlistButton, purchaseHistoryButton, homepageButton, purchaseButton, offerButton;
	private ObservableList<Item> itemList;
	private TableColumn<Item, String> nameColumn, categoryColumn, sizeColumn, priceColumn;
	private VBox mainContent;
	private HBox actionBar;

	private ItemController itemController;

	public BuyerHomepageView(ItemController itemController) {
		super();
		this.itemController = itemController;
		itemList = itemController.BrowseItem();
		initComponents();
		addComponents();
		styleComponents();
		setActionNode();
		addNavbar();
	}

	private void initComponents() {
		itemTable = new TableView<>();
		nameColumn = new TableColumn<>("Item Name");
		categoryColumn = new TableColumn<>("Category");
		sizeColumn = new TableColumn<>("Size");
		priceColumn = new TableColumn<>("Price");
		
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("item_name"));
		categoryColumn.setCellValueFactory(new PropertyValueFactory<>("item_category"));
		sizeColumn.setCellValueFactory(new PropertyValueFactory<>("item_size"));
		priceColumn.setCellValueFactory(new PropertyValueFactory<>("item_price"));
		
		itemTable.getColumns().addAll(Arrays.asList(nameColumn, categoryColumn, sizeColumn, priceColumn));
		itemTable.setItems(itemList);

		wishlistButton = new Button("Wishlist");
		purchaseHistoryButton = new Button("Purchase History");
		homepageButton = new Button("Homepage");
		
		mainContent = new VBox();
		actionBar = new HBox(10);
		
		purchaseButton = new Button("Purchase");
		offerButton = new Button("Offer");
		
	}

	private void addComponents() {
		mainContent.getChildren().add(itemTable);
		
		actionBar.getChildren().addAll(purchaseButton, offerButton);
		actionBar.setAlignment(Pos.CENTER);
		actionBar.setPadding(new Insets(10));
		
		this.setCenter(mainContent);
		this.setBottom(actionBar);
	}

	private void styleComponents() {
		this.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
		VBox.setVgrow(itemTable, Priority.ALWAYS);

		itemTable.setColumnResizePolicy(TableView.UNCONSTRAINED_RESIZE_POLICY);
		nameColumn.prefWidthProperty().bind(itemTable.widthProperty().multiply(0.4));
		categoryColumn.prefWidthProperty().bind(itemTable.widthProperty().multiply(0.387));
		sizeColumn.prefWidthProperty().bind(itemTable.widthProperty().multiply(0.1));
		priceColumn.prefWidthProperty().bind(itemTable.widthProperty().multiply(0.1));
	}

	private void setActionNode() {
		wishlistButton.setOnMouseClicked(e -> {
			if (e.getButton() == MouseButton.PRIMARY) {

			}
		});

		purchaseHistoryButton.setOnMouseClicked(e -> {
			if (e.getButton() == MouseButton.PRIMARY) {

			}
		});

		homepageButton.setOnMouseClicked(e -> {
			if (e.getButton() == MouseButton.PRIMARY) {
				
			}
		});
		
		purchaseButton.setOnMouseClicked(e -> {
			if (e.getButton() == MouseButton.PRIMARY) {
				
			}
		});
		
		offerButton.setOnMouseClicked(e -> {
			if (e.getButton() == MouseButton.PRIMARY) {
				
			}
		});
	}

	private void addNavbar() {
		Router.getAppNavBar().insertComponent(purchaseHistoryButton);
		Router.getAppNavBar().insertComponent(wishlistButton);
		Router.getAppNavBar().insertComponent(homepageButton);
	}
}
