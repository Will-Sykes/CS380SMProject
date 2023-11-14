import java.awt.EventQueue;
import java.util.*;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CustomerUi {
	
	private JFrame frame;
	private JTextField fNameField;
	private JTextField LNameFeild;
	private JTextField totalField;
	private Functionality function = new Functionality();
	private JTextArea orderView;

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
		// frame 
		frame = new JFrame();
		frame.setTitle("SoftMicro Coffee");
		frame.setBounds(100, 100, 470, 333);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		// first name label
		JLabel firstNameLabel = new JLabel("First Name");
		firstNameLabel.setBounds(6, 6, 68, 16);
		frame.getContentPane().add(firstNameLabel);
		// first name Field
		fNameField = new JTextField();
		fNameField.setBounds(86, 1, 150, 26);
		frame.getContentPane().add(fNameField);
		fNameField.setColumns(10);
		
		// last name label
		JLabel lastNameLabel = new JLabel("Last Name");
		lastNameLabel.setBounds(6, 34, 68, 16);
		frame.getContentPane().add(lastNameLabel);
		// last name field
		LNameFeild = new JTextField();
		LNameFeild.setBounds(86, 29, 150, 26);
		frame.getContentPane().add(LNameFeild);
		LNameFeild.setColumns(10);
		
		orderView = new JTextArea();
		orderView.setEditable(false);
		orderView.setBounds(264, 6, 196, 205);
		frame.getContentPane().add(orderView);
		
		//
		JButton americanoButton = new JButton("Americano");
		americanoButton.setBounds(6, 144, 117, 29);
		americanoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifyItem mod = new ModifyItem("Americano", function);
				mod.addWindowListener(new WindowAdapter() {
		            @Override
		            public void windowClosed(WindowEvent e) {
		            	orderView.setText(function.getOrder());
		            }
		        });
				mod.setVisible(true);
			}
		});
		frame.getContentPane().add(americanoButton);
		
		JButton hotChocolateButton = new JButton("Hot Chocolate");
		hotChocolateButton.setBounds(119, 113, 117, 29);
		hotChocolateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifyItem mod = new ModifyItem("Hot Chocolate", function);
				mod.addWindowListener(new WindowAdapter() {
		            @Override
		            public void windowClosed(WindowEvent e) {
		            	orderView.setText(function.getOrder());
		            }
		        });
				mod.setVisible(true);
			}
		});
		frame.getContentPane().add(hotChocolateButton);
		
		JButton latteButton = new JButton("Latte");
		latteButton.setBounds(6, 81, 117, 29);
		latteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifyItem mod = new ModifyItem("Latte", function);
				mod.addWindowListener(new WindowAdapter() {
		            @Override
		            public void windowClosed(WindowEvent e) {
		            	orderView.setText(function.getOrder());
		            }
		        });
				mod.setVisible(true);
			}
		});
		frame.getContentPane().add(latteButton);
		
		JButton cappuccinoButton = new JButton("Cappuccino");
		cappuccinoButton.setBounds(119, 144, 117, 29);
		cappuccinoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifyItem mod = new ModifyItem("Cappuccino", function);
				mod.addWindowListener(new WindowAdapter() {
		            @Override
		            public void windowClosed(WindowEvent e) {
		            	orderView.setText(function.getOrder());
		            }
		        });
				mod.setVisible(true);
			}
		});
		frame.getContentPane().add(cappuccinoButton);
		
		JButton macchiatoButton = new JButton("Macchiato");
		macchiatoButton.setBounds(6, 113, 117, 29);
		macchiatoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifyItem mod = new ModifyItem("Macchiato", function);
				mod.addWindowListener(new WindowAdapter() {
		            @Override
		            public void windowClosed(WindowEvent e) {
		            	orderView.setText(function.getOrder());
		            }
		        });
				mod.setVisible(true);
			}
		});
		frame.getContentPane().add(macchiatoButton);
		
		JButton frappeeButton = new JButton("Frappee");
		frappeeButton.setBounds(119, 81, 117, 29);
		frappeeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifyItem mod = new ModifyItem("Frappee", function);
				mod.addWindowListener(new WindowAdapter() {
		            @Override
		            public void windowClosed(WindowEvent e) {
		            	orderView.setText(function.getOrder());
		            }
		        });
				mod.setVisible(true);
			}
		});
		frame.getContentPane().add(frappeeButton);
		
		totalField = new JTextField();
		totalField.setBounds(264, 231, 180, 35);
		totalField.setEditable(false);
		frame.getContentPane().add(totalField);
		totalField.setColumns(10);
		
		JLabel labelForPriceBox = new JLabel("Total:");
		labelForPriceBox.setBounds(326, 217, 36, 16);
		frame.getContentPane().add(labelForPriceBox);
		
		JButton beagleButton = new JButton("Bagel");
		beagleButton.setBounds(6, 235, 117, 29);
		beagleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				function.addToOrder("Bagel", 1);
				orderView.setText(function.getOrder());
			}
		});
		frame.getContentPane().add(beagleButton);
		
		JButton cookieButton = new JButton("Cookie");
		cookieButton.setBounds(119, 235, 117, 29);
		cookieButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				function.addToOrder("Cookie", 1);
				orderView.setText(function.getOrder());
			}
		});
		frame.getContentPane().add(cookieButton);
		
		JButton muffinButton = new JButton("Muffin");
		muffinButton.setBounds(6, 204, 117, 29);
		muffinButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				function.addToOrder("Muffin", 1);
				orderView.setText(function.getOrder());
			}
		});
		frame.getContentPane().add(muffinButton);
		
		JButton doughnutButton = new JButton("Doughnut");
		doughnutButton.setBounds(119, 204, 117, 29);
		doughnutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				function.addToOrder("Doughnut", 1);
				orderView.setText(function.getOrder());
			}
		});
		frame.getContentPane().add(doughnutButton);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(6, 174, 230, 12);
		frame.getContentPane().add(separator);
		
		JLabel lblNewLabel = new JLabel("Food");
		lblNewLabel.setBounds(101, 185, 36, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Drinks");
		lblNewLabel_1.setBounds(96, 63, 47, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton addToOrderButton = new JButton("Add to Order");
		addToOrderButton.setBounds(353, 266, 117, 29);
		addToOrderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frame.getContentPane().add(addToOrderButton);
		
		JButton removeButton = new JButton("Remove");
		removeButton.setBounds(234, 266, 117, 29);
		removeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frame.getContentPane().add(removeButton);
		
	}
}
