import java.util.HashMap;
import java.util.Map;

public class VendingMachine {
    private Map<String, Integer> inventory;
    private Map<Integer, Integer> coinInventory;

    public VendingMachine(Map<String, Integer> inventory, Map<Integer, Integer> coinInventory) {
        this.inventory = inventory;
        this.coinInventory = coinInventory;
    }

    public void displayInventory() {
        System.out.println("Current Inventory:");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue() + " available");
        }
    }

    public void updateInventory(String product, int quantity) {
        inventory.put(product, quantity);
    }

    public void updateCoins(int denomination, int quantity) {
        coinInventory.put(denomination, quantity);
    }

    public void buyProduct(String product, int amount) {
        if (inventory.containsKey(product)) {
            int price = inventory.get(product);
            if (amount >= price) {
                int change = amount - price;
                if (hasSufficientChange(change)) {
                    inventory.put(product, inventory.get(product) - 1);
                    giveChange(change);
                    System.out.println("Enjoy your " + product + "!");
                } else {
                    System.out.println("Sorry, not enough change available. Transaction canceled.");
                }
            } else {
                System.out.println("Not enough money to buy " + product);
            }
        } else {
            System.out.println("Product not available");
        }
    }

    private boolean hasSufficientChange(int change) {
        for (int coin : new int[]{100, 50, 25, 10, 5, 1}) {
            int requiredCoins = change / coin;
            if (coinInventory.containsKey(coin) && coinInventory.get(coin) >= requiredCoins) {
                change %= coin;
            }
        }
        return change == 0;
    }

    private void giveChange(int change) {
        System.out.println("Change given: " + change + "p");
        for (int coin : new int[]{100, 50, 25, 10, 5, 1}) {
            int numCoins = change / coin;
            if (coinInventory.containsKey(coin) && coinInventory.get(coin) >= numCoins) {
                System.out.println(numCoins + " x " + coin + "p");
                coinInventory.put(coin, coinInventory.get(coin) - numCoins);
                change %= coin;
            }
        }
    }

    public static void main(String[] args) {
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

        // Sample usage
        vendingMachine.displayInventory();
        vendingMachine.buyProduct("Coke", 25);
        vendingMachine.displayInventory();
    }
}
