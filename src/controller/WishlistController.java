package controller;

import model.Wishlist;

public class WishlistController {
	public void ViewWishlist(String Wishlist_id, String User_id) {
		Wishlist.ViewWishlist(Wishlist_id, User_id);
	}
	public void AddWishlist(String item_id, String User_id) {
		Wishlist.AddWishlist(item_id, User_id);
	}
	public void RemoveWishlist(String Wishlist_id) {
		Wishlist.RemoveWishlist(Wishlist_id);
	}
}
