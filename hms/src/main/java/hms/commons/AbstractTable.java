package hms.commons;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class AbstractTable {
	private Connection connection = Connection.getInstance();

	protected java.sql.Connection getConnection() {
		return connection.connect();
	}
	
	protected PreparedStatement getPreparedStatement(String sql) throws SQLException {
		return (PreparedStatement) getConnection().prepareStatement(sql);
	}
}
