import entities.InventoryManager;
import entities.Product;
import entities.Warehouse;
import entities.strategy.impl.JustInTimeReplenishmentStrategy;
import enums.ProductType;
import factories.ProductFactory;

public class Main {
    public static void main(String[] args) {
        InventoryManager inventoryManager = InventoryManager.getInventoryManagerInstance();

        // Create and add warehouses
        Warehouse warehouse1 = new Warehouse("Warehouse 1");
        Warehouse warehouse2 = new Warehouse("Warehouse 2");
        inventoryManager.addWarehouse(warehouse1);
        inventoryManager.addWarehouse(warehouse2);

        Product tShirt = ProductFactory.createProduct(
                ProductType.CLOTHING, "SKU456", "T-Shirt", 20.0, 200, 100);
        Product apple = ProductFactory.createProduct(
                ProductType.FOOD, "SKU789", "Apple", 1.0, 100, 200);

        // Add products to warehouses
        warehouse1.addProduct(tShirt, tShirt.getQuantity());
        warehouse2.addProduct(apple, apple.getQuantity());
        warehouse1.addProduct(tShirt, 20);
        warehouse2.addProduct(apple, 50);

        // Set replenishment strategy to Just-In-Time
        inventoryManager.setReplenishmentStrategy(new JustInTimeReplenishmentStrategy());

        // Perform inventory check and replenish if needed
        inventoryManager.performInventoryCheck();

        // Replenish a specific product if needed
        inventoryManager.checkAndReplenish("SKU123");
    }
}