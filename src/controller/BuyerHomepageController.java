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
	
    /**
     * Handles the selection of an item by the buyer.
     *
     * @param item the selected {@code Item} to display details for
     */
	public void handleItemSelection(Item item) {
		router.navigateTo(PageData.buyerItemDetailsPage(item));
	}
    /**
     * Retrieves all available approved items for display on the buyer's homepage.
     *
     * @return an {@code ObservableList} of {@code Item} objects representing all available approved items
     */
	public ObservableList<Item> getAllApprovedItem() {
		return itemController.BrowseItem();
	}
}
