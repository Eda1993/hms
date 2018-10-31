package hms.user.actions.impl;

import static hms.commons.UserType.ADMIN;

import java.sql.PreparedStatement;
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

		String sql = "select * from user WHERE IS_ADMIN = 0";
		Statement statement = getPreparedStatement(sql);
		ResultSet resultSet = statement.executeQuery(sql);
		while (resultSet.next()) {
			User user = createUser(resultSet);
			users.add(user);
		}
		return users;
	}

	@Override
	public int insertUser(User user) throws SQLException {
		String sql = "insert into user (NAME, LASTNAME, USERNAME, PASSWORD, EMAIL, PHONE_NUMBER, BIRTHDAY, GENDER, CREATED_AT, IS_ADMIN, PENDING_REQUEST) values "
				+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		PreparedStatement statement = getPreparedStatement(sql);

		statement.setString(1, user.getName());
		statement.setString(2, user.getLastname());
		statement.setString(3, user.getUsername());
		statement.setString(4, user.getPassword());
		statement.setString(5, user.getEmail());
		statement.setString(6, user.getPhoneNumber());
		statement.setDate(7, new java.sql.Date(user.getBirthday().getTime()));
		statement.setString(8, String.valueOf(user.getGender()));
		statement.setTimestamp(9, java.sql.Timestamp.from(java.time.Instant.now()));
		statement.setInt(10, 0);
		statement.setInt(11, 0);

		return statement.executeUpdate();
	}

	@Override
	public User login(String userName, String password, String type) throws SQLException {
		String sql = "select * from user " + "where userName = ? " + "and password = ? ";

		if (type.equals(ADMIN.toString())) {
			sql += "and IS_ADMIN = 1";
		} else {
			sql += "and IS_ADMIN = 0";
		}

		PreparedStatement statement = getPreparedStatement(sql);
		statement.setString(1, userName);
		statement.setString(2, password);

		ResultSet resultSet = statement.executeQuery();

		if (resultSet.next()) {
			return createUser(resultSet);
		}
		return null;
	}

	private User createUser(ResultSet resultSet) throws SQLException {
		String name = resultSet.getString("NAME");
		String lastname = resultSet.getString("LASTNAME");
		String username = resultSet.getString("USERNAME");
		String email = resultSet.getString("EMAIL");
		String phoneNumber = resultSet.getString("PHONE_NUMBER");
		Date birthday = resultSet.getDate("BIRTHDAY");
		char gender = resultSet.getString("GENDER").charAt(0);

		return new User(name, lastname, username, null, email, phoneNumber, birthday, gender);
	}

}
