import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;

public class ModifyItem extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static String drink;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifyItem frame = new ModifyItem(drink);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("deprecation")
	public ModifyItem(String drink) {
		setTitle(drink);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 356, 309);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		// the quantity of drinks
		JLabel quantityLabel = new JLabel("Quantity ");
		SpinnerNumberModel shotsModel = new SpinnerNumberModel(1, 1, 10, 1); // min 1 drink, max 10 drinks
		JSpinner drinkQuantity = new JSpinner(shotsModel);
		
		JLabel iceOrHotLabel = new JLabel("Iced or Hot");	
		JComboBox<String> hotOrIced = new JComboBox<String>(new String[] {"Hot", "Iced"});
		if(drink.equals("Hot Chocolate"))
		{
			hotOrIced.disable();
		}else if(drink.equals("Frappee"))
		{
			hotOrIced.disable();
			hotOrIced = new JComboBox<String>(new String[] {"Iced (Blended)"});
		}
		
		JLabel drinkSizeLabel = new JLabel("Size");
		JComboBox<String> drinkSize = new JComboBox<String>(new String[] {"Small", "Medium", "Large"});
		
		JLabel flavorLabel = new JLabel("Flavor");
		JCheckBox noFlavorOption = new JCheckBox("No Flvaor");
		String[] arrayFlvaor = {"Caramel", "Vanilla", "Mocha"};
		JList<String> listOfFlavors = new JList<String>(arrayFlvaor);
		listOfFlavors.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		JScrollPane flavorScrollPane = new JScrollPane(listOfFlavors);
		
		
		
		JLabel numberOfShotsLabel = new JLabel("Shots");
		SpinnerNumberModel numberOfShots = new SpinnerNumberModel(1, 1, 4, 1); // min 1 shot, max 4 drinks
		JSpinner shotsNum = new JSpinner(numberOfShots);
		
		JButton addToOrderButton = new JButton("Add to Order");
		addToOrderButton.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            // TODO add all the modifications to the order
	        	// Logic to handle the order can go here
	        	
	        	
	        	ModifyItem.this.dispose(); // This will close the window
	        }
	    });
		
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(addToOrderButton, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(flavorLabel)
								.addComponent(quantityLabel)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(35)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
											.addComponent(drinkSizeLabel)
											.addComponent(numberOfShotsLabel)))
									.addComponent(iceOrHotLabel)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(drinkQuantity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(hotOrIced, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(drinkSize, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(6)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(flavorScrollPane, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
										.addComponent(shotsNum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addComponent(noFlavorOption))))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(drinkQuantity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(quantityLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(hotOrIced, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(iceOrHotLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(drinkSize, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(drinkSizeLabel))
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(noFlavorOption)
						.addComponent(flavorLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(flavorScrollPane, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
					.addGap(8)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(numberOfShotsLabel)
						.addComponent(shotsNum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(addToOrderButton))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
