/**
 * 
 */
package a01203138.io;

import a01203138.data.Customer;
import a01203138.data.util.Validator;

/**
 * @author Brian Truong
 * Jan 17, 2021
 * CustomerReport.java
 */
public class CustomerReport {

	public static void write(Customer[] customers) {
		String dash = "-";
		// Print the list customer in tabular format.
		System.out.println("Customer Report");
		System.out.println(dash.repeat(140));
	    System.out.printf("%-2s %-10s %-15s %-10s %-25s %-10s %-15s %-15s %-25s", 
	    		"#.","ID", "First name","Last name", "Street", "City", "Postal Code", "Phone", "Email");
	    System.out.println();
	    System.out.println(dash.repeat(140));
	    for(Customer customer: customers){
	    	String customer_email = customer.getEmailAddress();
	    	
	    	if (!Validator.isValidEmail(customer_email))
	    	{
	    		customer_email = "N/A";
	    	}
	        System.out.format("%-2s %-10s %-15s %-10s %-25s %-10s %-15s %-15s %-25s",
	        		customer.getId(), String.format("%06d",Integer.parseInt(customer.getId())), customer.getFirstName(),
	        		customer.getLastName(), customer.getStreetName(), customer.getCity(),
	        		customer.getPostalCode(), customer.getPhone(), customer_email);
	        System.out.println();
	    }
	    System.out.println(dash.repeat(140));
	}

}
