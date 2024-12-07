package repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Wishlist;

public class WishlistRepository {
	private DatabaseConnector db;
	private static ObservableList<Wishlist> wishlistList;
	
	public WishlistRepository() {
		db = DatabaseConnector.getInstance();
	}
	
	public void createWishlist(String item_id, String user_id) {
		String query = "INSERT INTO wishlist VALUES(?, ?, ?)";
		try (PreparedStatement pstmt = db.getConnection().prepareStatement(query)){
			pstmt.setString(1, UUID.randomUUID().toString());
			pstmt.setString(2, item_id);
			pstmt.setString(3, user_id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ObservableList<Wishlist> getWishlistByUserId(String user_id) {
		String query = "SELECT * FROM wishlist WHERE User_id = ?";
		wishlistList = FXCollections.observableArrayList();
		try(PreparedStatement pstmt = db.getConnection().prepareStatement(query)) {
			pstmt.setString(1, user_id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Wishlist wishlist = new Wishlist(rs.getString("Wishlist_id"), rs.getString("Item_id"), rs.getString("User_id"));
				wishlistList.add(wishlist);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return wishlistList;
	}
	
	public void removeWishlistById(String wishlist_id){
		String query = "DELETE FROM wishlist WHERE Wishlist_id = ?";
		
		try(PreparedStatement pstmt = db.getConnection().prepareStatement(query)) {
			pstmt.setString(1, wishlist_id);
			pstmt.executeUpdate();
			
	        // remove from list
	        for (int i = 0; i < wishlistList.size(); i++) {
	            if (wishlistList.get(i).getWhislist_id().equals(wishlist_id)) {
	                wishlistList.remove(i);
	                break;
	            }
	        }
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
