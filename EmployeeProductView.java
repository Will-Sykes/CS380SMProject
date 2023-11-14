import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeProductView {
	
	public static Connection con = null;
	public static void connection() {
		String url = "jdbc:mysql://localhost:3306/smcoffee";
		String username = "cs380Will";
		String pass = "cs380";
		
		try {
			con = DriverManager.getConnection(url, username,pass);
			System.out.println("Connected");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
}
	
	public static void addProduct(String product, Double price, int quantity, String category) {
	
	/**
     * Method to add a row in manageview table
     * @param String dvdT Title from field 
     * @param String dvdY Year  from field
     * @param Integer dvdCN Call number from field
     */
	try {
        Statement st = con.createStatement();

        
        String query = "INSERT INTO smcoffee.managerview (Product, Price, Quantity, Category) " +
                "VALUES ('" + product + "', '" + price + "', '" + quantity + "', '" + category +"')";

        int rowsAffected = st.executeUpdate(query);

        if (rowsAffected > 0) {
        	System.out.println("---------------------------------------");
            System.out.println("Product added successfully!");
            System.out.println("---------------------------------------");
        } else {
        	System.out.println("---------------------------------------");
            System.out.println("Failed to add product.");
            System.out.println("---------------------------------------");
        }
    } catch (SQLException e) {
        e.printStackTrace();  
    
    }
	
	}
	
	public static void removeProduct(String product) {
		
		/**
         * Method to remove a row in books table
         * @param String bookTitle Title from field 
         */
	    try {
	        Statement st = con.createStatement();

	        
	        String query = "DELETE FROM smcoffee.managerview WHERE Product = '" + product + "'";

	        int rowsAffected = st.executeUpdate(query);

	        if (rowsAffected > 0) {
	        	System.out.println("---------------------------------------");
	            System.out.println("Product removed successfully!");
	            System.out.println("---------------------------------------");
	        } else {
	        	System.out.println("---------------------------------------");
	            System.out.println("Product not found or failed to remove.");
	            System.out.println("---------------------------------------");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();  
	    }
		
		
	}
	
	
	public static void modProduct(String product, Double price, int quantity, String category) {
		/**
         * Method to remove a row in books table
         * @param String bookTitle Title from field 
         */
	    try {
	        Statement st = con.createStatement();

	        
	        String updateStatusQuery = "UPDATE smcoffee.managerview SET Price = '"+ price +"' WHERE Product = '" + product + "'";
	        int rowsAffected = st.executeUpdate(updateStatusQuery);
	        String updateStatusQuery2 = "UPDATE smcoffee.managerview SET Quantity = '"+ quantity +"' WHERE Product = '" + product + "'";
	        int rowsAffected2 = st.executeUpdate(updateStatusQuery2);
	        String updateStatusQuery3 = "UPDATE smcoffee.managerview SET Category = '"+ category +"' WHERE Product = '" + product + "'";
	        int rowsAffected3 = st.executeUpdate(updateStatusQuery2);

	        if (rowsAffected3 > 0) {
	        	System.out.println("---------------------------------------");
	            System.out.println("Product modified successfully!");
	            System.out.println("---------------------------------------");
	        } else {
	        	System.out.println("---------------------------------------");
	            System.out.println("Product not found or failed to modify.");
	            System.out.println("---------------------------------------");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();  
	    }
	}
}
