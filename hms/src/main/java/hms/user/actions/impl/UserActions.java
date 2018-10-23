package hms.user.actions.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import hms.commons.AbstractTable;
import hms.user.actions.IUserActions;
import hms.user.models.User;

public class UserActions extends AbstractTable implements IUserActions {

	@Override
	public List<User> getAllUsers() throws SQLException {
		List<User> users = new ArrayList<>();
		
		String sql ="select * from user";
		Statement statement = getConnection().prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery(sql);
		while (resultSet.next()) {
			String name = resultSet.getString("NAME");
			String lastname = resultSet.getString("LASTNAME");
			String username = resultSet.getString("USERNAME");
			String password = null;
			String email = resultSet.getString("EMAIL");
			String phoneNumber = resultSet.getString("PHONENUMBER");
			Date birthday = resultSet.getDate("BIRTHDAY");
			char gender = (char) resultSet.getInt("GENDER");
			
			User user = new User(name, lastname, username, password, email, phoneNumber, birthday, gender);
			
			users.add(user);
		}
		return users;
	}

}
