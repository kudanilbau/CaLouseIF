package controller;

import model.Item;

public class BuyerItemDetailsController {
	private ItemController itemController;
	
	public BuyerItemDetailsController(ItemController itemController) {
		this.itemController = itemController;
	}
	
	public void handlePurchaseButton(Item item) {
		
	}
	
	public void handleOfferButton(Item item, String offer) {
		itemController.OfferPrice(item.getItem_id(), offer);
	}
	
	public void handleAddToWishlist(Item item) {
		
	}
}
