package a01203138.book.ui;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import a01203138.book.data.Customer;
import a01203138.book.data.CustomerDao;
import net.miginfocom.swing.MigLayout;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDate;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class CustomerDetailDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField firstNameField;
	private JTextField lastNameField;
	private JTextField streetField;
	private JTextField cityField;
	private JTextField postalCodeField;
	private JTextField phoneField;
	private JTextField emailField;
	private JTextField joinedDateField;

	private JTextField idField;
	private static final Logger LOG = LogManager.getLogger();

	/**
	 * Create the dialog.
	 */
	public CustomerDetailDialog(CustomerDao customerDao, Customer customer) {
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
				firstNameField.getDocument().addDocumentListener(new DocumentListener() {
					@Override
					public void changedUpdate(DocumentEvent e) {
						customer.setFirstName(firstNameField.getText());
					}

					@Override
					public void insertUpdate(DocumentEvent e) {
						customer.setFirstName(firstNameField.getText());
					}

					@Override
					public void removeUpdate(DocumentEvent e) {
						customer.setFirstName(firstNameField.getText());
					}				
					
				});

				JLabel lblLastName = new JLabel("Last Name");
				getContentPane().add(lblLastName, "cell 0 2,alignx trailing");
				lastNameField = new JTextField();
				lastNameField.setText("");
				getContentPane().add(lastNameField, "cell 1 2,growx");
				lastNameField.setColumns(10);
				lastNameField.getDocument().addDocumentListener(new DocumentListener() {
					@Override
					public void changedUpdate(DocumentEvent e) {
						customer.setLastName(lastNameField.getText());
					}

					@Override
					public void insertUpdate(DocumentEvent e) {
						customer.setLastName(lastNameField.getText());
					}

					@Override
					public void removeUpdate(DocumentEvent e) {
						customer.setLastName(lastNameField.getText());
					}				
					
				});

				JLabel lblStreet = new JLabel("Street");
				getContentPane().add(lblStreet, "cell 0 3,alignx trailing");
				streetField = new JTextField();
				getContentPane().add(streetField, "cell 1 3,growx");
				streetField.setColumns(10);
				streetField.getDocument().addDocumentListener(new DocumentListener() {
					@Override
					public void changedUpdate(DocumentEvent e) {
						customer.setStreet(streetField.getText());
					}

					@Override
					public void insertUpdate(DocumentEvent e) {
						customer.setStreet(streetField.getText());
					}

					@Override
					public void removeUpdate(DocumentEvent e) {
						customer.setStreet(streetField.getText());
					}				
					
				});

				JLabel lblCity = new JLabel("City");
				getContentPane().add(lblCity, "cell 0 4,alignx trailing");
				cityField = new JTextField();
				getContentPane().add(cityField, "cell 1 4,growx");
				cityField.setColumns(10);
				cityField.getDocument().addDocumentListener(new DocumentListener() {
					@Override
					public void changedUpdate(DocumentEvent e) {
						customer.setCity(cityField.getText());
					}

					@Override
					public void insertUpdate(DocumentEvent e) {
						customer.setCity(cityField.getText());
					}

					@Override
					public void removeUpdate(DocumentEvent e) {
						customer.setCity(cityField.getText());
					}				
					
				});

				JLabel lblPostalCode = new JLabel("Postal Code");
				getContentPane().add(lblPostalCode, "cell 0 5,alignx trailing");
				postalCodeField = new JTextField();
				getContentPane().add(postalCodeField, "cell 1 5,growx");
				postalCodeField.setColumns(10);
				postalCodeField.getDocument().addDocumentListener(new DocumentListener() {
					@Override
					public void changedUpdate(DocumentEvent e) {
						customer.setPostalCode(postalCodeField.getText());
					}

					@Override
					public void insertUpdate(DocumentEvent e) {
						customer.setPostalCode(postalCodeField.getText());
					}

					@Override
					public void removeUpdate(DocumentEvent e) {
						customer.setPostalCode(postalCodeField.getText());
					}				
					
				});

				JLabel lblPhone = new JLabel("Phone");
				getContentPane().add(lblPhone, "cell 0 6,alignx trailing");
				phoneField = new JTextField();
				getContentPane().add(phoneField, "cell 1 6,growx");
				phoneField.setColumns(10);
				phoneField.getDocument().addDocumentListener(new DocumentListener() {
					@Override
					public void changedUpdate(DocumentEvent e) {
						customer.setPhone(phoneField.getText());
					}

					@Override
					public void insertUpdate(DocumentEvent e) {
						customer.setPhone(phoneField.getText());
					}

					@Override
					public void removeUpdate(DocumentEvent e) {
						customer.setPhone(phoneField.getText());
					}				
					
				});

				JLabel lblEmail = new JLabel("Email");
				getContentPane().add(lblEmail, "cell 0 7,alignx trailing");
				emailField = new JTextField();
				getContentPane().add(emailField, "cell 1 7,growx");
				emailField.setColumns(10);
				emailField.getDocument().addDocumentListener(new DocumentListener() {
					@Override
					public void changedUpdate(DocumentEvent e) {
						customer.setEmailAddress(emailField.getText());
					}

					@Override
					public void insertUpdate(DocumentEvent e) {
						customer.setEmailAddress(emailField.getText());
					}

					@Override
					public void removeUpdate(DocumentEvent e) {
						customer.setEmailAddress(emailField.getText());
					}				
					
				});

				JLabel lblJoinedDate = new JLabel("Joined Date");
				getContentPane().add(lblJoinedDate, "cell 0 8,alignx trailing");
				joinedDateField = new JTextField();
				getContentPane().add(joinedDateField, "cell 1 8,growx");
				joinedDateField.setColumns(10);
				joinedDateField.getDocument().addDocumentListener(new DocumentListener() {
					@Override
					public void changedUpdate(DocumentEvent e) {
						String date = joinedDateField.getText();
						LocalDate newDate = LocalDate.parse(date);
						customer.setJoinedDate(newDate);
					}

					@Override
					public void insertUpdate(DocumentEvent e) {
						String date = joinedDateField.getText();
						LocalDate newDate = LocalDate.parse(date);
						customer.setJoinedDate(newDate);
					}

					@Override
					public void removeUpdate(DocumentEvent e) {
						String date = joinedDateField.getText();
						LocalDate newDate = LocalDate.parse(date);
						customer.setJoinedDate(newDate);
					}				
					
				});
			}
			{
				JPanel buttonPane = new JPanel();
				buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
				getContentPane().add(buttonPane, "cell 1 9,growx,aligny top");
				{
					JButton okButton = new JButton("OK");
					okButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							try {
								customerDao.update(customer);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								LOG.error(e1.getMessage());
							}
							dispose();
							new CustomerDialog(customerDao, false);
//							new BookStore().run();;

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
			
			setData(customer);
		}

		private void setData(Customer customer) {
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

}
