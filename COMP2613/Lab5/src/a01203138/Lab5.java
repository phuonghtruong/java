/**
 * 
 */
package a01203138;


import a01203138.data.Customer;
import a01203138.io.ApplicationException;
import a01203138.io.CompareByJoinDate;
import a01203138.io.CustomerReader;
import a01203138.io.CustomerReport;

import java.io.File;
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
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;

/**
 * @author Brian Truong Feb 9, 2021 Lab5.java
 */
public class Lab5 {
	private String customerData;
	private Map<Integer, Customer> customers;
	private static Logger Log;
	
	public static final String LOG4J_CONFIG_FILENAME = "log4j2.xml";
	static {
		configureLogging();
		Log = LogManager.getLogger(Lab5.class);
	}	

	public Lab5(String customerData) {
		this.customerData = customerData;
	}

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
		Instant begin = Instant.now();
		Log.info(begin);
		
		try {
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(new File("customers.txt"));
			String row = "";
			scanner.nextLine();
			while (scanner.hasNext()) {
				row += scanner.nextLine() + ":";
			}
			new Lab5(row).run();
		} catch (FileNotFoundException e) {
			Log.error(e.getMessage());
			e.getMessage();
			System.exit(1);
		}
		
		Instant end = Instant.now();
		Log.info(end);
		Duration duration = Duration.between(begin, end);
		Log.info("Duration: " + duration.toMillis() + " ms");
	}

	private void run() {
		try {
			customers = CustomerReader.read(customerData);
			Collection<Customer> customerCollection = customers.values();
			List<Customer> list = new ArrayList<>(customerCollection);
			Collections.sort(list, new CompareByJoinDate());
			Map<Integer, Customer> sortedCustomers = new HashMap<Integer, Customer>();
			int index = 0;
			for (Iterator<Customer> it = list.iterator(); it.hasNext();) {
				Customer cus = (Customer) it.next();
				sortedCustomers.put(index, cus);
				index++;
			}
			CustomerReport.write(sortedCustomers);
		} catch (ApplicationException e) {
			Log.error(e.getMessage());
		}

	}

}
