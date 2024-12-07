package controller;

import javafx.collections.ObservableList;
import model.Item;
import router.PageData;
import router.Router;

public class BuyerHomepageController {	
	private Router router;
	private ItemController itemController;
	
	public BuyerHomepageController(ItemController itemController) {
		this.router = Router.getInstance();
		this.itemController = itemController;
	}
	public void handleItemSelection(Item item) {
		router.navigateTo(PageData.buyerItemDetailsPage(item));
	}
	public ObservableList<Item> getAllItem() {
		return itemController.BrowseItem();
	}
}
