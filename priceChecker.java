import java.awt.EventQueue;

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

public class priceChecker extends JFrame{
	
	// properties 
	private static final long serialVersionUID = 1L;
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
		initialize(function);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(final Functionality function) {
		frmPriceCheck = new JPanel();
		setTitle("Price Check");
		frmPriceCheck.setBounds(100, 100, 335, 480);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		DisplaytextArea = new JTextArea();
		DisplaytextArea.setEditable(false);
		
		final JLabel invalidInput = new JLabel("Please Enter Valid Item");
		invalidInput.setForeground(Color.RED);
		invalidInput.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		invalidInput.setBounds(168, 388, 162, 16);
		getContentPane().add(invalidInput);
		invalidInput.setVisible(false);
		
		/**
		 * creates a return button that allows for the user to go back to the previous page
		 */
		JButton ReturnButton = new JButton("Return");
		ReturnButton.setBounds(0, 361, 124, 29);
		ReturnButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		
		/**
		 * creates a display button that will print all product and pricing information onto the text area
		 */
		JButton DisplayButton = new JButton("Display Prices");
		DisplayButton.setBounds(0, 417, 150, 29);
		DisplayButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DisplaytextArea.setText(CustomerLineDatabase.PrintPriceCheckPanel());
			}
		});
		
		/**
		 * creates the formating for the buttons and the panel
		 */
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 330, 329);
		scrollPane.setViewportView(DisplaytextArea);
		getContentPane().setLayout(null);
		getContentPane().add(ReturnButton);
		getContentPane().add(DisplayButton);
		getContentPane().add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("Add to Cart:");
		lblNewLabel.setBounds(174, 346, 76, 16);
		getContentPane().add(lblNewLabel);
		textField = new JTextField();
		textField.setBounds(168, 361, 150, 26);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		/*
		 * creates a button that will add an item from the price menu to the cart
		 */
		JButton addtoCartBttn = new JButton("Add to Cart");
		addtoCartBttn.setBounds(213, 417, 117, 29);
		getContentPane().add(addtoCartBttn);
		addtoCartBttn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().isEmpty() || 
						function.santizie(textField.getText(), textField.getText()) || 
						function.itemExists(textField.getText())) {
					invalidInput.setVisible(true);
				}
				else {
					invalidInput.setVisible(false);
					
					// uses the method used for adding food to cart because we don't know about any modification or customizations
					function.addToCart(textField.getText(), 1);
				}
			}

		});
		getContentPane().add(addtoCartBttn);
	}

}