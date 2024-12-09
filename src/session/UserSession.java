package session;

import model.User;

public class UserSession {
	private static UserSession userSession;
	private User user;
	
	private UserSession(User user) {
		this.user = user;
	}
	
    /**
     * Initializes the user session with the specified {@code User}.
     * <p>
     * If the session is already initialized, the existing instance will be returned.
     * </p>
     *
     * @param user the {@code User} object to initialize the session
     * @return the singleton instance of {@code UserSession}
     */
	public static UserSession initInstance(User user) {
		if(userSession == null) userSession = new UserSession(user);
		return userSession;
	}
	
    /**
     * Retrieves the singleton instance of the {@code UserSession}.
     *
     * @return the current instance of {@code UserSession}, or {@code null} if not initialized
     */
	public static UserSession getInstance() {
		return userSession;
	}
	
    /**
     * Retrieves the {@code User} associated with the current session.
     *
     * @return the {@code User} object representing the logged-in user
     */
	public User getUser() {
		return user;
	}
	
    /**
     * Logs out the current user.
     * <p>
     * This method resets the {@code user} field to {@code null}, effectively terminating the session.
     * </p>
     */
	public void logout() {
		this.user = null;
	}
}
