package hms.user.actions.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import hms.commons.AbstractTable;
import hms.user.models.User;

public class AdminController extends AbstractTable {

	public String login(User user) throws SQLException {

		String sql = "select email,password from user where USERNAME='" + user.getUsername() + "' and PASSWORD='"
				+ user.getPassword() + "' and IS_ADMIN=1";
		Statement statement = getConnection().prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery(sql);

		if (resultSet.next()) {
			return "sucess";
		} else {
			return "wrong";
		}

	}
}
