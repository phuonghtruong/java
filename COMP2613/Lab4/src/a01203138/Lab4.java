/**
 * 
 */
package a01203138;

import a01203138.book.data.Customer;
import a01203138.io.ApplicationException;
import a01203138.io.CompareByJoinDate;
import a01203138.io.CustomerReader;
import a01203138.io.CustomerReport;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author Brian Truong Feb 2, 2021 Lab3.java
 */
public class Lab4 {
	private String customerData;
	private Map<Integer, Customer> customers;

	public Lab4(String customerData) {
		this.customerData = customerData;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Instant begin = Instant.now();
		System.out.println(begin);
		if (args.length == 0) {
			System.out.println("Input data is missing. Expecting data");
			System.exit(-1);
		}
		new Lab4(args[0]).run();
		Instant end = Instant.now();
		System.out.println(end);
		Duration duration = Duration.between(begin, end);
		System.out.println("Duration: " + duration.toMillis() + " ms");
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

		}

	}

}
