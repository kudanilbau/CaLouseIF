package controller;

import javafx.collections.ObservableList;
import model.Item;
import model.Wishlist;

public class WishlistController {
    /**
     * Views a specific wishlist for a user.
     * 
     * This method retrieves and displays the wishlist for a given user and wishlist ID.
     * 
     * @param Wishlist_id The ID of the wishlist to be viewed.
     * @param User_id The ID of the user whose wishlist is being viewed.
     * 
     * @return an {@code ObservableList<Item>} containing all user's wishlist
     */
	public ObservableList<Item> ViewWishlist(String User_id) {
		return Wishlist.ViewWishlist(User_id);
	}
	
    /**
     * Adds an item to the user's wishlist.
     * 
     * This method adds a specified item to the user's wishlist by invoking the
     * AddWishlist method in the Wishlist class.
     * 
     * @param item_id The ID of the item to be added to the wishlist.
     * @param User_id The ID of the user adding the item to their wishlist.
     */
	public void AddWishlist(String item_id, String User_id) {
		Wishlist.AddWishlist(item_id, User_id);
	}
	
    /**
     * Removes an item from the user's wishlist.
     * 
     * This method removes the specified wishlist by invoking the RemoveWishlist method
     * in the Wishlist class.
     * 
     * @param Wishlist_id The ID of the wishlist item to be removed.
     */
	public void RemoveWishlist(String Wishlist_id) {
		Wishlist.RemoveWishlist(Wishlist_id);
	}
}
