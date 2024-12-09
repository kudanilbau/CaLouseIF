package model;

import javafx.collections.ObservableList;
import repository.ItemRepository;
import session.UserSession;

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

	/**
	 * Retrieves all approved items available for browsing.
	 * 
	 * This method fetches a list of all items that have been approved and are available for browsing 
	 * by users. The list is returned as an ObservableList of Item objects.
	 * 
	 * @return An ObservableList of approved Item objects.
	 */
	public static ObservableList<Item> BrowseItem() {
		ItemRepository itemRepository = new ItemRepository();
		return itemRepository.getAllApprovedItem();
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
	 * Submits a new offer price for an item.
	 * 
	 * This method allows a user to submit a new offer price for an item. It checks if the new offer 
	 * is higher than the previous offer price. If not, it throws an IllegalArgumentException. 
	 * The offer details (price and user ID) are then stored in the item repository.
	 * 
	 * @param Item_id The ID of the item for which the offer is being made.
	 * @param item_price The new offer price for the item.
	 * 
	 * @throws IllegalArgumentException If the new offer price is less than or equal to the previous offer price.
	 */
	public static void OfferPrice(String Item_id, String item_price) throws IllegalArgumentException{
		ItemRepository itemRepository = new ItemRepository();
		Item item = itemRepository.getItemById(Item_id);
		int prevOfferPrice = 0;
		String[]itemOfferStatus = item.getItem_offer_status().split(",");
		if(itemOfferStatus[0].equals("offer")) {
			prevOfferPrice = Integer.parseInt(itemOfferStatus[1]);
		}
		int currentOfferPrice = Integer.parseInt(item_price);
		if(currentOfferPrice <= prevOfferPrice) {
			throw new IllegalArgumentException("Offer must be more than previous offer");
		}
		String currentUserId = UserSession.getInstance().getUser().getUser_id();
		System.out.println(currentUserId);
		String offer = String.format("offer,%s,%s", item_price, currentUserId);
		itemRepository.updateOfferItem(Item_id, offer);
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
