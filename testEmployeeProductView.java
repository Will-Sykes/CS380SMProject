import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class testEmployeeProductView {

	@BeforeAll
    static void setUp() {
        // Set up the database connection before running the tests
        EmployeeProductView.connection();
        assertTrue(EmployeeProductView.addProduct("TestProducttoSearch", 10.0, 20, "TestCategory"));
    }

    @AfterAll
    static void tearDown() {
        // Close the database connection after running all tests
        try {
            if (EmployeeProductView.con != null) {
                EmployeeProductView.con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testAddProduct() {
    	// Test adding a product to each category successfully
        assertTrue(EmployeeProductView.addProduct("TestProduct", 10.0, 0, "Price Check"));
        assertTrue(EmployeeProductView.addProduct("TestProductForMod", 0.0, 40, "Inventory"));

        // Test adding a product with negative quantity (should fail)
        assertFalse(EmployeeProductView.addProduct("TestProduct2", 15.0, -10, "TestCategory2"));

        // Test adding a product with an empty category (should fail)
        assertFalse(EmployeeProductView.addProduct("TestProduct3", 20.0, 30, ""));

        // Test adding a product with a null category (should fail)
        assertFalse(EmployeeProductView.addProduct("TestProduct4", 25.0, 40, null));
    }

    @Test
    void testRemoveProduct() {
    	// Assuming there's a product called "TestProduct" added for testing purposes
        assertTrue(EmployeeProductView.removeProduct("TestProduct"));

        // Test removing a non-existing product (should fail)
        assertFalse(EmployeeProductView.removeProduct("NonExistingProduct"));

        // Test removing a product with an empty name (should fail)
        assertFalse(EmployeeProductView.removeProduct(""));

        // Test removing a product with a null name (should fail)
        assertFalse(EmployeeProductView.removeProduct(null));
    }

    @Test
    void testModProduct() {
    	
    	// These tests were designed to go one after the other
    	// Assuming there's a product called "TestProductForMod" added for testing purposes
        assertTrue(EmployeeProductView.modProduct("TestProductForMod", 0.0, 100, "Inventory"));

        // Assuming the product has been modified in the previous step
        assertTrue(EmployeeProductView.modProduct("TestProductForMod", 0.0, 50, "Inventory"));

        // Assuming the product has been modified in the previous step
        assertFalse(EmployeeProductView.modProduct("TestProductForMod", 10.0, 100, "Inventory"));

        // Assuming the product has not been modified in the previous step
        assertFalse(EmployeeProductView.modProduct("TestProductForMod", 10.0, 100, "Price Check"));

        // Assuming the product has not been modified in the previous step
        assertTrue(EmployeeProductView.modProduct("TestProductForMod", 10.0, 0, "Price Check"));

        // Assuming the product has been modified in the previous step
        assertTrue(EmployeeProductView.modProduct("TestProductForMod", 15.5, 0, "Price Check"));

        // Test modifying a product with negative price (should fail)
        assertFalse(EmployeeProductView.modProduct("TestProductForMod", -5.0, 50, "Inventory"));

        // Test modifying a product with negative quantity (should fail)
        assertFalse(EmployeeProductView.modProduct("TestProductForMod", 10.0, -20, "Inventory"));

        // Test modifying a product with an empty category (should fail)
        assertFalse(EmployeeProductView.modProduct("TestProductForMod", 10.0, 30, ""));

        // Test modifying a product with a null category (should fail)
        assertFalse(EmployeeProductView.modProduct("TestProductForMod", 10.0, 30, null));
    
    }
    
    @Test
    void testSearchProduct() {
    	
        // Test searching for an existing product
        String result = EmployeeProductView.searchProduct("TestProducttoSearch");
        String result2 = EmployeeProductView.searchProduct("Coffee Grounds");
        String result3 = EmployeeProductView.searchProduct("");
        
        // Test with created product (should fail)
        assertFalse(result.contains("Item not found."), "Product should be found");
        
        // Test search for product true
        assertTrue(result.contains("Name: TestProduct"), "Product details should be present in the result");
        
        // Test for product previously added
        assertTrue(result2.contains("Name: Coffee Grounds"));
        
        // Test with empty string (should fail)
        assertTrue(result3.contains("Item not found."), "Product should be found");

        // Test searching for a non-existent product (should fail)
        String nonExistentResult = EmployeeProductView.searchProduct("NonExistentProduct");
        assertTrue(nonExistentResult.contains("Item not found."), "Product should not be found");
    }
    
    @Test
    void testSearchCat() {
    	
    	// Test searching for an existing product in the "Price Check" category
        String expectedPriceCheckResult = EmployeeProductView.searchCat("Price Check");
        String actualPriceCheckResult = EmployeeProductView.searchCat("Price Check");
        
        String expectedInventoryResult = EmployeeProductView.searchCat("Inventory");
        String actualInventoryResult = EmployeeProductView.searchCat("Inventory");
        
        String actualNoCategoryResult = EmployeeProductView.searchCat("");
        
       
        assertEquals(expectedPriceCheckResult, actualPriceCheckResult, "correct result for 'Price Check'");
        assertNotEquals(expectedPriceCheckResult, actualInventoryResult );

        // Test searching for existing products in the "Inventory" category
        assertEquals(expectedInventoryResult, actualInventoryResult, "correct result for 'Inventory'");
        assertNotEquals(actualPriceCheckResult, actualNoCategoryResult);

        // Test searching with no category selected
        String expectedNoCategoryResult = "No products found in the specified category.";
        assertEquals(expectedNoCategoryResult, actualNoCategoryResult, "Incorrect result for no category selected");
        
    }


}
