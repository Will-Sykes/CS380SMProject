import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LandingPage {
	/**
	 * creates the frame of the GUI
	 */
	private JFrame frmHub;
	/**
	 * holds the permission level of the user that is currently accessing the coffee shop landing page 
	 */
	private static int condition;
	
	/**
	 * allows condition to be updated to help hide which buttons are hidden later on
	 * @param permission the permission level of the person using the landing page
	 */
	public static void setCondition(int permission) {
		condition = permission;
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LandingPage window = new LandingPage();
					window.frmHub.setVisible(true);
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LandingPage() {
		initialize();
	}

	

	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHub = new JFrame();
		frmHub.setResizable(false);
		frmHub.setTitle("Hub");
		frmHub.setBounds(100, 100, 301, 390);
		frmHub.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/**
		 * customer view button that will bring up the customer GUI interface.
		 */
		JButton CustomerButton = new JButton("Customer View");
		CustomerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerUi.main(null);
			}
		});
		
		/**
		 * create the employee view button that will bring up the employee GUI upon being pressed and hide it if the user is not an employee.
		 */
		JButton EmployeeButton = new JButton("Employee View");
		EmployeeButton.setVisible(true);
		if(!(condition >= 2)) {
		EmployeeButton.setVisible(false);
		}else
			
		EmployeeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Employee_view.main(null);
			}
		});
		
		/**
		 * creates the manager view button that will bring up the manager GUI upon being pressed and hide it if the person is not a manager
		 */
		JButton ManagerButton = new JButton("Manager View");
		ManagerButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				productView.main(null);
			}
		});
		ManagerButton.setVisible(true);
		if(!(condition >= 3)) {
			ManagerButton.setVisible(false);
		}
		
		/**
		 * creates a sign out button that allows the user to go back to the login page
		 */
		JButton signoutButton = new JButton("Sign Out");
		signoutButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				login.main(null);
				frmHub.dispose();
			}
		});
		
		/**
		 * creates a grouplayout that will help organize the buttons on the landing page
		 */
		GroupLayout groupLayout = new GroupLayout(frmHub.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(signoutButton, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(ManagerButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(EmployeeButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(CustomerButton, GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)))
					.addGap(20))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(46)
					.addComponent(CustomerButton, GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(EmployeeButton, GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(ManagerButton, GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(signoutButton, GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
					.addContainerGap())
		);
		frmHub.getContentPane().setLayout(groupLayout);
	}
}
