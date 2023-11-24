import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;

public class CheckInventoryGUI {
	
	/**
	 * creates the frame of the GUI
	 */
	private JFrame frmInventoryCheck;
	/**
	 * creates the text area to display the inventory items.
	 */
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckInventoryGUI window = new CheckInventoryGUI();
					window.frmInventoryCheck.setVisible(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CheckInventoryGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmInventoryCheck = new JFrame();
		frmInventoryCheck.setTitle("Inventory Check");
		frmInventoryCheck.setBounds(100, 100, 425, 469);
		frmInventoryCheck.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/**
		 * creates a return button that allows the user to dispose of the current GUI
		 */
		JButton returnButton = new JButton("Return");
		returnButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmInventoryCheck.dispose();
			}
		});
		
		/**
		 * prints the inventory onto the text area
		 */
		JButton btnNewButton_1 = new JButton("Print Inventory");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textArea.setText(Order_database.PrintInventoryPanel());
			}
		});
		
		/**
		 * creates a pane used for the textArea
		 */
		JScrollPane scrollPane = new JScrollPane();
		/**
		 * creates a group layout that helps format the buttons and textareas
		 */
		GroupLayout groupLayout = new GroupLayout(frmInventoryCheck.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(61)
					.addComponent(returnButton, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
					.addGap(99)
					.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
					.addGap(46))
				.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(returnButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(38))
		);
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);
		frmInventoryCheck.getContentPane().setLayout(groupLayout);
	}
}
