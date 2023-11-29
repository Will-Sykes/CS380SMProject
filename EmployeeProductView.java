import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeProductView {
	
	public static Connection con = null;
	
	public static void connection() {
		String url = "jdbc:mysql://localhost:3306/my_coffee_shop";
		String username = "cs380Will";
		String pass = "cs380";
		
		try {
			con = DriverManager.getConnection(url, username, pass);
			System.out.println("Connected");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
}
	
	public static boolean addProduct(String product, Double price, int quantity, String category) {
	
		/**
		 * Method to add a product in manageview table
		 * @param String product name from field 
		 * @param double price from field
		 * @param Integer quantity from field
		 * @param category from jcbox field
		 */
		
		if(quantity < 0) {
			return false;
		}	
		
		if(price < 0) {
			return false;
		}
		
		if (category == "") {
			return false;
		}
		if (category == null) {
			return false;
		}
		
		try {
			Statement st = con.createStatement();

        
			String query = "INSERT INTO my_coffee_shop.managerview (Product, Price, Quantity, Category) " +
					"VALUES ('" + product + "', '" + price + "', '" + quantity + "', '" + category +"')";

			int rowsAffected = st.executeUpdate(query);

			if (rowsAffected > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();  
			return false;
		}
	
	}
	
	public static boolean removeProduct(String product) {
		
		/**
         * Method to remove a row in managerview table
         * @param String product name from field
         */
	    try {
	        Statement st = con.createStatement();

	        
	        String query = "DELETE FROM my_coffee_shop.managerview WHERE Product = '" + product + "'";

	        int rowsAffected = st.executeUpdate(query);

	        if (rowsAffected > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();  
			return false;
		}
		
		
	}
	
	
	public static boolean modProduct(String product, Double price, int quantity, String category) {
		/**
         * Method to modify a products information
         * @param String product  from field 
         * @param Double price  from field 
         * @param int quantity  from field 
         * @param String category  from field 
         */
		try {
	        Statement st = con.createStatement();

	        StringBuilder updateQuery = new StringBuilder("UPDATE my_coffee_shop.managerview SET ");
	        
	        if (price > 0 && category == "Inventory") {
	        	return false;
	        }
	        
	        if (quantity > 0 && category == "Price Check") {
	        	return false;
	        }
	        
	        if (price < 0) {
	        	return false; 
	        }
	        if (quantity < 0) {
	        	return false;
	        }
	        
	        if(category == "" || category == null) {
	        	return false;
	        }
	        
	        if (price >= 0) {
	            updateQuery.append("Price = '").append(price).append("', ");
	        }

	        if (quantity >= 0) {
	            updateQuery.append("Quantity = '").append(quantity).append("', ");
	        }

	        if (category != null && !category.isEmpty()) {
	            updateQuery.append("Category = '").append(category).append("', ");
	        }

	        
	        updateQuery.setLength(updateQuery.length() - 2);

	        updateQuery.append(" WHERE Product = '").append(product).append("'");

	        int rowsAffected = st.executeUpdate(updateQuery.toString());

	        return rowsAffected > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	/**
     * Search and retrieve product info for single product
     * @param String product from field
     */
	public static String searchProduct(String product) {
		
	    try {
	        Statement st = con.createStatement();

	        // query to retrieve customer information
	        String selectQuery = "SELECT * FROM my_coffee_shop.managerview WHERE Product = '" + product + "'";
	        ResultSet resultSet = st.executeQuery(selectQuery);

	        // if the customer with the provided name exists
	        if (resultSet.next()) {
	            // Customer found, retrieve information
	            String Product = resultSet.getString("Product");
	            Double price = resultSet.getDouble("Price");
	            int quantity = resultSet.getInt("Quantity");
	            String category = resultSet.getString("Category");

	         // Build the product information string
	            StringBuilder result = new StringBuilder();
	            result.append("Product Information:\n");
	            result.append("Name: ").append(Product).append("\n");
	            result.append("Price: $").append(price).append("\n");
	            result.append("Quantity: ").append(quantity).append("\n");
	            result.append("Category: ").append(category).append("\n");

	            return result.toString();
	        } else {
	        	return "Item not found.";
	        }
	    } catch (SQLException e) {
	    	e.printStackTrace();
	        return "Error occurred while searching for the product.";
	    }
	    
	    
	}
	
	
	/**
     * display all items by category
     * @param String category from combo box
     */
	public static String searchCat(String category) {
		
		try {
	        Statement st = con.createStatement();

	        // query to retrieve product information for the specified category
	        String selectQuery = "SELECT * FROM my_coffee_shop.managerview WHERE Category = '" + category + "'";
	        ResultSet resultSet = st.executeQuery(selectQuery);

	        StringBuilder result = new StringBuilder();

	        // loop through the result set for each product in the category
	        while (resultSet.next()) {
	            // Retrieve information for each product
	            String product = resultSet.getString("Product");
	            double price = resultSet.getDouble("Price");
	            int quantity = resultSet.getInt("Quantity");

	            // Append the product information to the result StringBuilder
	            result.append("Product Information:\n");
	            result.append("Name: ").append(product).append("\n");
	            result.append("Price: $").append(price).append("\n");
	            result.append("Quantity: ").append(quantity).append("\n");
	            result.append("----------------------------\n");
	        }

	        // Check if any products were found
	        if (result.length() > 0) {
	            return result.toString();
	        } else {
	            return "No products found in the specified category.";
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return "Error occurred while searching for products in the category.";
	    }
	}
}
