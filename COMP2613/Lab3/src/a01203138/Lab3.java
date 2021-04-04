/**
 * 
 */
package a01203138;

import a01203138.data.Customer;
import a01203138.io.ApplicationException;
import a01203138.io.CustomerReader;
import a01203138.io.CustomerReport;

import java.time.Duration;
import java.time.Instant;

/**
 * @author Brian Truong
 * Jan 26, 2021
 * Lab3.java
 */
public class Lab3 {
	private String customerData;
	private Customer[] customers;

	public Lab3(String customerData) {
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
		new Lab3(args[0]).run();
		Instant end = Instant.now();
		System.out.println(end);
		Duration duration = Duration.between(begin, end);
		System.out.println("Duration: " + duration.toMillis() + " ms");
	}

	private void run() {
		try {
			customers = CustomerReader.read(customerData);
			CustomerReport.write(customers);
		} catch (ApplicationException e) {
			
		}

		
	}

}
