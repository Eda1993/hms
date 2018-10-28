package hms.user.actions.impl;

import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

import hms.commons.AbstractTable;
import hms.user.models.User;

public class UserInsert extends AbstractTable {

	public void insertUser(User user) {

		try {
			String sql = "insert into user (NAME, LASTNAME, USERNAME, PASSWORD, EMAIL, PHONE_NUMBER, BIRTHDAY, GENDER)values('"
					+ user.getName() + "','" + user.getLastname() + "','" + user.getUsername() + "','"
					+ user.getPassword() + "','" + user.getEmail() + "','" + user.getPhoneNumber() + "','"
					+ user.getBirthday() + "','" + user.getGender() + "')";
			
			Statement statement = getConnection().prepareStatement(sql);
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
