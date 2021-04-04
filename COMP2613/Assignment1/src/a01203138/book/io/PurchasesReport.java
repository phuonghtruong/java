package a01203138.book.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import a01203138.book.data.Purchase;



public class PurchasesReport {
	public static final String HEADER_FORMAT   = "%-24s %-80s $%5s";
	public static final String PURCHASE_FORMAT = "%-24s %-80s $%.2f";
	
	private static final Logger Log = LogManager.getLogger();
	
	public static void write(Map<Integer, Purchase> purchases, boolean isTotalSet) {
		File filename = new File("purchase_report.txt");
		FileOutputStream fileOut;
		double sum = 0.0;
		try {
			fileOut = new FileOutputStream(filename);
			PrintStream out = new PrintStream(fileOut);
		
			String dash = "-";
			// Print the list customer in tabular format.
			out.println("Purchase Report");
			Log.info("Purchase Report");
			out.println(dash.repeat(200));
			Log.info(dash.repeat(200));
			out.printf(HEADER_FORMAT, "Name", "Title", "Price");
			Log.info(String.format(HEADER_FORMAT, "Name", "Title", "Price"));
			out.println();
			out.println(dash.repeat(200));
			Log.info(dash.repeat(200));
			
			for (Map.Entry<Integer, Purchase> purchase : purchases.entrySet()) {	
				out.printf(PURCHASE_FORMAT,
						purchase.getValue().getCustomer().getFirstName() + " " + purchase.getValue().getCustomer().getLastName(),
						purchase.getValue().getBook().getOriginal_title(), 						 
						purchase.getValue().getPrice()
						);
				out.println();
				Log.info(String.format(PURCHASE_FORMAT,
						purchase.getValue().getCustomer().getFirstName() + " " + purchase.getValue().getCustomer().getLastName(),
						purchase.getValue().getBook().getOriginal_title(), 						 
						purchase.getValue().getPrice()
						));
				sum += purchase.getValue().getPrice();
			}
			if (isTotalSet) {
				out.println();
				Log.info("\n");
				out.printf("Value of purchases : $%.2f", sum);
				Log.info(String.format("Value of purchases : $%.2f", sum));
				out.println();
				Log.info("\n");
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
