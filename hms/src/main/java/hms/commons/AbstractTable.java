package hms.commons;

public abstract class AbstractTable {
	private Connection connection = Connection.getInstance();

	protected java.sql.Connection getConnection() {
		return connection.connect();
	}
}
