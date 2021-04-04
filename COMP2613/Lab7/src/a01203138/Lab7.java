/**
 * 
 */
package a01203138;

import a01203138.db.Database;
import a01203138.io.ApplicationException;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.sql.SQLException;
import java.time.Duration;
import java.time.Instant;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;


import a01203138.data.CustomerDao;
import a01203138.CustomerDaoTest;

/**
 * @author Brian Truong Feb 9, 2021 Lab5.java
 */
public class Lab7 {
	
	private static final Instant startTime = Instant.now();
	private static final String DROP_OPTION = "-drop";
	private static final String LOG4J_CONFIG_FILENAME = "log4j2.xml";
	private static final String PLAYERS_DATA_FILENAME = "customers.txt";
	private static final String DB_PROPERTIES_FILENAME = "db.properties";
	
	static {
		configureLogging();
	}	
	
	private static final Logger Log = LogManager.getLogger();


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
	 */
	public static void main(String[] args) {
		Log.info("Start: " + startTime);

		if (args.length == 1 && args[0].equalsIgnoreCase(DROP_OPTION)) {
			Database.requestDbTableDrop();
		}

		File file = new File(PLAYERS_DATA_FILENAME);
		if (!file.exists()) {
			System.out.format("Required '%s' is missing.", PLAYERS_DATA_FILENAME);
			System.exit(-1);
		}

		new Lab7().run();

		Instant endTime = Instant.now();
		Log.info("End: " + endTime);
		Log.info(String.format("Duration: %d ms", Duration.between(startTime, endTime).toMillis()));
	}

	private void run() {
		try {
			Database db = connect();
			CustomerDao customerDao = loadCustomers(db);

			new CustomerDaoTest(customerDao).test();
		} catch (Exception e) {
			Log.error(e.getMessage());
		}
		
	}
	
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
