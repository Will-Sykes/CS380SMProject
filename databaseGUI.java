import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JCheckBox;

public class databaseGUI{
	/**
	 * creates the frame of the GUI that will in a way intialize the GUI
	 */
	private JFrame frmDatabaseInfo;
	/**
	 * Declares a text field for a URL
	 */
	private JTextField URLtextField;
	/**
	 * declares a username textfield for the username to allow for user inputs
	 */
	private JTextField UserNametextField;
	/**
	 * creates the password textfield that will allow for the sql password inputs
	 */
	private JPasswordField passwordTextField;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					databaseGUI window = new databaseGUI();
					window.frmDatabaseInfo.setVisible(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public databaseGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDatabaseInfo = new JFrame();
		frmDatabaseInfo.setResizable(false);
		frmDatabaseInfo.setTitle("Database Info");
		frmDatabaseInfo.setBounds(100, 100, 536, 368);
		frmDatabaseInfo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		URLtextField = new JTextField();
		URLtextField.setColumns(10);
		URLtextField.setText("jdbc:mysql://localhost:3306/");
		
		UserNametextField = new JTextField();
		UserNametextField.setColumns(10);
		
		passwordTextField = new JPasswordField();
		passwordTextField.setColumns(10);
		
		/**
		 * creates a Jlabel that tells the user which textfield is a URL
		 */
		JLabel linkLabel = new JLabel("URL:");
		
		/**
		 * Creates a JLabel that tells the user which textfield is associated with a username
		 */
		JLabel UserNameLabel = new JLabel("User Name:");
		
		/**
		 * creates a password JLabel that tells users which textfield is a password input
		 */
		JLabel PasswordLabel = new JLabel("Password:");
		
		/**
		 * creates a connection button that will tell the user when the connection has be established.
		 */
		JButton connectionbutton = new JButton("Establish Connection");
		connectionbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/**
				 * creates a urlcheck that will see if the current url is a valid connection
				 */
				String urlcheck = URLtextField.getText();
				
				CheckSQLconnection.setURL(URLtextField.getText());
				CheckSQLconnection.setUsername(UserNametextField.getText());
				/**
				 * creates a char array to hold the curreny password char arrays from the method
				 */
				char[] passwordchar = passwordTextField.getPassword();
				/**
				 * creates a string to put each character onto the string later on
				 */
				String password = "";
				for(char temp : passwordchar) {
					password += temp;
				}
				CheckSQLconnection.setPassword(password);
				
				/*error checks in case the user did add to the url*/
				if(CheckSQLconnection.connection() == true &&(urlcheck.charAt(urlcheck.length()-1)!= '/')) {
					JOptionPane.showMessageDialog(null, "Connection sucessful", "SQL connection", JOptionPane.INFORMATION_MESSAGE);
					login.main(null);
					frmDatabaseInfo.dispose();
					
				}else if(urlcheck.charAt(urlcheck.length()-1) == '/') {
					JOptionPane.showMessageDialog(null, "Invalid connection", "SQL connection", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		
		/**
		 * creates a check box to help reveal a password for the user
		 */
		final JCheckBox checkbox = new JCheckBox("");
		checkbox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(checkbox.isSelected()) {
					passwordTextField.setEchoChar((char) 0);
				}else {
					passwordTextField.setEchoChar('\u2022');
			    }
			}
		});
		/**
		 * creates a grouplayout that help with formating the buttons and text fields
		 */
		GroupLayout groupLayout = new GroupLayout(frmDatabaseInfo.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(62)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(linkLabel, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
						.addComponent(UserNameLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(PasswordLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(20)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(passwordTextField, Alignment.LEADING)
						.addComponent(UserNametextField, Alignment.LEADING)
						.addComponent(URLtextField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(checkbox, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(202, Short.MAX_VALUE)
					.addComponent(connectionbutton)
					.addGap(185))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(65)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(URLtextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(linkLabel))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(UserNametextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(UserNameLabel))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(PasswordLabel)
						.addComponent(checkbox))
					.addGap(55)
					.addComponent(connectionbutton)
					.addContainerGap(99, Short.MAX_VALUE))
		);
		frmDatabaseInfo.getContentPane().setLayout(groupLayout);
	}

}
