import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class SILab2Test {

    @Test
    public void testBranches() {
        List<Item> allItems = new ArrayList<>();

        // Test Case 1: allItems list is null
        Exception exception = assertThrows(RuntimeException.class, () -> SILab2.checkCart(null, 100));
        assertEquals("allItems list can't be null!", exception.getMessage());

        // Test Case 2: Item with null barcode
        allItems.add(new Item("", null, 100, 0));
        exception = assertThrows(RuntimeException.class, () -> SILab2.checkCart(allItems, 100));
        assertEquals("No barcode!", exception.getMessage());
        allItems.clear();

        // Test Case 3: Item with invalid barcode
        allItems.add(new Item("item1", "12345a", 100, 0));
        exception = assertThrows(RuntimeException.class, () -> SILab2.checkCart(allItems, 100));
        assertEquals("Invalid character in item barcode!", exception.getMessage());
        allItems.clear();

        // Test Case 4:  Item with valid barcode and no discount
        allItems.add(new Item("item1", "123456", 100, 0));
        assertTrue(SILab2.checkCart(allItems, 100));
        allItems.clear();

        // Test Case 5: Item with price > 300, discount > 0, and barcode starting with '0'
        allItems.add(new Item("item1", "012345", 400, 0.2F));
        assertTrue(SILab2.checkCart(allItems, 100));
        allItems.clear();
    }

    @Test
    public void testMultipleConditions() {
        List<Item> allItems = new ArrayList<>();
        //if (item.getPrice() > 300 && item.getDiscount() > 0 && item.getBarcode().charAt(0) == '0')
        // Test Case 1: F && F && F
        allItems.add(new Item("item1", "123456", 200, 0));
        assertTrue(SILab2.checkCart(allItems, 200));
        allItems.clear();

        //Test Case 2: F && F && T
        allItems.add(new Item("item1", "012345", 200, 0));
        assertTrue(SILab2.checkCart(allItems, 200));
        allItems.clear();

        //Test Case 3: F && T && F
        allItems.add(new Item("item1", "123456", 200, 0.1f));
        assertTrue(SILab2.checkCart(allItems, 20));
        allItems.clear();

        //Test Case 4: F && T && T
        allItems.add(new Item("item1", "012345", 200, 0.1f));
        assertTrue(SILab2.checkCart(allItems, 20));
        allItems.clear();

        //Test Case 5: T && F && F
        allItems.add(new Item("item1", "123456", 400, 0));
        assertTrue(SILab2.checkCart(allItems, 400));
        allItems.clear();

        //Test Case 6: T && F && T
        allItems.add(new Item("item1", "012345", 400, 0));
        assertTrue(SILab2.checkCart(allItems, 400));
        allItems.clear();

        //Test Case 7: T && T && F
        allItems.add(new Item("item1", "123456", 400, 0.1f));
        assertTrue(SILab2.checkCart(allItems, 40));
        allItems.clear();

        //Test Case 8: T && T && T
        allItems.add(new Item("item1", "012345", 400, 0.1f));
        assertTrue(SILab2.checkCart(allItems, 10));
        allItems.clear();
    }
}
