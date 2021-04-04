package a01203138.book.data;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import a01203138.book.ApplicationException;
import a01203138.book.db.Dao;
import a01203138.book.db.Database;
import a01203138.book.db.DbConstants;
import a01203138.book.io.PurchaseReader;


public class PurchaseDao extends Dao {
	public static final String TABLE_NAME = DbConstants.TABLE_ROOT + "Purchases";

	private static final String PURCHASE_DATA_FILENAME = "purchases.csv";
	private static Logger LOG = LogManager.getLogger();

	public PurchaseDao(Database database) throws ApplicationException {
		super(database, TABLE_NAME);

		load();
	}

	/**
	 * @param purchasesDataFile
	 * @throws ApplicationException
	 * @throws SQLException
	 */
	public void load() throws ApplicationException {
		File purchasesDataFile = new File(PURCHASE_DATA_FILENAME);
		try {
			if (!Database.tableExists(PurchaseDao.TABLE_NAME)) {

				create();

				LOG.debug("Inserting the purchases");

				if (!purchasesDataFile.exists()) {
					throw new ApplicationException(String.format("Required '%s' is missing.", PURCHASE_DATA_FILENAME));
				}

				PurchaseReader.read(purchasesDataFile, this);
			}
		} catch (SQLException e) {
			LOG.error(e.getMessage());
			throw new ApplicationException(e);
		}
	}

	@Override
	public void create() throws SQLException {
		LOG.debug("Creating database table " + TABLE_NAME);

		// With MS SQL Server, JOINED_DATE needs to be a DATETIME type.
		String sqlString = String.format("CREATE TABLE %s(" //
				+ "%s BIGINT, " // PURCHASE_ID
				+ "%s BIGINT, " // CUSTOMER_ID
				+ "%s BIGINT, " // BOOK_ID
				+ "%s FLOAT(%d), " // PRICE
				+ "PRIMARY KEY (%s), "
				+ "FOREIGN key (%s) references %s, " //
				+ "FOREIGN key (%s) references %s )", //,
				TABLE_NAME, //
				Column.PURCHASE_ID.name, //
				Column.CUSTOMER_ID.name, //
				Column.BOOK_ID.name, //
				Column.PRICE.name, Column.PRICE.length, //
				Column.PURCHASE_ID.name,
				Column.CUSTOMER_ID.name, CustomerDao.CUSTOMER_TABLE_NAME,
				Column.BOOK_ID.name, BookDao.TABLE_NAME);

		super.create(sqlString);
	}

	public void add(Purchase purchase) throws SQLException {
		String sqlString = String.format("INSERT INTO %s values(?, ?, ?, ?)", TABLE_NAME);
		boolean result = execute(sqlString, //
				purchase.getId(), //
				purchase.getCustomerId(), //
				purchase.getBookId(), //
				purchase.getPrice());
		LOG.debug(String.format("Adding %s was %s", purchase, result ? "successful" : "unsuccessful"));
	}

	public void dropConstraints() throws SQLException {
		String sqlString = String.format("ALTER TABLE %s DROP CONSTRAINT %s %s", TABLE_NAME);
		boolean result = execute(sqlString, //
				Column.CUSTOMER_ID.name, //
				Column.BOOK_ID.name);
		LOG.debug(String.format("Dropping constraints %s and %s was %s", 
				Column.CUSTOMER_ID.name,Column.BOOK_ID.name , result ? "successful" : "unsuccessful"));
	}
	/**
	 * Update the purchase.
	 * 
	 * @param purchase
	 * @throws SQLException
	 */
	public void update(Purchase purchase) throws SQLException {
		String sqlString = String.format("UPDATE %s SET %s=?, %s=?, %s=?, %s=?, WHERE %s=?", TABLE_NAME, //
				Column.PURCHASE_ID.name, //
				Column.CUSTOMER_ID.name, //
				Column.BOOK_ID.name, //
				Column.PRICE.name, //
				Column.PURCHASE_ID.name);
		LOG.debug("Update statment: " + sqlString);

		boolean result = execute(sqlString, purchase.getId(), 
				purchase.getCustomerId(), purchase.getBookId(), purchase.getPrice()
				);
		LOG.debug(String.format("Updating %s was %s", purchase, result ? "successful" : "unsuccessful"));
	}

	/**
	 * Delete the purchase from the database.
	 * 
	 * @param purchase
	 * @throws SQLException
	 */
	public void delete(Purchase purchase) throws SQLException {
		Connection connection;
		Statement statement = null;
		try {
			connection = Database.getConnection();
			statement = connection.createStatement();

			String sqlString = String.format("DELETE FROM %s WHERE %s='%s'", TABLE_NAME, Column.PURCHASE_ID.name, purchase.getId());
			LOG.debug(sqlString);
			int rowcount = statement.executeUpdate(sqlString);
			LOG.debug(String.format("Deleted %d rows", rowcount));
		} finally {
			close(statement);
		}
	}

	/**
	 * Retrieve all the purchase IDs from the database
	 * 
	 * @return the list of purchase IDs
	 * @throws SQLException
	 */
	public List<Long> getPurchaseIds() throws SQLException {
		List<Long> ids = new ArrayList<>();

		String selectString = String.format("SELECT %s FROM %s", Column.PURCHASE_ID.name, TABLE_NAME);
		LOG.debug(selectString);

		Statement statement = null;
		ResultSet resultSet = null;
		try {
			Connection connection = Database.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(selectString);

			while (resultSet.next()) {
				ids.add(resultSet.getLong(Column.PURCHASE_ID.name));
			}

		} finally {
			close(statement);
		}

		LOG.debug(String.format("Loaded %d purchases IDs from the database", ids.size()));

		return ids;
	}

	/**
	 * @param purchaseId
	 * @return
	 * @throws Exception
	 */
	public Purchase getPurchase(Long purchaseId) throws Exception {
		String sqlString = String.format("SELECT * FROM %s WHERE %s = %d", TABLE_NAME, Column.PURCHASE_ID.name, purchaseId);
		LOG.debug(sqlString);

		Statement statement = null;
		ResultSet resultSet = null;
		try {
			Connection connection = Database.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sqlString);

			int count = 0;
			while (resultSet.next()) {
				count++;
				if (count > 1) {
					throw new ApplicationException(String.format("Expected one result, got %d", count));
				}
				int purchase_id = Integer.parseInt(resultSet.getString(Column.PURCHASE_ID.name));
				int customer_id = Integer.parseInt(resultSet.getString(Column.CUSTOMER_ID.name));
				int book_id = Integer.parseInt(resultSet.getString(Column.BOOK_ID.name));
				float price = Float.parseFloat(resultSet.getString(Column.PRICE.name));
										
				Purchase purchase = new Purchase.Builder(
						purchase_id, //
						customer_id, //
						book_id, //
						price) //
						.build();

				return purchase;
			}
		} finally {
			close(statement);
		}

		return null;
	}

	public int countAllPurchases() throws Exception {
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
	
	public static Map<Long, Purchase> getAllPurchases() throws Exception {
		Statement statement = null;
		Map<Long, Purchase> purchases = new HashMap<>();
		try {
			Connection connection = Database.getConnection();
			statement = connection.createStatement();
			// Execute a statement
			String sqlString = String.format("SELECT * FROM %s", TABLE_NAME);
			ResultSet resultSet = statement.executeQuery(sqlString);
			while (resultSet.next()) {

				long purchase_id = Long.parseLong(resultSet.getString(Column.PURCHASE_ID.name));
				long customer_id = Long.parseLong(resultSet.getString(Column.CUSTOMER_ID.name));
				long book_id = Long.parseLong(resultSet.getString(Column.BOOK_ID.name));
				float price = Float.parseFloat(resultSet.getString(Column.PRICE.name));
										
				Purchase purchase = new Purchase.Builder(
						purchase_id, //
						customer_id, //
						book_id, //
						price) //
						.build();

				purchases.put(purchase.getId(), purchase);
			}
		} finally {
			close(statement);
		}
		return purchases;
	}

	public List<Long> getCustomerIDs() throws Exception {
		Statement statement = null;
		List<Long> listCustomerIDs = new ArrayList<Long>();
		try {
			Connection connection = Database.getConnection();
			statement = connection.createStatement();
			// Execute a statement
			String sqlString = String.format("SELECT %s FROM %s", Column.CUSTOMER_ID.name, TABLE_NAME);
			ResultSet resultSet = statement.executeQuery(sqlString);
			while (resultSet.next()) {
				long customerID = Long.parseLong(resultSet.getString(Column.CUSTOMER_ID.name));
				listCustomerIDs.add(customerID);
			}
		} finally {
			close(statement);
		}
		return listCustomerIDs;
	}
	
	public enum Column {
		PURCHASE_ID("purchase_id", 16), //
		CUSTOMER_ID("customer_id", 10), //
		BOOK_ID("book_id", 10), //
		PRICE("price", 10); //

		String name;
		int length;

		private Column(String name, int length) {
			this.name = name;
			this.length = length;
		}

	}
}
