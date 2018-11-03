package hms.user.actions;

import java.sql.SQLException;
import java.util.List;

import hms.user.models.User;

public interface IUserActions {
	List<User> getAllUsers() throws SQLException;
	int insertUser(User user) throws SQLException;
	User login(String userName, String password, String type) throws SQLException;
	void requestRoom(int id) throws SQLException;
	
}
