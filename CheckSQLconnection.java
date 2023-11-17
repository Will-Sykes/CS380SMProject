import java.sql.DriverManager;
import java.sql.*;

public class CheckSQLconnection {
	private static String url;
	private static String username;
	private static String password;
	
	public CheckSQLconnection(String url, String username, String password){
		this.url = url;
		this.username = username;
		this.password = password;
	}
		
	public static void setURL(String tempURL) {
		url = tempURL;
	}
	
	public static String getURL() {
		return url;
	}
	
	public static void setUsername(String tempUsername) {
		username = tempUsername;
	}
	
	public static String getUsername() {
		return username;
	}
	
	public static void setPassword(String tempPassword) {
		password = tempPassword;
	}
	
	public static String getPassword() {
		return password;
	}
	
	public static boolean connection() {
	
		try(Connection con = DriverManager.getConnection(url, username, password)) {
			System.out.println("connected");
			return true;
		}catch(SQLException e){
			System.out.println("exception "+ e.getMessage());
			return false;
		}
	}
	
}
