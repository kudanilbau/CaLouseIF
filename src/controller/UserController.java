package controller;

import model.User;

/**
 * Controller class responsible for handling user authentication and registration logic.
 * <p>
 * The {@code UserController} class acts as an intermediary between the user interface 
 * and the user-related functionality. It provides methods to log in, register a new 
 * user, and validate account details. The controller delegates the core logic to 
 * the {@code User} class methods and throws exceptions when necessary.
 * </p>
 */
public class UserController {
    /**
     * Login a user by validating their username and password.
     * <p>
     * This method delegates the login process to the {@code User.Login} method 
     * and returns the {@code User} object if the credentials are valid. 
     * If the credentials are invalid, an {@code IllegalArgumentException} is thrown.
     * </p>
     *
     * @param Username the username of the user attempting to log in
     * @param Password the password of the user attempting to log in
     * @return a {@code User} object representing the authenticated user
     * @throws IllegalArgumentException if the username or password is incorrect
     */
	public User Login(String Username, String Password) throws IllegalArgumentException{
		return User.Login(Username, Password);
	}
	
    /**
     * Registers a new user by validating the account details and creating the user.
     * <p>
     * This method delegates the registration process to the {@code User.Register} method 
     * and returns the newly created {@code User} object. If registration fails, 
     * an {@code Exception} is thrown.
     * </p>
     *
     * @param Username the username for the new user
     * @param Password the password for the new user
     * @param Phone_Number the phone number for the new user
     * @param Address the address for the new user
     * @param Role the role for the new user
     * @return a {@code User} object representing the newly registered user
     * @throws Exception if the registration fails
     */
	public User Register(String Username, String Password, String Phone_Number, String Address, String Role)
			throws Exception {
		return User.Register(Username, Password, Phone_Number, Address, Role);
	}
	
    /**
     * Validates the account details provided during user registration.
     * <p>
     * This method delegates the validation process to the {@code User.CheckAccountValidation} method. 
     * If any of the validation criteria are not met, an {@code IllegalArgumentException} is thrown.
     * </p>
     *
     * @param Username the username to be validated
     * @param Password the password to be validated
     * @param Phone_Number the phone number to be validated
     * @param Address the address to be validated
     * @param Role the role to be validated
     * @throws IllegalArgumentException if any of the account details fail validation
     */
	public void CheckAccountValidation(String Username, String Password, String Phone_Number, String Address,
			String Role) throws IllegalArgumentException {
		User.CheckAccountValidation(Username, Password, Phone_Number, Address, Role);
	}
}
