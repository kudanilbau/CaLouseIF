package controller;

import javafx.collections.ObservableList;
import model.Transaction;

public class TransactionController {

	/**
	 * Creates a new purchase transaction for a specific user and item.
	 *
	 * @param User_id the ID of the user making the purchase
	 * @param Item_id the ID of the item being purchased
	 * @return the created {@code Transaction} object
	 */
	public static Transaction PurchaseItems(String User_id, String Item_id) {
		return Transaction.PurchaseItems(User_id, Item_id);
	}

	/**
	 * Retrieves the transaction history for a specific user.
	 *
	 * @param user_id the ID of the user whose transaction history is being
	 *                retrieved
	 * @return an {@code ObservableList<Transaction>} containing the user's
	 *         transaction history
	 */
	public static ObservableList<Transaction> ViewHistory(String user_id) {
		return Transaction.ViewHistory(user_id);
	}

	/**
	 * Retrieves a specific transaction by its ID.
	 *
	 * @param Transaction_id the ID of the transaction to retrieve
	 * @return the {@code Transaction} object corresponding to the given ID, or
	 *         {@code null} if not found
	 */

	public static Transaction CreateTransaction(String Transaction_id) {
		return Transaction.CreateTransaction(Transaction_id);
	}
}
