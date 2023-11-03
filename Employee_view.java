import java.awt.EventQueue;

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Employee_view window = new Employee_view();
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
	public Employee_view() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 652, 303);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 300, 300);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(100,200,100,100);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(textArea, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 263, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		/*buttons that will be affected later on*/
		JButton RemoveButton = new JButton("Remove Order");
		
		JButton ViewButton = new JButton("View Order");
		
		JButton addButton = new JButton("Add Order");
		
		JButton ManagerButton = new JButton("Manager View");
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
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		
		
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap(51, GroupLayout.PREFERRED_SIZE)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(PriceLabel, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
								.addComponent(LastNameLabel, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
								.addComponent(FirstnameLabel, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
								.addComponent(DescriptionLabel, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
							.addGap(22))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(addButton)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(ViewButton)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(OrderDescription)
						.addComponent(Price)
						.addComponent(Fname)
						.addComponent(Lname)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(RemoveButton)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(ManagerButton)))
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
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
						.addComponent(OrderDescription, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
						.addComponent(DescriptionLabel))
					.addPreferredGap(ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(RemoveButton)
						.addComponent(ViewButton)
						.addComponent(addButton)
						.addComponent(ManagerButton))
					.addGap(22))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		frame.getContentPane().setLayout(groupLayout);
	}
}
