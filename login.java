import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class login {

	private JFrame frame;
	private JTextField FirstNametextField;
	private JTextField LastNametextField;
	private JTextField IDtextField;
	private JLabel FirstnameLabel;
	private JLabel LastNameLabel;
	private JLabel IDlabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
					Order_database.connection();
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
	public login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 487, 297);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton LoginButton = new JButton("Login");
		LoginButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int condition = 0;
				condition = Order_database.checkEmployee(FirstNametextField.getText(), LastNametextField.getText(), IDtextField.getText());
				if(condition > 0 && condition <=3) {
					LandingPage.main(null);
					LandingPage.setCondition(condition);
					frame.dispose();
				}
			}
		});
		
		JButton CustomerButton = new JButton("Continue as customer:");
		CustomerButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LandingPage.main(null);
				LandingPage.setCondition(1);
				frame.dispose();
			}
		});
		
		FirstNametextField = new JTextField();
		FirstNametextField.setColumns(10);
		
		LastNametextField = new JTextField();
		LastNametextField.setColumns(10);
		
		IDtextField = new JTextField();
		IDtextField.setColumns(10);
		
		FirstnameLabel = new JLabel("First Name:");
		
		LastNameLabel = new JLabel("Last Name:");
		
		IDlabel = new JLabel("ID:");
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(56)
							.addComponent(LoginButton, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
							.addComponent(CustomerButton))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(55)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(LastNameLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(FirstnameLabel, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)))
								.addComponent(IDlabel, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(LastNametextField, GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
								.addComponent(FirstNametextField, GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
								.addComponent(IDtextField, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE))))
					.addGap(43))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(48)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(FirstNametextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(FirstnameLabel))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(LastNametextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(LastNameLabel))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(IDtextField)
						.addComponent(IDlabel))
					.addGap(70)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(LoginButton)
						.addComponent(CustomerButton))
					.addGap(23))
		);
		frame.getContentPane().setLayout(groupLayout);
	}

}
