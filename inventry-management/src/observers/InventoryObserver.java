package observers;

import entities.Product;

public interface InventoryObserver {
    void observe(Product product);
}
