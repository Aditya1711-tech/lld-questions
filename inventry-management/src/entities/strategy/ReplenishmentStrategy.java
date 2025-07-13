package entities.strategy;

import entities.Product;

public interface ReplenishmentStrategy {
    void replenish(Product product);
}
