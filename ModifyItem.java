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
	private StringBuilder custom = new StringBuilder();
	
	private JSpinner drinkQuantity;
	private JComboBox<String> drinkSize;
    private JComboBox<String> hotOrIced;
    private JList<String> listOfFlavors;
    private JSpinner shotsNum;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		final Functionality function = new Functionality();
		final String drink = "";
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifyItem frame = new ModifyItem(drink, function);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private String customFormat(String ammount, String size, String temp, String flav, String shots) {
		
		// add the amount of drinks to add
		custom.append(ammount + " ");
		
		// add the letter of the desired size to the order
		if(size.equals("Small")) {
			custom.append("S ");
		}else if (size.equals("Medium")) {
			custom.append("M ");
		}else if (size.equals("Large")) {
			custom.append("L ");
		}
		
		// add the if they would like it iced or hot, and if it is blended
		// say its iced with a B to stand for blended
		if(temp.equals("Iced (Blended)")) {
			custom.append("Ice-B ");
		}else {
			custom.append(temp + " ");
		}
		// add the abbreviation of the flavor they got
		if(flav.equals("No Flavor")) {
			custom.append("NF ");
		}else if(flav.equals("Caramel")) {
			custom.append("CAR ");
		}else if(flav.equals("Vanilla")) {
			custom.append("VAN ");
		}else if(flav.equals("Mocha")) {
			custom.append("MOC ");
		}
		
		custom.append(shots + "Shot");
		
		return custom.toString();
	}
	

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("deprecation")
	public ModifyItem(final String drink, final Functionality function) {
		setTitle(drink);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 204, 345);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		// the quantity of drinks
		JLabel quantityLabel = new JLabel("Quantity ");
		SpinnerNumberModel shotsModel = new SpinnerNumberModel(1, 1, 10, 1); // min 1 drink, max 10 drinks
		drinkQuantity = new JSpinner(shotsModel);
		
		JLabel iceOrHotLabel = new JLabel("Iced or Hot");	
		hotOrIced = new JComboBox<String>(new String[] {"Hot", "Iced"});
		if(drink.equals("Hot Chocolate"))
		{
			//hotOrIced.disable();
			hotOrIced.enable(false);
		}else if(drink.equals("Frappee"))
		{
			//hotOrIced.disable();
			hotOrIced.enable(false);
			hotOrIced = new JComboBox<String>(new String[] {"Iced (Blended)"});
		}
		
		JLabel drinkSizeLabel = new JLabel("Size");
		drinkSize = new JComboBox<String>(new String[] {"Small", "Medium", "Large"});
		
		JLabel flavorLabel = new JLabel("Flavor");
		String[] arrayFlvaor = {"No Flavor", "Caramel", "Vanilla", "Mocha"};
		listOfFlavors = new JList<String>(arrayFlvaor);
		listOfFlavors.setSelectedIndex(0);
		JScrollPane flavorScrollPane = new JScrollPane();
		
		
		
		JLabel numberOfShotsLabel = new JLabel("Shots");
		SpinnerNumberModel numberOfShots = new SpinnerNumberModel(1, 1, 4, 1); // min 1 shot, max 4 drinks
		shotsNum = new JSpinner(numberOfShots);
		
		JButton addToOrderButton = new JButton("Add to Cart");
		addToOrderButton.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	String quant = drinkQuantity.getValue().toString();
	        	String siz = drinkSize.getSelectedItem().toString();
				String temp = hotOrIced.getSelectedItem().toString();
				String flav = listOfFlavors.getSelectedValue();
				String shot = shotsNum.getValue().toString();
	        	String mods = customFormat(quant, siz, temp, flav, shot);
	        	
	        	function.addToCart(drink, mods, (Integer) drinkQuantity.getValue());
	        	
	        	ModifyItem.this.dispose(); // This will close the window
	        }
	    });
		
		JButton backButton = new JButton("Back");
		
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(addToOrderButton, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
											.addComponent(drinkSizeLabel)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPane.createSequentialGroup()
													.addGap(12)
													.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
														.addComponent(quantityLabel)
														.addComponent(flavorLabel)))
												.addComponent(iceOrHotLabel)))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addGroup(gl_contentPane.createSequentialGroup()
												.addGap(6)
												.addComponent(flavorScrollPane, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
											.addComponent(drinkQuantity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addComponent(hotOrIced, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addComponent(drinkSize, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(40)
									.addComponent(numberOfShotsLabel)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(shotsNum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addComponent(backButton))
					.addContainerGap(158, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(backButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(quantityLabel)
						.addComponent(drinkQuantity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(hotOrIced, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(iceOrHotLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(drinkSize, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(drinkSizeLabel))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(33)
							.addComponent(flavorLabel))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(flavorScrollPane, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(numberOfShotsLabel)
						.addComponent(shotsNum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(addToOrderButton)
					.addContainerGap(31, Short.MAX_VALUE))
		);
		flavorScrollPane.setViewportView(listOfFlavors);
		contentPane.setLayout(gl_contentPane);
	}
}
