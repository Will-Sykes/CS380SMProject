import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;

public class login {
	/**
	 * the frame of the GUI
	 */
	private JFrame frmLogin;
	/**
	 * creates the first name textField to hold the firstname string of the employee
	 */
	private JTextField FirstNametextField;
	/**
	 * creates a last name text field to hold the last name of the person trying to login
	 */
	private JTextField LastNametextField;
	/**
	 * creates a textfields for to hold the employee ID of the person trying to login later on
	 */
	private JPasswordField IDtextField;
	/**
	 * creates the first name the will help identify which textfield holds the first name
	 */
	private JLabel FirstnameLabel;
	/**
	 * creates a last name JLabel variable to tell the user which textfield is the last name
	 */
	private JLabel LastNameLabel;
	/**
	 * creates a ID JLabel to tell the user which textfield is a ID later on.
	 */
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
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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
		frmLogin = new JFrame();
		frmLogin.setResizable(false);
		frmLogin.setTitle("Login");
		frmLogin.setBounds(100, 100, 487, 297);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/**
		 * allows the user to login and disposes of the current frame if the login was sucessful.
		 */
		JButton LoginButton = new JButton("Login");
		LoginButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int condition = 0;
				/**
				 * creates a char to hold each character from the password
				 */
				char[] passwordchar = IDtextField.getPassword();
				/**
				 * creates a string password to combind each character from the password onto a single string
				 */
				String password = "";
				for(char temp: passwordchar) {
					password += temp;
				}
				
				
				condition = Order_database.checkEmployee(FirstNametextField.getText(), LastNametextField.getText(), password);
				if(condition > 0 && condition <=3) {
					LandingPage.main(null);
					LandingPage.setCondition(condition);
					frmLogin.dispose();
				}
			}
		});
		
		/**
		 * allows the user to continue as a customer without the need of a login.
		 */
		JButton CustomerButton = new JButton("Continue as customer:");
		CustomerButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LandingPage.main(null);
				LandingPage.setCondition(1);
				frmLogin.dispose();
			}
		});
		
		FirstNametextField = new JTextField();
		FirstNametextField.setColumns(10);
		
		LastNametextField = new JTextField();
		LastNametextField.setColumns(10);
		
		IDtextField = new JPasswordField();
		IDtextField.setColumns(10);
		
		FirstnameLabel = new JLabel("First Name:");
		
		LastNameLabel = new JLabel("Last Name:");
		
		IDlabel = new JLabel("ID:");

		/**
		 * checkbox that will hide the ID for the login later on
		 */
		final JCheckBox checkbox = new JCheckBox("");
		checkbox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(checkbox.isSelected()) {
					IDtextField.setEchoChar((char) 0);
				}else {
					IDtextField.setEchoChar('\u2022');
			    }
			}
		});
		/**
		 * creates a group layout to help with button formating
		 */
		GroupLayout groupLayout = new GroupLayout(frmLogin.getContentPane());
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
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addComponent(LastNameLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGroup(groupLayout.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(FirstnameLabel, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)))
								.addComponent(IDlabel, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(LastNametextField, GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
								.addComponent(FirstNametextField, GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
								.addComponent(IDtextField, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE))))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(checkbox, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(48)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(checkbox)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(FirstNametextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(FirstnameLabel))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(LastNametextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(LastNameLabel))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(IDtextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(IDlabel))))
					.addGap(68)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(LoginButton)
						.addComponent(CustomerButton))
					.addGap(23))
		);
		frmLogin.getContentPane().setLayout(groupLayout);
	}
}
