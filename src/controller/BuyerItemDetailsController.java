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
	
	public void handleOfferButton(Item item, String offer) {
		itemController.OfferPrice(item.getItem_id(), offer);
	}
	
	public void handleAddToWishlist(Item item) {
		wishlistController.AddWishlist(item.getItem_id(), UserSession.getInstance().getUser().getUser_id());
	}
}
