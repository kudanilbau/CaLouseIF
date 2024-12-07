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
