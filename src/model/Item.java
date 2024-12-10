package model;

import javafx.collections.ObservableList;
import repository.ItemRepository;
import session.UserSession;

public class Item {
	private String Item_id;
	private String Item_seller_id;
	private String Item_name;
	private String Item_size;
	private String Item_price;
	private String Item_category;
	private String Item_status;
	private String Item_wishlist;
	private String Item_offer_status;

	public Item(String item_id, String item_seller_id, String item_name, String item_size, String item_price,
			String item_category, String item_status, String item_wishlist, String item_offer_status) {
		super();
		Item_id = item_id;
		Item_seller_id = item_seller_id;
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

	public String getItem_seller_id() {
		return Item_seller_id;
	}

	public void setItem_seller_id(String item_seller_id) {
		Item_seller_id = item_seller_id;
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

	/**
	 * Uploads a new item for the current user.
	 * 
	 * This method creates a new item entry with the specified details and
	 * associates it with the currently logged-in user (should be the seller). The
	 * new item is stored in the item repository.
	 * 
	 * @param Item_name     The name of the item.
	 * @param Item_category The category of the item.
	 * @param Item_size     The size of the item.
	 * @param Item_price    The price of the item.
	 */
	public static void UploadItem(String Item_name, String Item_category, String Item_size, String Item_price) {
		ItemRepository itemRepository = new ItemRepository();
		itemRepository.createNewItem(UserSession.getInstance().getUser().getUser_id(), Item_name, Item_category,
				Item_size, Item_price);
	}

	/**
	 * Edits the details of an existing item.
	 * 
	 * This method updates the details of an existing item with the specified ID in
	 * the item repository.
	 * 
	 * @param Item_id       The ID of the item to be updated.
	 * @param Item_name     The new name of the item.
	 * @param Item_category The new category of the item.
	 * @param Item_size     The new size of the item.
	 * @param Item_price    The new price of the item.
	 */
	public static void EditItem(String Item_id, String Item_name, String Item_category, String Item_size,
			String Item_price) {
		ItemRepository itemRepository = new ItemRepository();
		itemRepository.updateItem(Item_id, Item_name, Item_category, Item_size, Item_price);
	}

	/**
	 * Deletes an item.
	 * 
	 * This method removes an item with the specified ID from the item repository.
	 * 
	 * @param Item_id The ID of the item to be deleted.
	 */
	public static void DeleteItem(String Item_id) {
		ItemRepository itemRepository = new ItemRepository();
		itemRepository.deleteItem(Item_id);
	}

	/**
	 * Retrieves all approved items available for browsing.
	 * 
	 * This method fetches a list of all items that have been approved and are
	 * available for browsing by users. The list is returned as an ObservableList of
	 * Item objects.
	 * 
	 * @return An ObservableList of approved Item objects.
	 */
	public static ObservableList<Item> BrowseItem() {
		ItemRepository itemRepository = new ItemRepository();
		return itemRepository.getAllApprovedItem();
	}

	/**
	 * Retrieves an item by its name.
	 * 
	 * This method fetches an item from the repository based on the given item name.
	 * 
	 * @param Item_name The name of the item to retrieve.
	 * @return The {@code Item} object corresponding to the given name, or
	 *         {@code null} if no item is found.
	 */
	public static Item VIewItem(String Item_name) {
		ItemRepository itemRepository = new ItemRepository();
		return itemRepository.getItemByName(Item_name);
	}

	/**
	 * Validates the details of an item before performing operations.
	 * 
	 * This method checks whether the provided item details meet the required
	 * validation criteria:
	 * <ul>
	 * <li>The item name must not be blank and must be at least 3 characters
	 * long.</li>
	 * <li>The item category must not be blank and must be at least 3 characters
	 * long.</li>
	 * <li>The item size must not be blank.</li>
	 * <li>The item price must be a positive number greater than 0.</li>
	 * </ul>
	 * If any validation fails, an {@code IllegalArgumentException} is thrown with
	 * an appropriate error message.
	 * 
	 * @param Item_name     The name of the item to validate.
	 * @param Item_category The category of the item to validate.
	 * @param Item_size     The size of the item to validate.
	 * @param Item_price    The price of the item to validate.
	 * 
	 * @throws IllegalArgumentException If any validation criteria are not met.
	 */
	public static void CheckItemValidation(String Item_name, String Item_category, String Item_size, String Item_price)
			throws IllegalArgumentException {
		if (Item_name.isBlank() || Item_name.length() < 3) {
			throw new IllegalArgumentException("Item name atleast 3 characters long");
		}
		if (Item_category.isBlank() || Item_name.length() < 3) {
			throw new IllegalArgumentException("Item category atleast 3 characters long");
		}
		if (Item_size.isBlank()) {
			throw new IllegalArgumentException("Item size must be filled");
		}
		try {
			if (Item_price.isBlank()) {
				throw new IllegalArgumentException("Item price must be filled");
			}
			int price = Integer.parseInt(Item_price);
			if (price < 1) {
				throw new IllegalArgumentException("Item price must be more than 0");
			}
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("Item price must be a number");

		}
	}

	public static void ViewRequestedItem(String Item_id, String item_status) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Retrieves a list of items that are pending review by the admin.
	 * 
	 * This method fetches all items with a status of "waiting" from the database.
	 * 
	 * @return An {@code ObservableList<Item>} containing all items that are waiting
	 *         for review.
	 */
	public static ObservableList<Item> ViewRequestedItem() {
		ItemRepository itemRepository = new ItemRepository();
		return itemRepository.getAllRequestItems();
	}

	/**
	 * Submits a new offer price for an item.
	 * 
	 * This method allows a user to submit a new offer price for an item. It checks
	 * if the new offer is higher than the previous offer price. If not, it throws
	 * an IllegalArgumentException. The offer details (price and user ID) are then
	 * stored in the item repository.
	 * 
	 * @param Item_id    The ID of the item for which the offer is being made.
	 * @param item_price The new offer price for the item.
	 * 
	 * @throws IllegalArgumentException If the new offer price is less than or equal
	 *                                  to the previous offer price.
	 */
	public static void OfferPrice(String Item_id, String item_price) throws IllegalArgumentException {
		ItemRepository itemRepository = new ItemRepository();
		Item item = itemRepository.getItemById(Item_id);
		int prevOfferPrice = 0;
		String[] itemOfferStatus = item.getItem_offer_status().split(",");
		if (itemOfferStatus[0].equals("offer")) {
			prevOfferPrice = Integer.parseInt(itemOfferStatus[1]);
		}
		int currentOfferPrice = Integer.parseInt(item_price);
		if (currentOfferPrice <= prevOfferPrice) {
			throw new IllegalArgumentException("Offer must be more than previous offer");
		}
		String currentUserId = UserSession.getInstance().getUser().getUser_id();
		System.out.println(currentUserId);
		String offer = String.format("offer,%s,%s", item_price, currentUserId);
		itemRepository.updateOfferItem(Item_id, offer);
	}

	/**
	 * Accepts an offer made on an item.
	 * 
	 * This method processes an accepted offer by updating the item's status,
	 * recording a transaction, and updating the offer status. If the item does not
	 * have an offer, the method exits without changes.
	 * 
	 * @param Item_id           The ID of the item for which the offer is accepted.
	 * @param item_status_offer The current offer status in the format
	 *                          "offer,price,buyerId".
	 */
	public static void AcceptOffer(String Item_id, String item_status_offer) {
		ItemRepository itemRepository = new ItemRepository();
		String[] itemStatus = item_status_offer.split(",");
//		return if there's isn't an offer
		if (!itemStatus[0].equals("offer")) {
			return;
		}
		String offerPrice = itemStatus[1];
		String buyerId = itemStatus[2];

		itemRepository.updateAcceptOffer(Item_id, offerPrice);

		Transaction.PurchaseItems(buyerId, Item_id);
//		Get current user (should be the current seller)
		User user = UserSession.getInstance().getUser();
//		update table because the item should disappear from table
		itemRepository.getAllOfferItem(user.getUser_id());

	}

	/**
	 * Declines an offer made on an item.
	 * 
	 * This method resets the offer status of an item to indicate no offers are
	 * currently available.
	 * 
	 * @param Item_id The ID of the item for which the offer is declined.
	 */
	public static void DeclineOffer(String Item_id) {
		ItemRepository itemRepository = new ItemRepository();
		itemRepository.updateOfferItem(Item_id, "no_offer");
	}

	/**
	 * Approves an item for listing.
	 * 
	 * This method updates the status of an item to "approved" for visibility or use
	 * in the system.
	 * 
	 * @param Item_id The ID of the item to approve.
	 */
	public static void ApproveItem(String Item_id) {
		ItemRepository itemRepository = new ItemRepository();
		String item_status = "approved";
		itemRepository.updateItemStatus(Item_id, item_status);
	}

	/**
	 * Declines an item with a specified reason.
	 * 
	 * This method updates the status of an item to "declined" and records the
	 * reason for declination.
	 * 
	 * @param Item_id The ID of the item to decline.
	 * @param reason  The reason for declining the item.
	 */
	public static void DeclineItem(String Item_id, String reason) {
		ItemRepository itemRepository = new ItemRepository();
		String item_status = String.format("declined,%s", reason);
		itemRepository.updateItemStatus(Item_id, item_status);
	}

	/**
	 * Retrieves an accepted item by its ID.
	 * 
	 * This method fetches an item if its status starts with "accepted". Otherwise,
	 * it returns {@code null}.
	 * 
	 * @param Item_id The ID of the item to retrieve.
	 * @return The {@code Item} object if the status is "accepted"; otherwise,
	 *         {@code null}.
	 */
	public static Item VIewAcceptedItem(String Item_id) {
		ItemRepository itemRepository = new ItemRepository();
		Item item = itemRepository.getItemById(Item_id);
		String itemStatus = item.getItem_status();
		if (!itemStatus.startsWith("accepted")) {
			return null;
		}
		return item;
	}

	/**
	 * Retrieves items that have been offered to the seller.
	 * 
	 * This method fetches a list of items with offers made by buyers, showing
	 * details such as the item's name, category, size, initial price, and the
	 * offered price.
	 * 
	 * @param User_id The ID of the seller to view offered items.
	 * @return An {@code ObservableList<Item>} containing items with buyer offers.
	 */
	public static ObservableList<Item> ViewOfferItem(String User_id) {
		/*
		 * As a seller, they could view items that has been offered by the buyers, it
		 * will display the item’s name, category, size, initial price and also the
		 * offered price.
		 */
		ItemRepository itemRepository = new ItemRepository();
		return itemRepository.getAllOfferItem(User_id);
	}
}
