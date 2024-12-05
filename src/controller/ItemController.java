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
//	Asumsi sementara ini ndapetin semua data dari database
	public ObservableList<Item> BrowseItem() {
		return Item.BrowseItem();
	}
//	Asumsi sementara ini ngeliat salah satu item yang ada
	public void VIewItem(String Item_name) {
		throw new UnsupportedOperationException();
	}

	public void CheckItemValidation(String Item_name, String Item_category, String Item_size, String Item_price) {
		throw new UnsupportedOperationException();
	}

	public void ViewRequestedItem(String Item_id, String item_status) {
		throw new UnsupportedOperationException();
	}

	public void OfferPrice(String Item_id, String item_price) {
		throw new UnsupportedOperationException();
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
