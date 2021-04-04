/**
 * Project: A00123456Lab7
 * File: Lab7.java
 */

package a01203138;

import java.awt.EventQueue;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.time.Duration;
import java.time.Instant;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;

import a01203138.data.customer.CustomerDao;
import a01203138.db.Database;
import a01203138.ui.MainFrame;

/**
 * To demonstrate knowledge of JDBC
 * 
 * @author Hoang Phuong Truong, A01203138
 *
 */
public class Lab9 {

	private static final Instant startTime = Instant.now();
	private static final String DROP_OPTION = "-drop";
	private static final String LOG4J_CONFIG_FILENAME = "log4j2.xml";
	private static final String PLAYERS_DATA_FILENAME = "customers.txt";
	private static final String DB_PROPERTIES_FILENAME = "db.properties";

	static {
		configureLogging();
	}

	private static final Logger LOG = LogManager.getLogger();

	private static void configureLogging() {
		ConfigurationSource source;
		try {
			source = new ConfigurationSource(new FileInputStream(LOG4J_CONFIG_FILENAME));
			Configurator.initialize(null, source);
		} catch (IOException e) {
			System.out.println(String.format("Can't find the log4j logging configuration file %s.", LOG4J_CONFIG_FILENAME));
		}
	}

	/**
	 * @param args
	 * @throws IOException
	 * @throws FileNotFoundException
	 */

	public static void main(String[] args) throws FileNotFoundException, IOException {
		LOG.info("Start: " + startTime);

		if (args.length == 1 && args[0].equalsIgnoreCase(DROP_OPTION)) {
			Database.requestDbTableDrop();
		}

		File file = new File(PLAYERS_DATA_FILENAME);
		if (!file.exists()) {
			System.out.format("Required '%s' is missing.", PLAYERS_DATA_FILENAME);
			System.exit(-1);
		}

		final CustomerDao customerDao = new Lab9().run();
		
		try {
			for (LookAndFeelInfo info:UIManager.getInstalledLookAndFeels()) {
				if("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getName());
					break;
				}
			}
		} catch (Exception e) {
			// if Nimbus is not available, use the default
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame(customerDao);
					frame.setVisible(true);
					JFrame.setDefaultLookAndFeelDecorated(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		Instant endTime = Instant.now();
		LOG.info("End: " + endTime);
		LOG.info(String.format("Duration: %d ms", Duration.between(startTime, endTime).toMillis()));
	}

	/**
	 * Populate the customers and print them out.
	 */
	private CustomerDao run() {
		CustomerDao customerDao = null;
		try {
			Database db = connect();
			customerDao = loadCustomers(db);

			new CustomerDaoTester(customerDao).test();
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
		
		return customerDao;
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

	private Database connect() throws IOException, SQLException, ApplicationException {
		Properties dbProperties = new Properties();
		dbProperties.load(new FileInputStream(DB_PROPERTIES_FILENAME));
		Database db = new Database(dbProperties);

		return db;
	}

}
