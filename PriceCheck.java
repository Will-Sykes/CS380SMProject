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

public class PriceCheck {
	/**
	 * creates the frame of the GUI
	 */
	private JFrame frmPriceCheck;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PriceCheck window = new PriceCheck();
					Order_database.connection();
					window.frmPriceCheck.setVisible(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PriceCheck() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPriceCheck = new JFrame();
		frmPriceCheck.setTitle("Price Check");
		frmPriceCheck.setBounds(100, 100, 450, 526);
		frmPriceCheck.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/**
		 * creates a JPanel that will contain the Text area
		 */
		JPanel panel = new JPanel();
		/**
		 * declares the textarea that will contain the prices and products of various items
		 */
		JTextArea DisplaytextArea = new JTextArea();
		DisplaytextArea.setEditable(false);
		
		/**
		 * creates the formating of the text area
		 */
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(DisplaytextArea, GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(DisplaytextArea, GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
		);
		panel.setLayout(gl_panel);
		/**
		 * creates a return button that allows for the user to go back to the previous page
		 */
		JButton ReturnButton = new JButton("Return");
		ReturnButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmPriceCheck.dispose();
			}
		});
		
		/**
		 * creates a display button that will print all product and pricing information onto the text area
		 */
		JButton DisplayButton = new JButton("Display Prices");
		DisplayButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DisplaytextArea.setText(Order_database.PrintPriceCheckPanel());
			}
		});
		/**
		 * creates the formating for the buttons and the panel
		 */
		GroupLayout groupLayout = new GroupLayout(frmPriceCheck.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
					.addGap(0))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(44)
					.addComponent(ReturnButton, GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
					.addGap(92)
					.addComponent(DisplayButton, GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
					.addGap(40))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
					.addGap(38)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(ReturnButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(DisplayButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(39))
		);
		frmPriceCheck.getContentPane().setLayout(groupLayout);
	}
}
