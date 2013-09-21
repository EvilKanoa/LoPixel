package ca.kanoa.lopixel.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import ca.kanoa.lopixel.LoPixel;
import ca.kanoa.lopixel.utils.Log;

public class MySQLConnection {

	private final String address;
	private final String database;
	private final String username;
	private final String password;
	private final String port;
	private String location;
	
	/**
	 * Creates a new connection to a database to assist with MySQL transfers
	 * @param address The URL or IP of the database's server
	 * @param database The name of the database you want to make a connection for
	 * @param username The user you want to be used to connect to the database
	 * @param password The password for the user you want to connect to the database
	 * @param port The port of the database's server
	 */
	public MySQLConnection(String address, String database, String username, 
			String password, String port) {
		this.address  = address;
		this.database = database;
		this.username = username;
		this.password = password;
		this.port     = port;
		this.location = String.format("jdbc:mysql://%s:%s/%s", getAddress(), 
				getPort(), getDatabase());
	}

	/**
	 * A connection to the database that this object represents
	 * @return New connection to the database this object represents
	 * @throws SQLException If there is a problem connecting to the database.
	 */
	public Connection getConnection() throws SQLException {
		try {
			return DriverManager.getConnection(location, getUsername(), getPassword());
		} catch (SQLException e) {
			Log.error(LoPixel.getMessages().format("sql-connection-error", new String[]{"database", "address", "error"}, new String[]{database, address, e.getMessage()}));
			throw e;
		}
	}

	public String getAddress() {
		return address;
	}

	public String getDatabase() {
		return database;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getPort() {
		return port;
	}
	
}
