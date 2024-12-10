package model;

import javafx.collections.ObservableList;
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

	public static Transaction PurchaseItems(String User_id, String Item_id) {
		TransactionRepository transactionRepository = new TransactionRepository();
		return transactionRepository.createPurchaseOrder(User_id, Item_id);
	}

	public static ObservableList<Transaction> ViewHistory(String user_id) {
		TransactionRepository transactionRepository = new TransactionRepository();
		return transactionRepository.getTransactionHistory(user_id);
	}

	public static Transaction CreateTransaction(String Transaction_id) {
		TransactionRepository transactionRepository = new TransactionRepository();
		return transactionRepository.getTransactionById(Transaction_id);
	}

}
