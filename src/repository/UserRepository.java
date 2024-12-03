package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import model.User;
import util.PasswordEncrypt;

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

	public User getUserByUsernameAndPassword(String username, String password) throws Exception{
		User user = null;
		Connection con = db.getConnection();
		String query = "SELECT * FROM user WHERE username = ? AND password = ?";
		try (PreparedStatement pstmt = con.prepareStatement(query)) {
			String encryptedPassword = PasswordEncrypt.encrypt(password);
			System.out.println(encryptedPassword);
			pstmt.setString(1, username);
//			pstmt.setString(2, password);
			pstmt.setString(2, encryptedPassword);
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
		if(user == null) {
			throw new Exception("Incorrect username or password");			
		}
		return user;
	}
	
	public User getUserByUsername(String username){
		User user = null;
		Connection con = db.getConnection();
		String query = "SELECT * FROM user WHERE username = ?";
		try (PreparedStatement pstmt = con.prepareStatement(query)) {
			pstmt.setString(1, username);
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
	
	
	
	public User createUser(String username, String password, String phone_Number, String address) throws Exception {
//		check if user already exist
		User user = getUserByUsername(username);
		if(user != null) {
			throw new Exception("User already exist");
		}
		
//		encrypt password
		String encryptedPassword = PasswordEncrypt.encrypt(password);
		
//		generate user id
		UUID uuid = UUID.randomUUID();
		
		user = new User(uuid.toString(), username, encryptedPassword, phone_Number, address, "user");
		Connection con = db.getConnection();
		String query = "INSERT INTO user VALUES(?, ?, ?, ?, ?, ?)";
		try(PreparedStatement pstmt = con.prepareStatement(query)) {
			pstmt.setString(1, user.getUser_id());
			pstmt.setString(2, user.getUsername());
			pstmt.setString(3, user.getPassword());
			pstmt.setString(4, user.getPhone_Number());
			pstmt.setString(5, user.getAddress());
			pstmt.setString(6, user.getRole());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			user = null;
			e.printStackTrace();
		}
		if(user == null) {
			throw new Exception("Failed to register");
		}
		return user;
	}
}
