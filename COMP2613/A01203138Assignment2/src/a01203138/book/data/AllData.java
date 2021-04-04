/**
 * 
 */
package a01203138.book.data;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import a01203138.book.ApplicationException;


/**
 * @author scirka
 *
 */
public class AllData {

	private static final Logger LOG = LogManager.getLogger();

	private static Map<Long, Book> books;
	private static Map<Long, Customer> customers;
	private static Map<Long, Purchase> purchases;

	private AllData() {
//		try {
//			loadData();
//		} catch (ApplicationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	/**
	 * @throws ApplicationException
	 * 
	 */
	public static void loadData() throws ApplicationException {
		LOG.debug("loading the data");
		try {
			customers = CustomerDao.getAllCustomers();
			books = BookDao.getAllBooks();
			purchases = PurchaseDao.getAllPurchases();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LOG.debug("successfully loaded the data");
	}

	/**
	 * @return the customers
	 */
	public static Map<Long, Customer> getCustomers() {
		return customers;
	}

	/**
	 * @return the books
	 */
	public static Map<Long, Book> getBooks() {
		return books;
	}

	/**
	 * @return the purchases
	 */
	public static Map<Long, Purchase> getPurchases() {
		return purchases;
	}

}
