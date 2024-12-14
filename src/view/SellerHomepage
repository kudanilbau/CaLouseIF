package view;

import javafx.scene.control.Button;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Item;

public class SellerDashboard {
	TableView<Item>item_List = new TableView<>();
	TableColumn<Item, Integer> idColumn = new TableColumn<Item, Integer>("ID");
	idColumn.setCellValueFactory(new PropertyValueFactory<Item, Integer>("item_seller_id"));
	TableColumn<Item, String> itemName = new TableColumn<>("Item Name");
	itemName.setCellValueFactory(new PropertyValueFactory<Item, String>("item_name"));
	TableColumn<Item, String> itemSize = new TableColumn<>("Size");
	itemSize.setCellValueFactory(new PropertyValueFactory<Item, String>("item_size"));
	TableColumn<Item, String> itemPrice = new TableColumn<>("Price");
	itemPrice.setVCellValueFactory(new PropertyValueFactory<Item, String>("item_price"));
	
	
	Button deleteButton = new Button();
	Button editButton = new Button();
	
	
}
