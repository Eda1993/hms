package hms.user.actions;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import hms.user.models.User;

public interface IUserActions {
	List<User> getAllUsers() throws SQLException;
	int insertUser(User user) throws SQLException;
	User login(String userName, String password, String type) throws SQLException;
	Map<String, List<String>> getResposes(int userId) throws SQLException;
}
