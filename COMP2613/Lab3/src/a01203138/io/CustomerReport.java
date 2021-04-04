/**
 * 
 */
package a01203138.io;

import a01203138.data.Customer;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


/**
 * @author Brian Truong
 * Jan 26, 2021
 * CustomerReport.java
 */
public class CustomerReport {

	public static void write(Customer[] customers) {
		String dash = "-";
		// Print the list customer in tabular format.
		System.out.println("Customer Report");
		System.out.println(dash.repeat(150));
	    System.out.printf("%-2s %-10s %-15s %-10s %-25s %-10s %-15s %-15s %-25s %-15s", 
	    		"#.","ID", "First name","Last name", "Street", "City", "Postal Code", "Phone", "Email", "Joined Date");
	    System.out.println();
	    System.out.println(dash.repeat(150));
	    for(Customer customer: customers){
   	
	    	String joinedDate = customer.getJoinDate();
	    	int year = Integer.parseInt(joinedDate.substring(0, 4));
	    	int month = Integer.parseInt(joinedDate.substring(4, 6));
	    	int day = Integer.parseInt(joinedDate.substring(6));
	    	LocalDate date = LocalDate.of(year, month, day);
	    	String formatDate = date.format(DateTimeFormatter.ofPattern("MMM dd yyyy"));
	    			
	        System.out.format("%-2s %-10s %-15s %-10s %-25s %-10s %-15s %-15s %-25s %-15s",
	        		customer.getId(), String.format("%06d",Integer.parseInt(customer.getId())), customer.getFirstName(),
	        		customer.getLastName(), customer.getStreetName(), customer.getCity(),
	        		customer.getPostalCode(), customer.getPhone(), customer.getEmailAddress(), formatDate);
	        System.out.println();
	    }
	    System.out.println(dash.repeat(150));
	}

}
