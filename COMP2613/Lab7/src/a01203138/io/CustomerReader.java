/**
 * 
 */
package a01203138.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

import java.util.Arrays;


import a01203138.data.Customer;
import a01203138.data.CustomerDao;
import a01203138.data.util.Validator;
import a01203138.io.ApplicationException;

/**
 * @author Brian Truong Feb 2, 2021 CustomerReader.java
 */

public class CustomerReader {

	public static final String RECORD_DELIMITER = ":";
	public static final String FIELD_DELIMITER = "\\|";

	private CustomerReader() {
	}


	public static void read(File customerDataFile, CustomerDao dao) throws ApplicationException {

		BufferedReader customerReader = null;
		try {
			customerReader = new BufferedReader(new FileReader(customerDataFile));

			String line = null;
			line = customerReader.readLine(); // skip the header line
			while ((line = customerReader.readLine()) != null) {
				Customer customer = readCustomerString(line);
				try {
					dao.add(customer);
				} catch (SQLException e) {
					throw new ApplicationException(e);
				}
			}
		} catch (IOException e) {
			throw new ApplicationException(e.getMessage());
		} finally {
			try {
				if (customerReader != null) {
					customerReader.close();
				}
			} catch (IOException e) {
				throw new ApplicationException(e.getMessage());
			}
		}
	}
	
	private static Customer readCustomerString(String data) throws ApplicationException {
		String[] elements = data.split(FIELD_DELIMITER);
		if (elements.length != Customer.ATTRIBUTE_COUNT) {
			throw new ApplicationException(String.format("Expected %d but got %d: %s", Customer.ATTRIBUTE_COUNT, elements.length, Arrays.toString(elements)));
		}

		int index = 0;
		String id = elements[index++];
		String firstName = elements[index++];
		String lastName = elements[index++];
		String street = elements[index++];
		String city = elements[index++];
		String postalCode = elements[index++];
		String phone = elements[index++];
		// should the email validation be performed here or in the customer class? I'm leaning towards putting it here.
		String emailAddress = elements[index++];
		if (!Validator.isValidEmail(emailAddress)) {
			throw new ApplicationException(String.format("Invalid email: %s", emailAddress));
		}
		String yyyymmdd = elements[index];
		if (!Validator.validateJoinedDate(yyyymmdd)) {
			throw new ApplicationException(String.format("Invalid joined date: %s for customer %d", yyyymmdd, id));
		}
		int year = Integer.parseInt(yyyymmdd.substring(0, 4));
		int month = Integer.parseInt(yyyymmdd.substring(4, 6));
		int day = Integer.parseInt(yyyymmdd.substring(6, 8));

		return new Customer.Builder(id, phone).//
				firstName(firstName).//
				lastName(lastName).//
				streetName(street).//
				city(city).//
				postalCode(postalCode).//
				emailAddress(emailAddress).//
				joinDate(year, month, day).build();
	}

}
