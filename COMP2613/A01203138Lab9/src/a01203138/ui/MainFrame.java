package a01203138.ui;


import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;

import a01203138.data.customer.CustomerDao;
import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;


@SuppressWarnings("serial")
public class MainFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public MainFrame(CustomerDao customerDao) {
		setTitle("A01203138Lab9");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[]", "[]"));
		
		JMenuBar mainMenuBar = new JMenuBar();
		setJMenuBar(mainMenuBar);
		
		JMenu fileMenu = new JMenu("File");
		mainMenuBar.add(fileMenu);
		JMenu helpMenu = new JMenu("Help");
		mainMenuBar.add(helpMenu);
		
		JMenuItem customer = new JMenuItem("Customer", 'C');
		customer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.ALT_MASK));
		customer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					CustomerDialog dialog = new CustomerDialog(customerDao);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		fileMenu.add(customer);
		JMenuItem exit = new JMenuItem("Exit", 'X');
		exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.ALT_MASK));
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		fileMenu.add(exit);
		
		JMenuItem about = new JMenuItem("About");
		about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		about.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(MainFrame.this, "Lab 9\nBy Hoang Phuong Truong A01203138", "About Lab 9",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		helpMenu.add(about);
		
		
	}

}
