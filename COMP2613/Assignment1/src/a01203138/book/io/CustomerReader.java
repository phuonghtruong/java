/**
 * 
 */
package a01203138.book.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import a01203138.book.data.Customer;
import a01203138.book.data.util.Validator;
import a01203138.book.ApplicationException;


/**
 * @author Brian Truong Feb 2, 2021 CustomerReader.java
 */
@SuppressWarnings("unused")
public class CustomerReader {

	private static final String FIELD_DELIMITER = "\\|";

	private static Map<Integer, Customer> customer_list;

	public static Map<Integer, Customer> read(String customerData) throws ApplicationException {
		String customers = "";
		Scanner scanner;
		try {
			scanner = new Scanner(new File(customerData));
			
			scanner.nextLine();
			while (scanner.hasNext()) {
				customers += scanner.nextLine() + ":";
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String[] arr = customers.split(":");
		customer_list = new HashMap<Integer, Customer>();

		for (int index = 0; index < arr.length; index++) {

			String[] customerInfo = arr[index].split(FIELD_DELIMITER);
			if (customerInfo.length != Customer.ATTRIBUTE_COUNT) {
				throw new ApplicationException(
						String.format("Expected %d but got %d: %s", Customer.ATTRIBUTE_COUNT, customerInfo.length, Arrays.toString(customerInfo)));
			}

			int id = Integer.parseInt(customerInfo[0]);
			String firstName = customerInfo[1];
			String lastName = customerInfo[2];
			String streetName = customerInfo[3];
			String city = customerInfo[4];
			String postalCode = customerInfo[5];
			String phone = customerInfo[6];
			String emailAddress = customerInfo[7];
			if (!Validator.isValidEmail(emailAddress)) {
				throw new ApplicationException(emailAddress);
			}
			String joinDate = customerInfo[8];
			try {
				Validator.ValidateDate(joinDate);
			} catch (DateTimeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ApplicationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			customer_list.put(index,
					new Customer.Builder(id, phone).firstName(firstName).lastName(lastName).streetName(streetName)
							.city(city).postalCode(postalCode).emailAddress(emailAddress).joinDate(joinDate).build());
		}

		return customer_list;
	}

}

