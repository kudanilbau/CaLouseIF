package repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

public class TransactionRepository {
	private DatabaseConnector db;
	
	public TransactionRepository() {
		db = DatabaseConnector.getInstance();
	}
	
	public void createPurchaseOrder(String user_id, String item_id) {
		String query = "INSERT INTO transaction(User_id, Item_id, transaction_id) VALUES(?, ? ,?)";
		try(PreparedStatement pstmt = db.getConnection().prepareStatement(query)) {
			pstmt.setString(1, user_id);
			pstmt.setString(2, item_id);
			pstmt.setString(3, UUID.randomUUID().toString());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
