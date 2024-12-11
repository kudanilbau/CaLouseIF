package view;

import java.util.Arrays;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;

public class BuyerPurchaseHistoryView {
    public Parent createPurchaseHistoryPage() {
        VBox root = new VBox(10);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER);

        Label titleLabel = new Label("Purchase History");
        titleLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        TableView<Object> historyTable = new TableView<>();
        historyTable.setPrefWidth(600);
        historyTable.setPrefHeight(400);

        TableColumn<Object, String> transactionIdColumn = new TableColumn<>("Transaction ID");
        TableColumn<Object, String> itemNameColumn = new TableColumn<>("Item Name");
        TableColumn<Object, String> itemCategoryColumn = new TableColumn<>("Category");
        TableColumn<Object, String> itemSizeColumn = new TableColumn<>("Size");
        TableColumn<Object, String> itemPriceColumn = new TableColumn<>("Price");

        historyTable.getColumns().addAll(Arrays.asList(transactionIdColumn, itemNameColumn, itemCategoryColumn, itemSizeColumn, itemPriceColumn));

        root.getChildren().addAll(titleLabel, historyTable);
        return root;
    }
}
