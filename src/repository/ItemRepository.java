package repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Item;

public class ItemRepository {
	private DatabaseConnector db;
	private ObservableList<Item> itemList;

	public ItemRepository() {
		db = DatabaseConnector.getInstance();
		 itemList = FXCollections.observableArrayList();
	}

	public ObservableList<Item> getAllItem() {
		itemList = FXCollections.observableArrayList();
		String query = "SELECT * FROM item WHERE item_status='approved'";
		try (PreparedStatement pstmt = db.getConnection().prepareStatement(query)) {
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Item item = new Item(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
				itemList.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return itemList;
	}

	public Item getItemById(String item_id) {
		Item item = null;
		String query = "SELECT * FROM item WHERE Item_id = ?";
		try (PreparedStatement pstmt = db.getConnection().prepareStatement(query)) {
			pstmt.setString(1, item_id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				item = new Item(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return item;
	}

	public Item getItemByName(String item_name) {
		Item item = null;
		String query = "SELECT * FROM item WHERE item_name = ?";
		try (PreparedStatement pstmt = db.getConnection().prepareStatement(query)) {
			pstmt.setString(1, item_name);
			ResultSet rs = pstmt.executeQuery();
			item = new Item(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
					rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return item;

	}

	public void updateOfferItem(String item_id, String offer) {
		String query = "UPDATE item SET item_offer_status = ? WHERE item_id = ?";
		try(PreparedStatement pstmt = db.getConnection().prepareStatement(query)){
			pstmt.setString(1, offer);
			pstmt.setString(2, item_id);
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
