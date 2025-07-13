package factories;

import entities.Product;
import entities.concreteProducts.ClothingProduct;
import entities.concreteProducts.FoodProduct;
import enums.ProductType;

public class ProductFactory {
    public static Product createProduct(ProductType productType, String sku, String name, double price, int quantity, int threshold){
        if(ProductType.CLOTHING.equals(productType)){
            return new ClothingProduct(sku, name, price, quantity, threshold);
        }else if(ProductType.FOOD.equals(productType)){
            return new FoodProduct(sku, name, price, quantity, threshold);
        }
        return null;
    }
}
