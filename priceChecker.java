import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import java.awt.EventQueue;

public class priceChecker extends JFrame{
	
	// properties 
	//private static final long serialVersionUID = 1L;
	private JPanel frmPriceCheck;
	private JTextArea DisplaytextArea;
	private JTextField textField;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		final Functionality function = new Functionality();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					priceChecker window = new priceChecker(function);
					CustomerLineDatabase.connection();
					window.frmPriceCheck.setVisible(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param function 
	 */
	public priceChecker(Functionality function) {
		getContentPane().setBackground(new Color(228, 194, 149));
		setFont(new Font("Apple Chancery", Font.PLAIN, 12));
		setResizable(false);
		initialize(function);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(final Functionality function) {
		frmPriceCheck = new JPanel();
		setTitle("Prices");
		frmPriceCheck.setBounds(100, 100, 335, 480);
		setSize(335, 480);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		DisplaytextArea = new JTextArea();
		DisplaytextArea.setFont(new Font("Apple Chancery", Font.PLAIN, 13));
		DisplaytextArea.setBackground(new Color(228, 194, 149));
		DisplaytextArea.setEditable(false);
		
		final JLabel invalidInput = new JLabel("Please Enter Valid Item");
		invalidInput.setForeground(Color.RED);
		invalidInput.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		invalidInput.setBounds(156, 348, 162, 16);
		getContentPane().add(invalidInput);
		invalidInput.setVisible(false);
		
		final JLabel addedSuccessfully = new JLabel("Item added to cart!");
		addedSuccessfully.setFont(new Font("Apple Chancery", Font.BOLD, 13));
		addedSuccessfully.setForeground(new Color(0, 163, 17));
		addedSuccessfully.setBounds(156, 348, 134, 16);
		getContentPane().add(addedSuccessfully);
		addedSuccessfully.setVisible(false);
		
		/**
		 * creates a return button that allows for the user to go back to the previous page
		 */
		JButton ReturnButton = new JButton("Return");
		ReturnButton.setFont(new Font("Apple Chancery", Font.PLAIN, 13));
		ReturnButton.setBounds(0, 425, 124, 29);
		ReturnButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		DisplaytextArea.setText(CustomerLineDatabase.PrintPriceCheckPanel());
		
		/**
		 * creates the formating for the buttons and the panel
		 */
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 330, 329);
		scrollPane.setViewportView(DisplaytextArea);
		getContentPane().setLayout(null);
		getContentPane().add(ReturnButton);
		getContentPane().add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("Add to Cart:");
		lblNewLabel.setFont(new Font("Apple Chancery", Font.PLAIN, 13));
		lblNewLabel.setBounds(11, 328, 76, 16);
		getContentPane().add(lblNewLabel);
		textField = new JTextField();
		textField.setFont(new Font("Apple Chancery", Font.PLAIN, 13));
		textField.setBounds(5, 343, 150, 26);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		/*
		 * creates a button that will add an item from the price menu to the cart
		 */
		JButton addtoCartBttn = new JButton("Add to Cart");
		addtoCartBttn.setFont(new Font("Apple Chancery", Font.PLAIN, 13));
		addtoCartBttn.setBounds(0, 371, 117, 29);
		getContentPane().add(addtoCartBttn);
		addtoCartBttn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				invalidInput.setVisible(false);
				addedSuccessfully.setVisible(false);
				if(textField.getText().isEmpty() || 
						function.santizie(textField.getText(), textField.getText()) || 
						CustomerLineDatabase.ItemNotExist(textField.getText())) {
					
					invalidInput.setVisible(true);
				}
				else {
					invalidInput.setVisible(false);
					function.addToCart(textField.getText(), 1);
					addedSuccessfully.setVisible(true);
				}
			}

		});
		getContentPane().add(addtoCartBttn);
	}
}