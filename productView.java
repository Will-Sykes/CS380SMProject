import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JLabel;
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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 116, 128);
		frame.getContentPane().add(panel);
		
		final JComboBox<String> coffee = new JComboBox(new String[] {"", "Price Check", "Inventory"});
        coffee.setBounds(20, 200, 116, 40);
        frame.getContentPane().add(coffee);
		
		JButton searchButton = new JButton("Search");
		searchButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				prodField = productField.getText();
				
				EmployeeProductView.searchProduct(prodField);
			}
		});
		panel.add(searchButton);
		
		JButton modButton = new JButton("Modify");
		panel.add(modButton);
		modButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				prodField = productField.getText();
				priField = Double.parseDouble(priceField.getText());
				quaField = Integer.parseInt(quantityField.getText());
				String selectedValue = (String) coffee.getSelectedItem();
				
				
				EmployeeProductView.modProduct(prodField, priField, quaField, selectedValue);
				
			}
		});
		
		
        
        JButton adButton = new JButton("Add");
		panel.add(adButton);
		adButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				prodField = productField.getText();
				priField = Double.parseDouble(priceField.getText());
				quaField = Integer.parseInt(quantityField.getText());
				String selectedValue = (String) coffee.getSelectedItem();
				
				
				EmployeeProductView.addProduct(prodField, priField, quaField, selectedValue);
				
			}
		});
		
		JButton reButton = new JButton("Remove");
		reButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				prodField = productField.getText();
				
				EmployeeProductView.removeProduct(prodField);
				
			}
		});
		panel.add(reButton);
		
		JLabel lblNewLabel = new JLabel("Product");
		lblNewLabel.setBounds(148, 140, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Quantity:");
		lblNewLabel_1.setBounds(148, 176, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Price:");
		lblNewLabel_2.setBounds(148, 210, 62, 20);
		frame.getContentPane().add(lblNewLabel_2);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(136, 11, 288, 109);
		frame.getContentPane().add(textArea);
		
		productField = new JTextField();
		productField.setBounds(231, 137, 193, 20);
		frame.getContentPane().add(productField);
		productField.setColumns(10);
		
		quantityField = new JTextField();
		quantityField.setBounds(231, 173, 193, 20);
		frame.getContentPane().add(quantityField);
		quantityField.setColumns(10);
		
		priceField = new JTextField();
		priceField.setBounds(231, 213, 193, 20);
		frame.getContentPane().add(priceField);
		priceField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Category Select:");
		lblNewLabel_3.setBounds(20, 176, 106, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JButton clsWButton = new JButton("Close Window");
		clsWButton.setBounds(20, 150, 106, 23);
		frame.getContentPane().add(clsWButton);
	}
}
