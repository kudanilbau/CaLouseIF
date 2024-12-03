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

	public static DatabaseConnector getInstance() {
		if (db == null)
			db = new DatabaseConnector();
		return db;
	}

	public Connection getConnection() {
		return con;
	}

}
