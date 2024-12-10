package controller;

import javafx.collections.ObservableList;
import model.Item;

public class ItemController {
	/**
	 * Uploads a new item after validating its details.
	 *
	 * @param Item_name     the name of the item
	 * @param Item_category the category of the item
	 * @param Item_size     the size of the item
	 * @param Item_price    the price of the item
	 * @throws IllegalArgumentException if any validation fails
	 */
	public void UploadItem(String Item_name, String Item_category, String Item_size, String Item_price)
			throws IllegalArgumentException {
		CheckItemValidation(Item_name, Item_category, Item_size, Item_price);
		Item.UploadItem(Item_name, Item_category, Item_size, Item_price);
	}

	/**
	 * Updates the details of an existing item after validation.
	 *
	 * @param Item_name     the updated name of the item
	 * @param Item_category the updated category of the item
	 * @param Item_size     the updated size of the item
	 * @param Item_price    the updated price of the item
	 * @throws IllegalArgumentException if any validation fails
	 */
	public void EditItem(String Item_name, String Item_category, String Item_size, String Item_price)
			throws IllegalArgumentException {
		CheckItemValidation(Item_name, Item_category, Item_size, Item_price);
		Item.EditItem(Item_price, Item_name, Item_category, Item_size, Item_price);
	}

	/**
	 * Deletes an item by its ID.
	 *
	 * @param Item_id the ID of the item to delete
	 */
	public void DeleteItem(String Item_id) {
		Item.DeleteItem(Item_id);
	}

	/**
	 * Retrieves a list of all available approved items.
	 *
	 * @return an {@code ObservableList<Item>} containing all available approved
	 *         items
	 */
	public ObservableList<Item> BrowseItem() {
		return Item.BrowseItem();
	}

	/**
	 * Views an item by its name.
	 *
	 * @param Item_name the name of the item to view
	 * @return the {@code Item} object if found, or {@code null} otherwise
	 */
	public Item VIewItem(String Item_name) {
		return Item.VIewItem(Item_name);
	}

	/**
	 * Validates the details of an item.
	 *
	 * @param Item_name     the name of the item
	 * @param Item_category the category of the item
	 * @param Item_size     the size of the item
	 * @param Item_price    the price of the item
	 * @throws IllegalArgumentException if any validation fails
	 */
	public void CheckItemValidation(String Item_name, String Item_category, String Item_size, String Item_price)
			throws IllegalArgumentException {
		Item.CheckItemValidation(Item_name, Item_category, Item_size, Item_price);
	}

	/**
	 * Views all requested items.
	 *
	 * @param Item_id     the ID of the item
	 * @param item_status the status of the item
	 * @return an {@code ObservableList<Item>} containing requested items
	 */
	public ObservableList<Item> ViewRequestedItem() {
		return Item.ViewRequestedItem();
	}

	/**
	 * Submits an offer for the specified item.
	 *
	 * @param Item_id    the unique identifier of the item
	 * @param item_price the offered price for the item, as a {@code String}
	 * @throws IllegalArgumentException if the offer price is empty, less than 1, or
	 *                                  not a valid numeric value
	 */
	public void OfferPrice(String Item_id, String item_price) throws IllegalArgumentException {
		if (item_price.isEmpty()) {
			throw new IllegalArgumentException("Offer cannot be empty");
		}
		try {
			if (Integer.parseInt(item_price) < 1) {
				throw new IllegalArgumentException("Offer must be more than zero");
			}
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("Offer must be a number");
		}
		Item.OfferPrice(Item_id, item_price);
	}

	/**
	 * Accepts an offer for the specified item.
	 *
	 * @param Item_id           the unique identifier of the item
	 * @param Item_status_offer the status of the offer, including details
	 */
	public void AcceptOffer(String Item_id, String Item_status_offer) {
		Item.AcceptOffer(Item_id, Item_status_offer);
	}

	/**
	 * Declines an offer for the specified item.
	 *
	 * @param Item_id the unique identifier of the item
	 */
	public void DeclineOffer(String Item_id) {
		Item.DeclineOffer(Item_id);
	}

	/**
	 * Approves an item for listing.
	 *
	 * @param Item_id the ID of the item to approve
	 */
	public void ApproveItem(String Item_id) {
		Item.ApproveItem(Item_id);
	}

	/**
	 * Declines an item with a specified reason.
	 *
	 * @param Item_id the ID of the item to decline
	 * @param reason  the reason for declining the item
	 * @throws IllegalArgumentException if the reason is empty
	 */
	public void DeclineItem(String Item_id, String reason) throws IllegalArgumentException{
		if(reason.isBlank()) {
			throw new IllegalArgumentException("Reason cannot be empty");
		}
		Item.DeclineItem(Item_id, reason);
	}

	/**
	 * Views an accepted item by its ID.
	 *
	 * @param Item_id the ID of the item to view
	 * @return the {@code Item} object if found, or {@code null} otherwise
	 */
	public Item VIewAcceptedItem(String Item_id) {
		return Item.VIewAcceptedItem(Item_id);
	}

	/**
	 * Views items offered to the specified user.
	 *
	 * @param User_id the ID of the user
	 * @return an {@code ObservableList<Item>} containing items offered to the user
	 */
	public ObservableList<Item> ViewOfferItem(String User_id) {
		return Item.ViewOfferItem(User_id);
	}
}
