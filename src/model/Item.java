package model;

public class Item {
	private String Item_id;
	private String Item_name;
	private String Item_size;
	private String Item_price;
	private String Item_category;
	private String Item_status;
	private String Item_wishlist;
	private String Item_offer_status;

	public Item(String item_id, String item_name, String item_size, String item_price, String item_category,
			String item_status, String item_wishlist, String item_offer_status) {
		super();
		Item_id = item_id;
		Item_name = item_name;
		Item_size = item_size;
		Item_price = item_price;
		Item_category = item_category;
		Item_status = item_status;
		Item_wishlist = item_wishlist;
		Item_offer_status = item_offer_status;
	}

	public String getItem_id() {
		return Item_id;
	}

	public void setItem_id(String item_id) {
		Item_id = item_id;
	}

	public String getItem_name() {
		return Item_name;
	}

	public void setItem_name(String item_name) {
		Item_name = item_name;
	}

	public String getItem_size() {
		return Item_size;
	}

	public void setItem_size(String item_size) {
		Item_size = item_size;
	}

	public String getItem_price() {
		return Item_price;
	}

	public void setItem_price(String item_price) {
		Item_price = item_price;
	}

	public String getItem_category() {
		return Item_category;
	}

	public void setItem_category(String item_category) {
		Item_category = item_category;
	}

	public String getItem_status() {
		return Item_status;
	}

	public void setItem_status(String item_status) {
		Item_status = item_status;
	}

	public String getItem_wishlist() {
		return Item_wishlist;
	}

	public void setItem_wishlist(String item_wishlist) {
		Item_wishlist = item_wishlist;
	}

	public String getItem_offer_status() {
		return Item_offer_status;
	}

	public void setItem_offer_status(String item_offer_status) {
		Item_offer_status = item_offer_status;
	}

	public void UploadItem(String Item_name, String Item_category, String Item_size, String Item_price) {
		throw new UnsupportedOperationException();
	}

	public void EditItem(String Item_name, String Item_category, String Item_size, String Item_price) {
		throw new UnsupportedOperationException();
	}

	public void DeleteItem(String Item_id) {
		throw new UnsupportedOperationException();
	}

	public void BrowseItem(String Item_name) {
		throw new UnsupportedOperationException();
	}

	public void VIewItem() {
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
