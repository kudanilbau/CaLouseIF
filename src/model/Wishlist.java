package model;

import repository.WishlistRepository;

public class Wishlist {
	private String Whislist_id;
	private String Item_id;
	private String User_id;
	public Wishlist(String whislist_id, String item_id, String user_id) {
		super();
		Whislist_id = whislist_id;
		Item_id = item_id;
		User_id = user_id;
	}
	public String getWhislist_id() {
		return Whislist_id;
	}
	public void setWhislist_id(String whislist_id) {
		Whislist_id = whislist_id;
	}
	public String getItem_id() {
		return Item_id;
	}
	public void setItem_id(String item_id) {
		Item_id = item_id;
	}
	public String getUser_id() {
		return User_id;
	}
	public void setUser_id(String user_id) {
		User_id = user_id;
	}
	public static void ViewWishlist(String Wishlist_id, String User_id) {
		throw new UnsupportedOperationException();
	}
	public static void AddWishlist(String item_id, String User_id) {
		WishlistRepository wishlistRepository = new WishlistRepository();
		wishlistRepository.createWishlist(item_id, User_id);
		
	}
	public static void RemoveWishlist(String Wishlist_id) {
		throw new UnsupportedOperationException();
	}
	
}
