package a01203138.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;

public class MyFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JList list;

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
		setTitle("Reverse");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow]", "[][][grow]"));
		
		textField = new JTextField();
		contentPane.add(textField, "cell 0 0,growx");
		textField.setColumns(10);
		
		list = new JList();
		contentPane.add(list, "flowx,cell 0 2");
		
		JButton btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = textField.getText();
				String[] words = text.split(" ");
				for (String word : words) {
					String new_word = word.substring(1, word.length())+ word.charAt(0)+"ay";
//					textArea.append(new_word+"\n");	
					list.add(new_word);
				}
			}
		});
		contentPane.add(btnOK, "cell 0 1");
		
		
	}

}
