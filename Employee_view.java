import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

public class Employee_view {

	private JFrame frame;
	private JTextField Fname;
	private JTextField Lname;
	private JTextField Price;
	private JTextField OrderDescription;
	private JTextArea OrderLineTextArea;
	private JTextArea OrderTextArea;
	//private JTextArea OrderLineTextArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Employee_view window = new Employee_view();
					window.frame.setVisible(true);
					setup(window);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	protected static void setup(Employee_view window) {
		// TODO Auto-generated method stub
		Order_database.connection();
	}

	/**Prints on the database through the TextArea.
	 * 
	 */
	public void updateDisplay() {
		OrderTextArea.setText(Order_database.PrintOrderPanel());
		OrderLineTextArea.setText(Order_database.PrintLinePanel());
	}
	
	public Employee_view(){
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 900, 304);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/*buttons that will be affected later on*/
		JButton RemoveButton = new JButton("Remove Order");
		RemoveButton.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(Order_database.PrintOrderPanel());
				Order_database.OrderRemove(Fname.getText(), Lname.getText(), OrderDescription.getText(), Price.getText());
				updateDisplay();
				
			}
		});
		
		JButton ViewButton = new JButton("View Order & Line");
		ViewButton.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(Order_database.PrintOrderPanel());
				updateDisplay();
				
			}
		});
		
		JButton addButton = new JButton("Add Order");
		addButton.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(Order_database.PrintOrderPanel());
				Order_database.OrderAdd(Fname.getText(), Lname.getText(), OrderDescription.getText(), Price.getText());
				updateDisplay();
			}
		});
		
		JButton ManagerButton = new JButton("Manager View");
		ManagerButton.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(Order_database.PrintOrderPanel());
				updateDisplay();
			}
		});
		
		JButton CompleteOrder = new JButton("Complete Order");
		CompleteOrder.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(Order_database.PrintOrderPanel());
				updateDisplay();
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
		
		JLabel FirstnameLabel = new JLabel("First Name");
		
		JLabel LastNameLabel = new JLabel("Last Name");
		
		JLabel PriceLabel = new JLabel("Price");
		
		
		JLabel DescriptionLabel = new JLabel("Order Description");
		
		JPanel panel_1 = new JPanel();
		
		JPanel panel = new JPanel();
		
		OrderTextArea = new JTextArea();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addComponent(OrderTextArea, GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addComponent(OrderTextArea, GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
		);
		panel.setLayout(gl_panel);
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
							.addComponent(CompleteOrder)))
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
								.addComponent(ManagerButton, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
								.addComponent(ViewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
					.addGap(18)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
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
						.addComponent(OrderDescription, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
						.addComponent(DescriptionLabel))
					.addPreferredGap(ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(addButton)
						.addComponent(ViewButton))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(RemoveButton)
						.addComponent(ManagerButton)
						.addComponent(CompleteOrder))
					.addGap(22))
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		OrderLineTextArea = new JTextArea();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addComponent(OrderLineTextArea, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addComponent(OrderLineTextArea, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
		);
		panel_1.setLayout(gl_panel_1);
		
		frame.getContentPane().setLayout(groupLayout);
	}
}
