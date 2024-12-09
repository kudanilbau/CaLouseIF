package controller;

import model.Item;
import session.UserSession;

public class BuyerItemDetailsController {
	private ItemController itemController;
	private WishlistController wishlistController;
	
	public BuyerItemDetailsController(ItemController itemController, WishlistController wishlistController) {
		this.itemController = itemController;
		this.wishlistController = wishlistController;
	}
	
	public void handlePurchaseButton(Item item) {
		
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
	public void handleAddToWishlist(Item item) {
		wishlistController.AddWishlist(item.getItem_id(), UserSession.getInstance().getUser().getUser_id());
	}
}
