package servlets;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {
	public Connection getConnection() throws SQLException, IOException {
		Properties props = new Properties();
		try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("db.properties")) {
			props.load(inputStream);
		}

		String url = props.getProperty("db.url");
		String username = props.getProperty("db.username");
		String password = props.getProperty("db.password");

		return DriverManager.getConnection(url, username, password);
	}
}