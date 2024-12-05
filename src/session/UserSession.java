package session;

import model.User;

public class UserSession {
	private static UserSession userSession;
	private User user;
	
	private UserSession(User user) {
		this.user = user;
	}
	
	public static UserSession initInstance(User user) {
		if(userSession == null) userSession = new UserSession(user);
		return userSession;
	}
	
	public static UserSession getInstance() {
		return userSession;
	}
	
	public User getUser() {
		return user;
	}
	
	public void logout() {
		this.user = null;
	}
}
