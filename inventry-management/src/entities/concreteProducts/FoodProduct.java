package entities.concreteProducts;

import entities.Product;
import enums.ProductType;

import java.util.Date;

public class FoodProduct extends Product {
    private Date manufacturedDate;
    private Date expiryDate;

    public FoodProduct(String sku, String name, double price, int quantity, int threshold) {
        super();
        setSku(sku);
        setName(name);
        setPrice(price);
        setQuantity(quantity);
        setThreshold(threshold);
        setProductType(ProductType.FOOD);
    }

    public Date getManufacturedDate() {
        return manufacturedDate;
    }

    public void setManufacturedDate(Date manufacturedDate) {
        this.manufacturedDate = manufacturedDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
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
