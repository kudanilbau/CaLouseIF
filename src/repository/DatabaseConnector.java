package repository;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnector {

	private static final String HOST = "localhost";
	private static final String PORT = "3306";
	private static final String DATABASE = "calouseif";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";
	private static final String URL = String.format("jdbc:mysql://%s:%s/%s", HOST, PORT, DATABASE);

	private static DatabaseConnector db;

	private Connection con;

	private DatabaseConnector() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Returns the singleton instance of the {@code DatabaseConnector}. If instance
	 * hasn't been initialized, it will be initialized
	 *
	 * @return the singleton {@code DatabaseConnector} instance
	 */
	public static DatabaseConnector getInstance() {
		if (db == null)
			db = new DatabaseConnector();
		return db;
	}
	
    /**
     * Returns the active database connection.
     *
     * @return the current {@code Connection} to the database
     */
	public Connection getConnection() {
		return con;
	}

}
