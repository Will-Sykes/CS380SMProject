import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class productView {

	private JFrame frame;
	private JTextField productField;
	private JTextField quantityField;
	private JTextField priceField;
	
	private String prodField;
	private Double priField;
	private int quaField;
	private String catField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					productView window = new productView();
					window.frame.setVisible(true);
					EmployeeProductView.connection();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public productView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 570, 414);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(20, 70, 106, 138);
		frame.getContentPane().add(panel);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(154, 11, 390, 353);
		frame.getContentPane().add(textArea);
		
		JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(154, 11, 390, 353);
        frame.getContentPane().add(scrollPane);
		
		final JComboBox<String> coffee = new JComboBox(new String[] {"", "Price Check", "Inventory"});
		coffee.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // This method will be called when an item is selected in the JComboBox
                String selectedOption = (String) coffee.getSelectedItem();
             
                String productInfo =  selectedOption + ":" + "\n" + EmployeeProductView.searchCat(selectedOption);

		        // Update the GUI component with the product information
		        textArea.setText(productInfo);

		        // If the product was not found, show an error message
		        if (productInfo.equals("Items not found.")) {
		            JOptionPane.showMessageDialog(null, "Could not find items.", "Error", JOptionPane.ERROR_MESSAGE);
		        }
                // Add your custom code here based on the selected item
            }
        });
		coffee.setBounds(10, 36, 116, 23);
        frame.getContentPane().add(coffee);
		
        
		
		JButton searchButton = new JButton("Search");
		searchButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				prodField = productField.getText();
				
				String productInfo = EmployeeProductView.searchProduct(prodField);
				
				textArea.setText(productInfo);
			
				if (productInfo.equals("Item not found.")) {
		            JOptionPane.showMessageDialog(null, "Could not find product.", "Error", JOptionPane.ERROR_MESSAGE);
		        }
				
			}
		});
		panel.add(searchButton);
		
		JButton modButton = new JButton("Modify");
		panel.add(modButton);
		modButton.addMouseListener(new MouseAdapter() {
			@Override
		    public void mouseClicked(MouseEvent e) {
				
				if (productField.getText().isEmpty()) {
		            JOptionPane.showMessageDialog(null, "Please enter a product to modify.", "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }

		        prodField = productField.getText();

		        Double priField = -1.0; // Default value indicating no input
		        if (!priceField.getText().isEmpty()) {
		            try {
		                priField = Double.parseDouble(priceField.getText());
		            } catch (NumberFormatException ex) {
		                // Handle invalid input if needed
		            }
		        }

		        Integer quaField = -1; // Default value indicating no input
		        if (!quantityField.getText().isEmpty()) {
		            try {
		                quaField = Integer.parseInt(quantityField.getText());
		            } catch (NumberFormatException ex) {
		                // Handle invalid input if needed
		            }
		        }
		        
		        
		        
		        String selectedValue = (String) coffee.getSelectedItem();
		        boolean productInfo = EmployeeProductView.modProduct(prodField, priField, quaField, selectedValue);

		       

		        // If the product was not found, show an error message
		        if (productInfo) {
		            JOptionPane.showMessageDialog(null, "Product modified successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
		        } else {
		            JOptionPane.showMessageDialog(null, "Failed to modify product.", "Error", JOptionPane.ERROR_MESSAGE);
		        }
			}
		});
		
		
        
        JButton adButton = new JButton("Add");
		panel.add(adButton);
		adButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				
				
				if ((String) coffee.getSelectedItem() == "") {
					JOptionPane.showMessageDialog(null, "Please select an item category.", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				String selectedValue = (String) coffee.getSelectedItem();
				prodField = productField.getText();
				
				
				if(selectedValue == "Inventory") {
					quaField = Integer.parseInt(quantityField.getText());
					priField = 0.0;
				} else {
					priField = Double.parseDouble(priceField.getText());
					quaField = 0; 
				}
					
				
				boolean productAdded = EmployeeProductView.addProduct(prodField, priField, quaField, selectedValue);
				
				if (productAdded) {
		            JOptionPane.showMessageDialog(null, "Product added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
		        } else {
		            JOptionPane.showMessageDialog(null, "Failed to add product.", "Error", JOptionPane.ERROR_MESSAGE);
		        }
				
				
			}
		});
		
		JButton reButton = new JButton("Remove");
		reButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				prodField = productField.getText();
				
				boolean productremoved = EmployeeProductView.removeProduct(prodField);
				
				if (productremoved) {
		            JOptionPane.showMessageDialog(null, "Product removed successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
		        } else {
		            JOptionPane.showMessageDialog(null, "Failed to remove product.", "Error", JOptionPane.ERROR_MESSAGE);
		        }
			}
		});
		panel.add(reButton);
		
		JLabel lblNewLabel = new JLabel("Product");
		lblNewLabel.setBounds(10, 209, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Quantity:");
		lblNewLabel_1.setBounds(10, 251, 81, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Price:");
		lblNewLabel_2.setBounds(10, 298, 62, 20);
		frame.getContentPane().add(lblNewLabel_2);
		
		
		
		productField = new JTextField();
		productField.setBounds(61, 209, 86, 20);
		frame.getContentPane().add(productField);
		productField.setColumns(10);
		
		quantityField = new JTextField();
		quantityField.setBounds(61, 248, 86, 20);
		frame.getContentPane().add(quantityField);
		quantityField.setColumns(10);
		
		priceField = new JTextField();
		priceField.setBounds(61, 298, 86, 20);
		frame.getContentPane().add(priceField);
		priceField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Category Select:");
		lblNewLabel_3.setBounds(10, 11, 106, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JButton clsWButton = new JButton("Close Window");
		clsWButton.setBounds(10, 341, 106, 23);
		clsWButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				frame.dispose();
				
			}
		});
		frame.getContentPane().add(clsWButton);
		
		
	}
}
