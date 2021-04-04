package a01203138.book.ui;


import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import a01203138.book.data.PurchaseDao;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PurchaseDialog_CustomerIDFilter extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField_customerIDInput;
	private long customerIDInput;
	private List<Long> listCustomerIDs;
	private static final Logger LOG = LogManager.getLogger();

	/**
	 * Create the dialog.
	 */
	public PurchaseDialog_CustomerIDFilter(PurchaseDao purchaseDao) {
		setTitle("Filter by Customer ID");
		setBounds(100, 100, 313, 123);
		getContentPane().setLayout(new MigLayout("", "[436px]", "[232px][31px]"));
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, "cell 0 0,grow");
		{
			JLabel lblCustomerID = new JLabel("Enter Customer ID");
			contentPanel.add(lblCustomerID);
		}
		{
			textField_customerIDInput = new JTextField();
			contentPanel.add(textField_customerIDInput);
			textField_customerIDInput.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, "cell 0 1,growx,aligny top");
			{
				JButton okButton = new JButton("OK");
				try {
					listCustomerIDs = purchaseDao.getCustomerIDs();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					LOG.error(e1.getMessage());
				}
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String inputCustomerID = textField_customerIDInput.getText();
						if (inputCustomerID.isEmpty() || inputCustomerID.isBlank())
						{
							MainFrame.customerID = 0;
							dispose();
							return;
						}
						if (isNumeric(inputCustomerID) )
						{
							long customerID_inLong = Long.parseLong(inputCustomerID);
							if (listCustomerIDs.contains(customerID_inLong))
							{
								MainFrame.customerID = customerID_inLong;
								dispose();
								return;
							}
						}
						JOptionPane.showMessageDialog(new JFrame(), "Invalid Customer ID!!!", "Dialog",
								JOptionPane.ERROR_MESSAGE);
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
	}
	
	public long getCustomerIDInput() {
		return customerIDInput;
	}
	
	public void setCustomerIDInput(long customerID) {
		customerIDInput = customerID;
	}
	public static boolean isNumeric(String strNum) {
	    if (strNum == null) {
	        return false;
	    }
	    try {
	        long number = Long.parseLong(strNum);
	        if (number < 0) {
	        	return false;
	        }
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
	

}
