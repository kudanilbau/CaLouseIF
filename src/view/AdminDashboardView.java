package view;

import java.util.Arrays;

import controller.AdminDashboardController;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import model.Item;

public class AdminDashboardView extends BorderPane{
    private TableView<Item> itemTable;
    private Button approveButton, declineButton;
    private TextField reasonField;
    private TableColumn<Item, String> nameColumn, categoryColumn, sizeColumn, priceColumn, statusColumn;
	private HBox actionBarTopHBox, actionBarBottomHBox;
	private Button refreshTableButton;
	private Label messageLabel;
	
	private ObservableList<Item> itemList;
	private AdminDashboardController controller;

    public AdminDashboardView(AdminDashboardController controller) {
		super();
		this.controller = controller;
		itemList = this.controller.getRequestItem();
        initComponents();
        addComponents();
        styleComponents();
        setActionComponents();
    }

    private void initComponents() {
        itemTable = new TableView<>();
        nameColumn = new TableColumn<>("Item Name");
        categoryColumn = new TableColumn<>("Category");
        sizeColumn = new TableColumn<>("Size");
        priceColumn = new TableColumn<>("Price");
        statusColumn = new TableColumn<>("Status");
        
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("item_name"));
		categoryColumn.setCellValueFactory(new PropertyValueFactory<>("item_category"));
		sizeColumn.setCellValueFactory(new PropertyValueFactory<>("item_size"));
		priceColumn.setCellValueFactory(new PropertyValueFactory<>("item_price"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("item_status"));
        itemTable.getColumns().addAll(Arrays.asList(nameColumn, categoryColumn, sizeColumn, priceColumn, statusColumn));
        itemTable.setItems(itemList);
        
        approveButton = new Button("Approve");
        declineButton = new Button("Decline");
        reasonField = new TextField();
        reasonField.setPromptText("Enter reason for decline...");
        
		actionBarTopHBox = new HBox(15);
		actionBarBottomHBox = new HBox(10);
		
		refreshTableButton = new Button("Refresh Table");
		
		messageLabel = new Label();
    }

    private void addComponents() {
    	actionBarBottomHBox.getChildren().addAll(approveButton, declineButton, reasonField, messageLabel);
        actionBarBottomHBox.setAlignment(Pos.CENTER);
        actionBarBottomHBox.setPadding(new Insets(10));

		actionBarTopHBox.getChildren().add(refreshTableButton);
        
		this.setTop(actionBarTopHBox);
        this.setCenter(itemTable);
        this.setBottom(actionBarBottomHBox);
    }

    private void styleComponents() { 
		this.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
		VBox.setVgrow(itemTable, Priority.ALWAYS);

		itemTable.setColumnResizePolicy(TableView.UNCONSTRAINED_RESIZE_POLICY);
		nameColumn.prefWidthProperty().bind(itemTable.widthProperty().multiply(0.3));
		categoryColumn.prefWidthProperty().bind(itemTable.widthProperty().multiply(0.287));
		sizeColumn.prefWidthProperty().bind(itemTable.widthProperty().multiply(0.1));
		priceColumn.prefWidthProperty().bind(itemTable.widthProperty().multiply(0.1));
		statusColumn.prefWidthProperty().bind(itemTable.widthProperty().multiply(0.2));
		
		actionBarTopHBox.setPadding(new Insets(0, 15, 15, 15));
    }
    
    private void setActionComponents() {
    	declineButton.setOnMouseClicked(e -> {
    		if(e.getButton() == MouseButton.PRIMARY) {
    			try {
    				Item item = itemTable.getSelectionModel().getSelectedItem();
    				controller.handleDeclineButton(item, reasonField.getText());
    				messageLabel.setText("");
				} catch (IllegalArgumentException ex) {
					messageLabel.setTextFill(Color.RED);
					messageLabel.setText(ex.getMessage());
				}
    		}
    	});
    	
    	approveButton.setOnMouseClicked(e -> {
    		if(e.getButton() == MouseButton.PRIMARY) {
    			Item item = itemTable.getSelectionModel().getSelectedItem();
    			controller.handleApproveButton(item);
    		}
    	});
    	
    	refreshTableButton.setOnMouseClicked(e -> {
    		if(e.getButton() == MouseButton.PRIMARY) {
    			itemList = controller.getRequestItem();
    		}
    	});
    }
}
