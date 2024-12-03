package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class UserRepository {
	private DatabaseConnector db;

	public UserRepository() {
		db = DatabaseConnector.getInstance();
	}

	public User getUserById(String userId) {
		User user = null;
		Connection con = db.getConnection();
		try (PreparedStatement pstmt = con.prepareStatement("SELECT * FROM user WHERE user_id = ?")) {
			pstmt.setString(1, userId);
			try (ResultSet rs = pstmt.executeQuery()) {
				String User_id = rs.getString(1);
				String Username = rs.getString(2);
				String Password = rs.getString(3);
				String Phone_number = rs.getString(4);
				String Address = rs.getString(5);
				String Role = rs.getString(6);

				user = new User(User_id, Username, Password, Phone_number, Address, Role);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public User getUserByUsernameAndPassword(String username, String password) {
		User user = null;
		Connection con = db.getConnection();
		try (PreparedStatement pstmt = con.prepareStatement("SELECT * FROM user WHERE username = ? AND password = ?")) {
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			try (ResultSet rs = pstmt.executeQuery()) {
				// check if result has data
				if (rs.isBeforeFirst()) {
					rs.next();
					String User_id = rs.getString(1);
					String Username = rs.getString(2);
					String Password = rs.getString(3);
					String Phone_number = rs.getString(4);
					String Address = rs.getString(5);
					String Role = rs.getString(6);
					user = new User(User_id, Username, Password, Phone_number, Address, Role);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
}
