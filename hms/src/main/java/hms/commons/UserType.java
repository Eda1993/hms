package hms.commons;

public enum UserType {
	ADMIN("admin"),
	USER("user");
	
	private String user;

	private UserType(String user) {
		this.user = user;
	}

	public String getUser() {
		return user;
	}
	
	@Override
	public String toString() {
		return getUser();
	}
}
