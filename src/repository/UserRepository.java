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

	/**
	 * Retrieves a {@code User} object based on the provided user id
	 *
	 * @param userId the ID of the user
	 * @return a {@code User} object representing the user with the matching
	 *         id
	 * @see User
	 */
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

	/**
	 * Retrieves a {@code User} object based on the provided username and password.
	 * <p>
	 * This method connects to the database, encrypts the provided password, and
	 * queries the user table for a match. If a user is found, a {@code User} object
	 * is created and returned. If no match is found, an
	 * {@code InvalidParameterException} is thrown.
	 * </p>
	 *
	 * @param username the username of the user to retrieve
	 * @param password the plaintext password of the user to retrieve
	 * @return a {@code User} object representing the user with the matching
	 *         credentials
	 * @throws InvalidParameterException if the username or password is incorrect
	 * @see PasswordEncrypt#encrypt(String)
	 * @see User
	 */

	public User getUserByUsernameAndPassword(String username, String password) throws IllegalArgumentException {
		User user = null;
		Connection con = db.getConnection();
		String query = "SELECT * FROM user WHERE username = ? AND password = ?";
		try (PreparedStatement pstmt = con.prepareStatement(query)) {
			String encryptedPassword = PasswordEncrypt.encrypt(password);
			pstmt.setString(1, username);
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
		if (user == null) {
			throw new IllegalArgumentException("Incorrect username or password");
		}
		return user;
	}

	/**
	 * Retrieves a {@code User} object based on the provided username.
	 * <p>
	 * This method connects to the database and queries the user table for a user
	 * with the specified username. If a user is found, a {@code User} object is
	 * created and returned. If no user is found, the method returns {@code null}.
	 * </p>
	 *
	 * @param username the username of the user to retrieve
	 * @return a {@code User} object representing the user with the specified
	 *         username, or {@code null} if no user is found
	 * @see User
	 */

	public User getUserByUsername(String username) {
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

	/**
	 * Creates a new {@code User} and stores it in the database.
	 * <p>
	 * This method first checks if a user with the given username already exists. If
	 * the user exists, an {@code Exception} is thrown. Otherwise, the password is
	 * encrypted, a unique user ID is generated, and the new user is inserted into
	 * the database. If the insertion fails, an {@code Exception} is thrown.
	 * </p>
	 *
	 * @param username     the username for the new user
	 * @param password     the plaintext password for the new user
	 * @param phone_Number the phone number of the new user
	 * @param address      the address of the new user
	 * @param role         the role of the new user
	 * @return the created {@code User} object
	 * @throws Exception if the username already exists or if the user cannot be
	 *                   registered
	 * @see #getUserByUsername(String)
	 * @see PasswordEncrypt#encrypt(String)
	 * @see User
	 */

	public User createUser(String username, String password, String phone_Number, String address, String role)
			throws Exception {
//		check if user already exist
		User user = getUserByUsername(username);
		if (user != null)
			throw new Exception("User already exist");

//		encrypt password
		String encryptedPassword = PasswordEncrypt.encrypt(password);

//		generate user id
		UUID uuid = UUID.randomUUID();

		user = new User(uuid.toString(), username, encryptedPassword, phone_Number, address, role);
		Connection con = db.getConnection();
		String query = "INSERT INTO user VALUES(?, ?, ?, ?, ?, ?)";
		try (PreparedStatement pstmt = con.prepareStatement(query)) {
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
		if (user == null) {
			throw new Exception("Failed to register");
		}
		return user;
	}
}
