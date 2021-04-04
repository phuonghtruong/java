package a01203138.data;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import a01203138.db.Dao;
import a01203138.db.Database;
import a01203138.db.DbConstants;
import a01203138.io.ApplicationException;
import a01203138.io.CustomerReader;
import a01203138.data.Customer;


public class CustomerDao extends Dao {
	public static final String TABLE_NAME = DbConstants.TABLE_ROOT + "Customers";

	private static final String CUSTOMERS_DATA_FILENAME = "customers.txt";
	private static final Logger Log = LogManager.getLogger();

	public CustomerDao(Database database) throws ApplicationException {
		super(database, TABLE_NAME);
		load();
	}

	public void load() throws ApplicationException {
		File customerDataFile = new File(CUSTOMERS_DATA_FILENAME);
		try {
			if (!Database.tableExists(CustomerDao.TABLE_NAME) || Database.dbTableDropRequested()) {
				if (Database.tableExists(CustomerDao.TABLE_NAME) && Database.dbTableDropRequested()) {
					drop();
				}

				create();

				Log.debug("Inserting the customers");

				if (!customerDataFile.exists()) {
					throw new ApplicationException(String.format("Required '%s' is missing.", CUSTOMERS_DATA_FILENAME));
				}

				CustomerReader.read(customerDataFile, this);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ApplicationException();
		}
	}

	@Override
	public void create() throws SQLException {
		Log.debug("Creating database table " + TABLE_NAME);

		// With MS SQL Server, JOINED_DATE needs to be a DATETIME type.
		String sqlString = String.format("CREATE TABLE %s(" //
				+ "%s VARCHAR(%d), " // ID
				+ "%s VARCHAR(%d), " // FIRST_NAME
				+ "%s VARCHAR(%d), " // LAST_NAME
				+ "%s VARCHAR(%d), " // STREET
				+ "%s VARCHAR(%d), " // CITY
				+ "%s VARCHAR(%d), " // POSTAL_CODE
				+ "%s VARCHAR(%d), " // PHONE
				+ "%s VARCHAR(%d), " // EMAIL_ADDRESS
				+ "%s DATETIME, " // JOINED_DATE
				+ "PRIMARY KEY (%s))", // ID
				TABLE_NAME, //
				Fields.ID.name, Fields.ID.length, //
				Fields.FIRST_NAME.name, Fields.FIRST_NAME.length, //
				Fields.LAST_NAME.name, Fields.LAST_NAME.length, //
				Fields.STREET.name, Fields.STREET.length, //
				Fields.CITY.name, Fields.CITY.length, //
				Fields.POSTAL_CODE.name, Fields.POSTAL_CODE.length, //
				Fields.PHONE.name, Fields.PHONE.length, //
				Fields.EMAIL_ADDRESS.name, Fields.EMAIL_ADDRESS.length, //
				Fields.JOINED_DATE.name, //
				Fields.ID.name);

		super.create(sqlString);
	}

	public void add(Customer customer) throws SQLException {
		String sqlString = String.format("INSERT INTO %s values(?, ?, ?, ?, ?, ?, ?, ?, ?)", TABLE_NAME);
		boolean result = execute(sqlString, //
				customer.getId(), //
				customer.getFirstName(), //
				customer.getLastName(), //
				customer.getStreetName(), //
				customer.getCity(), //
				customer.getPostalCode(), //
				customer.getPhone(), //
				customer.getEmailAddress(), //
				toTimestamp(customer.getJoinDate())
				);
		Log.debug(String.format("Adding %s was %s", customer, result ? "successful" : "unsuccessful"));
	}


	public void update(Customer customer) throws SQLException {
		String sqlString = String.format("UPDATE %s SET %s=?, %s=?, %s=?, %s=?, %s=?, %s=?, %s=?, %s=?, WHERE %s=?", TABLE_NAME, //
				Fields.FIRST_NAME.name, //
				Fields.LAST_NAME.name, //
				Fields.STREET.name, //
				Fields.CITY.name, //
				Fields.POSTAL_CODE.name, //
				Fields.PHONE.name, //
				Fields.EMAIL_ADDRESS.name, //
				Fields.JOINED_DATE.name, //
				Fields.ID.name);
		Log.debug("Update statment: " + sqlString);

		boolean result = execute(sqlString, customer.getId(), sqlString, customer.getFirstName(), customer.getLastName(), customer.getStreetName(),
				customer.getCity(), customer.getPostalCode(), customer.getPhone(), customer.getEmailAddress(), toTimestamp(customer.getJoinDate()));
		Log.debug(String.format("Updating %s was %s", customer, result ? "successful" : "unsuccessful"));
	}

	public Customer getCustomer(String customerId) throws SQLException, Exception {
		Connection connection;
		Statement statement = null;
		Customer customer = null;
		try {
			connection = Database.getConnection();
			statement = connection.createStatement();
			// Execute a statement
			String sql = String.format("SELECT * FROM %s WHERE %s = '%s'", tableName, Fields.ID.name, customerId);
			Log.debug(sql);
			ResultSet resultSet = statement.executeQuery(sql);

			int count = 0;
			while (resultSet.next()) {
				count++;
				if (count > 1) {
					throw new Exception(String.format("Expected one result, got %d", count));
				}
				
				Timestamp timestamp = resultSet.getTimestamp(Fields.JOINED_DATE.name);
				LocalDate date = timestamp.toLocalDateTime().toLocalDate();
				
				customer = new Customer.Builder(resultSet.getString(Fields.ID.name),resultSet.getString(Fields.PHONE.name))
						.firstName(resultSet.getString(Fields.FIRST_NAME.name))
						.lastName(resultSet.getString(Fields.LAST_NAME.name))
						.streetName(resultSet.getString(Fields.STREET.name))
						.city(resultSet.getString(Fields.CITY.name))
						.postalCode(resultSet.getString(Fields.POSTAL_CODE.name))
						.emailAddress(resultSet.getString(Fields.EMAIL_ADDRESS.name))
						.joinDate(date)
						.build();
			}
		} finally {
			close(statement);
		}

		return customer;
	}

	public List<String> getCustomerIds() throws SQLException {
		List<String> ids = new ArrayList<>();

		String selectString = String.format("SELECT %s FROM %s", Fields.ID.name, TABLE_NAME);
		Log.debug(selectString);

		Statement statement = null;
		ResultSet resultSet = null;
		try {
			Connection connection = Database.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(selectString);

			while (resultSet.next()) {
				ids.add(resultSet.getString(Fields.ID.name));
			}

		} finally {
			close(statement);
		}

		Log.debug(String.format("Loaded %d customer IDs from the database", ids.size()));

		return ids;
	}
	
	public int countAllCustomers() throws Exception {
		Statement statement = null;
		int count = 0;
		try {
			Connection connection = Database.getConnection();
			statement = connection.createStatement();
			// Execute a statement
			String sqlString = String.format("SELECT COUNT(*) AS total FROM %s", tableName);
			ResultSet resultSet = statement.executeQuery(sqlString);
			if (resultSet.next()) {
				count = resultSet.getInt("total");
			}
		} finally {
			close(statement);
		}
		return count;
	}
	
	
	public void delete(Customer customer) throws SQLException {
		Connection connection;
		Statement statement = null;
		try {
			connection = Database.getConnection();
			statement = connection.createStatement();

			String sqlString = String.format("DELETE FROM %s WHERE %s='%s'", TABLE_NAME, Fields.ID.name, customer.getId());
			Log.debug(sqlString);
			int rowcount = statement.executeUpdate(sqlString);
			Log.debug(String.format("Deleted %d rows", rowcount));
		} finally {
			close(statement);
		}
	}
	
	public enum Fields {

		ID("id", 16), //
		FIRST_NAME("firstName", 20), //
		LAST_NAME("lastName", 20), //
		STREET("street", 40), //
		CITY("city", 20), //
		POSTAL_CODE("postalCode", 10), //
		PHONE("phone", 10), //
		EMAIL_ADDRESS("emailAddress", 40), //
		JOINED_DATE("joinedDate", 20); //

		String name;
		int length;

		private Fields(String name, int length) {
			this.name = name;
			this.length = length;
		}
	}
}
