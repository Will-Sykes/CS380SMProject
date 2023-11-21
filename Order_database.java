
import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;


public class Order_database {
	
	/**
	 * creates a connection to the database
	 */
	public static Connection con = null;
	/**
	 * variable that stores the first name of the customer
	 */
	public static final String Fname = "Fname";
	/**
	 * variable that stores the lastname of the customer
	 */
	public static final String Lname = "Lname";
	
	/**
	 * variable that stores the orderDescription of the customer
	 */
	public static final String OrderDescription = "OrderDescription";
	
	/**
	 * variable that stores the total price of the customer order
	 */
	public static final String Price = "Price";
	/**
	 * variable that holds the coffeeshoporders table name to be refrenced later
	 */
	public static final String Ordertable = "coffeeshoporders";
	
	/**
	 * variable that holds the order line table name
	 */
	public static final String OrderLineTable = "CustomerLine";
	
	/**
	 * holds the name of a column from the database onto a beingworkedon variable
	 */
	public static final String BeingWorkedOn = "BeingWorkedOn";
	/**
	 * Holds the name of the MangerView table in the database
	 */
	private static final String ManagerView = "ManagerView";
	
	/**
	 * Create a string variable that holds the name of a attribute within the 
	 */
	public static final String PriceCheck = "Price Check";
	/**
	 * Holds the category tuple within the ManagerView table
	 */
	public static final String Category = "Category";
	/**
	 * Holds the Product name tuple within the ManagerView table
	 */
	public static final String Product = "Product";
	
	/**
	 * Holds the quantity from the managerview table
	 */
	public static final String Quantity = "Quantity";
	/**
	 * holds the employee table name so that we can access permission level later on
	 */
	public static final String EmployeesTable = "Employees";
	/**
	 * holds the tuple name for permissions within the Employees table
	 */
	public static final String Permission = "Permission";
	
	/**
	 * holds the tuple name for EmployeeID within the Employees table
	 */
	public static final String EmployeeID = "EmployeeID";
	
	/**
	 * 
	 */
	public static final String Inventory = "Inventory";
	/**
	 * Connects to the MySQL database
	 */
	public static void connection() {
		/**
		 * declares a string link to the database so that both ends can connect
		 */				
		String url = CheckSQLconnection.getURL();
		
		/**
		 * declares the user name needed to access the database
		 */
		String username = CheckSQLconnection.getUsername();
		
		/**
		 * declares a password needed to access the database
		 */
		String pass = CheckSQLconnection.getPassword();
		try {
			con = DriverManager.getConnection(url, username, pass);
			
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage(), "SQL connection error", JOptionPane.ERROR_MESSAGE);
		}
	}
	

	/**
	 * Prints the products and the quantity of those products
	 */
	public static String PrintInventoryPanel() {
		/**
		 * holds the output from the sql statment to be returned later on
		 */
		String output = "";
		
		try {
			/**
			 * creates a console statment from the current sql connection
			 */
			Statement st = con.createStatement();
			/**
			 * gathers all the attributes within the database table
			 */
			ResultSet rs = st.executeQuery("select * from "+ManagerView+"\nwhere " + Category + " = "+"\"" +  Inventory+"\"");
			while(rs.next()) {
				output += (rs.getString(Product)+ " ");
				output += (rs.getString(Quantity));
				output += ("\n");
			}
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage(), "Printing Error", JOptionPane.ERROR_MESSAGE);
		}
		return output;
		
	}
	
	/**
	 * Prints the prices products and prices of certain items
	 */
	public static String PrintPriceCheckPanel() {
		/**
		 * holds the output from the sql statment to be returned later on
		 */
		String output = "";
		
		
		try {
			/**
			 * creates a console statment from the current sql connection
			 */
			Statement st = con.createStatement();
			/**
			 * gathers all the attributes within the database table
			 */
			ResultSet rs = st.executeQuery("select * from "+ManagerView+"\nwhere " + Category + " = "+"\"" +  PriceCheck+"\"");
			while(rs.next()) {
				output += (rs.getString(Product)+ " ");
				output += (rs.getString(Price));
				output += ("\n");
			}
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage(), "Printing Error", JOptionPane.ERROR_MESSAGE);
		}
		return output;
		
	}
	
	/**
	 * Prints the customer orders within the database that is ordered by the Fname
	 */
	public static String PrintOrderPanel() {
		/**
		 * holds the output from the sql statment as a string
		 */
		String output = "";
		
		try {
			/**
			 * creates a statement variable through the sql connection
			 */
			Statement st = con.createStatement();
			/**
			 * creates a result set to hold all value from the sql statement
			 */
			ResultSet rs = st.executeQuery("select * from "+Ordertable+"\nORDER BY Fname");
			while(rs.next()) {
				output += (rs.getString(Fname)+ " ");
				output += (rs.getString(Lname)+ " ");
				output += ("\""+rs.getString(OrderDescription)+ "\" ");
				output += (rs.getString(Price));
				output += ("\n");
			}
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage(), "Printing Error", JOptionPane.ERROR_MESSAGE);
		}
		return output;
		
	}
	
	
	/**
	 * Prints the customer's that are in line within the database that is ordered by the Fname
	 */
	public static String PrintLinePanel() {
		/**
		 * creates output string to hold all attribute from the sql statement
		 */
		String output = "";
		
		try {
			/**
			 * creates a statement variable based on the sql connection
			 */
			Statement st = con.createStatement();
			/**
			 * creates a result set that holds all attributes from the sql statment
			 */
			ResultSet rs = st.executeQuery("select * from "+OrderLineTable+"\nORDER BY Fname");
			while(rs.next()) {
				output += (rs.getString(Fname)+ " ");
				output += (rs.getString(Lname)+ " ");
				output += ("\""+rs.getString(OrderDescription)+ "\" ");
				output += (rs.getString(BeingWorkedOn));
				output += ("\n");
			}
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage(), "Printing Error", JOptionPane.ERROR_MESSAGE);
		}
		return output;
		
	}
	/**
	 * Adds all a customer that is in line into a tuple on the database undertable if it exists within the customer line.
	 * @param Firstname the first name of the customer
	 * @param lastname the last name of the customer
	 * @param orderDescription the order description of what the customer wants
	 * @param price of the order
	 */
	public static void OrderAdd(String Firstname, String lastname, String orderDescription, String price) {
		/*order Section*/
		/**
		 * creates a array list string to combind all sql statments and variables onto one single string combination 
		 */
		ArrayList<String> conditions = new ArrayList<String>();
		
		if(!Firstname.equals("")) {
			conditions.add("\""+Firstname+"\"");
		}
		else {
			JOptionPane.showMessageDialog(null, "Please make sure all textfields are entered", "Input Error", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		if(!lastname.equals("")) {
			conditions.add("\""+lastname+"\"");
		}
		else {
			JOptionPane.showMessageDialog(null, "Please make sure all textfields are entered", "Input Error", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		if(!orderDescription.equals("")) {
			conditions.add("\""+orderDescription+"\"");
		}
		else {
			JOptionPane.showMessageDialog(null, "Please make sure all textfields are entered", "Input Error", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		if(!price.equals("")) {
			conditions.add(price);
		}
		else {
			JOptionPane.showMessageDialog(null, "Please make sure all textfields are entered", "Input Error", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		/**
		 * creates a new string based on the array list and inserts a , in between each string token
		 */
		String joinedconditions= String.join(", ", conditions);
		if(joinedconditions.isEmpty()) {return;}
		String query = "INSERT INTO "+ Ordertable + " VALUES ("+ joinedconditions+")";
		System.out.println("Try to add: "+query.toString());
		
		if(price.equals("")) {
			JOptionPane.showMessageDialog(null, "Please make sure all textfields are entered", "Input Error", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		/*Line Section*/
		/**
		 * creates a new array list based on the customer line attributes
		 */
		ArrayList<String> Lineconditions = new ArrayList<String>();
		if(!Firstname.equals("")) {
			Lineconditions.add(Fname+"=\""+Firstname+"\"");
		}
		
		if(!lastname.equals("")) {
			Lineconditions.add(Lname+"=\""+lastname+"\"");
		}
	
		if(!orderDescription.equals("")) {
			Lineconditions.add(OrderDescription+"=\""+orderDescription+"\"");
		}
	
		/**
		 * creates a new string based on the customer line array list, inserting an and in between each attribute and element
		 */
		String joinedLineconditions= String.join(" AND ", Lineconditions);
		if(joinedLineconditions.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please enter all information", "Input Error", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		/**
		 * creates a line query to format the sql statement
		 */
		String Linequery = "UPDATE "+ OrderLineTable + " SET "+ BeingWorkedOn+" = TRUE WHERE "+joinedLineconditions;
		System.out.println("Try to update: "+Linequery);
		
		try{
			/**
			 * creates a statment based on the sql statement
			 */
			Statement st = con.createStatement();
			/**
			 * creates a result set based on a created sql statement and a joinLinecondition
			 */
			ResultSet rs = st.executeQuery("select * from "+ OrderLineTable + " WHERE "+ joinedLineconditions);
			if(!rs.next()){
				JOptionPane.showMessageDialog(null, "The current inputs are not in the table " +OrderLineTable, "Input Error", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			
			con.createStatement().executeUpdate(query);
			con.createStatement().executeUpdate(Linequery);
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage(), "Order adding error", JOptionPane.ERROR_MESSAGE);
		}
		
	}

	/**
	 * Removes any tuple from the order database table that contains the users inputs
	 * @param Firstname of the customer
	 * @param lastname last name of the customer
	 * @param orderDescription order description of the database
	 * @param price price of the order
	 */
	public static void OrderRemove(String Firstname, String lastname, String orderDescription, String price) {
		
		/**
		 * creates a array list to help format attributes from the order table database
		 */
		ArrayList<String> conditions = new ArrayList<String>();
		
		if(!Firstname.equals("")) {
			conditions.add(Fname+"=\""+Firstname+"\"");
		}
		if(!lastname.equals("")) {
			conditions.add(Lname+"=\""+lastname+"\"");
		}
		if(!orderDescription.equals("")) {
			conditions.add(OrderDescription+"=\""+orderDescription+"\"");
		}
		if(!price.equals("")) {
			conditions.add(Price+"="+price);
		}
		
		/**
		 * creates a new string joining the array list with a and in between each string token 
		 */
		String joinedconditions= String.join(" AND ", conditions);
		if(joinedconditions.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please make sure a value is entered to remove", "Input Error", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		/**
		 * creates a query to format the sql statement
		 */
		String query = "Delete from "+ Ordertable + " where "+ joinedconditions;
		System.out.println("Try to delete: "+query);
		try{
			con.createStatement().executeUpdate(query);
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Exeception: "+e.getMessage(), "Order removal Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Removes any tuple from the customer line database table that contains the users inputs
	 * @param Firstname of the customer
	 * @param lastname last name of the customer
	 * @param orderDescription order description of the database
	 */
	public static void LineRemove(String Firstname, String lastname, String orderDescription) {
		
		/**
		 * creates a array list that format the user inputs in a way that resembles the sql statment somewhat
		 */
		ArrayList<String> conditions = new ArrayList<String>();
		
		if(!Firstname.equals("")) {
			conditions.add(Fname+"=\""+Firstname+"\"");
		}
		if(!lastname.equals("")) {
			conditions.add(Lname+"=\""+lastname+"\"");
		}
		if(!orderDescription.equals("")) {
			conditions.add(OrderDescription+"=\""+orderDescription+"\"");
		}
		
		if(!conditions.isEmpty()) {
			conditions.add(BeingWorkedOn +" = TRUE");
		}
		
		/**
		 * creates a joined condition string based on the array list inserting a AND statement in between each and. 
		 */
		String joinedconditions= String.join(" AND ", conditions);
		if(joinedconditions.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please make sure a value is entered to remove", "Input Error", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		/**
		 * creates a string formated as a sql statment attached the join condition to mainpulate the database table later on
		 */
		String query = "Delete from "+ OrderLineTable + " where "+ joinedconditions;
		//System.out.println("Try to delete: "+query);
		try{
			con.createStatement().executeUpdate(query);
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage(), "Line removal Error", JOptionPane.ERROR_MESSAGE);
			
		}
	}
	/**
	 * returns the employee permission level
	 * @param Firstname first name of the employee
	 * @param Lastname last name of the employee
	 * @param ID the employee ID of the employee logining in
	 * @return returns the permission level of the employee
	 */
	public static int checkEmployee(String Firstname, String Lastname, String ID) {
	   /**
	 	* creates a integer output to return the employee permission.
	 	*/
		int output = 0;
		
		
		if(Firstname.equals("") && Lastname.equals("") && ID.equals("")) {
			JOptionPane.showMessageDialog(null, "Please make sure all textfields are entered", "Login Error", JOptionPane.INFORMATION_MESSAGE);
			return 0;
		}
		
		/**
		 * creates a array list to help with formating the where case within the sql statement later on
		 */
		ArrayList<String> Lineconditions = new ArrayList<String>();
		if(!Firstname.equals("")) {
			Firstname = Firstname.toLowerCase();
			Lineconditions.add(Fname+"=\""+Firstname+"\"");
		}
		else {
			JOptionPane.showMessageDialog(null, "Please enter a first name", "Login Error", JOptionPane.INFORMATION_MESSAGE);
			return 0;
		}
		
		if(!Lastname.equals("")) {
			Lastname = Lastname.toLowerCase();
			Lineconditions.add(Lname+"=\""+Lastname+"\"");
		}
		else {
			JOptionPane.showMessageDialog(null, "Please enter a last name", "Login Error", JOptionPane.INFORMATION_MESSAGE);
			return 0;
		}
		if(!ID.equals("")) {
			Lineconditions.add(EmployeeID+"=\""+ID+"\"");
		}
		else {
			JOptionPane.showMessageDialog(null, "Please enter an ID", "Login Error", JOptionPane.INFORMATION_MESSAGE);
			return 0;
		}
		/**
		 * creates a join string to hold by inserting a and in between each element within the array list
		 */
		String joinedEmployeeconditions= String.join(" AND ", Lineconditions);
	
		try {
			/**
			 * creates a statement based on the sql connection
			 */
			Statement st = con.createStatement();
			/**
			 * creates a result set to hold all elements within the 
			 */
			ResultSet rs = st.executeQuery("select "+ Permission + " from "+EmployeesTable+"\nwhere " + joinedEmployeeconditions);
			/*calls rs.next() to see if it has a value if it doesnt then it will throw an exception*/
			rs.next();
			output = rs.getInt(Permission);
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Invalid login", "Login Error", JOptionPane.ERROR_MESSAGE);
		}
		return output;
	}
}
