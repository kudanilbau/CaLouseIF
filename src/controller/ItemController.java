package controller;

import javafx.collections.ObservableList;
import model.Item;

public class ItemController {
	public void UploadItem(String Item_name, String Item_category, String Item_size, String Item_price) {
		throw new UnsupportedOperationException();
	}

	public void EditItem(String Item_name, String Item_category, String Item_size, String Item_price) {
		throw new UnsupportedOperationException();
	}

	public void DeleteItem(String Item_id) {
		throw new UnsupportedOperationException();
	}

	/**
     * Retrieves a list of all available approved items.
     *
     * @return an {@code ObservableList<Item>} containing all available approved items
     */
	public ObservableList<Item> BrowseItem() {
		return Item.BrowseItem();
	}

	public void VIewItem(String Item_name) {
		throw new UnsupportedOperationException();
	}

	public void CheckItemValidation(String Item_name, String Item_category, String Item_size, String Item_price) {
		throw new UnsupportedOperationException();
	}

	public void ViewRequestedItem(String Item_id, String item_status) {
		throw new UnsupportedOperationException();
	}

    /**
     * Submits an offer for the specified item.
     * <p>
     * This method validates the offer price and, if valid, delegates the operation
     * to the {@code Item} model for processing.
     * </p>
     *
     * @param Item_id   the unique identifier of the item
     * @param item_price the offered price for the item, as a {@code String}
     * @throws IllegalArgumentException if the offer price is empty, less than 1,
     *                                  or not a valid numeric value
     */
	public void OfferPrice(String Item_id, String item_price) throws IllegalArgumentException{
		if(item_price.isEmpty()) {
			throw new IllegalArgumentException("Offer cannot be empty");
		}
		try {
			if(Integer.parseInt(item_price) < 1) {
				throw new IllegalArgumentException("Offer must be more than zero");
			}			
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("Offer must be a number");
		}
		Item.OfferPrice(Item_id, item_price);
	}

	public void AcceptOffer(String Item_id) {
		throw new UnsupportedOperationException();
	}

	public void DeclineOffer(String Item_id) {
		throw new UnsupportedOperationException();
	}

	public void ApproveItem(String Item_id) {
		throw new UnsupportedOperationException();
	}

	public void DeclineItem(String Item_id) {
		throw new UnsupportedOperationException();
	}

	public void VIewAcceptedItem(String Item_id) {
		throw new UnsupportedOperationException();
	}

	public void ViewOfferItem(String User_id) {
		throw new UnsupportedOperationException();
	}
}
