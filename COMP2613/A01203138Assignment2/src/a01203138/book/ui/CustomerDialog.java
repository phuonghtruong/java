package a01203138.book.ui;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import a01203138.book.data.Customer;
import a01203138.book.data.CustomerDao;
import a01203138.book.sorters.CustomerSorter;
import net.miginfocom.swing.MigLayout;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.JTable;
import javax.swing.SwingUtilities;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Dimension;


@SuppressWarnings("serial")
public class CustomerDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static final Logger LOG = LogManager.getLogger();

	/**
	 * Create the dialog.
	 */
	@SuppressWarnings("static-access")
	public CustomerDialog(CustomerDao customerDao, boolean isSortedByJoinDate) {
		setBounds(100, 100, 678, 300);
		setTitle("List of Customers");
		getContentPane().setLayout(new MigLayout("", "[644.00px]", "[232px][31px]"));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, "cell 0 0,grow");
		{
			String[] column = {"ID", "First Name", "Last Name", "Street", "City", "Postal Code", "Phone", "Email Address", "Joined Date"};
			Map<Long, Customer> customers = new HashMap<>();
			Map<Long, Customer> sortedCustomers = new HashMap<Long, Customer>();
			try {
				customers = customerDao.getAllCustomers();
				Collection<Customer> customerCollection = customers.values();
				List<Customer> list = new ArrayList<>(customerCollection);
				if (isSortedByJoinDate)
					Collections.sort(list, new CustomerSorter.CompareByJoinedDate());
				
				long index = 0;
				for (Iterator<Customer> it = list.iterator(); it.hasNext();) {
					Customer cus = (Customer) it.next();
					sortedCustomers.put(index, cus);
					index++;
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				LOG.error(e1.getMessage());
			}
			
			DefaultTableModel model = new DefaultTableModel();
			model.setColumnIdentifiers(column);
			table = new JTable();
			table.setPreferredScrollableViewportSize(new Dimension(600, 400));
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(SwingUtilities.isLeftMouseButton(e)) {
						if (table.getRowCount() != 0) {
							int row = table.getSelectedRow();
							long id = Long.valueOf((String) table.getValueAt(row, 0));
							Customer customer;
							try {
								customer = customerDao.getCustomer(id);
								CustomerDetailDialog dialog = new CustomerDetailDialog(customerDao, customer);
								dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
								dialog.setVisible(true);
							} catch (Exception e1) {
								LOG.error(e1.getMessage());
							}
						}
					}
				}
			});
			table.setModel(model);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
			
			table.setFillsViewportHeight(true);
			JScrollPane scroll = new JScrollPane(table);
			scroll.setAlignmentX(1.5f);
			scroll.setHorizontalScrollBarPolicy(
	                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	        scroll.setVerticalScrollBarPolicy(
	                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
			
			for (Map.Entry<Long,Customer> customer : sortedCustomers.entrySet()) {
				Customer cus = customer.getValue();
				model.addRow(new Object[] {
						String.valueOf(cus.getId()),
						cus.getFirstName(),
						cus.getLastName(),
						cus.getStreet(),
						cus.getCity(),
						cus.getPostalCode(),
						cus.getPhone(),
						cus.getEmailAddress(),
						String.valueOf(cus.getJoinedDate())
				});
			}			
			contentPanel.setLayout(new MigLayout("", "[774.00px]", "[402px]"));
			contentPanel.add(scroll, "cell 0 0,alignx left,aligny top");
			contentPanel.setVisible(true);			
			
		}
		
	}

}
