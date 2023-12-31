import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class Employee_view {
	/**
	 * the frame of the GUI
	 */
	private JFrame frmEmployeeView;
	/**
	 * the customers first name
	 */
	private JTextField Fname;
	/**
	 * the customers last name
	 */
	private JTextField Lname;
	/**
	 * the Price of the product that the employee will be able to customize
	 */
	private JTextField Price;
	/**
	 * the customers order
	 */
	private JTextField OrderDescription;
	/**
	 * the OrderLine display that will display all customers that are currently in line
	 */
	private JTextArea OrderLineTextArea;
	/**
	 * displays the orders that are currently being worked on within the Order database.
	 */
	private JTextArea OrderTextArea;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Employee_view window = new Employee_view();
					window.frmEmployeeView.setVisible(true);
					setup(window);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

	/**
	 * sets up the GUI to have a sql connection
	 * @param window the current GUI popup window
	 */
	protected static void setup(Employee_view window) {
		// TODO Auto-generated method stub
		Order_database.connection();
	}

	/**
	 * Prints on the database from the order and order line tables through the existing TextArea.
	 */
	public void updateDisplay() {
		OrderTextArea.setText(Order_database.PrintOrderPanel());
		OrderLineTextArea.setText(Order_database.PrintLinePanel());
	}
	
	/**
	 * intializes the Employee_view GUI
	 */
	public Employee_view(){
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEmployeeView = new JFrame();
		frmEmployeeView.setResizable(false);
		frmEmployeeView.setTitle("Employee View");
		frmEmployeeView.setBounds(100, 100, 961, 304);
		frmEmployeeView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/*removes a completed order from the order table database*/
		JButton RemoveButton = new JButton("Remove Order");
		RemoveButton.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Order_database.OrderRemove(Fname.getText(), Lname.getText(), OrderDescription.getText(), Price.getText());
				updateDisplay();
				
			}
		});
		
		/**
		 * allows the employee to view the orderline and order databases
		 */
		JButton ViewButton = new JButton("View Order & Line");
		ViewButton.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				updateDisplay();
				
			}
		});
		
		/**
		 * Adds a customer that is currently in the orderline 
		 */
		JButton addButton = new JButton("Add Order");
		addButton.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Order_database.OrderAdd(Fname.getText(), Lname.getText(), OrderDescription.getText(), Price.getText());
				updateDisplay();
			}
		});
		
		/**
		 * pops up a seperate GUI that will display all existing products within the database associated with a price
		 */
		JButton PriceCheckButton = new JButton("Price Check View");
		PriceCheckButton.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				
				PriceCheck.main(null);
				updateDisplay();
			}
		});
		
		/**
		 * Removes any customers that have been completed from the database 
		 */
		JButton CompleteOrder = new JButton("Complete Order");
		CompleteOrder.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Order_database.LineRemove(Fname.getText(), Lname.getText(), OrderDescription.getText());
				updateDisplay();
			}
		});
		
		/*user data that will be retrieved*/
		Fname = new JTextField();
		Fname.setColumns(10);
		
		Lname = new JTextField();
		Lname.setColumns(10);
		
		Price = new JTextField();
		Price.setColumns(10);
		
		OrderDescription = new JTextField();
		OrderDescription.setColumns(10);
		
		/**
		 * Firstname label to associated which textField is the firstname
		 */
		JLabel FirstnameLabel = new JLabel("First Name");
		
		/**
		 * Lastname label to depict which textfield is the last name
		 */
		JLabel LastNameLabel = new JLabel("Last Name");
		
		/**
		 * price label to depict which texfield is associated with the price
		 */
		JLabel PriceLabel = new JLabel("Price");
		
		/**
		 * Description label to help associate which text field is the order desciption
		 */
		JLabel DescriptionLabel = new JLabel("Order Description");
		
		/**
		 * closes the current window and returns to previous GUI
		 */
		JButton CloseButton = new JButton("Close Window");
		CloseButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmEmployeeView.dispose();
			}
		});
		/**
		 * creates a button that will help the inventory 
		 */
		JButton InventoryButton = new JButton("Check Inventory");
		InventoryButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CheckInventoryGUI.main(null);
				updateDisplay();
			}
		});
		
		/**
		 * creates the pane used for the textarea.
		 */
		JScrollPane scrollPane = new JScrollPane();
		/**
		 * creates the pane used for the textarea.
		 */
		JScrollPane scrollPane_1 = new JScrollPane();
		/**
		 * creates a group layout to help with organization
		 */
		GroupLayout groupLayout = new GroupLayout(frmEmployeeView.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(59)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(LastNameLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.UNRELATED))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(PriceLabel, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
										.addComponent(DescriptionLabel, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
									.addGap(18))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(FirstnameLabel, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(CloseButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
								.addComponent(InventoryButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
								.addComponent(CompleteOrder, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE))
							.addGap(59)))
					.addGap(16)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(OrderDescription)
						.addComponent(Price)
						.addComponent(Fname)
						.addComponent(Lname)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(addButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(RemoveButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(PriceCheckButton, GroupLayout.PREFERRED_SIZE, 113, Short.MAX_VALUE)
								.addComponent(ViewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
					.addGap(18)
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(36)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(Fname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(FirstnameLabel))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(Lname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(LastNameLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(Price, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(PriceLabel))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(DescriptionLabel)
							.addGap(18)
							.addComponent(CompleteOrder, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
						.addComponent(OrderDescription, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(addButton)
								.addComponent(ViewButton))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(RemoveButton)
								.addComponent(PriceCheckButton))
							.addGap(22))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(InventoryButton)
							.addGap(4)
							.addComponent(CloseButton)))
					.addGap(262))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 258, GroupLayout.PREFERRED_SIZE)
						.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 258, GroupLayout.PREFERRED_SIZE))
					.addGap(268))
		);
		
		OrderTextArea = new JTextArea();
		OrderTextArea.setEditable(false);
		scrollPane_1.setViewportView(OrderTextArea);
		
		OrderLineTextArea = new JTextArea();
		OrderLineTextArea.setEditable(false);
		scrollPane.setViewportView(OrderLineTextArea);
		
		frmEmployeeView.getContentPane().setLayout(groupLayout);
	}
}
