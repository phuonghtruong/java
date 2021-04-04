/**
 * 
 */
package a01203138.io;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import a01203138.book.data.Customer;

/**
 * @author Brian Truong Feb 2, 2021 CustomerReport.java
 */
public class CustomerReport {

	public static void write(Map<Integer, Customer> customers) {
		String dash = "-";
		// Print the list customer in tabular format.
		System.out.println("Customer Report");
		System.out.println(dash.repeat(150));
		System.out.printf("%-2s %-10s %-15s %-10s %-25s %-10s %-15s %-15s %-25s %-15s", "#.", "ID", "First name",
				"Last name", "Street", "City", "Postal Code", "Phone", "Email", "Joined Date");
		System.out.println();
		System.out.println(dash.repeat(150));
		for (Map.Entry<Integer, Customer> entry : customers.entrySet()) {

			String joinedDate = entry.getValue().getJoinDate();
			int year = Integer.parseInt(joinedDate.substring(0, 4));
			int month = Integer.parseInt(joinedDate.substring(4, 6));
			int day = Integer.parseInt(joinedDate.substring(6));
			LocalDate date = LocalDate.of(year, month, day);
			String formatDate = date.format(DateTimeFormatter.ofPattern("MMM dd yyyy"));

			System.out.format("%-2s %-10s %-15s %-10s %-25s %-10s %-15s %-15s %-25s %-15s", entry.getValue().getId(),
					String.format("%06d", Integer.parseInt(entry.getValue().getId())), entry.getValue().getFirstName(),
					entry.getValue().getLastName(), entry.getValue().getStreetName(), entry.getValue().getCity(),
					entry.getValue().getPostalCode(), entry.getValue().getPhone(), entry.getValue().getEmailAddress(),
					formatDate);
			System.out.println();
		}
		System.out.println(dash.repeat(150));
	}

}
