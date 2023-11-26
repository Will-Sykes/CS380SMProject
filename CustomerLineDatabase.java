import java.sql.*;


public class CustomerLineDatabase {
	
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
		String pass = "#h3ll0W0r1d!";
		try {
			con = DriverManager.getConnection(url, username, pass);
			System.out.println("connected");
			
		}catch(Exception e){
			System.out.println("exception "+ e.getMessage());
		}
	}
	
	/*
	 * adds an order to the database
	 * @param fname is the first name of the customer
	 * @param lname is the last name of the customer
	 * @order is the total order of the customer
	 */
	public static void makeOrder(String fname, String lname, String order) {
		String toAdd = "'" + fname + "'" + ", " + "'" + lname + "' ," + "'"+ order + "', False";
		String query = "INSERT INTO CustomerLine(Fname, Lname, OrderDescription, BeingWorkedOn) VALUES (" + toAdd + ")";
		System.out.println("try to insert: " + query);
		try {
			con.createStatement().executeUpdate(query);
		}catch(Exception e){
			System.out.println("Exception "+e.getMessage());
		}
	}

	/**
	 * Prints the products and prices of menu items
	 */
	public static String PrintPriceCheckPanel() {
		String output = "";

		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from "+ManagerView+"\nwhere " + Category + " = "+"\"" +  PriceCheck+"\"");
			while(rs.next()) {
				output += (rs.getString(Product)+ " ");
				if(rs.getString(Price).length() == 3) {
					output += ("$" + rs.getString(Price) + "0");
				}else {
					output += ("$" + rs.getString(Price));
				}
				output += ("\n");
			}
		}catch(Exception e){
			System.out.println("Exception "+e.getMessage());
		}
		return output;
		
	}
	
	/*
	 * get the price of a certain item as a string
	 * @param item is the item to check the price of
	 */
	public static String getPrice(String item) {
		String output = "";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from "+ManagerView+"\nwhere " + Category + " = "+"\"" +  PriceCheck+"\"");
			while(rs.next()) {
				if(rs.getString(Product).equals(item)) {
					output = rs.getString(Price);
				}
			}
		}catch(Exception e){
			System.out.println("Exception "+e.getMessage());
		}
		
		return output;
	}
	
	/*
	 * check if an item exists in the menu
	 * @param is the item we are looking for
	 * @return true if the item exists menu, false if not
	 */
	public static boolean ItemNotExist(String item) {	
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from "+ManagerView+"\nwhere " + Category + " = "+"\"" +  PriceCheck+"\"");
			while(rs.next()) {
				if(rs.getString(Product).equals(item)) {
					return false;
				}
			}
		}catch(Exception e){
			System.out.println("Exception "+e.getMessage());
		}
		return true;
	}

}
