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
import a01203138.book.io.BookReader;


public class BookDao extends Dao{
	public static final String TABLE_NAME = DbConstants.TABLE_ROOT + "Books";

	private static final String BOOKS_DATA_FILENAME = "books500.csv";
	private static Logger LOG = LogManager.getLogger();

	public BookDao(Database database) throws ApplicationException {
		super(database, TABLE_NAME);

		load();
	}

	/**
	 * @param booksDataFile
	 * @throws ApplicationException
	 * @throws SQLException
	 */
	public void load() throws ApplicationException {
		File booksDataFile = new File(BOOKS_DATA_FILENAME);
		try {
			if (!Database.tableExists(BookDao.TABLE_NAME) ) {

				create();

				LOG.debug("Inserting the books");

				if (!booksDataFile.exists()) {
					throw new ApplicationException(String.format("Required '%s' is missing.", BOOKS_DATA_FILENAME));
				}

				BookReader.read(booksDataFile, this);
			}
		} catch (SQLException e) {
			LOG.error(e.getMessage());
			throw new ApplicationException(e);
		}
	}

	public void dropConstraints() throws SQLException {
		String sqlString = String.format("ALTER TABLE %s DROP CONSTRAINT %s ", TABLE_NAME);
		boolean result = execute(sqlString, Column.BOOK_ID.name);
		LOG.debug(String.format("Dropping constraints %s was %s", 
				Column.BOOK_ID.name, result ? "successful" : "unsuccessful"));
	}
	
	@Override
	public void create() throws SQLException {
		LOG.debug("Creating database table " + TABLE_NAME);

		// With MS SQL Server, JOINED_DATE needs to be a DATETIME type.
		String sqlString = String.format("CREATE TABLE %s(" //
				+ "%s BIGINT, " // ID
				+ "%s VARCHAR(%d), " // ISBN
				+ "%s VARCHAR(%d), " // AUTHORS
				+ "%s VARCHAR(%d), " // ORIGINAL_PUBLICATION_YEAR
				+ "%s VARCHAR(%d), " // ORIGINAL_TITLE
				+ "%s FLOAT(%d), " // AVERAGE_RATING
				+ "%s VARCHAR(%d), " // RATING_COUNT
				+ "%s VARCHAR(%d), " // IMAGE_URL
				+ "PRIMARY KEY (%s))", // ID
				TABLE_NAME, //
				Column.BOOK_ID.name, //
				Column.ISBN.name, Column.ISBN.length, //
				Column.AUTHORS.name, Column.AUTHORS.length, //
				Column.ORIGINAL_PUBLICATION_YEAR.name, Column.ORIGINAL_PUBLICATION_YEAR.length, //
				Column.ORIGINAL_TITLE.name, Column.ORIGINAL_TITLE.length, //
				Column.AVERAGE_RATING.name, Column.AVERAGE_RATING.length, //
				Column.RATING_COUNT.name, Column.RATING_COUNT.length, //
				Column.IMAGE_URL.name, Column.IMAGE_URL.length, //
				Column.BOOK_ID.name);

		super.create(sqlString);
	}

	public void add(Book book) throws SQLException {
		String sqlString = String.format("INSERT INTO %s values(?, ?, ?, ?, ?, ?, ?, ?)", TABLE_NAME);
		boolean result = execute(sqlString, //
				book.getId(), //
				book.getIsbn(), //
				book.getAuthors(), //
				book.getYear(), //
				book.getTitle(), //
				book.getRating(), //
				book.getRatingsCount(), //
				book.getImageUrl());
		LOG.debug(String.format("Adding %s was %s", book, result ? "successful" : "unsuccessful"));
	}

	/**
	 * Update the book.
	 * 
	 * @param book
	 * @throws SQLException
	 */
	public void update(Book book) throws SQLException {
		String sqlString = String.format("UPDATE %s SET %s=?, %s=?, %s=?, %s=?, %s=?, %s=?, %s=?, WHERE %s=?", TABLE_NAME, //
				Column.ISBN.name, //
				Column.AUTHORS.name, //
				Column.ORIGINAL_PUBLICATION_YEAR.name, //
				Column.ORIGINAL_TITLE.name, //
				Column.AVERAGE_RATING.name, //
				Column.RATING_COUNT.name, //
				Column.IMAGE_URL.name, //
				Column.BOOK_ID.name);
		LOG.debug("Update statment: " + sqlString);

		boolean result = execute(sqlString, book.getId(), 
				book.getIsbn(), book.getAuthors(), book.getYear(),
				book.getTitle(), book.getRating(), book.getRatingsCount(), 
				book.getImageUrl());
		LOG.debug(String.format("Updating %s was %s", book, result ? "successful" : "unsuccessful"));
	}

	/**
	 * Delete the book from the database.
	 * 
	 * @param book
	 * @throws SQLException
	 */
	public void delete(Book book) throws SQLException {
		Connection connection;
		Statement statement = null;
		try {
			connection = Database.getConnection();
			statement = connection.createStatement();

			String sqlString = String.format("DELETE FROM %s WHERE %s='%s'", TABLE_NAME, Column.BOOK_ID.name, book.getId());
			LOG.debug(sqlString);
			int rowcount = statement.executeUpdate(sqlString);
			LOG.debug(String.format("Deleted %d rows", rowcount));
		} finally {
			close(statement);
		}
	}

	/**
	 * Retrieve all the book IDs from the database
	 * 
	 * @return the list of book IDs
	 * @throws SQLException
	 */
	public List<Long> getBookIds() throws SQLException {
		List<Long> ids = new ArrayList<>();

		String selectString = String.format("SELECT %s FROM %s", Column.BOOK_ID.name, TABLE_NAME);
		LOG.debug(selectString);

		Statement statement = null;
		ResultSet resultSet = null;
		try {
			Connection connection = Database.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(selectString);

			while (resultSet.next()) {
				ids.add(resultSet.getLong(Column.BOOK_ID.name));
			}

		} finally {
			close(statement);
		}

		LOG.debug(String.format("Loaded %d book IDs from the database", ids.size()));

		return ids;
	}

	/**
	 * @param bookId
	 * @return
	 * @throws Exception
	 */
	public Book getBook(Long bookId) throws Exception {
		String sqlString = String.format("SELECT * FROM %s WHERE %s = %d", TABLE_NAME, Column.BOOK_ID.name, bookId);
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
				int year = Integer.parseInt(resultSet.getString(Column.ORIGINAL_PUBLICATION_YEAR.name));
				float rating = Float.parseFloat(resultSet.getString(Column.AVERAGE_RATING.name));
				int ratingCnt = Integer.parseInt(resultSet.getString(Column.RATING_COUNT.name));
										
				Book book = new Book.Builder(resultSet.getInt(Column.BOOK_ID.name)) //
						.setIsbn(resultSet.getString(Column.ISBN.name)) //
						.setAuthors(resultSet.getString(Column.AUTHORS.name)) //
						.setYear(year) //
						.setTitle(resultSet.getString(Column.ORIGINAL_TITLE.name)) //
						.setRating(rating) //
						.setRatingsCount(ratingCnt) //
						.setImageUrl(resultSet.getString(Column.IMAGE_URL.name)).build();

				return book;
			}
		} finally {
			close(statement);
		}

		return null;
	}

	public int countAllBooks() throws Exception {
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
	
	public static Map<Long, Book> getAllBooks() throws Exception {
		Statement statement = null;
		Map<Long, Book> books = new HashMap<>();
		try {
			Connection connection = Database.getConnection();
			statement = connection.createStatement();
			// Execute a statement
			String sqlString = String.format("SELECT * FROM %s", TABLE_NAME);
			ResultSet resultSet = statement.executeQuery(sqlString);
			while (resultSet.next()) {
				int year = Integer.parseInt(resultSet.getString(Column.ORIGINAL_PUBLICATION_YEAR.name));
				float rating = Float.parseFloat(resultSet.getString(Column.AVERAGE_RATING.name));
				int ratingCnt = Integer.parseInt(resultSet.getString(Column.RATING_COUNT.name));
										
				Book book = new Book.Builder(resultSet.getInt(Column.BOOK_ID.name)) //
						.setIsbn(resultSet.getString(Column.ISBN.name)) //
						.setAuthors(resultSet.getString(Column.AUTHORS.name)) //
						.setYear(year) //
						.setTitle(resultSet.getString(Column.ORIGINAL_TITLE.name)) //
						.setRating(rating) //
						.setRatingsCount(ratingCnt) //
						.setImageUrl(resultSet.getString(Column.IMAGE_URL.name)).build();

				books.put(book.getId(), book);
			}
		} finally {
			close(statement);
		}
		return books;
	}

	public enum Column {
		BOOK_ID("book_id", 16), //
		ISBN("isbn", 20), //
		AUTHORS("authors", 100), //
		ORIGINAL_PUBLICATION_YEAR("original_publication_year", 4), //
		ORIGINAL_TITLE("original_title", 100), //
		AVERAGE_RATING("average_rating", 6), //
		RATING_COUNT("rating_count", 16), //
		IMAGE_URL("image_url", 100); //

		String name;
		int length;

		private Column(String name, int length) {
			this.name = name;
			this.length = length;
		}

	}
}
