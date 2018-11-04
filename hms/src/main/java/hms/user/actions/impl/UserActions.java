package hms.user.actions.impl;

import static hms.commons.UserType.ADMIN;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hms.commons.AbstractTable;
import hms.user.actions.IUserActions;
import hms.user.models.User;

public class UserActions extends AbstractTable implements IUserActions {
	public static final String PENDING = "PENDING";
	public static final String ACCEPTED = 	"ACCEPTED";
	public static final String REJECTED = "REJECTED";

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
	
	@Override
	public Map<String, List<String>> getResposes(int userId) throws SQLException {
		Map<String, List<String>> messages = new HashMap<>();
		List<String> pendingRequest = new ArrayList<>();
		List<String> acceptedRequests = new ArrayList<>();
		List<String> rejectedRequests = new ArrayList<>();
		
		String sql = "select * from room where REQUESTED_BY = ?";
		PreparedStatement statement = getPreparedStatement(sql);
		statement.setInt(1, userId);
		ResultSet resultSet = statement.executeQuery();
		
		while (resultSet.next()) {
			int occupied = resultSet.getInt("OCCUPIED");
			int roomNumber = resultSet.getInt("ROOM_NUMBER");
			
			if (occupied == 0) {
				pendingRequest.add(formatMessage(roomNumber, PENDING));
			} else if (occupied == 1) {
				acceptedRequests.add(formatMessage(roomNumber, ACCEPTED));
			} else {
				rejectedRequests.add(formatMessage(roomNumber, REJECTED));
			}
		}
		
		messages.put(ACCEPTED, acceptedRequests);
		messages.put(PENDING, pendingRequest);
		messages.put(REJECTED, rejectedRequests);
		
		return messages;
	}
	
	private String formatMessage(int roomNumber, String status) {
		String msg = "Dhoma me numer " + roomNumber + " ka statusin " + status; 
		return msg;
	}

	private User createUser(ResultSet resultSet) throws SQLException {
		int id = resultSet.getInt("ID");
		String name = resultSet.getString("NAME");
		String lastname = resultSet.getString("LASTNAME");
		String username = resultSet.getString("USERNAME");
		String email = resultSet.getString("EMAIL");
		String phoneNumber = resultSet.getString("PHONE_NUMBER");
		Date birthday = resultSet.getDate("BIRTHDAY");
		char gender = resultSet.getString("GENDER").charAt(0);

		User user = new User(name, lastname, username, null, email, phoneNumber, birthday, gender);
		user.setId(id);
		return user;
	}
}
