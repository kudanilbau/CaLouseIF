package repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Item;
import model.Wishlist;

public class WishlistRepository {
	private DatabaseConnector db;
	private static ObservableList<Wishlist> wishlistList;
	private static ObservableList<Item> wishlistItemList;

	public WishlistRepository() {
		db = DatabaseConnector.getInstance();
		if (wishlistList == null) {
			wishlistList = FXCollections.observableArrayList();
		}
		if (wishlistItemList == null) {
			wishlistItemList = FXCollections.observableArrayList();
		}
	}

	/**
	 * Adds a new wishlist entry to the database.
	 *
	 * @param item_id the ID of the item
	 * @param user_id the ID of the user
	 */
	public void createWishlist(String item_id, String user_id) {
		String query = "INSERT INTO wishlist VALUES(?, ?, ?)";
		try (PreparedStatement pstmt = db.getConnection().prepareStatement(query)) {
			pstmt.setString(1, UUID.randomUUID().toString());
			pstmt.setString(2, item_id);
			pstmt.setString(3, user_id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Retrieves all wishlist entries for a specific user.
	 *
	 * @param user_id the ID of the user
	 * @return an observable list of wishlist items for the user
	 */
	public ObservableList<Item> getWishlistByUserId(String user_id) {
		String query = "SELECT * FROM wishlist WHERE User_id = ?";
		wishlistList.clear();
		wishlistItemList.clear();
		ItemRepository itemRepository = new ItemRepository();
		try (PreparedStatement pstmt = db.getConnection().prepareStatement(query)) {
			pstmt.setString(1, user_id);
			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					Wishlist wishlist = new Wishlist(rs.getString("Wishlist_id"), rs.getString("Item_id"),
							rs.getString("User_id"));
					wishlistList.add(wishlist);

					Item item = itemRepository.getItemById(wishlist.getItem_id());
					wishlistItemList.add(item);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return wishlistItemList;
	}

	/**
	 * Removes a wishlist entry by its ID.
	 *
	 * @param wishlist_id the ID of the wishlist to remove
	 */
	public void removeWishlistById(String wishlist_id) {
		String query = "DELETE FROM wishlist WHERE Wishlist_id = ?";

		try (PreparedStatement pstmt = db.getConnection().prepareStatement(query)) {
			pstmt.setString(1, wishlist_id);
			pstmt.executeUpdate();

			// remove from list
			for (int i = 0; i < wishlistList.size(); i++) {
				if (wishlistList.get(i).getWhislist_id().equals(wishlist_id)) {
					wishlistList.remove(i);
					wishlistItemList.remove(i);
					break;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Wishlist getWishlistByUserIdAndItemId(String user_id, String item_id) {
		String query = "SELECT * FROM wishlist WHERE User_id = ? AND Item_id = ?";

		try (PreparedStatement pstmt = db.getConnection().prepareStatement(query)) {
			pstmt.setString(1, user_id);
			pstmt.setString(2, item_id);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					Wishlist wishlist = new Wishlist(rs.getString("Wishlist_id"), item_id, user_id);
					return wishlist;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
