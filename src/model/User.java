package model;

import repository.UserRepository;

public class User {
	private String User_id;
	private String Username;
	private String Password;
	private String Phone_Number;
	private String Address;
	private String Role;

	public User(String user_id, String username, String password, String phone_Number, String address, String role) {
		super();
		User_id = user_id;
		Username = username;
		Password = password;
		Phone_Number = phone_Number;
		Address = address;
		Role = role;
	}

	public String getUser_id() {
		return User_id;
	}

	public void setUser_id(String user_id) {
		User_id = user_id;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getPhone_Number() {
		return Phone_Number;
	}

	public void setPhone_Number(String phone_Number) {
		Phone_Number = phone_Number;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
	}
	
	private static boolean isValidUsername(String username) {
		if (username.length() < 3)
			return false;
		return true;
	}

	private static boolean isValidPassword(String password) {
		if (password.length() < 8)
			return false;

		final String SPECIAL_CHARACTER = "!@#$%^&*";
		for (int i = 0; i < password.length(); i++) {
			if (SPECIAL_CHARACTER.contains(String.valueOf(password.charAt(i)))) {
				return true;
			}
		}
		return false;
	}

	private static boolean isValidPhoneNumber(String phoneNumber) {
		if (!phoneNumber.startsWith("+62") || phoneNumber.length() != 12)
			return false;
//		check only the character after +62
		for (int i = 3; i < phoneNumber.length(); i++) {
			if (!Character.isDigit(phoneNumber.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	private static boolean isValidAddress(String address) {
		if (address.isEmpty())
			return false;
		return true;
	}

	private static boolean isValidRole(String role) {
		if (!role.equals("buyer") && !role.equals("seller"))
			return false;
		return true;
	}

	/**
	 * Authenticates a user by checking their username and password.
	 * <p>
	 * This method checks if the provided username and password are non-empty. If 
	 * either is empty, it throws an {@code IllegalArgumentException}. If both fields 
	 * are filled, it attempts to retrieve a {@code User} object from the repository 
	 * by matching the username and password. If the credentials are valid, the 
	 * corresponding user is returned. Otherwise, an exception is thrown by the 
	 * repository method.
	 * </p>
	 *
	 * @param Username the username entered by the user
	 * @param Password the password entered by the user
	 * @return a {@code User} object representing the authenticated user
	 * @throws IllegalArgumentException if either the username or password is empty
	 * @throws IllegalArgumentException if the username and password combination is incorrect
	 */
	public static User Login(String Username, String Password) throws IllegalArgumentException{
//		check if username or password is empty
		if(Username.isEmpty() || Password.isEmpty()) throw new IllegalArgumentException("All field must be filled");
		
		UserRepository userRepository = new UserRepository();
		return userRepository.getUserByUsernameAndPassword(Username, Password);
	}

	/**
	 * Registers a new user by validating the provided account details and 
	 * creating a new user in the repository.
	 * <p>
	 * This method first validates the input fields such as username, password, 
	 * phone number, address, and role by calling the {@code CheckAccountValidation} 
	 * method. If the validation passes, it proceeds to create a new user by 
	 * calling the {@code createUser} method in the {@code UserRepository}. 
	 * If the user is successfully created, the {@code User} object is returned.
	 * </p>
	 *
	 * @param Username the username for the new user
	 * @param Password the password for the new user
	 * @param Phone_Number the phone number for the new user
	 * @param Address the address for the new user
	 * @param Role the role for the new user
	 * @return a {@code User} object representing the newly registered user
	 * @throws Exception if any validation fails or user creation encounters an error
	 */
	public static User Register(String Username, String Password, String Phone_Number, String Address, String Role)
			throws Exception {
		UserRepository userRepository = new UserRepository();
		User user = userRepository.createUser(Username, Password, Phone_Number, Address, Role);
		return user;
	}
	
	/**
	 * Validates the account details provided during user registration.
	 * <p>
	 * This method checks if the provided username, password, phone number, 
	 * address, and role meet specific validation criteria. If any of the criteria 
	 * are not met, it throws an {@code IllegalArgumentException} with a relevant 
	 * error message indicating the issue.
	 * </p>
	 *
	 * @param Username the username to be validated
	 * @param Password the password to be validated
	 * @param Phone_Number the phone number to be validated
	 * @param Address the address to be validated
	 * @param Role the role to be validated
	 * @throws IllegalArgumentException if any of the input fields fail to meet validation criteria
	 */
	public static void CheckAccountValidation(String Username, String Password, String Phone_Number, String Address, String Role) {
		if (!isValidUsername(Username))
			throw new IllegalArgumentException("Username must be more than 3 characters");

		if (!isValidPassword(Password))
			throw new IllegalArgumentException(
					"Password must be more than 8 characters and include special characters (!, @, #, $, %, ^, &, *)");

		if (!isValidPhoneNumber(Phone_Number))
			throw new IllegalArgumentException("Phone number must contain +62 and 10 numbers long");

		if (!isValidAddress(Address))
			throw new IllegalArgumentException("Address must be filled");

		if (!isValidRole(Role))
			throw new IllegalArgumentException("Role must be selected");
	}
}
