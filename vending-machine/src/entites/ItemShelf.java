package entites;

import java.util.ArrayList;
import java.util.List;

public class ItemShelf {
    private int code;
    private List<Item> items;
    private boolean isSoldOut;

    public ItemShelf(int code) {
        this.code = code;
        this.items = new ArrayList<>();
        this.isSoldOut = false;
    }

    public void addItem(Item item) {
        items.add(item);
        if(isSoldOut) setIsSoldOut(false); // Update sold-out status after adding an item
    }

    public void removeItem(Item item) {
        items.remove(item);
        if(items.isEmpty()) setIsSoldOut(true); // Update sold-out status after removing an item
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public boolean isSoldOut() {
        return isSoldOut;
    }

    public void setSoldOut(boolean soldOut) {
        isSoldOut = soldOut;
    }

    public void setIsSoldOut(boolean isSoldOut) {
        this.isSoldOut = isSoldOut;
    }

}
