package entities;

import entities.strategy.ReplenishmentStrategy;
import factories.ProductFactory;
import observers.InventoryObserver;

import java.util.ArrayList;
import java.util.List;

public class InventoryManager {
    private static InventoryManager inventoryManagerInstance;
    private List<Warehouse> warehouses;
    private List<InventoryObserver> inventoryObservers;
    private ProductFactory productFactory;
    private ReplenishmentStrategy replenishmentStrategy;

    private InventoryManager(){
        warehouses = new ArrayList<>();
        inventoryObservers = new ArrayList<>();
    }

    public static synchronized InventoryManager getInventoryManagerInstance() {
        if(inventoryManagerInstance == null) {
            inventoryManagerInstance = new InventoryManager();
        }
        return inventoryManagerInstance;
    }

    public static void setInventoryManagerInstance(InventoryManager inventoryManagerInstance) {
        InventoryManager.inventoryManagerInstance = inventoryManagerInstance;
    }

    public List<Warehouse> getWarehouses() {
        return warehouses;
    }

    public void setWarehouses(List<Warehouse> warehouses) {
        this.warehouses = warehouses;
    }

    public List<InventoryObserver> getInventoryObservers() {
        return inventoryObservers;
    }

    public void setInventoryObservers(List<InventoryObserver> inventoryObservers) {
        this.inventoryObservers = inventoryObservers;
    }

    public ProductFactory getProductFactory() {
        return productFactory;
    }

    public void setProductFactory(ProductFactory productFactory) {
        this.productFactory = productFactory;
    }


    public void addWarehouse(Warehouse warehouse) {
        warehouses.add(warehouse);
    }

    public void removeWarehouse(Warehouse warehouse) {
        warehouses.remove(warehouse);
    }

    public ReplenishmentStrategy getReplenishmentStrategy() {
        return replenishmentStrategy;
    }

    public void setReplenishmentStrategy(ReplenishmentStrategy replenishmentStrategy) {
        this.replenishmentStrategy = replenishmentStrategy;
    }

    public void notifyObservers(Product product){
        for (InventoryObserver inventoryObserver : inventoryObservers) {
            inventoryObserver.observe(product);
        }
    }

    // Product inventory operations
    public Product getProductBySku(String sku) {
        for (Warehouse warehouse : warehouses) {
            Product product = warehouse.getProductBySku(sku);
            if (product != null) {
                return product;
            }
        }
        return null;
    }

    // Check stock levels and apply replenishment strategy if needed
    public void checkAndReplenish(String sku) {
        Product product = getProductBySku(sku);
        if (product != null) {
            // If product is below threshold, notify observers
            if (product.getQuantity() < product.getThreshold()) {
                notifyObservers(product);
                // Apply current replenishment strategy
                if (replenishmentStrategy != null) {
                    replenishmentStrategy.replenish(product);
                }
            }
        }
    }

    // Global inventory check
    public void performInventoryCheck() {
        for (Warehouse warehouse : warehouses) {
            for (Product product : warehouse.getAllProducts()) {
                if (product.getQuantity() < product.getThreshold()) {
                    notifyObservers(product);
                    if (replenishmentStrategy != null) {
                        replenishmentStrategy.replenish(product);
                    }
                }
            }
        }
    }
}
