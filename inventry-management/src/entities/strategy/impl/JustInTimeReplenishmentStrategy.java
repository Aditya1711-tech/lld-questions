package entities.strategy.impl;

import entities.Product;
import entities.strategy.ReplenishmentStrategy;

public class JustInTimeReplenishmentStrategy implements ReplenishmentStrategy {
    @Override
    public void replenish(Product product) {
        System.out.println("Applying Just-In-Time replenishment for " + product.getName());
    }
}
