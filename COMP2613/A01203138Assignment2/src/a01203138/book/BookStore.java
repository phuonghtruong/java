package a01203138.book;

import java.awt.EventQueue;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.SQLException;
import java.time.Duration;
import java.time.Instant;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;
import org.apache.logging.log4j.core.config.DefaultConfiguration;


import a01203138.book.data.AllData;
import a01203138.book.data.BookDao;
import a01203138.book.data.CustomerDao;
import a01203138.book.data.PurchaseDao;
import a01203138.book.db.Database;
import a01203138.book.io.BooksReport;
import a01203138.book.io.CustomersReport;
import a01203138.book.io.PurchasesReport;
import a01203138.book.ui.MainFrame;



/**
 * Project: Books
 * File: BookStore.java
 */

/**
 * @author Hoang Phuong Truong, A01203138
 *
 */
public class BookStore {

	private static final String DROP_OPTION = "-drop";
	private static final String LOG4J_CONFIG_FILENAME = "log4j2.xml";
	private static final String CUSTOMER_DATA_FILENAME = "customers.dat";
	private static final String BOOK_DATA_FILENAME = "books500.csv";
	private static final String PURCHASE_DATA_FILENAME = "purchases.csv";
	private static final String DB_PROPERTIES_FILENAME = "db.properties";
	
	private static CustomerDao customerDao;
	private static BookDao bookDao;
	private static PurchaseDao purchaseDao;
	
    static {
        configureLogging();
    }
    private static final Logger LOG = LogManager.getLogger();

    /**
     * Book Constructor. Processes the commandline arguments
     * ex. -inventory -make=honda -by_count -desc -total -service
     * 
     * @throws ApplicationException
     * @throws ParseException
     */

    /**
     * Entry point to GIS
     * 
     * @param args
     * @throws IOException
     * @throws FileNotFoundException
     */
    public static void main(String[] args) {
        LOG.info("Starting Books");
        Instant startTime = Instant.now();
        LOG.info(startTime);

		File customersFile = new File(CUSTOMER_DATA_FILENAME);
		File booksFile = new File(BOOK_DATA_FILENAME);
		File purchasesFile = new File(PURCHASE_DATA_FILENAME);
		
		if (!customersFile.exists()) {
			System.out.format("Required '%s' is missing.", CUSTOMER_DATA_FILENAME);
			System.exit(-1);
		}
		if (!booksFile.exists()) {
			System.out.format("Required '%s' is missing.", BOOK_DATA_FILENAME);
			System.exit(-1);
		}
		if (!purchasesFile.exists()) {
			System.out.format("Required '%s' is missing.", PURCHASE_DATA_FILENAME);
			System.exit(-1);
		}

		BookStore bookStore = new BookStore();
        bookStore.run();
        
        EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame(customerDao, bookDao, purchaseDao);
					frame.setVisible(true);
				} catch (Exception e) {
					LOG.error(e.getMessage());
				}
			}
		});

        Instant endTime = Instant.now();
        LOG.info(endTime);
        LOG.info(String.format("Duration: %d ms", Duration.between(startTime, endTime).toMillis()));
        LOG.info("Books has stopped");
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
     * Generate the reports from the input data
     * 
     * @throws FileNotFoundException
     */
    @SuppressWarnings("unused")
	private void generateReports() throws FileNotFoundException {
        LOG.debug("generating the reports");

        PrintStream out = null;

        if (BookOptions.isCustomersOptionSet()) {
            LOG.debug("generating the customer report");
            CustomersReport.print(System.out);
            out = getOutputStream(CustomersReport.REPORT_FILENAME);
            CustomersReport.print(out);
            out.close();
        }

        if (BookOptions.isBooksOptionSet()) {
            LOG.debug("generating the book report");
            BooksReport.print(System.out);
            out = getOutputStream(BooksReport.REPORT_FILENAME);
            BooksReport.print(out);
            out.close();
        }

        if (BookOptions.isPurchasesOptionSet()) {
            LOG.debug("generating the purchase report");
            PurchasesReport.print(System.out);
            out = getOutputStream(PurchasesReport.REPORT_FILENAME);
            PurchasesReport.print(out);
            out.close();
        }

    }

    /**
     * @param reportFilename
     * @return
     * @throws ApplicationException
     * @throws FileNotFoundException
     */
    private PrintStream getOutputStream(String reportFilename) throws FileNotFoundException {
        PrintStream out = null;
        try {
            out = new PrintStream(new File(reportFilename));
        } catch (FileNotFoundException e) {
            LOG.error(e.getMessage());
            throw e;
        }

        return out;
    }

    /**
	 * Populate the customers and print them out.
	 */
	public void run() {
		try {
			Database db = connect();
			customerDao = loadCustomers(db);
			bookDao = loadBooks(db);
			purchaseDao = loadPurchases(db);
			try {
				AllData.loadData();
			} catch (ApplicationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
	}

	/**
	 * Load the customers.
	 * 
	 * @TODO this method has much to much knowledge of the DB and should be refactored.
	 * 
	 * @throws IOException
	 * @throws SQLException
	 * @throws ApplicationException
	 */
	private CustomerDao loadCustomers(Database db) throws ApplicationException {
		CustomerDao customerDao = new CustomerDao(db);
		return customerDao;
	}

	private BookDao loadBooks(Database db) throws ApplicationException {
		BookDao bookDao = new BookDao(db);
		return bookDao;
	}
	
	private PurchaseDao loadPurchases(Database db) throws ApplicationException {
		PurchaseDao purchaseDao = new PurchaseDao(db);
		return purchaseDao;
	}
	
	private Database connect() throws IOException, SQLException, ApplicationException {
		Properties dbProperties = new Properties();
		dbProperties.load(new FileInputStream(DB_PROPERTIES_FILENAME));
		Database db = new Database(dbProperties);

		return db;
	}


}
