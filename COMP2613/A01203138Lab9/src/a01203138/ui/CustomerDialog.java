package a01203138.ui;


import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import a01203138.data.customer.Customer;
import a01203138.data.customer.CustomerDao;


import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import java.awt.event.ActionEvent;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;


@SuppressWarnings("serial")
public class CustomerDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField firstNameField;
	private JTextField lastNameField;
	private JTextField streetField;
	private JTextField cityField;
	private JTextField postalCodeField;
	private JTextField phoneField;
	private JTextField emailField;
	private JTextField joinedDateField;
	private CustomerDao customerDao;
	private JTextField idField;


	/**
	 * Create the dialog.
	 */
	public CustomerDialog(CustomerDao customerDao) {
		this.customerDao = customerDao;
		setBounds(100, 100, 539, 325);
		getContentPane().setLayout(new MigLayout("", "[63.00][grow]", "[][][][][][][][][][grow]"));
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, "cell 0 0,alignx trailing");
		{
			JLabel lblId = new JLabel("ID");
			contentPanel.add(lblId);
			
			idField = new JTextField();
			idField.setEnabled(false);
			idField.setEditable(false);
			getContentPane().add(idField, "cell 1 0,growx");
			idField.setColumns(10);

			JLabel lblFirstName = new JLabel("First Name");
			getContentPane().add(lblFirstName, "cell 0 1,alignx trailing");
			firstNameField = new JTextField();
			getContentPane().add(firstNameField, "cell 1 1,growx");
			firstNameField.setColumns(10);

			JLabel lblLastName = new JLabel("Last Name");
			getContentPane().add(lblLastName, "cell 0 2,alignx trailing");
			lastNameField = new JTextField();
			lastNameField.setText("");
			getContentPane().add(lastNameField, "cell 1 2,growx");
			lastNameField.setColumns(10);

			JLabel lblStreet = new JLabel("Street");
			getContentPane().add(lblStreet, "cell 0 3,alignx trailing");
			streetField = new JTextField();
			getContentPane().add(streetField, "cell 1 3,growx");
			streetField.setColumns(10);

			JLabel lblCity = new JLabel("City");
			getContentPane().add(lblCity, "cell 0 4,alignx trailing");
			cityField = new JTextField();
			getContentPane().add(cityField, "cell 1 4,growx");
			cityField.setColumns(10);

			JLabel lblPostalCode = new JLabel("Postal Code");
			getContentPane().add(lblPostalCode, "cell 0 5,alignx trailing");
			postalCodeField = new JTextField();
			getContentPane().add(postalCodeField, "cell 1 5,growx");
			postalCodeField.setColumns(10);

			JLabel lblPhone = new JLabel("Phone");
			getContentPane().add(lblPhone, "cell 0 6,alignx trailing");
			phoneField = new JTextField();
			getContentPane().add(phoneField, "cell 1 6,growx");
			phoneField.setColumns(10);

			JLabel lblEmail = new JLabel("Email");
			getContentPane().add(lblEmail, "cell 0 7,alignx trailing");
			emailField = new JTextField();
			getContentPane().add(emailField, "cell 1 7,growx");
			emailField.setColumns(10);

			JLabel lblJoinedDate = new JLabel("Joined Date");
			getContentPane().add(lblJoinedDate, "cell 0 8,alignx trailing");
			joinedDateField = new JTextField();
			getContentPane().add(joinedDateField, "cell 1 8,growx");
			joinedDateField.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, "cell 1 9,growx,aligny top");
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		setData();
	}

	private void setData() {
		Customer customer = getRandomCustomer();
		idField.setText(String.valueOf(customer.getId()));
		firstNameField.setText(customer.getFirstName());
		lastNameField.setText(customer.getLastName());
		streetField.setText(customer.getStreet());
		cityField.setText(customer.getCity());
		postalCodeField.setText(customer.getPostalCode());
		phoneField.setText(customer.getPhone());
		emailField.setText(customer.getEmailAddress());
		joinedDateField.setText(customer.getJoinedDate().toString());

	}
	
	private Customer getRandomCustomer() {
		Customer customer = null;		
		List<Long> ids = null;
		try {
			ids = customerDao .getCustomerIds();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		Random rand = new Random();
		long randomId = ids.get(rand.nextInt(ids.size()));

		try {
			customer = customerDao.getCustomer((long) randomId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return customer;
	}
}
