package view;

import java.util.Arrays;

import controller.BuyerHomepageController;
import controller.ItemController;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import model.Item;

public class BuyerHomepageView extends BorderPane {
	private TableView<Item> itemTable;
	private ObservableList<Item> itemList;
	private TableColumn<Item, String> nameColumn, categoryColumn, sizeColumn, priceColumn;
	private VBox mainContent;

	private ItemController itemController;
	private BuyerHomepageController buyerHomepageController;

	public BuyerHomepageView(ItemController itemController, BuyerHomepageController buyerHomepageController) {
		super();
		this.itemController = itemController;
		this.buyerHomepageController = buyerHomepageController;
		itemList = this.itemController.BrowseItem();
		initComponents();
		addComponents();
		styleComponents();
		setActionNode();
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

		mainContent = new VBox();

	}

	private void addComponents() {
		mainContent.getChildren().add(itemTable);
		this.setCenter(mainContent);
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
		itemTable.setOnMouseClicked(e -> {
			if(e.getButton() == MouseButton.PRIMARY) {
				Item item = itemTable.getSelectionModel().getSelectedItem();
				buyerHomepageController.handleItemSelection(item);
			}
		});
	}
}
