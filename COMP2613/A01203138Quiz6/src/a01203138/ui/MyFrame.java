package a01203138.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class MyFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtFieldValue;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyFrame frame = new MyFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MyFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Temperature Converter");
		setBackground(Color.gray);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][][grow]", "[][][][][][][][][][]"));
		
		JLabel lblValue = new JLabel("Enter Value:");
		contentPane.add(lblValue, "cell 3 1");
		
		txtFieldValue = new JTextField();
		contentPane.add(txtFieldValue, "cell 3 2,growx");
		txtFieldValue.setColumns(10);
		
		textField_1 = new JTextField();
		contentPane.add(textField_1, "cell 3 7,growx");
		textField_1.setColumns(10);
		
		JButton btnCelsius = new JButton("To Celsius");
		btnCelsius.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double value = Double.parseDouble(txtFieldValue.getText());
				double cel = (value - 32) * 5/9;
				String cel_inStr = String.valueOf(cel);
				textField_1.setText(String.format("%.2f",cel) + "C");
			}
		});
		contentPane.add(btnCelsius, "flowx,cell 3 4");
		
		JButton btnFahrenheit = new JButton("To Fahrenheit");
		btnFahrenheit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double value = Double.parseDouble(txtFieldValue.getText());
				double fahrenheit = (value * 9 /5 ) + 32;
				String fahrenheit_inStr = String.valueOf(fahrenheit);
				textField_1.setText(String.format("%.2f",fahrenheit) + "F");
			}
		});
		contentPane.add(btnFahrenheit, "cell 3 4");
		
		JLabel lblNewLabel_1 = new JLabel("Converted Temperature");
		contentPane.add(lblNewLabel_1, "cell 3 6");		

		JButton btnNewButton_2 = new JButton("RESET");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_1.setText("");
				txtFieldValue.setText("");
			}
		});
		contentPane.add(btnNewButton_2, "cell 3 9,alignx right");
	}

}
