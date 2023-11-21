import java.sql.DriverManager;

import javax.swing.JOptionPane;

import java.sql.*;

public class CheckSQLconnection {
	/**
	 * a url string to check its connection later on
	 */
	private static String url;
	/**
	 * creates a string username to hold the sql database username
	 */
	private static String username;
	/**
	 * creates a string password that will hold the sql database password 
	 */
	private static String password;

	/**
	 * updates the url within the object
	 * @param tempURL the current string url
	 */
	public static void setURL(String tempURL) {
		url = tempURL;
	}
	
	/**
	 * retrieves the url to the sql database
	 * @return the url the string url of the database
	 */
	public static String getURL() {
		return url;
	}
	
	/**
	 * updates the username to the mysql database
	 * @param tempUsername new username to the database
	 */
	public static void setUsername(String tempUsername) {
		username = tempUsername;
	}
	
	/**
	 * retrieves the current instance of the username as a string
	 * @return string that holds the username to the mySQL connection
	 */
	public static String getUsername() {
		return username;
	}
	
	/**
	 * updates the password the the current instance of the mySQL database
	 * @param tempPassword new string for the password
	 */
	public static void setPassword(String tempPassword) {
		password = tempPassword;
	}
	
	/**
	 * retrieves the password the sql database
	 * @return the password as a string
	 */
	public static String getPassword() {
		return password;
	}
	
	/**
	 * checks the mySQL connection with the given values and returns a boolean
	 * @return a boolean that tells if the connection is valid or not
	 */
	public static boolean connection() {
	
		try(Connection con = DriverManager.getConnection(url, username, password)) {
			return true;
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, e.getMessage(), "SQL connection Issue", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}
	
}
