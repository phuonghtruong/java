/**
 * 
 */
package a01203138.book.io;

import a01203138.book.data.Customer;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
 * @author Brian Truong Feb 9, 2021 CustomerReport.java
 */
public class CustomersReport {

	public static final String HEADER_FORMAT   = "%4s. %-6s %-12s %-12s %-40s %-25s %-12s %-15s %-40s %-12s";
	public static final String CUSTOMER_FORMAT = "%4d. %06d %-12s %-12s %-40s %-25s %-12s %-15s %-40s %-12s";
	
	private static final Logger Log = LogManager.getLogger();
	
	public static void write(Map<Integer, Customer> customers) {
		File filename = new File("customers_report.txt");
		FileOutputStream fileOut;
		try {
			fileOut = new FileOutputStream(filename);
			PrintStream out = new PrintStream(fileOut);
		
			String dash = "-";
			// Print the list customer in tabular format.
			out.println("Customer Report");
			Log.info("Customer Report");
			out.println(dash.repeat(200));
			Log.info(dash.repeat(200));
			out.printf(HEADER_FORMAT, "#", "ID", "First name",
					"Last name", "Street", "City", "Postal Code", "Phone", "Email", "Joined Date");
			Log.info(String.format(HEADER_FORMAT, "#", "ID", "First name",
					"Last name", "Street", "City", "Postal Code", "Phone", "Email", "Joined Date"));
			out.println();
			out.println(dash.repeat(200));
			Log.info(dash.repeat(200));
			int i = 0;
			for (Map.Entry<Integer, Customer> entry : customers.entrySet()) {
	
				String joinedDate = entry.getValue().getJoinDate();
				int year = Integer.parseInt(joinedDate.substring(0, 4));
				int month = Integer.parseInt(joinedDate.substring(4, 6));
				int day = Integer.parseInt(joinedDate.substring(6));
				LocalDate date = LocalDate.of(year, month, day);
				String formatDate = date.format(DateTimeFormatter.ofPattern("MMM dd yyyy"));
				++i;
				out.printf(CUSTOMER_FORMAT, i,
						entry.getValue().getId(), entry.getValue().getFirstName(),
						entry.getValue().getLastName(), entry.getValue().getStreetName(), entry.getValue().getCity(),
						entry.getValue().getPostalCode(), entry.getValue().getPhone(), entry.getValue().getEmailAddress(),
						formatDate);
				out.println();
				Log.info(String.format(CUSTOMER_FORMAT, i,
						entry.getValue().getId(), entry.getValue().getFirstName(),
						entry.getValue().getLastName(), entry.getValue().getStreetName(), entry.getValue().getCity(),
						entry.getValue().getPostalCode(), entry.getValue().getPhone(), entry.getValue().getEmailAddress(),
						formatDate));
			}
			out.println(dash.repeat(200));
			Log.info(dash.repeat(200));
			out.close();
		} catch (FileNotFoundException e) {
			Log.error(e.getMessage());
			e.getMessage();
		}
	}

}

