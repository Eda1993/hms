package hms.commons;

import static java.sql.DriverManager.getConnection;

public class Connection {
	private static Connection instance = null;
	private static java.sql.Connection connection = null;

	private Connection() {
		String url = "jdbc:mysql://localhost:3306/";
		String database = "hotelmanagment";
		String userName = "root";
		String password = "mysql123";
		try {
			connection = getConnection(url + database, userName, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getInstance() {
		if (instance == null) {
			instance = new Connection();
		}
		return instance;
	}
	
	public static java.sql.Connection connect() {
		return connection;
	}
}
