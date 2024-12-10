package repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Item;

public class ItemRepository {
	private DatabaseConnector db;
//	to make table able to be updated
	private static ObservableList<Item> itemList;

	public ItemRepository() {
		db = DatabaseConnector.getInstance();
		if(itemList == null) {
			itemList = FXCollections.observableArrayList();
		}
	}
	
	private Item createItemFromResultSet(ResultSet rs) throws SQLException{
		return new Item(rs.getString("Item_id"), rs.getString("Item_seller_id"), rs.getString("Item_name"), rs.getString("Item_size"), rs.getString("Item_price"), rs.getString("Item_category"),
							rs.getString("Item_status"), rs.getString("Item_wishlist"), rs.getString("Item_offer_status"));
	}
	
	private void updateItemList(String item_id) {
		// After updating, fetch the updated list of items
		Item updatedItem = getItemById(item_id);
		
		// Update the specific item in the list
		for (int i = 0; i < itemList.size(); i++) {
		    if (itemList.get(i).getItem_id().equals(updatedItem.getItem_id())) {
		        itemList.set(i, updatedItem);
		        break;
		    }
		}
	}

    /**
     * Retrieves all items with an "approved" status from the database.
     *
     * @return an {@code ObservableList} of approved {@code Item} objects.
     */
	public ObservableList<Item> getAllApprovedItem() {
		itemList.clear();
		String query = "SELECT * FROM item WHERE item_status LIKE 'approved%'";
		try (PreparedStatement pstmt = db.getConnection().prepareStatement(query)) {
			try(ResultSet rs = pstmt.executeQuery()){				
				while (rs.next()) {
//					(Item_id, Item_seller_id, Item_name, Item_size, Item_price, Item_category, Item_status, Item_wishlist, Item_offer_status)
					Item item = createItemFromResultSet(rs);
					itemList.add(item);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return itemList;
	}

    /**
     * Retrieves an {@code Item} object from the database using its ID.
     *
     * @param item_id the unique identifier of the item to retrieve.
     * @return an {@code Item} object if found, or {@code null} otherwise.
     */
	public Item getItemById(String item_id) {
		Item item = null;
		String query = "SELECT * FROM item WHERE Item_id = ?";
		try (PreparedStatement pstmt = db.getConnection().prepareStatement(query)) {
			pstmt.setString(1, item_id);
			try(ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
					item = createItemFromResultSet(rs);				
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return item;
	}

    /**
     * Retrieves an {@code Item} object from the database using its name.
     *
     * @param item_name the name of the item to retrieve.
     * @return an {@code Item} object if found, or {@code null} otherwise.
     */
	public Item getItemByName(String item_name) {
		Item item = null;
		String query = "SELECT * FROM item WHERE item_name = ?";
		try (PreparedStatement pstmt = db.getConnection().prepareStatement(query)) {
			pstmt.setString(1, item_name);
			try(ResultSet rs = pstmt.executeQuery()){
				item = createItemFromResultSet(rs);			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return item;

	}

    /**
     * Updates the offer status of an item in the database.
     *
     * @param item_id the unique identifier of the item to update.
     * @param offer   the new offer status to set.
     */
	public void updateOfferItem(String item_id, String offer) {
		String query = "UPDATE item SET item_offer_status = ? WHERE item_id = ?";
		try(PreparedStatement pstmt = db.getConnection().prepareStatement(query)){
			pstmt.setString(1, offer);
			pstmt.setString(2, item_id);
			pstmt.executeUpdate();
	        updateItemList(item_id);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Creates a new item record in the database.
	 * 
	 * This method generates a new item with a unique ID and sets its initial status to "waiting."
	 * The item is then added to the database.
	 * 
	 * @param Item_seller_id The ID of the seller creating the item.
	 * @param Item_name The name of the item.
	 * @param Item_category The category of the item.
	 * @param Item_size The size of the item.
	 * @param Item_price The price of the item.
	 * @return A {@code Item} object representing the newly created item, or {@code null} if an error occurs.
	 */
	public Item createNewItem(String Item_seller_id, String Item_name, String Item_category, String Item_size, String Item_price) {
		String query = "INSERT INTO item(Item_id, Item_seller_id, Item_name, Item_size, Item_price, Item_category, Item_status, Item_wishlist, Item_offer_status) VALUES(?,?,?,?,?,?,?,?,?)";
		Item item = new Item(UUID.randomUUID().toString(), Item_seller_id, Item_name, Item_size, Item_price, Item_category, "waiting", "0", "no_offer");
		try(PreparedStatement pstmt = db.getConnection().prepareStatement(query)) {
			pstmt.setString(1, item.getItem_id());
			pstmt.setString(2, item.getItem_seller_id());
			pstmt.setString(3, item.getItem_name());
			pstmt.setString(4, item.getItem_size());
			pstmt.setString(5, item.getItem_price());
			pstmt.setString(6, item.getItem_category());
			pstmt.setString(7, item.getItem_status());
			pstmt.setString(8, item.getItem_wishlist());
			pstmt.setString(9, item.getItem_offer_status());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return item;
	}
	
	/**
	 * Updates an existing item's details in the database.
	 * 
	 * @param Item_id The ID of the item to update.
	 * @param Item_name The updated name of the item.
	 * @param Item_category The updated category of the item.
	 * @param Item_size The updated size of the item.
	 * @param Item_price The updated price of the item.
	 */
	public void updateItem(String Item_id, String Item_name, String Item_category, String Item_size, String Item_price) {
		String query = "UPDATE item SET Item_name = ?, Item_category = ?, Item_size = ?, Item_price = ? WHERE Item_id = ?";
		try(PreparedStatement pstmt = db.getConnection().prepareStatement(query)) {
			pstmt.setString(1, Item_name);
			pstmt.setString(2, Item_category);
			pstmt.setString(3, Item_size);
			pstmt.setString(4, Item_price);
			pstmt.setString(5, Item_id);
			pstmt.executeUpdate();
			
			updateItemList(Item_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Deletes an item record from the database.
	 * 
	 * @param item_id The ID of the item to delete.
	 */
	public void deleteItem(String item_id) {
		String query = "DELETE FROM item WHERE item_id = ?";
		try(PreparedStatement pstmt = db.getConnection().prepareStatement(query)) {
			pstmt.setString(1, item_id);
			pstmt.executeUpdate();
			
			updateItemList(item_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Retrieves all items with offers for a seller.
	 * 
	 * @param user_id The ID of the seller whose offered items are being retrieved.
	 * @return An {@code ObservableList<Item>} containing all offered items for the user.
	 */
	public ObservableList<Item> getAllOfferItem(String user_id){
		itemList.clear();
		String query = "SELECT * FROM item WHERE Item_seller_id = ? AND Item_offer_status LIKE 'offer%'";
		try(PreparedStatement pstmt = db.getConnection().prepareStatement(query)) {
			pstmt.setString(1, user_id);
			try(ResultSet rs = pstmt.executeQuery()){
				while(rs.next()) {
					Item item = createItemFromResultSet(rs);
					itemList.add(item);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return itemList;
	}
	
	/**
	 * Updates an item's status to "bought" and clears its offer status.
	 * 
	 * @param item_id The ID of the item being updated.
	 * @param item_price The price at which the item was sold.
	 */
	public void updateAcceptOffer(String item_id, String item_price) {
		String query = "UPDATE item SET Item_status = 'bought', Item_price = ?, Item_status_offer='no_offer' WHERE Item_id = ?";
		try(PreparedStatement pstmt = db.getConnection().prepareStatement(query)) {
			pstmt.setString(1, item_price);
			pstmt.setString(2, item_id);
			pstmt.executeUpdate();
			
			updateItemList(item_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Updates the status of an item in the database.
	 * 
	 * @param item_id The ID of the item to update.
	 * @param item_status The new status for the item.
	 */
	public void updateItemStatus(String item_id, String item_status) {
		String query = "UPDATE item SET Item_status = ? WHERE Item_id = ?";
		try(PreparedStatement pstmt = db.getConnection().prepareStatement(query)) {
			pstmt.setString(1, item_status);
			pstmt.setString(2, item_id);
			pstmt.executeUpdate();
			
			updateItemList(item_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Retrieves all items waiting for review.
	 * 
	 * This method fetches all items with a status of "waiting," indicating they are pending approval.
	 * 
	 * @return An {@code ObservableList<Item>} containing all items awaiting review.
	 */
	public ObservableList<Item> getAllRequestItems(){
		String query = "SELECT * FROM item WHERE Item_status = 'waiting'";
		itemList.clear();
		try(PreparedStatement pstmt = db.getConnection().prepareStatement(query);
				ResultSet rs = pstmt.executeQuery();) {
			while(rs.next()) {
				itemList.add(createItemFromResultSet(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return itemList;
	}
}
