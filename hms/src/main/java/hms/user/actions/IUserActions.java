package hms.user.actions;

import java.sql.SQLException;
import java.util.List;

import hms.user.models.User;

public interface IUserActions {
	List<User> getAllUsers() throws SQLException;
}
