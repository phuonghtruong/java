package a01203138.book.ui;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import a01203138.book.data.Book;
import a01203138.book.data.BookDao;
import a01203138.book.data.Customer;
import a01203138.book.data.CustomerDao;
import a01203138.book.data.Purchase;
import a01203138.book.data.PurchaseDao;
import a01203138.book.sorters.PurchaseSorter;
import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class PurchaseDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static final Logger LOG = LogManager.getLogger();

	/**
	 * Create the dialog.
	 */
	@SuppressWarnings("static-access")
	public PurchaseDialog(CustomerDao customerDao, BookDao bookDao,PurchaseDao purchaseDao, 
			boolean byLastName, boolean byTitle, 
			boolean descending, long customerID) {
		setBounds(100, 100, 500, 300);
		setTitle("List of Purchases");
		getContentPane().setLayout(new MigLayout("", "[600px]", "[232px][31px]"));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			String[] column = {"First Name", "Last Name", "Title", "Price"};
			Map<Long, Purchase> purchases = new HashMap<>();
			Map<Long, Purchase> sortedPurchases = new HashMap<Long, Purchase>();
			try {
				purchases = purchaseDao.getAllPurchases();
				Collection<Purchase> purchaseCollection = purchases.values();
				List<Purchase> list = new ArrayList<>(purchaseCollection);
				if (byLastName)
					Collections.sort(list, new PurchaseSorter.CompareByLastName());
				if (byTitle)
					Collections.sort(list, new PurchaseSorter.CompareByBookTitle());
				if (descending && byTitle)
					Collections.sort(list, new PurchaseSorter.CompareByBookTitleDescending());
				if (descending && byLastName)
					Collections.sort(list, new PurchaseSorter.CompareByLastNameDescending());
				long index = 0;
				for (Iterator<Purchase> it = list.iterator(); it.hasNext();) {
					Purchase purchase = (Purchase) it.next();
					
					sortedPurchases.put(index, purchase);
					index++;
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				LOG.error(e1.getMessage());
			}
			
			DefaultTableModel model = new DefaultTableModel();
			model.setColumnIdentifiers(column);
			table = new JTable();
			
			table.setModel(model);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			
			table.setFillsViewportHeight(true);
			JScrollPane scroll = new JScrollPane(table);
			scroll.setHorizontalScrollBarPolicy(
	                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	        scroll.setVerticalScrollBarPolicy(
	                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
			
			for (Map.Entry<Long,Purchase> purchase : sortedPurchases.entrySet()) {
				Purchase pur = purchase.getValue();
				long cusID = pur.getCustomerId();
				long bookID = pur.getBookId();
				Customer cus;
				try {
					cus = customerDao.getCustomer(cusID);
					if (customerID != 0)
					{
						if (customerID != cus.getId())
							continue;
					}
					Book book = bookDao.getBook(bookID);
					model.addRow(new Object[] {
							cus.getFirstName(),
							cus.getLastName(),
							book.getTitle(),
							pur.getPrice()
					});
				} catch (Exception e) {
					// TODO Auto-generated catch block
					LOG.error(e.getMessage());
				}			
			}			
			contentPanel.setLayout(new MigLayout("", "[774.00px]", "[402px]"));
			contentPanel.add(scroll, "cell 0 0,alignx left,aligny top");
			contentPanel.setVisible(true);
		}
	}

}
