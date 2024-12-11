package model;

import javafx.collections.ObservableMap;
import repository.TransactionRepository;

public class Transaction {
	private String User_id;
	private String Item_id;
	private String transaction_id;

	public Transaction(String user_id, String item_id, String transaction_id) {
		super();
		User_id = user_id;
		Item_id = item_id;
		this.transaction_id = transaction_id;
	}

	public String getUser_id() {
		return User_id;
	}

	public void setUser_id(String user_id) {
		User_id = user_id;
	}

	public String getItem_id() {
		return Item_id;
	}

	public void setItem_id(String item_id) {
		Item_id = item_id;
	}

	public String getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}

	/**
	 * Creates a new purchase transaction for a specified user and item.
	 * 
	 * @param User_id The ID of the user making the purchase.
	 * @param Item_id The ID of the item being purchased.
	 * @return A {@code Transaction} object representing the created transaction.
	 */
	public static Transaction PurchaseItems(String User_id, String Item_id) {
		TransactionRepository transactionRepository = new TransactionRepository();
		return transactionRepository.createTransaction(User_id, Item_id);
	}

	/**
	 * Retrieves the transaction history for a specific user.
	 * 
	 * @param user_id The ID of the user whose transaction history is being requested.
	 * @return An {@code ObservableList<Transaction, Item>} containing the user's transaction history.
	 */
	public static ObservableMap<Transaction, Item> ViewHistory(String user_id) {
		TransactionRepository transactionRepository = new TransactionRepository();
		return transactionRepository.getTransactionHistory(user_id);
	}

	/**
	 * Retrieves a specific transaction by its transaction ID.
	 * 
	 * @param Transaction_id The ID of the transaction to retrieve.
	 * @return A {@code Transaction} object representing the requested transaction, or {@code null} if no matching transaction is found.
	 */
	public static Transaction CreateTransaction(String Transaction_id) {
		TransactionRepository transactionRepository = new TransactionRepository();
		return transactionRepository.getTransactionById(Transaction_id);
	}

}
