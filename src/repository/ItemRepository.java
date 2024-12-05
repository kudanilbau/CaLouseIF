package repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Item;

public class ItemRepository {
	private DatabaseConnector db;

	public ItemRepository() {
		db = DatabaseConnector.getInstance();
	}

	public ObservableList<Item> getAllItem() {
		ObservableList<Item> itemList = FXCollections.observableArrayList();
		String query = "SELECT * FROM item WHERE item_status='approved'";
		try (PreparedStatement pstmt = db.getConnection().prepareStatement(query)) {
			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					Item item = new Item(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
					itemList.add(item);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return itemList;
	}
}
