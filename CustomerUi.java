import java.awt.EventQueue;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Color;
import java.awt.Font;

public class CustomerUi {
	
	private JFrame frame;
	private JTextField fNameField;
	private JTextField lNameFeild;
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
//-----------------------------------------------------------------------------------------------UI assets
		
		// frame 
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(228, 194, 149));
		frame.setBackground(new Color(238, 238, 238));
		frame.setResizable(false);
		frame.setTitle("SoftMicro Coffee");
		frame.setBounds(100, 100, 550, 364);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		// first name label
		JLabel firstNameLabel = new JLabel("First Name");
		firstNameLabel.setFont(new Font("Apple Chancery", Font.PLAIN, 13));
		firstNameLabel.setBounds(6, 11, 68, 16);
		frame.getContentPane().add(firstNameLabel);
		// first name Field
		fNameField = new JTextField();
		fNameField.setFont(new Font("Apple Chancery", Font.PLAIN, 13));
		fNameField.setBounds(86, 6, 150, 26);
		frame.getContentPane().add(fNameField);
		fNameField.setColumns(10);
		
		// last name label
		JLabel lastNameLabel = new JLabel("Last Name");
		lastNameLabel.setFont(new Font("Apple Chancery", Font.PLAIN, 13));
		lastNameLabel.setBounds(6, 39, 68, 16);
		frame.getContentPane().add(lastNameLabel);
		// last name field
		lNameFeild = new JTextField();
		lNameFeild.setFont(new Font("Apple Chancery", Font.PLAIN, 13));
		lNameFeild.setBounds(86, 34, 150, 26);
		frame.getContentPane().add(lNameFeild);
		lNameFeild.setColumns(10);
		
		// a message that will appear if first name or last names contains characters that are not allowed
		final JLabel invalidName = new JLabel("Name should only contain letters (a-z, A-Z)");
		invalidName.setForeground(Color.RED);
		invalidName.setBounds(6, 64, 300, 16);
		frame.getContentPane().add(invalidName);
		invalidName.setVisible(false);
		
		// a message that appears if the user did not input the first or last name
		final JLabel noName = new JLabel("Please enter your first and last name");
		noName.setForeground(Color.RED);
		noName.setBounds(6, 67, 289, 16);
		frame.getContentPane().add(noName);
		noName.setVisible(false);
		
		// seperator to make everything look nicer
		JSeparator separator = new JSeparator();
		separator.setBounds(17, 195, 230, 12);
		frame.getContentPane().add(separator);
		
		// fonts and colors
		orderView = new JTextArea();
		orderView.setFont(new Font("Apple Chancery", Font.PLAIN, 13));
		orderView.setEditable(false);
		orderView.setBounds(304, 11, 230, 222);
		frame.getContentPane().add(orderView);
		
		JLabel labelForPriceBox = new JLabel("Total:");
		labelForPriceBox.setFont(new Font("Apple Chancery", Font.PLAIN, 13));
		labelForPriceBox.setBounds(418, 245, 36, 16);
		frame.getContentPane().add(labelForPriceBox);
		
		totalField = new JTextField();
		totalField.setFont(new Font("Apple Chancery", Font.PLAIN, 15));
		totalField.setBounds(347, 256, 180, 35);
		totalField.setEditable(false);
		frame.getContentPane().add(totalField);
		totalField.setColumns(10);
		totalField.setText("$0.00");
		
		JLabel lblNewLabel = new JLabel("Food");
		lblNewLabel.setFont(new Font("Apple Chancery", Font.PLAIN, 13));
		lblNewLabel.setBounds(107, 210, 36, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Drinks");
		lblNewLabel_1.setFont(new Font("Apple Chancery", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(96, 92, 47, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		
//-----------------------------------------------------------------------------------------------Drinks
		//the following are for buttons that add drinks to the order
		//the buttons will open up another window so customers can customize their drinks
		//when that window is closed, the order box and total box will update showing the new total and item 
		
		//button to add an Americano
		JButton americanoButton = new JButton("Americano");
		americanoButton.setFont(new Font("Apple Chancery", Font.PLAIN, 13));
		americanoButton.setBounds(7, 169, 117, 29);
		americanoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifyItem mod = new ModifyItem("Americano", function);
				frame.setVisible(false);
				mod.addWindowListener(new WindowAdapter() {
		            @Override
		            public void windowClosed(WindowEvent e) {
		            	orderView.setText(function.getOrder());
		            	totalField.setText(function.getPrice());
		            	frame.setVisible(true);
		            }
		        });
				mod.setVisible(true);
			}
		});
		frame.getContentPane().add(americanoButton);
		
		//button to add an Hot Chocolate
		JButton hotChocolateButton = new JButton("Hot Chocolate");
		hotChocolateButton.setFont(new Font("Apple Chancery", Font.PLAIN, 13));
		hotChocolateButton.setBounds(119, 138, 117, 29);
		hotChocolateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifyItem mod = new ModifyItem("Hot Chocolate", function);
				frame.setVisible(false);
				mod.addWindowListener(new WindowAdapter() {
		            @Override
		            public void windowClosed(WindowEvent e) {
		            	orderView.setText(function.getOrder());
		            	totalField.setText(function.getPrice());
		            	frame.setVisible(true);
		            }
		        });
				mod.setVisible(true);
			}
		});
		frame.getContentPane().add(hotChocolateButton);
		
		//button to add an Latte
		JButton latteButton = new JButton("Latte");
		latteButton.setBackground(new Color(238, 238, 238));
		latteButton.setFont(new Font("Apple Chancery", Font.PLAIN, 13));
		latteButton.setBounds(7, 106, 117, 29);
		latteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifyItem mod = new ModifyItem("Latte", function);
				frame.setVisible(false);
				mod.addWindowListener(new WindowAdapter() {
		            @Override
		            public void windowClosed(WindowEvent e) {
		            	orderView.setText(function.getOrder());
		            	totalField.setText(function.getPrice());
		            	frame.setVisible(true);
		            }
		        });
				mod.setVisible(true);
			}
		});
		frame.getContentPane().add(latteButton);
		
		//button to add an Cappuccino
		JButton cappuccinoButton = new JButton("Cappuccino");
		cappuccinoButton.setFont(new Font("Apple Chancery", Font.PLAIN, 13));
		cappuccinoButton.setBounds(119, 169, 117, 29);
		cappuccinoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifyItem mod = new ModifyItem("Cappuccino", function);
				frame.setVisible(false);
				mod.addWindowListener(new WindowAdapter() {
		            @Override
		            public void windowClosed(WindowEvent e) {
		            	orderView.setText(function.getOrder());
		            	totalField.setText(function.getPrice());
		            	frame.setVisible(true);
		            }
		        });
				mod.setVisible(true);
			}
		});
		frame.getContentPane().add(cappuccinoButton);
		
		//button to add an Macchiato
		JButton macchiatoButton = new JButton("Macchiato");
		macchiatoButton.setFont(new Font("Apple Chancery", Font.PLAIN, 13));
		macchiatoButton.setBounds(6, 138, 117, 29);
		macchiatoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifyItem mod = new ModifyItem("Macchiato", function);
				frame.setVisible(false);
				mod.addWindowListener(new WindowAdapter() {
		            @Override
		            public void windowClosed(WindowEvent e) {
		            	orderView.setText(function.getOrder());
		            	totalField.setText(function.getPrice());
		            	frame.setVisible(true);
		            }
		        });
				mod.setVisible(true);
			}
		});
		frame.getContentPane().add(macchiatoButton);
		
		//button to add an Frappee
		JButton frappeeButton = new JButton("Frappee");
		frappeeButton.setFont(new Font("Apple Chancery", Font.PLAIN, 13));
		frappeeButton.setBounds(119, 106, 117, 29);
		frappeeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifyItem mod = new ModifyItem("Frappee", function);
				frame.setVisible(false);
				mod.addWindowListener(new WindowAdapter() {
		            @Override
		            public void windowClosed(WindowEvent e) {
		            	orderView.setText(function.getOrder());
		            	totalField.setText(function.getPrice());
		            	frame.setVisible(true);
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
		beagleButton.setFont(new Font("Apple Chancery", Font.PLAIN, 13));
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
		cookieButton.setFont(new Font("Apple Chancery", Font.PLAIN, 13));
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
		muffinButton.setFont(new Font("Apple Chancery", Font.PLAIN, 13));
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
		doughnutButton.setFont(new Font("Apple Chancery", Font.PLAIN, 13));
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
		addToOrderButton.setFont(new Font("Apple Chancery", Font.PLAIN, 13));
		addToOrderButton.setBounds(433, 303, 117, 29);
		addToOrderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				noName.setVisible(false);
				invalidName.setVisible(false);
				if(fNameField.getText().isEmpty() || lNameFeild.getText().isEmpty()) {
					noName.setVisible(true);
				}
				else if(function.santizie(fNameField.getText(), lNameFeild.getText())){
					invalidName.setVisible(true);
				}else if(function.getOrder().isBlank()) {
					JOptionPane.showMessageDialog(null, "Your Cart is Empty!");
				}else {
					function.order(fNameField.getText(), lNameFeild.getText());
				}
			}
		});
		frame.getContentPane().add(addToOrderButton);
		
		//remove the last entered item in the order
		JButton removeButton = new JButton("Remove");
		removeButton.setFont(new Font("Apple Chancery", Font.PLAIN, 13));
		removeButton.setBounds(347, 303, 93, 29);
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
		pricesButton.setFont(new Font("Apple Chancery", Font.PLAIN, 13));
		pricesButton.setBounds(254, 303, 99, 29);
		pricesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				priceChecker checker = new priceChecker(function);
				frame.setVisible(false);
				checker.addWindowListener(new WindowAdapter() {
		            @Override
		            public void windowClosed(WindowEvent e) {
		            	orderView.setText(function.getOrder());
		            	totalField.setText(function.getPrice());
		            	frame.setVisible(true);
		            }
		        });
				checker.setVisible(true);
			}
		});
		frame.getContentPane().add(pricesButton);
		
		final JButton exitBttn = new JButton("Close/Hide");
		exitBttn.setBounds(7, 303, 117, 29);
		exitBttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] options = {"Close Window", "Hide Button"};
		        int choice = JOptionPane.showOptionDialog(frame, "Would you like to close this window or hide the button?",
		        		"Close or Hide",
		        		JOptionPane.YES_NO_OPTION,
		        		JOptionPane.QUESTION_MESSAGE,
		        		null,
		        		options,
		        		options[1]);

		        // Perform action based on user choice
		        if (choice == JOptionPane.YES_OPTION) {
		            // Close window
		            frame.dispose();
		        } else if (choice == JOptionPane.NO_OPTION) {
		            // Hide button
		            exitBttn.setVisible(false);
		        }
			}
		});
		frame.getContentPane().add(exitBttn);
		
		
	}
}
