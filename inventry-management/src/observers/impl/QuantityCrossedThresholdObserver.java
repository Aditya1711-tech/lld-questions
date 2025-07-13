package observers.impl;

import entities.Product;
import observers.InventoryObserver;

public class QuantityCrossedThresholdObserver implements InventoryObserver {
    @Override
    public void observe(Product product) {
        System.out.println("Only " + product.getQuantity() + " left for " + product.getName());
    }
}
