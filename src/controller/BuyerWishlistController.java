package controller;

import javafx.collections.ObservableList;
import model.Item;
import model.User;
import model.Wishlist;
import session.UserSession;

public class BuyerWishlistController {
	public void handleRemoveButton(Item item) {
		User user = UserSession.getInstance().getUser();
		Wishlist wishlist= Wishlist.ViewWishlist(user.getUser_id(), item.getItem_id());
		Wishlist.RemoveWishlist(wishlist.getWhislist_id());
	}
	
	public ObservableList<Item> getWishlistItems(){
		User user = UserSession.getInstance().getUser();
		return Wishlist.ViewWishlist(user.getUser_id());
	}
	
	
}
