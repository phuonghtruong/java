package a01203138.book.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import a01203138.book.data.BookDao;
import a01203138.book.data.CustomerDao;
import a01203138.book.data.PurchaseDao;
import net.miginfocom.swing.MigLayout;

import javax.swing.AbstractButton;
import javax.swing.JCheckBoxMenuItem;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {

	private JPanel contentPane;
	public static long customerID;
	
	private static final Logger LOG = LogManager.getLogger();

	/**
	 * Create the frame.
	 */
	public MainFrame(CustomerDao customerDao, BookDao bookDao, PurchaseDao purchaseDao) {
		setTitle("Book");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[]", "[]"));
		
		JMenuBar mainMenuBar = new JMenuBar();
		setJMenuBar(mainMenuBar);
		
		// File Menu 
		JMenu fileMenu = new JMenu("File");
		mainMenuBar.add(fileMenu);
		
		
		JMenuItem drop = new JMenuItem("Drop");
		drop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog (null, "Would You Like to Drop all tables?","Warning",dialogButton);
				if(dialogResult == JOptionPane.YES_OPTION){
					try {
						purchaseDao.drop();
						customerDao.drop();
						bookDao.drop();
						System.exit(0);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						LOG.error(e1.getMessage());
					}
				}
			}
		});
		fileMenu.add(drop);
		
		JMenuItem quit = new JMenuItem("Quit", 'Q');
		quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		fileMenu.add(quit);
		
		// Books Menu
		JMenu booksMenu = new JMenu("Books");
		mainMenuBar.add(booksMenu);
		
		JMenuItem bookCount = new JMenuItem("Count");
		bookCount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String totalBooks = "";
				try {
					totalBooks = String.valueOf(bookDao.countAllBooks());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					LOG.error(e1.getMessage());
				}
				JOptionPane.showMessageDialog(MainFrame.this, "Total books: " + totalBooks, "",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		booksMenu.add(bookCount);
		JCheckBoxMenuItem byAuthor = new JCheckBoxMenuItem("By Author");
		byAuthor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AbstractButton aButton = (AbstractButton) e.getSource();
				boolean selected = aButton.getModel().isSelected();
				if (selected) {
					byAuthor.setState(true);
				}
				else {
					byAuthor.setState(false);
				}
			}
		});
		booksMenu.add(byAuthor);
		JCheckBoxMenuItem bookDescending = new JCheckBoxMenuItem("Descending");
		bookDescending.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AbstractButton aButton = (AbstractButton) e.getSource();
				boolean selected = aButton.getModel().isSelected();
				if (selected) {
					bookDescending.setState(true);
				}
				else {
					bookDescending.setState(false);
				}
			}
		});
		booksMenu.add(bookDescending);
		JMenuItem listBook = new JMenuItem("List");
		listBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					BookDialog dialog = new BookDialog(bookDao, byAuthor.getState(), bookDescending.getState());
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e2) {
					LOG.error(e2.getMessage());
				}
			}
		});
		booksMenu.add(listBook);
		
		// Customer Menu
		JMenu customersMenu = new JMenu("Customers");
		mainMenuBar.add(customersMenu);
		
		JMenuItem customerCount = new JMenuItem("Count");
		customerCount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String totalCustomers = "";
				try {
					totalCustomers = String.valueOf(customerDao.countAllCustomers());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					LOG.error(e1.getMessage());
				}
				JOptionPane.showMessageDialog(MainFrame.this, "Total customers: " + totalCustomers, "",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		customersMenu.add(customerCount);
		JCheckBoxMenuItem byJoinDate = new JCheckBoxMenuItem("By Join Date");
		byJoinDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AbstractButton aButton = (AbstractButton) e.getSource();
				boolean selected = aButton.getModel().isSelected();
				if (selected) {
					byJoinDate.setState(true);
				}
				else {
					byJoinDate.setState(false);
				}
			}
		});

		customersMenu.add(byJoinDate);
		JMenuItem listCustomer = new JMenuItem("List");
		listCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					CustomerDialog dialog = new CustomerDialog(customerDao, byJoinDate.getState());
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e1) {
					LOG.error(e1.getMessage());
				}
			}
		});
		customersMenu.add(listCustomer);
		
		// Purchases Menu
		JMenu purchasesMenu = new JMenu("Purchases");
		mainMenuBar.add(purchasesMenu);
		
		JMenuItem total = new JMenuItem("Total");
		total.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String totalPurchases = "";
				try {
					totalPurchases = String.valueOf(purchaseDao.countAllPurchases());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					LOG.error(e1.getMessage());
				}
				JOptionPane.showMessageDialog(MainFrame.this, "Total purchases: " + totalPurchases, "",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		purchasesMenu.add(total);
		
		JCheckBoxMenuItem byLastName = new JCheckBoxMenuItem("By Last Name");
		byLastName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AbstractButton aButton = (AbstractButton) e.getSource();
				boolean selected = aButton.getModel().isSelected();
				if (selected) {
					byLastName.setState(true);
				}
				else {
					byLastName.setState(false);
				}
			}
		});
		purchasesMenu.add(byLastName);
		
		JCheckBoxMenuItem byTitle = new JCheckBoxMenuItem("By Title");
		byTitle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AbstractButton aButton = (AbstractButton) e.getSource();
				boolean selected = aButton.getModel().isSelected();
				if (selected) {
					byTitle.setState(true);
				}
				else {
					byTitle.setState(false);
				}
			}
		});
		purchasesMenu.add(byTitle);
		
		JCheckBoxMenuItem purchaseDescending = new JCheckBoxMenuItem("Descending");
		purchaseDescending.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AbstractButton aButton = (AbstractButton) e.getSource();
				boolean selected = aButton.getModel().isSelected();
				if (selected) {
					purchaseDescending.setState(true);
				}
				else {
					purchaseDescending.setState(false);
				}
			}
		});
		purchasesMenu.add(purchaseDescending);
		
		JMenuItem filterByCustomerID = new JMenuItem("Filter by Customer ID");

		filterByCustomerID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					PurchaseDialog_CustomerIDFilter dialog = new PurchaseDialog_CustomerIDFilter(purchaseDao);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
					customerID = dialog.getCustomerIDInput();
				} catch (Exception e1) {
					LOG.error(e1.getMessage());
				}
			}
		});
		purchasesMenu.add(filterByCustomerID);
		
		JMenuItem listPurchases = new JMenuItem("List");
		listPurchases.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					PurchaseDialog dialog = new PurchaseDialog(customerDao,
							bookDao,
							purchaseDao, 
							byLastName.getState(), 
							byTitle.getState(), 
							purchaseDescending.getState(),
							customerID);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e3) {
					LOG.error(e3.getMessage());
				}
			}
		});
		purchasesMenu.add(listPurchases);
		
		// Help Menu
		JMenu helpMenu = new JMenu("Help");
		mainMenuBar.add(helpMenu);
		
		JMenuItem about = new JMenuItem("About");
		about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		about.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(MainFrame.this, "Assignment 2\nBy Hoang Phuong Truong A01203138", "About Book",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		helpMenu.add(about);
		
	}

}
