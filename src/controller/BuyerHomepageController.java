package controller;

import model.Item;
import router.PageData;
import router.Router;

public class BuyerHomepageController {	
	private Router router;
	
	public BuyerHomepageController() {
		this.router = Router.getInstance();
	}
	public void handleItemSelection(Item item) {
		router.navigateTo(PageData.buyerItemDetailsPage(item));
	}
}
