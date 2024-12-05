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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import model.Item;

public class BuyerHomepageView extends BorderPane{
    private TableView<Item> itemTable;
    private Button wishlistButton, purchaseHistoryButton;
    private ObservableList<Item> itemList;
    
    private ItemController itemController;

    public BuyerHomepageView(ItemController itemController) {
		super();
		this.itemController = itemController;
		itemList = itemController.BrowseItem();
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
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("item_name"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("item_category"));
        sizeColumn.setCellValueFactory(new PropertyValueFactory<>("item_size"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("item_price"));
        itemTable.getColumns().addAll(Arrays.asList(nameColumn, categoryColumn, sizeColumn, priceColumn));
        itemTable.setItems(itemList);

        wishlistButton = new Button("Wishlist");
        purchaseHistoryButton = new Button("Purchase History");
    }

    private void addComponents() {
        HBox topBar = new HBox(10, wishlistButton, purchaseHistoryButton);
        topBar.setAlignment(Pos.CENTER);
        topBar.setPadding(new Insets(10));

        VBox mainContent = new VBox(10, itemTable);
        mainContent.setPadding(new Insets(10));

        this.setTop(topBar);
        this.setCenter(mainContent);
    }

    private void styleComponents() {
        this.setPrefSize(Double.MAX_VALUE,Double.MAX_VALUE);
        VBox.setVgrow(itemTable, Priority.ALWAYS);
    }
}
