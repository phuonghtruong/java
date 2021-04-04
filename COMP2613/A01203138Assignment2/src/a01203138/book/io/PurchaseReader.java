/**
 * Project: Books
 * File: PurchaseReader.java
 */

package a01203138.book.io;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;


import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import a01203138.book.ApplicationException;
import a01203138.book.data.Purchase;
import a01203138.book.data.PurchaseDao;



/**
 * @author Hoang Phuong Truong, A01203138
 *
 */
public class PurchaseReader extends Reader {

//    public static final String FILENAME = "purchases.csv";

    private static final Logger LOG = LogManager.getLogger();
//    private static Set<Long> customerIds = AllData.getCustomers().keySet();
//    private static Long[] customerIdArray = customerIds.toArray(new Long[0]);
//    private static int customerIdCount = customerIdArray.length;
//    private static Set<Long> bookIds = AllData.getBooks().keySet();
//    private static Long[] bookIdArray = bookIds.toArray(new Long[0]);
//    private static int bookIdCount = bookIdArray.length;

    /**
     * private constructor to prevent instantiation
     */
    private PurchaseReader() {
    }

    /**
     * Read the inventory input data.
     * 
     * @return the inventory.
     * @throws ApplicationException
     */
    public static void read(File purchaseDataFile, PurchaseDao dao) throws ApplicationException {
        FileReader in;
        Iterable<CSVRecord> records;
        try {
            in = new FileReader(purchaseDataFile);
            records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(in);
        } catch (IOException e) {
            throw new ApplicationException(e);
        }

        LOG.debug("Reading" + purchaseDataFile.getAbsolutePath());
        for (CSVRecord record : records) {
            long id = Long.parseLong(record.get("id"));
            long customerId = Long.parseLong(record.get("customer_id"));
            long bookId = Long.parseLong(record.get("book_id"));
            float price = Float.parseFloat(record.get("price"));

            Purchase purchase = new Purchase.Builder(id, customerId, bookId, price).build();
            try {
				dao.add(purchase);
			} catch (SQLException e) {
				throw new ApplicationException(e);
			}

//            if (!customerIds.contains(customerId)) {
//                customerId = customerIdArray[(int) (Math.random() * customerIdCount)];
//            }
//            if (!bookIds.contains(bookId)) {
//                bookId = bookIdArray[(int) (Math.random() * bookIdCount)];
//            }
        }
        
        if (in != null) {
            try {
                in.close();
            } catch (IOException e) {
                throw new ApplicationException(e);
            }
        }

    }

}
