import java.sql.*;
import java.util.ArrayList;


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
	
	public static final String Category = "Category";
	
	public static final String Product = "Product";
	
	public static final String Quantity = "Quantity";
	
	
	
	
	
	/**
	 * Connects to the MySQL database
	 */
	public static void connection() {
		/**
		 * declares a string link to the database so that both ends can connect
		 */
		String url = "jdbc:mysql://localhost:3306/my_coffee_shop";
		/**
		 * declares the user name needed to access the database
		 */
		String username = "root";
		/**
		 * declares a password needed to access the database
		 */
		String pass = "password!";
		try {
			con = DriverManager.getConnection(url, username, pass);
			System.out.println("connected");
			
		}catch(Exception e){
			System.out.println("exception "+ e.getMessage());
		}
	}
	

	/**
	 * Prints the prices products and prices of certain items
	 */
	public static String PrintPriceCheckPanel() {
		String output = "";
		
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from "+ManagerView+"\nwhere " + Category + " = "+"\"" +  PriceCheck+"\"");
			while(rs.next()) {
				output += (rs.getString(Product)+ " ");
				output += (rs.getString(Price));
				output += ("\n");
			}
		}catch(Exception e){
			System.out.println("Exception "+e.getMessage());
		}
		return output;
		
	}
	
	/**
	 * Prints the entire table in the database that is ordered by the Fname
	 */
	public static String PrintOrderPanel() {
		String output = "";
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from "+Ordertable+"\nORDER BY Fname");
			while(rs.next()) {
				output += (rs.getString(Fname)+ " ");
				output += (rs.getString(Lname)+ " ");
				output += ("\""+rs.getString(OrderDescription)+ "\" ");
				output += (rs.getString(Price));
				output += ("\n");
			}
		}catch(Exception e){
			System.out.println("Exception "+e.getMessage());
		}
		return output;
		
	}
	
	
	/**
	 * Prints the entire table in the database that is ordered by the Fname
	 */
	public static String PrintLinePanel() {
		String output = "";
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from "+OrderLineTable+"\nORDER BY Fname");
			while(rs.next()) {
				output += (rs.getString(Fname)+ " ");
				output += (rs.getString(Lname)+ " ");
				output += ("\""+rs.getString(OrderDescription)+ "\" ");
				output += (rs.getString(BeingWorkedOn));
				output += ("\n");
			}
		}catch(Exception e){
			System.out.println("Exception "+e.getMessage());
		}
		return output;
		
	}
	/**
	 * Adds all user inputs into a tuple on the database.
	 * @param Firstname the first name of the customer
	 * @param lastname the last name of the customer
	 * @param orderDescription the order description of what the customer wants
	 * @param price of the order
	 */
	public static void OrderAdd(String Firstname, String lastname, String orderDescription, String price) {
		/*order Section*/
		ArrayList<String> conditions = new ArrayList<String>();
		
		if(!Firstname.equals("")) {
			conditions.add("\""+Firstname+"\"");
		}
		else {
			System.out.println("Please make sure all values are entered");
			return;
		}
		if(!lastname.equals("")) {
			conditions.add("\""+lastname+"\"");
		}
		else {
			System.out.println("Please make sure all values are entered");
			return;
		}
		if(!orderDescription.equals("")) {
			conditions.add("\""+orderDescription+"\"");
		}
		else {
			System.out.println("Please make sure all values are entered");
			return;
		}
		if(!price.equals("")) {
			conditions.add(price);
		}
		else {
			System.out.println("Please make sure all values are entered");
			return;
		}
		String joinedconditions= String.join(", ", conditions);
		if(joinedconditions.isEmpty()) {return;}
		String query = "INSERT INTO "+ Ordertable + " VALUES ("+ joinedconditions+")";
		System.out.println("Try to add: "+query.toString());
		
		/*Line Section*/
		if(price.equals("")) {
			System.out.println("make sure all textfields are filled");
			return;
		}
		
		ArrayList<String> Lineconditions = new ArrayList<String>();
		if(!Firstname.equals("")) {
			Lineconditions.add(Fname+"=\""+Firstname+"\"");
		}
		else {
			System.out.println("Please enter a Firstname");
			return;
		}
		
		if(!lastname.equals("")) {
			Lineconditions.add(Lname+"=\""+lastname+"\"");
		}
		else {
			System.out.println("Please enter a lastname");
			return;
		}
		if(!orderDescription.equals("")) {
			Lineconditions.add(OrderDescription+"=\""+orderDescription+"\"");
		}
		else {
			System.out.println("Please enter a order Description");
			return;
		}
		
		String joinedLineconditions= String.join(" AND ", Lineconditions);
		if(joinedLineconditions.isEmpty()) {
			System.out.println("please enter all information");
			return;
		}
		String Linequery = "UPDATE "+ OrderLineTable + " SET "+ BeingWorkedOn+" = TRUE WHERE "+joinedLineconditions;
		System.out.println("Try to update: "+Linequery);
		
		
		
		try{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from "+ OrderLineTable + " WHERE "+ joinedLineconditions);
			if(!rs.next()){
				System.out.println("The current inputs are not in the table "+ OrderLineTable);
				return;
			}
			
			
			con.createStatement().executeUpdate(query);
			con.createStatement().executeUpdate(Linequery);
		}catch(Exception e){
			System.out.println("Exception "+e.getMessage());
		}
		
	}

	/**
	 * Removes any tuple from the database that contains the users inputs
	 * @param Firstname of the customer
	 * @param lastname last name of the customer
	 * @param orderDescription order description of the database
	 * @param price price of the order
	 */
	public static void OrderRemove(String Firstname, String lastname, String orderDescription, String price) {
		
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
		
		String joinedconditions= String.join(" AND ", conditions);
		if(joinedconditions.isEmpty()) {
			System.out.println("Please make sure a value is entered to remove");
			return;
		}
		String query = "Delete from "+ Ordertable + " where "+ joinedconditions;
		System.out.println("Try to delete: "+query);
		try{
			con.createStatement().executeUpdate(query);
		}catch(Exception e){
			System.out.println("Exception "+e.getMessage());
		}
	}
	
	/**
	 * Removes any tuple from the database that contains the users inputs
	 * @param Firstname of the customer
	 * @param lastname last name of the customer
	 * @param orderDescription order description of the database
	 */
	public static void LineRemove(String Firstname, String lastname, String orderDescription) {
		
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
		
		String joinedconditions= String.join(" AND ", conditions);
		if(joinedconditions.isEmpty()) {
			System.out.println("Please make sure a value is entered to remove");
			return;
		}
		String query = "Delete from "+ OrderLineTable + " where "+ joinedconditions;
		System.out.println("Try to delete: "+query);
		try{
			con.createStatement().executeUpdate(query);
		}catch(Exception e){
			System.out.println("Exception "+e.getMessage());
		}
	}
	

}
