package a01203138.book.io;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import a01203138.book.ApplicationException;
import a01203138.book.data.Book;
import a01203138.book.data.Customer;
import a01203138.book.data.Purchase;


public class PurchaseReader {
	public static final String FIELD_DELIMITER = ",";
	private static final Logger LOG = LogManager.getLogger();

	private static Customer cus;
	private static Book boo;

	public static Map<Integer, Purchase> read(String purchaseData, String customerData, String bookData ) throws ApplicationException {
		
		Map<Integer, Purchase>purchase_list = new HashMap<Integer, Purchase>();

		File file = new File(purchaseData);
		FileReader in;
		Iterable<CSVRecord>records;
		try {
			in = new FileReader(file);
			records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(in);
		}catch (IOException e) {
			throw new ApplicationException(e);
		}
		
		LOG.debug("Reading" + file.getAbsolutePath());
		
		Map<Integer, Customer> customers_list = CustomerReader.read(customerData);
		Map<Integer, Book> books_list = BookReader.read(bookData);
				
		for (CSVRecord record : records) {
			
			int id = Integer.parseInt(record.get("id"));
			int customer_id = Integer.parseInt(record.get("customer_id"));
			int book_id = Integer.parseInt(record.get("book_id"));
			double price = Double.parseDouble(record.get("price"));				
			
			for (Map.Entry<Integer, Customer> customer : customers_list.entrySet()){
				if (customer.getValue().getId() == customer_id) {
					cus = customer.getValue();
					break;
				}
			}
			
			for (Map.Entry<Integer, Book> book : books_list.entrySet()){
				if (book.getValue().getBook_id() == book_id) {
					boo = book.getValue();
					break;
				}
			}
			purchase_list.put(id,
					new Purchase.Builder(id, cus, boo, price).build());
		}

		return purchase_list;
	}
}
