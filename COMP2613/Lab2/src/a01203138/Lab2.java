/**
 * 
 */
package a01203138;

import a01203138.data.Customer;
import a01203138.io.CustomerReader;
import a01203138.io.CustomerReport;

/**
 * @author Brian Truong
 * Jan 17, 2021
 * Lab2.java
 */
public class Lab2 {
	private String customerData;
	private Customer[] customers;

	public Lab2(String customerData) {
		this.customerData = customerData;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Input data is missing. Expecting data");
			System.exit(-1);
		}
		new Lab2(args[0]).run();
	}

	private void run() {
		customers = CustomerReader.read(customerData);
		CustomerReport.write(customers);
		
	}

}
