import java.util.*;

public class Test {
    public static void main(String[] args) {
        // Initial setup
        VendingMachine vendingMachine = createSampleVendingMachine();

        // Display initial inventory
        vendingMachine.displayInventory();

        // Test buying multiple products
        Map<String, Integer> selectedProducts = new HashMap<>();
        selectedProducts.put("Coke", 2);
        selectedProducts.put("Pepsi", 1);

        vendingMachine.buyProducts(selectedProducts, 75);

        // Display updated inventory
        vendingMachine.displayInventory();
    }

    private static VendingMachine createSampleVendingMachine() {
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

        return new VendingMachine(initialInventory, initialCoins);
    }
}
