package view;

import java.util.Arrays;

import controller.BuyerPurchaseHistoryController;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.MapChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import model.Item;
import model.Transaction;
import util.MapEntry;

public class BuyerPurchaseHistoryView extends BorderPane {

	private Label titleLabel;
	private TableColumn<MapEntry<Transaction, Item>, String> transactionIdColumn, itemNameColumn, itemCategoryColumn,
			itemSizeColumn, itemPriceColumn;
	private TableView<MapEntry<Transaction, Item>> transactionHistoryTable;
	private BorderPane actionBarTopContainer;

	private ObservableMap<Transaction, Item> transactionList;
	private ObservableList<MapEntry<Transaction, Item>> tableData;
	private BuyerPurchaseHistoryController controller;

	public BuyerPurchaseHistoryView(BuyerPurchaseHistoryController controller) {
		this.controller = controller;
		initComponents();
		createTableData();
		addComponents();
		styleComponents();
		setActionNode();
	}

	private void initComponents() {
		tableData = FXCollections.observableArrayList();
		titleLabel = new Label("Purchase History");

		transactionHistoryTable = new TableView<>(tableData);

		transactionIdColumn = new TableColumn<>("Transaction ID");
		transactionIdColumn.setCellValueFactory(cd -> Bindings.createStringBinding(() -> cd.getValue().getKey().getItem_id()));
		
		itemNameColumn = new TableColumn<>("Item Name");
		itemNameColumn.setCellValueFactory(cd -> Bindings.createStringBinding(() -> cd.getValue().getValue().getItem_name()));
		
		itemCategoryColumn = new TableColumn<>("Category");
		itemCategoryColumn.setCellValueFactory(cd -> Bindings.createStringBinding(() -> cd.getValue().getValue().getItem_category()));
		
		itemSizeColumn = new TableColumn<>("Size");
		itemSizeColumn.setCellValueFactory(cd -> Bindings.createStringBinding(() -> cd.getValue().getValue().getItem_size()));
		
		itemPriceColumn = new TableColumn<>("Price");
		itemPriceColumn.setCellValueFactory(cd -> Bindings.createStringBinding(() -> cd.getValue().getValue().getItem_price()));
		
		actionBarTopContainer = new BorderPane();
	}

	private void styleComponents() {
		titleLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");
		
		transactionIdColumn.prefWidthProperty().bind(transactionHistoryTable.widthProperty().multiply(0.3));
		itemNameColumn.prefWidthProperty().bind(transactionHistoryTable.widthProperty().multiply(0.3));
		itemCategoryColumn.prefWidthProperty().bind(transactionHistoryTable.widthProperty().multiply(0.187));
		itemSizeColumn.prefWidthProperty().bind(transactionHistoryTable.widthProperty().multiply(0.1));
		itemPriceColumn.prefWidthProperty().bind(transactionHistoryTable.widthProperty().multiply(0.1));
		
		actionBarTopContainer.setPadding(new Insets(0, 15, 15, 15));
	}

	private void setActionNode() {
		transactionList.addListener((MapChangeListener<Transaction, Item>) change -> {
			if(change.wasAdded()) {
				tableData.add(new MapEntry<Transaction, Item>(change.getKey(), change.getValueAdded()));
			}
			if(change.wasRemoved()) {
				tableData.removeIf(entry -> entry.getKey().equals(change.getKey()));
			}
		});
	}

	private void addComponents() {
		transactionHistoryTable.getColumns().addAll(Arrays.asList(transactionIdColumn, itemNameColumn,
				itemCategoryColumn, itemSizeColumn, itemPriceColumn));

		actionBarTopContainer.setCenter(titleLabel);
		
		this.setTop(actionBarTopContainer);
		this.setCenter(transactionHistoryTable);
	}
	
	private void createTableData() {
		transactionList = controller.getPurchaseHistory();
		transactionList.forEach((transaction, item) -> {
			tableData.add(new MapEntry<Transaction, Item>(transaction, item));
		});
		
	}

}
