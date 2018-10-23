package hms.commons;

import static hms.commons.Connection.connect;

public abstract class AbstractTable {
	private java.sql.Connection connection = connect();

	protected java.sql.Connection getConnection() {
		return connection;
	}
}
