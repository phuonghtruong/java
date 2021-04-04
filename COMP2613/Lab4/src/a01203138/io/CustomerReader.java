/**
 * 
 */
package a01203138.io;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import a01203138.book.data.Customer;
import a01203138.data.util.Validator;
import a01203138.io.ApplicationException;

/**
 * @author Brian Truong Feb 2, 2021 CustomerReader.java
 */
@SuppressWarnings("unused")
public class CustomerReader {

	private static Map<Integer, Customer> customer_list;

	public static Map<Integer, Customer> read(String customerData) throws ApplicationException {

		String[] arr = customerData.split(":");
		customer_list = new HashMap<Integer, Customer>();

		for (int index = 0; index < arr.length; index++) {
			String[] customerInfo = arr[index].split("\\|");
			if (customerInfo.length != 9) {
				throw new ApplicationException(customerInfo.length, customerInfo);
			}

			String id = customerInfo[0];
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
			Validator.ValidateDate(joinDate);

			customer_list.put(index,
					new Customer.Builder(id, phone).firstName(firstName).lastName(lastName).streetName(streetName)
							.city(city).postalCode(postalCode).emailAddress(emailAddress).joinDate(joinDate).build());
		}

		return customer_list;
	}

}
