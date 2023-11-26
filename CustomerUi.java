import java.awt.EventQueue;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Color;

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
					CustomerLineDatabase.connection();
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
		frame.setResizable(false);
		frame.setTitle("SoftMicro Coffee");
		frame.setBounds(100, 100, 550, 364);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		// first name label
		JLabel firstNameLabel = new JLabel("First Name");
		firstNameLabel.setBounds(6, 11, 68, 16);
		frame.getContentPane().add(firstNameLabel);
		// first name Field
		fNameField = new JTextField();
		fNameField.setBounds(86, 6, 150, 26);
		frame.getContentPane().add(fNameField);
		fNameField.setColumns(10);
		
		// last name label
		JLabel lastNameLabel = new JLabel("Last Name");
		lastNameLabel.setBounds(6, 39, 68, 16);
		frame.getContentPane().add(lastNameLabel);
		// last name field
		LNameFeild = new JTextField();
		LNameFeild.setBounds(86, 29, 150, 26);
		frame.getContentPane().add(LNameFeild);
		LNameFeild.setColumns(10);
		
		// a message that will appear if first name or last names contains characters that are not allowed
		final JLabel invalidName = new JLabel("Name should only contain letters (a-z, A-Z)");
		invalidName.setForeground(Color.RED);
		invalidName.setBounds(6, 64, 289, 16);
		frame.getContentPane().add(invalidName);
		invalidName.setVisible(false);
		
		// a message that appears if the user did not input the first or last name
		final JLabel noName = new JLabel("Please enter your first and last name");
		noName.setForeground(Color.RED);
		noName.setBounds(6, 67, 289, 16);
		frame.getContentPane().add(noName);
		noName.setVisible(false);
		
		orderView = new JTextArea();
		orderView.setEditable(false);
		orderView.setBounds(304, 11, 230, 222);
		frame.getContentPane().add(orderView);
		
		JLabel labelForPriceBox = new JLabel("Total:");
		labelForPriceBox.setBounds(418, 245, 36, 16);
		frame.getContentPane().add(labelForPriceBox);
		
		totalField = new JTextField();
		totalField.setBounds(347, 256, 180, 35);
		totalField.setEditable(false);
		frame.getContentPane().add(totalField);
		totalField.setColumns(10);
		totalField.setText("$0.00");
		
		JSeparator separator = new JSeparator();
		separator.setBounds(17, 195, 230, 12);
		frame.getContentPane().add(separator);
		
		JLabel lblNewLabel = new JLabel("Food");
		lblNewLabel.setBounds(107, 210, 36, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Drinks");
		lblNewLabel_1.setBounds(96, 92, 47, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		
//-----------------------------------------------------------------------------------------------Drinks
		//the following are for buttons that add drinks to the order
		//the buttons will open up another window so customers can customize their drinks
		//when that window is closed, the order box and total box will update showing the new total and item 
		
		//button to add an Americano
		JButton americanoButton = new JButton("Americano");
		americanoButton.setBounds(7, 169, 117, 29);
		americanoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifyItem mod = new ModifyItem("Americano", function);
				mod.addWindowListener(new WindowAdapter() {
		            @Override
		            public void windowClosed(WindowEvent e) {
		            	orderView.setText(function.getOrder());
		            	totalField.setText(function.getPrice());
		            }
		        });
				mod.setVisible(true);
			}
		});
		frame.getContentPane().add(americanoButton);
		
		//button to add an Hot Chocolate
		JButton hotChocolateButton = new JButton("Hot Chocolate");
		hotChocolateButton.setBounds(119, 138, 117, 29);
		hotChocolateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifyItem mod = new ModifyItem("Hot Chocolate", function);
				mod.addWindowListener(new WindowAdapter() {
		            @Override
		            public void windowClosed(WindowEvent e) {
		            	orderView.setText(function.getOrder());
		            	totalField.setText(function.getPrice());
		            }
		        });
				mod.setVisible(true);
			}
		});
		frame.getContentPane().add(hotChocolateButton);
		
		//button to add an Latte
		JButton latteButton = new JButton("Latte");
		latteButton.setBounds(7, 106, 117, 29);
		latteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifyItem mod = new ModifyItem("Latte", function);
				mod.addWindowListener(new WindowAdapter() {
		            @Override
		            public void windowClosed(WindowEvent e) {
		            	orderView.setText(function.getOrder());
		            	totalField.setText(function.getPrice());
		            }
		        });
				mod.setVisible(true);
			}
		});
		frame.getContentPane().add(latteButton);
		
		//button to add an Cappuccino
		JButton cappuccinoButton = new JButton("Cappuccino");
		cappuccinoButton.setBounds(119, 169, 117, 29);
		cappuccinoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifyItem mod = new ModifyItem("Cappuccino", function);
				mod.addWindowListener(new WindowAdapter() {
		            @Override
		            public void windowClosed(WindowEvent e) {
		            	orderView.setText(function.getOrder());
		            	totalField.setText(function.getPrice());
		            }
		        });
				mod.setVisible(true);
			}
		});
		frame.getContentPane().add(cappuccinoButton);
		
		//button to add an Macchiato
		JButton macchiatoButton = new JButton("Macchiato");
		macchiatoButton.setBounds(6, 138, 117, 29);
		macchiatoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifyItem mod = new ModifyItem("Macchiato", function);
				mod.addWindowListener(new WindowAdapter() {
		            @Override
		            public void windowClosed(WindowEvent e) {
		            	orderView.setText(function.getOrder());
		            	totalField.setText(function.getPrice());
		            }
		        });
				mod.setVisible(true);
			}
		});
		frame.getContentPane().add(macchiatoButton);
		
		//button to add an Frappee
		JButton frappeeButton = new JButton("Frappee");
		frappeeButton.setBounds(119, 106, 117, 29);
		frappeeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifyItem mod = new ModifyItem("Frappee", function);
				mod.addWindowListener(new WindowAdapter() {
		            @Override
		            public void windowClosed(WindowEvent e) {
		            	orderView.setText(function.getOrder());
		            	totalField.setText(function.getPrice());
		            }
		        });
				mod.setVisible(true);
			}
		});
		frame.getContentPane().add(frappeeButton);
		
//-----------------------------------------------------------------------------------------------Food
		//unlike drinks, food will automatically add 1 of its kind straight to the order without opening a new window
		//in most coffee shops you are not able to customize food as it comes premade.
		
		//button to add a Bagel
		JButton beagleButton = new JButton("Bagel");
		beagleButton.setBounds(7, 260, 117, 29);
		beagleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				function.addToCart("Bagel", 1);
				orderView.setText(function.getOrder());
				totalField.setText(function.getPrice());
			}
		});
		frame.getContentPane().add(beagleButton);
		
		//button to add a Cookie
		JButton cookieButton = new JButton("Cookie");
		cookieButton.setBounds(119, 260, 117, 29);
		cookieButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				function.addToCart("Cookie", 1);
				orderView.setText(function.getOrder());
				totalField.setText(function.getPrice());
			}
		});
		frame.getContentPane().add(cookieButton);
		
		//button to add a Muffin
		JButton muffinButton = new JButton("Muffin");
		muffinButton.setBounds(6, 229, 117, 29);
		muffinButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				function.addToCart("Muffin", 1);
				orderView.setText(function.getOrder());
				totalField.setText(function.getPrice());
			}
		});
		frame.getContentPane().add(muffinButton);
		
		//button to add a Doughnut
		JButton doughnutButton = new JButton("Doughnut");
		doughnutButton.setBounds(119, 229, 117, 29);
		doughnutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				function.addToCart("Doughnut", 1);
				orderView.setText(function.getOrder());
				totalField.setText(function.getPrice());
			}
		});
		frame.getContentPane().add(doughnutButton);
		
//-----------------------------------------------------------------------------------------------utilities
		
		// button to add the entire order to the database
		//before adding to the order it checks if: the names contain any unwanted characters, there is text in the names, and if there even is anything in the order
		JButton addToOrderButton = new JButton("Add to Order");
		addToOrderButton.setBounds(418, 303, 117, 29);
		addToOrderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				noName.setVisible(false);
				invalidName.setVisible(false);
				if(fNameField.getText().isEmpty() || LNameFeild.getText().isEmpty()) {
					noName.setVisible(true);
				}
				else if(function.santizie(fNameField.getText(), LNameFeild.getText())){
					invalidName.setVisible(true);
				}else if(function.getOrder().isBlank()) {
					JOptionPane.showMessageDialog(null, "Your Cart is Empty!");
				}else {
					function.order(fNameField.getText(), LNameFeild.getText());
				}
			}
		});
		frame.getContentPane().add(addToOrderButton);
		
		//remove the last entered item in the order
		JButton removeButton = new JButton("Remove");
		removeButton.setBounds(304, 303, 117, 29);
		removeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				function.remove();
				orderView.setText(function.getOrder());
				totalField.setText(function.getPrice());
			}
		});
		frame.getContentPane().add(removeButton);
		
		//open another window to check the prices and make an order for items that do not have a button
		JButton pricesButton = new JButton("View Prices");
		pricesButton.setBounds(6, 301, 117, 29);
		pricesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				priceChecker checker = new priceChecker(function);
				checker.addWindowListener(new WindowAdapter() {
		            @Override
		            public void windowClosed(WindowEvent e) {
		            	orderView.setText(function.getOrder());
		            	totalField.setText(function.getPrice());
		            }
		        });
				checker.setVisible(true);
			}
		});
		frame.getContentPane().add(pricesButton);
		
		
	}
}