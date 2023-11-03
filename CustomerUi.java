import java.awt.EventQueue;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomerUi {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerUi window = new CustomerUi();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the application.
	 */
	public CustomerUi() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("SoftMicro Coffee");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel firstNameLabel = new JLabel("First Name");
		firstNameLabel.setBounds(6, 6, 68, 16);
		frame.getContentPane().add(firstNameLabel);
		
		textField = new JTextField();
		textField.setBounds(86, 1, 150, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lastNameLabel = new JLabel("Last Name");
		lastNameLabel.setBounds(6, 34, 68, 16);
		frame.getContentPane().add(lastNameLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(86, 29, 150, 26);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton americanoButton = new JButton("Americano");
		americanoButton.setBounds(6, 144, 117, 29);
		frame.getContentPane().add(americanoButton);
		
		JButton hotChocolateButton = new JButton("Hot Chocolate");
		hotChocolateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifyItem mod = new ModifyItem("Hot Chocolate");
				mod.setVisible(true);
			}
		});
		hotChocolateButton.setBounds(119, 113, 117, 29);
		frame.getContentPane().add(hotChocolateButton);
		
		JButton latteButton = new JButton("Latte");
		latteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifyItem mod = new ModifyItem("Latte");
				mod.setVisible(true);
			}
		});
		latteButton.setBounds(6, 81, 117, 29);
		frame.getContentPane().add(latteButton);
		
		JButton cappuccinoButton = new JButton("Cappuccino");
		cappuccinoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		cappuccinoButton.setBounds(119, 144, 117, 29);
		frame.getContentPane().add(cappuccinoButton);
		
		JButton macchiatoButton = new JButton("Macchiato");
		macchiatoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		macchiatoButton.setBounds(6, 113, 117, 29);
		frame.getContentPane().add(macchiatoButton);
		
		JButton frappeeButton = new JButton("Frappee");
		frappeeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifyItem mod = new ModifyItem("Frappee");
				mod.setVisible(true);
			}
		});
		frappeeButton.setBounds(119, 81, 117, 29);
		frame.getContentPane().add(frappeeButton);
		
		textField_2 = new JTextField();
		textField_2.setBounds(264, 6, 180, 213);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(264, 231, 180, 35);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel labelForPriceBox = new JLabel("Total:");
		labelForPriceBox.setBounds(326, 217, 36, 16);
		frame.getContentPane().add(labelForPriceBox);
		
		JButton btnNewButton_6 = new JButton("New button");
		btnNewButton_6.setBounds(6, 235, 117, 29);
		frame.getContentPane().add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("New button");
		btnNewButton_7.setBounds(119, 235, 117, 29);
		frame.getContentPane().add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("New button");
		btnNewButton_8.setBounds(6, 204, 117, 29);
		frame.getContentPane().add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("New button");
		btnNewButton_9.setBounds(119, 204, 117, 29);
		frame.getContentPane().add(btnNewButton_9);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(6, 174, 230, 12);
		frame.getContentPane().add(separator);
		
		JLabel lblNewLabel = new JLabel("Food");
		lblNewLabel.setBounds(101, 185, 36, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Drinks");
		lblNewLabel_1.setBounds(96, 63, 47, 16);
		frame.getContentPane().add(lblNewLabel_1);
	}
}
