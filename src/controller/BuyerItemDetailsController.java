package controller;

import model.Item;
import model.User;
import model.Wishlist;
import session.UserSession;

public class BuyerItemDetailsController {
	private ItemController itemController;
	private WishlistController wishlistController;
	private TransactionController transactionController;
	
	public BuyerItemDetailsController(ItemController itemController, WishlistController wishlistController, TransactionController transactionController) {
		this.itemController = itemController;
		this.wishlistController = wishlistController;
		this.transactionController = transactionController;
	}
	
	public void handlePurchaseButton(Item item) throws IllegalArgumentException {
		User user = UserSession.getInstance().getUser();
		item = Item.VIewAcceptedItem(item.getItem_id());
//		if item status is not accepted, then it have already been bought
		if(item == null) {
			throw new IllegalArgumentException("Product sold");
		}
		transactionController.PurchaseItems(user.getUser_id(), item.getItem_id());
		Wishlist wishlist = wishlistController.ViewWishlist(user.getUser_id(), item.getItem_id());
		if(wishlist != null) {
			Wishlist.RemoveWishlist(wishlist.getWhislist_id());
		}
	}
	
    /**
     * Handles the action of making an offer on an item.
     *
     * @param item  the {@code Item} for which an offer is being made
     * @param offer the offer price as a {@code String}
     */
	public void handleOfferButton(Item item, String offer) {
		itemController.OfferPrice(item.getItem_id(), offer);
	}
	
    /**
     * Handles the action of adding an item to the wishlist.
     * <p>
     * This method uses the {@code WishlistController} to add the specified item to the wishlist
     * of the currently logged-in user, as determined by the {@code UserSession}.
     * </p>
     *
     * @param item the {@code Item} to be added to the wishlist
     */
	public void handleAddToWishlist(Item item) throws IllegalArgumentException{
		wishlistController.AddWishlist(item.getItem_id(), UserSession.getInstance().getUser().getUser_id());
	}
}
