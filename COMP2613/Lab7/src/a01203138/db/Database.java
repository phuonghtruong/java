package a01203138.db;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Database{

	public static final String DB_DRIVER_KEY = "db.driver";
	public static final String DB_URL_KEY = "db.url";
	public static final String DB_USER_KEY = "db.user";
	public static final String DB_PASSWORD_KEY = "db.password";

	
	private static final Logger Log = LogManager.getLogger();	


	private static Connection connection;
	private static Properties properties;
	private static boolean dbTableDropRequested;


	public Database(Properties properties) {
		Log.debug("Loading database properties from db.properties");
		Database.properties = properties;
	}
	

	public static Connection getConnection() throws SQLException {
		if (connection != null) {
			return connection;
		}

		try {
			connect();
		} catch (ClassNotFoundException e) {
			throw new SQLException(e);
		}

		return connection;
	}

	public static void connect() throws ClassNotFoundException, SQLException{
		String dbDriver = properties.getProperty(DB_DRIVER_KEY);
		Log.debug(dbDriver);
		Class.forName(dbDriver);
		Log.debug("Driver loaded");
		String dbUrl = properties.getProperty(DB_URL_KEY);
		Log.debug("DB URL=" + dbUrl);
		String dbUser = properties.getProperty(DB_USER_KEY);
		Log.debug("DB USER=" + dbUser);
		String dbPassword = properties.getProperty(DB_PASSWORD_KEY);
		Log.debug("DB URL=" + dbPassword);
		connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
		Log.debug("Database connected");
	}
	
	public static boolean tableExists(String targetTableName) throws SQLException{
		DatabaseMetaData databaseMetaData = getConnection().getMetaData();
		ResultSet resultSet = null;
		String tableName = null;

		try {
			resultSet = databaseMetaData.getTables(connection.getCatalog(), "%", "%", null);
			while (resultSet.next()) {
				tableName = resultSet.getString("TABLE_NAME");
				if (tableName.equalsIgnoreCase(targetTableName)) {
					Log.debug("Found the target table named: " + targetTableName);
					return true;
				}
			}
		} finally {
			resultSet.close();
		}

		return false;
	}
	
	public static void shutdown() {
		if (connection != null) {
			try {
				connection.close();
				connection = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void requestDbTableDrop() {
		dbTableDropRequested = true;
	}
	
	public static boolean dbTableDropRequested() {
		return dbTableDropRequested;
	}

	public static boolean isMsSqlServer() {
		return Database.properties.get(DB_DRIVER_KEY).toString().contains("sqlserver");
	}
	

	
}
