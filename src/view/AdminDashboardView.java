package view;

import java.util.Arrays;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import model.Item;

public class AdminDashboardView extends BorderPane{
    private TableView<Item> itemTable;
    private Button approveButton, declineButton;
    private TextField reasonField;

    public AdminDashboardView() {
		super();
        initComponents();
        addComponents();
        styleComponents();
    }

    private void initComponents() {
        itemTable = new TableView<>();
        TableColumn<Item, String> nameColumn = new TableColumn<>("Item Name");
        TableColumn<Item, String> categoryColumn = new TableColumn<>("Category");
        TableColumn<Item, String> sizeColumn = new TableColumn<>("Size");
        TableColumn<Item, Double> priceColumn = new TableColumn<>("Price");
        TableColumn<Item, String> statusColumn = new TableColumn<>("Status");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        sizeColumn.setCellValueFactory(new PropertyValueFactory<>("size"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        itemTable.getColumns().addAll(Arrays.asList(nameColumn, categoryColumn, sizeColumn, priceColumn, statusColumn));

        approveButton = new Button("Approve");
        declineButton = new Button("Decline");
        reasonField = new TextField();
        reasonField.setPromptText("Enter reason for decline...");
    }

    private void addComponents() {
        HBox actionBar = new HBox(10, approveButton, declineButton, reasonField);
        actionBar.setAlignment(Pos.CENTER);
        actionBar.setPadding(new Insets(10));

        this.setCenter(itemTable);
        this.setBottom(actionBar);
    }

    private void styleComponents() { 
        this.setPrefSize(800, 600);
        itemTable.setPrefHeight(500);
    }

    public Node asNode() {
    	return this;
    }
}
