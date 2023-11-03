
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Employee_ProductView extends JFrame {

    private JTextArea displayArea;

    public Employee_ProductView() {

        // Layout manager
        setLayout(new BorderLayout());

        // Panel for labels and text fields
        JPanel inputPanel = new JPanel(new GridLayout(4, 2)); // 4 rows, 2 columns

        // Labels and text fields
        JLabel prodlabel = new JLabel("Product:");
        final JTextField productfield = new JTextField(15);

        JLabel quantitylabel = new JLabel("Quantity:");
        final JTextField quantityfield = new JTextField(15);

        JLabel pricelabel = new JLabel("Price:");
        final JTextField pricefield = new JTextField(15);


        // Adding labels and text fields to the inputPanel
        inputPanel.add(prodlabel);
        inputPanel.add(productfield);

        inputPanel.add(quantitylabel);
        inputPanel.add(quantityfield);

        inputPanel.add(pricelabel);
        inputPanel.add(pricefield);

        //Display Area in a displayPanel
        JPanel displayPanel = new JPanel(new BorderLayout());
        JTextArea displayArea = new JTextArea(10, 40);
        // Make it non-editable
        displayArea.setEditable(false);
        // Scrollable
        JScrollPane scrollPane = new JScrollPane(displayArea);
        displayPanel.add(scrollPane, BorderLayout.NORTH);

        // Button Panel
        JPanel buttonPanel = new JPanel();
        // Centering buttons
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        // Buttons
        JButton addButton = new JButton("Add");
        JButton removeButton = new JButton("Remove");
        JButton searchButton = new JButton("Search");
        JButton modButton = new JButton("Modify");

        // Adding the buttons to the buttonPanel
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(searchButton);
        buttonPanel.add(modButton);

        // Adding inputPanel, scrollPane, and buttonPanel to the frame
        add(inputPanel, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);

        // Frame Properties
        setTitle("Employee View: Product Catalog");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

    }

    private void updateDisplayPanel(String data) {
        // Appending to displayArea
        displayArea.append(data + "\n");
    }




    public static void main(String[] args) throws SQLException {

        // Creating our gui and making it visible
        Employee_ProductView gui = new Employee_ProductView();
        gui.setVisible(true);
    }
}
