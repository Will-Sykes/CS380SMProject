import static org.junit.Assert.*;

import org.junit.Test;

public class TestCustomer {
	// No tests for the CustomerUI class because there are no methods to test
	
	//private Functionality function = new Functionality();

	@Test
	public void testAddToCartFood() {
		CustomerLineDatabase.connection();
		Functionality function = new Functionality();
		
		/*
		 * edits made:
		 * 
		 * added try catch to the method so ensure that the item I am adding does exist
		 * 
		 * made sure to only add items if quantity is greater than 0
		 * 
		 * made better use of the quantity variable 
		 */
		
		function.addToCart("ggakelrijovaer", 1);
		assertEquals("{}", function.getOrderDisplayHash());
		assertEquals("[]", function.getOrderDisplayArray());
		assertEquals("[]", function.getOrderArray());
		assertEquals(0.0f, function.getTotal(), 0.00f);
		
		
		function.addToCart("Bagel", -1);
		assertEquals("{}", function.getOrderDisplayHash());
		assertEquals("[]", function.getOrderDisplayArray());
		assertEquals("[]", function.getOrderArray());
		assertEquals(0.0f, function.getTotal(), 0.00f);
		
		function.addToCart("Bagel", 0);
		assertEquals("{}", function.getOrderDisplayHash());
		assertEquals("[]", function.getOrderDisplayArray());
		assertEquals("[]", function.getOrderArray());
		assertEquals(0.0f, function.getTotal(), 0.00f);
		
		function.addToCart("Bagel", 100);
		assertEquals("{Bagel=100}", function.getOrderDisplayHash());
		assertEquals("[Bagel]", function.getOrderDisplayArray());
		assertEquals("[|100 Bagel]", function.getOrderArray());
		assertEquals(500.0f, function.getTotal(), 0.00f);
	}
	
	@Test
	public void testAddToCartDrinks() {
		CustomerLineDatabase.connection();
		Functionality function = new Functionality();
		
		/*
		 * edits made:
		 * 
		 * added try catch to the method so ensure that the item I am adding does exist
		 * 
		 * made sure to only add items if quantity is greater than 0
		 */
		function.clear();
		function.addToCart("ggakelrijovaer", "S Hot NF 1Shot", 1);
		assertEquals("{}", function.getOrderDisplayHash());
		assertEquals("[]", function.getOrderDisplayArray());
		assertEquals("[]", function.getOrderArray());
		assertEquals(0.0f, function.getTotal(), 0.00f);
		
		function.addToCart("Latte", "S Hot NF 1Shot", -1);
		assertEquals("{}", function.getOrderDisplayHash());
		assertEquals("[]", function.getOrderDisplayArray());
		assertEquals("[]", function.getOrderArray());
		assertEquals(0.0f, function.getTotal(), 0.00f);
		
		function.addToCart("Latte", "S Hot NF 1Shot", 0);
		assertEquals("{}", function.getOrderDisplayHash());
		assertEquals("[]", function.getOrderDisplayArray());
		assertEquals("[]", function.getOrderArray());
		assertEquals(0.0f, function.getTotal(), 0.00f);
		
		function.addToCart("Latte", "1 S Hot NF 1Shot", 1);
		assertEquals("{Latte: S Hot NF 1Shot=1}", function.getOrderDisplayHash());
		assertEquals("[Latte: S Hot NF 1Shot]", function.getOrderDisplayArray());
		assertEquals("[|1 Latte: S Hot NF 1Sh]", function.getOrderArray());
		assertEquals(3.5f, function.getTotal(), 0.00f);

	}
	
	
	@Test
	public void testRemove() {
		CustomerLineDatabase.connection();
		Functionality function = new Functionality();
		
		/*
		 * edits made:
		 * 
		 * made it so that it removes from the orderArray, did not realize it originally did not 
		 * remove from that array
		 */
		
		function.addToCart("Latte", "S Hot NF 1Shot", 100);
		for(int i = 0; i < 100; i++) {
			function.remove();
		}
		assertEquals("{}", function.getOrderDisplayHash());
		assertEquals("[]", function.getOrderDisplayArray());
		assertEquals("[]", function.getOrderArray());
		assertEquals(0.0f, function.getTotal(), 0.00f);
		
		function.remove();
		function.remove();
		assertEquals("{}", function.getOrderDisplayHash());
		assertEquals("[]", function.getOrderDisplayArray());
		assertEquals("[]", function.getOrderArray());
		assertEquals(0.0f, function.getTotal(), 0.00f);
		
		function.addToCart("Latte", "1 S Hot NF 1Shot", 100);
		for(int i = 0; i < 99; i++) {
			function.remove();
		}
		assertEquals("{Latte: S Hot NF 1Shot=1}", function.getOrderDisplayHash());
		assertEquals("[Latte: S Hot NF 1Shot]", function.getOrderDisplayArray());
		assertEquals("[|1 Latte: S Hot NF 1Sh]", function.getOrderArray());
		assertEquals(3.5f, function.getTotal(), 0.00f);
		
		
	}

}
