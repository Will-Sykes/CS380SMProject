import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LandingPage {

	private JFrame frame;
	private static int condition;
	
	
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
	public LandingPage() {
		initialize();
	}

	

	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 301, 344);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton CustomerButton = new JButton("Customer View");
		CustomerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerUi.main(null);
			}
		});
		
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
		
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(ManagerButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(EmployeeButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(CustomerButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(46)
					.addComponent(CustomerButton, GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(EmployeeButton, GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(ManagerButton, GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
					.addGap(28))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
	


}
