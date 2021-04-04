/**
 * 
 */
package a01203138.io;

import a01203138.data.Customer;

/**
 * @author Brian Truong
 * Jan 17, 2021
 * CustomerReader.java
 */
public class CustomerReader {

	private static Customer[] customer_arr;
	
	public static Customer[] read(String customerData) {
		
		String[] arr = customerData.split(":");
		customer_arr = new Customer[arr.length];
		
		for (int index = 0; index < arr.length; index++) {
			String[] customerInfo = arr[index].split("\\|");

			String id = customerInfo[0];
			String firstName = customerInfo[1];
			String lastName = customerInfo[2];
			String streetName = customerInfo[3];
			String city = customerInfo[4];
			String postalCode = customerInfo[5];
			String phone = customerInfo[6];
			String emailAddress = customerInfo[7];
			String joinDate = customerInfo[8];
			
			customer_arr[index] = new Customer.Builder(id, phone)
									   .firstName(firstName)
									   .lastName(lastName)
									   .streetName(streetName)
									   .city(city)
									   .postalCode(postalCode)
									   .emailAddress(emailAddress)
									   .joinDate(joinDate)
									   .build();
		}
		
		return customer_arr;
	}

}
