import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        // Test vending machine functionality
        testVendingMachine();
    }

    private static void testVendingMachine() {
        // Initialize vending machine with inventory and coin float
        Map<String, Integer> initialInventory = new HashMap<>();
        initialInventory.put("Coke", 10);
        initialInventory.put("Pepsi", 15);
        initialInventory.put("Sprite", 12);

        Map<Integer, Integer> initialCoins = new HashMap<>();
        initialCoins.put(1, 10);
        initialCoins.put(5, 10);
        initialCoins.put(10, 10);
        initialCoins.put(25, 10);
        initialCoins.put(50, 10);
        initialCoins.put(100, 10);

        VendingMachine vendingMachine = new VendingMachine(initialInventory, initialCoins);

        // Test buying a product
        System.out.println("Test 1: Buying a product with exact change");
        vendingMachine.buyProduct("Coke", 25);
        vendingMachine.displayInventory();
        System.out.println();

        // Test buying a product with insufficient change
        System.out.println("Test 2: Buying a product with insufficient change");
        vendingMachine.buyProduct("Pepsi", 10);
        vendingMachine.displayInventory();
        System.out.println();

        // Test buying a product with excess change
        System.out.println("Test 3: Buying a product with excess change");
        vendingMachine.buyProduct("Sprite", 50);
        vendingMachine.displayInventory();
        System.out.println();
    }
}
