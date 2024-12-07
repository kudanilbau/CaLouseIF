package controller;

import router.PageData;
import router.Router;

public class BuyerHomepageController {
	private Router router;
	
	public BuyerHomepageController() {
		router = Router.getInstance();
	}
	
	public void handleWishlistButton() {
		
	}
	
	public void handlePurchaseHistoryButton() {
		
	}
	
	public void handlePurchaseButton() {
		
	}
	
	public void handleHomepageButton() {
		router.navigateTo(PageData.buyerHomePage());
	}
}
