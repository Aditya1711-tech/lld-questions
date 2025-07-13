package entities.concreteProducts;

import entities.Product;
import enums.ProductType;

public class ClothingProduct extends Product {
    private String brand;

    public ClothingProduct(String sku, String name, double price, int quantity, int threshold) {
        super();
        setSku(sku);
        setName(name);
        setPrice(price);
        setQuantity(quantity);
        setThreshold(threshold);
        setProductType(ProductType.CLOTHING);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public void addStock(int quantity) {
        this.setQuantity(this.getQuantity() + quantity);
    }

    @Override
    public void removeStock(int quantity) {
        this.setQuantity(this.getQuantity() - quantity);
    }
}
