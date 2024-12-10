package repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Transaction;

public class TransactionRepository {
	private DatabaseConnector db;
	private static ObservableList<Transaction> transactionList;
	
	public TransactionRepository() {
		db = DatabaseConnector.getInstance();
		if(transactionList == null) {
			transactionList = FXCollections.observableArrayList();
		}
	}
	
	private Transaction createTransactionFromResultSet(ResultSet rs) throws SQLException{
		return new Transaction(rs.getString("User_id"), rs.getString("Item_id"), rs.getString("transaction_id"));
	}
	
	public Transaction createPurchaseOrder(String user_id, String item_id) {
		String query = "INSERT INTO transaction(User_id, Item_id, transaction_id) VALUES(?, ? ,?)";
		Transaction transaction = new Transaction(user_id, item_id, UUID.randomUUID().toString());
		try(PreparedStatement pstmt = db.getConnection().prepareStatement(query)) {
			pstmt.setString(1, transaction.getUser_id());
			pstmt.setString(2, transaction.getItem_id());
			pstmt.setString(3, transaction.getTransaction_id());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return transaction;
	}
	
	public ObservableList<Transaction> getTransactionHistory(String user_id){
		String query = "SELECT * FROM transaction WHERE User_id = ?";
		try(PreparedStatement pstmt = db.getConnection().prepareStatement(query)) {
			pstmt.setString(1, user_id);
			try(ResultSet rs = pstmt.executeQuery()){
				while(rs.next()) {
					transactionList.add(createTransactionFromResultSet(rs));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return transactionList;
	}

	public Transaction getTransactionById(String transaction_id) {
		String query = "SELECT * FROM transaction WHERE transaction_id = ?";
		Transaction transaction = null;
		try(PreparedStatement pstmt = db.getConnection().prepareStatement(query)) {
			pstmt.setString(1, transaction_id);
			try(ResultSet rs = pstmt.executeQuery()){
				transaction = createTransactionFromResultSet(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return transaction;
	}
}
