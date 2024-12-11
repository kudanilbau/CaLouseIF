package model;

import javafx.collections.ObservableList;
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

	public static ObservableList<Item> ViewWishlist(String User_id) {
		WishlistRepository wishlistRepository = new WishlistRepository();
		return wishlistRepository.getWishlistByUserId(User_id);
	}

	/**
	 * Adds an item to the user's wishlist.
	 * <p>
	 * This method creates a new wishlist entry for the specified item and user. It
	 * interacts with the WishlistRepository to store the item in the wishlist.
	 * </p>
	 * 
	 * @param item_id The ID of the item to be added to the wishlist.
	 * @param User_id The ID of the user who is adding the item to their wishlist.
	 */
	public static void AddWishlist(String item_id, String User_id) {
		WishlistRepository wishlistRepository = new WishlistRepository();
		wishlistRepository.createWishlist(item_id, User_id);

	}

	public static void RemoveWishlist(String Wishlist_id) {
		WishlistRepository wishlistRepository = new WishlistRepository();
		wishlistRepository.removeWishlistById(Wishlist_id);
	}
	
	public static Wishlist ViewWishlist(String User_id, String Item_id) {
		WishlistRepository wishlistRepository = new WishlistRepository();
		return wishlistRepository.getWishlistByUserIdAndItemId(User_id, Item_id);
	}

}
