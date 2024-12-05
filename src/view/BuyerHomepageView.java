package view;

import java.util.Arrays;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Item;

public class BuyerHomepageView {
    private BorderPane root;
    private TableView<Item> itemTable;
    private Button wishlistButton, purchaseHistoryButton;

    public BuyerHomepageView() {
        initComponents();
        addComponents();
        styleComponents();
    }

    private void initComponents() {
        root = new BorderPane();

        itemTable = new TableView<>();
        TableColumn<Item, String> nameColumn = new TableColumn<>("Item Name");
        TableColumn<Item, String> categoryColumn = new TableColumn<>("Category");
        TableColumn<Item, String> sizeColumn = new TableColumn<>("Size");
        TableColumn<Item, Double> priceColumn = new TableColumn<>("Price");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        sizeColumn.setCellValueFactory(new PropertyValueFactory<>("size"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        itemTable.getColumns().addAll(Arrays.asList(nameColumn, categoryColumn, sizeColumn, priceColumn));

        wishlistButton = new Button("Wishlist");
        purchaseHistoryButton = new Button("Purchase History");
    }

    private void addComponents() {
        HBox topBar = new HBox(10, wishlistButton, purchaseHistoryButton);
        topBar.setAlignment(Pos.CENTER);
        topBar.setPadding(new Insets(10));

        VBox mainContent = new VBox(10, itemTable);
        mainContent.setPadding(new Insets(10));

        root.setTop(topBar);
        root.setCenter(mainContent);
    }

    private void styleComponents() {
        root.setPrefSize(800, 600);
        itemTable.setPrefHeight(500);
    }

    public Node asNode() {
    	return root;
    }
}
