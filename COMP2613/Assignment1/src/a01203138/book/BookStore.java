package a01203138.book;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.cli.ParseException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;
import org.apache.logging.log4j.core.config.DefaultConfiguration;

import a01203138.book.data.Book;
import a01203138.book.data.Customer;
import a01203138.book.data.Purchase;
import a01203138.book.sorters.BookSorter;
import a01203138.book.sorters.CustomerSorter;
import a01203138.book.sorters.PurchaseSorter;
import a01203138.book.io.BookReader;
import a01203138.book.io.BooksReport;
import a01203138.book.io.CustomerReader;
import a01203138.book.io.CustomersReport;
import a01203138.book.io.PurchaseReader;
import a01203138.book.io.PurchasesReport;
import a01203138.book.ApplicationException;



/**
 * Project: Book
 * File: BookStore.java
 * Date: October, 2017
 * Time: 1:22:25 PM
 */

/**
 * @author Hoang Phuong Truong, A01203138
 *
 */
public class BookStore {

	private static final String CUSTOMERS_DATA_FILENAME = "customers.dat";
	private static final String BOOKS_DATA_FILENAME = "books500.csv";
	private static final String PURCHASES_DATA_FILENAME = "purchases.csv";
	private static final String LOG4J_CONFIG_FILENAME = "log4j2.xml";
	static {
		configureLogging();
	}
	private static final Logger LOG = LogManager.getLogger();

	/**
	 * Bcmc Constructor. Processes the commandline arguments
	 * ex. -inventory -make=honda -by_count -desc -total -service
	 * 
	 * @throws ApplicationException
	 * @throws ParseException
	 */
	public BookStore(String[] args) throws ApplicationException, ParseException {
		LOG.info("Created Bcmc");

		BookOptions.process(args);
	}

	/**
	 * Entry point to GIS
	 * 
	 * @param args
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) {
		Instant startTime = Instant.now();
		LOG.info(startTime);

		// start the Book System
		try {
			BookStore book = new BookStore(args);
			if (BookOptions.isHelpOptionSet()) {
				BookOptions.Value[] values = BookOptions.Value.values();
				System.out.format("%-5s %-15s %-10s %s%n", "Option", "Long Option", "Has Value", "Description");
				for (BookOptions.Value value : values) {
					System.out.format("-%-5s %-15s %-10s %s%n", value.getOption(), ("-" + value.getLongOption()), value.isHasArg(),
							value.getDescription());
				}

				return;
			}

			book.run();
		} catch (Exception e) {
			e.printStackTrace();
			LOG.debug(e.getMessage());
		}

		Instant endTime = Instant.now();
		LOG.info(endTime);
		LOG.info(String.format("Duration: %d ms", Duration.between(startTime, endTime).toMillis()));
	}

	/**
	 * Configures log4j2 from the external configuration file specified in LOG4J_CONFIG_FILENAME.
	 * If the configuration file isn't found then log4j2's DefaultConfiguration is used.
	 */
	private static void configureLogging() {
		ConfigurationSource source;
		try {
			source = new ConfigurationSource(new FileInputStream(LOG4J_CONFIG_FILENAME));
			Configurator.initialize(null, source);
		} catch (IOException e) {
			System.out.println(String.format("WARNING! Can't find the log4j logging configuration file %s; using DefaultConfiguration for logging.",
					LOG4J_CONFIG_FILENAME));
			Configurator.initialize(new DefaultConfiguration());
		}
	}

	/**
	 * @throws ApplicationException
	 * @throws FileNotFoundException
	 * 
	 */
	private void run() throws ApplicationException, FileNotFoundException {
		LOG.debug("run()");
		
		generateReports();
	}

	/**
	 * Generate the reports from the input data
	 * 
	 * @throws FileNotFoundException
	 */
	@SuppressWarnings("null")
	private void generateReports() throws FileNotFoundException {
		LOG.debug("generating the reports");


		if (BookOptions.isCustomersOptionSet()) {
			LOG.debug("generating the customer report");
			// for program args: -c -J -d
			System.out.println("Cutomer Report: " + BookOptions.isCustomersOptionSet());
			System.out.println("Cutomer Join Date: " + BookOptions.isByJoinDateOptionSet());
			System.out.println("Cutomer Join Date DESC: " + BookOptions.isDescendingOptionSet());
				
			Map<Integer, Customer> customers;
			try {
				customers = CustomerReader.read(CUSTOMERS_DATA_FILENAME);
				Collection<Customer> customerCollection = customers.values();
				List<Customer> list = new ArrayList<>(customerCollection);
				if (BookOptions.isByJoinDateOptionSet())
					Collections.sort(list, new CustomerSorter.CompareByJoinedDate());
				if (BookOptions.isDescendingOptionSet())
					Collections.sort(list, new CustomerSorter.CompareByJoinedDateDescending());
				Map<Integer, Customer> sortedCustomers = new HashMap<Integer, Customer>();
				int index = 0;
				for (Iterator<Customer> it = list.iterator(); it.hasNext();) {
					Customer cus = (Customer) it.next();
					sortedCustomers.put(index, cus);
					index++;
				}
				CustomersReport.write(sortedCustomers);
			} catch (ApplicationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				LOG.error(e.getMessage());
			}			
		}

		if (BookOptions.isBooksOptionSet()) {
			LOG.debug("generating the book report");
			
			// for program args: -b -A
			System.out.println("Book Report: " + BookOptions.isBooksOptionSet());
			System.out.println("Book Authors: " + BookOptions.isByAuthorOptionSet());
			System.out.println("Book Authors DESC: " + BookOptions.isDescendingOptionSet());
			
			Map<Integer, Book> books;
			try {
				books = BookReader.read(BOOKS_DATA_FILENAME);
				Collection<Book> bookCollection = books.values();
				List<Book> booksByAuthor = new ArrayList<>(bookCollection);
				if (BookOptions.isByAuthorOptionSet()) {
					Collections.sort(booksByAuthor, new BookSorter.CompareByAuthor());
				}
				if (BookOptions.isDescendingOptionSet()) {
					Collections.sort(booksByAuthor, new BookSorter.CompareByAuthorDescending());
				}
				HashMap<Integer, Book> sortedBooks = new LinkedHashMap<>();
				for (Iterator<Book> it = booksByAuthor.iterator(); it.hasNext();) {
					Book book = (Book) it.next();
					sortedBooks.put(book.getBook_id(), book);
				}
				BooksReport.write(sortedBooks);
			} catch (ApplicationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				LOG.error(e.getMessage());
			}		
			
		}

		if (BookOptions.isPurchasesOptionSet()) {
			LOG.debug("generating the inventory report");
			
			Map<Integer, Purchase> purchases = new HashMap<>();
			boolean isTotalSet = false;
			
			try {
				
				if (BookOptions.getCustomerId() != null) {
					Map<Integer, Purchase> purchasesByCustomer;
					purchasesByCustomer = PurchaseReader.read(PURCHASES_DATA_FILENAME,CUSTOMERS_DATA_FILENAME,BOOKS_DATA_FILENAME);
					
					for (Entry<Integer, Purchase> pur : purchasesByCustomer.entrySet()) {
						if (pur.getValue().getCustomer().getId() == Integer.parseInt(BookOptions.getCustomerId())) 
						{
							purchases.put(pur.getValue().getId(), pur.getValue());
						}
					}
				}
				else {
					purchases = PurchaseReader.read(PURCHASES_DATA_FILENAME,CUSTOMERS_DATA_FILENAME,BOOKS_DATA_FILENAME);
				}
				Collection<Purchase> purchaseCollection = purchases.values();
				List<Purchase> purchasesByBookTitle = new ArrayList<>(purchaseCollection);
				if (BookOptions.isByTitleOptionSet()) {
					Collections.sort(purchasesByBookTitle, new PurchaseSorter.CompareByBookTitle());
				}
				if (BookOptions.isTotalOptionSet()) {
					isTotalSet = true;
				}
				
				HashMap<Integer, Purchase> sortedPurchases = new LinkedHashMap<>();
				for (Iterator<Purchase> it = purchasesByBookTitle.iterator(); it.hasNext();) {
					Purchase purchase = (Purchase) it.next();
					sortedPurchases.put(purchase.getId(), purchase);
				}
				PurchasesReport.write(sortedPurchases, isTotalSet);
			} catch (ApplicationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				LOG.error(e.getMessage());
			}
		}
	}


}
