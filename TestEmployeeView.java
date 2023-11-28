import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestEmployeeView{

	
	/**
	 * Tests the order add method
	 */
	@Test
	void testOrderAdd() {
		CheckSQLconnection.setURL("jdbc:mysql://localhost:3306/my_coffee_shop");
		CheckSQLconnection.setUsername("root");
		CheckSQLconnection.setPassword("password!");
		CheckSQLconnection.connection();
		Order_database.connection();
		String prevCustomerLine = Order_database.PrintLinePanel();
		String prevOrders = Order_database.PrintOrderPanel();
		
		Order_database.OrderAdd("Dave", "Le", "Mocha and a sandwhich", "15.50");
		 assertEquals(prevCustomerLine, Order_database.PrintLinePanel());
		 assertEquals(prevOrders, Order_database.PrintOrderPanel());
		 
		Order_database.OrderAdd("Dave", "", "Mocha and a sandwhich", "15.50");
		assertEquals(prevCustomerLine, Order_database.PrintLinePanel());
		assertEquals(prevOrders, Order_database.PrintOrderPanel());
			 
		Order_database.OrderAdd("", "Lee", "Mocha and a sandwhich", "15.50");
		assertEquals(prevCustomerLine, Order_database.PrintLinePanel());
		assertEquals(prevOrders, Order_database.PrintOrderPanel());
		
		Order_database.OrderAdd("Dave", "Lee", "", "15.50");
		assertEquals(prevCustomerLine, Order_database.PrintLinePanel());
		assertEquals(prevOrders, Order_database.PrintOrderPanel());
		
		Order_database.OrderAdd("Dave", "Le", "Mocha and a sandwhich", "");
		assertEquals(prevCustomerLine, Order_database.PrintLinePanel());
		assertEquals(prevOrders, Order_database.PrintOrderPanel());
		
		Order_database.OrderAdd("Dave", "Lee", "Mocha and a sandwhich", "15.50");
		assertNotEquals(prevCustomerLine, Order_database.PrintLinePanel());
		assertNotEquals(prevOrders, Order_database.PrintOrderPanel());
	}
	/**
	 * Tests the order removal method
	 */
	@Test
	void testOrderRemove() {
		CheckSQLconnection.setURL("jdbc:mysql://localhost:3306/my_coffee_shop");
		CheckSQLconnection.setUsername("root");
		CheckSQLconnection.setPassword("password!");
		
		CheckSQLconnection.connection();
		Order_database.connection();
		
		String prevOrders = Order_database.PrintOrderPanel();
		Order_database.OrderRemove("B", "S", "L", "6");
		assertEquals(prevOrders, Order_database.PrintOrderPanel());
		
		Order_database.OrderRemove("", "", "", "");
		assertEquals(prevOrders, Order_database.PrintOrderPanel());
		
		Order_database.OrderRemove("Bob", "Smith", "Latte and a cookie", "6.50");
		assertNotEquals(prevOrders, Order_database.PrintOrderPanel());
		
	}
	
	/**
	 * Tests the Line remove 
	 */
	@Test
	void testLineRemove() {
		CheckSQLconnection.setURL("jdbc:mysql://localhost:3306/my_coffee_shop");
		CheckSQLconnection.setUsername("root");
		CheckSQLconnection.setPassword("password!");
		 
		CheckSQLconnection.connection();
		Order_database.connection();
		
		String prevCustomerLine = Order_database.PrintLinePanel();
		Order_database.LineRemove("B", "S", "L and a c");
		assertEquals(prevCustomerLine, Order_database.PrintLinePanel());
		
		Order_database.LineRemove("", "", "");
		assertEquals(prevCustomerLine, Order_database.PrintLinePanel());
		
		Order_database.LineRemove("Bob", "Smith", "Latte and a cookie");
		assertNotEquals(prevCustomerLine, Order_database.PrintLinePanel());
		
	}
	
	/**
	 * Tests the employee login for the database
	 */
	@Test
	void testCheckEmployee() {
		
		CheckSQLconnection.setURL("jdbc:mysql://localhost:3306/my_coffee_shop");
		CheckSQLconnection.setUsername("root");
		CheckSQLconnection.setPassword("password!");
		
		CheckSQLconnection.connection();
		Order_database.connection();
		
		assertEquals(2, Order_database.checkEmployee("Devlin", "Hamill", "213"));
		assertEquals(3, Order_database.checkEmployee("William", "Sykes", "321"));
		assertEquals(0, Order_database.checkEmployee("", "Hamill", "213"));
		assertEquals(0, Order_database.checkEmployee("William", "", "321"));
		assertEquals(0, Order_database.checkEmployee("Devlin", "Hamill", ""));
		assertEquals(0, Order_database.checkEmployee("Chuck", "Norris", "55555555"));
		
		
	}
	/**
	 * Tests the sql connection for the database
	 */
	@Test
	void checkConnection(){
		CheckSQLconnection.setURL("jdbc:mysql://localhost:3306/my_coffee_shop");
		CheckSQLconnection.setUsername("root");
		CheckSQLconnection.setPassword("password!");
		
		assertTrue(CheckSQLconnection.connection());
		CheckSQLconnection.setURL("jdbc:mysql://localhost:33");
		assertFalse(CheckSQLconnection.connection());
		
		CheckSQLconnection.setURL("jdbc:mysql://localhost:3306/my_coffee_shop");
		CheckSQLconnection.setUsername("r");
		assertFalse(CheckSQLconnection.connection());
		
		CheckSQLconnection.setUsername("root");
		CheckSQLconnection.setPassword("pass");
		assertFalse(CheckSQLconnection.connection());
	}
	
}
