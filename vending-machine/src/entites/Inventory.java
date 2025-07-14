package entites;

public class Inventory {
    ItemShelf[] itemShelves = null;

    public Inventory(int itemCounts) {
        itemShelves = new ItemShelf[itemCounts];
        initializeEmptyInventory();
    }

    public void initializeEmptyInventory() {
        int startCode = 101;
        for (int i = 0; i < itemShelves.length; i++) {
            itemShelves[i] = new ItemShelf(startCode);
            startCode++;
        }
    }

    public void addItem (Item item, int code) throws Exception {
        for (ItemShelf itemShelf : itemShelves) {
            if(itemShelf.getCode() == code) {
                itemShelf.addItem(item);
                return;
            }
        }
        throw new Exception("Invalid Code");
    }

    public Item getItem (int code) throws Exception {
        for (ItemShelf itemShelf : itemShelves) {
            if(itemShelf.getCode() == code) {
                if(itemShelf.isSoldOut()) throw new Exception("Item self is empty");
                else{
                    return itemShelf.getItems().getFirst(); // Get the first item
                }
            }
        }
        throw new Exception("Invalid Code");
    }

    public void updateSoldOutItem(int codeNumber) {
        for (ItemShelf itemShelf : itemShelves) {
            if (itemShelf.getCode() == codeNumber) {
                if (itemShelf.getItems().isEmpty())
                    itemShelf.setIsSoldOut(true); // Mark the shelf as sold out
            }
        }
    }

    public boolean isOutOfStock() {
        for (ItemShelf itemShelf : itemShelves) {
            if(!itemShelf.isSoldOut()) return false;
        }
        return true;
    }

    public void removeItem(int codeNumber) throws Exception {
        for (ItemShelf itemShelf : itemShelves) {
            if (itemShelf.getCode() == codeNumber) {
                itemShelf.removeItem(
                        itemShelf.getItems().getFirst()); // Remove the specific item from the shelf
                return;
            }
        }
        throw new Exception("Invalid Code");
    }

    public ItemShelf[] getItemShelves() {
        return itemShelves;
    }

    public void setItemShelves(ItemShelf[] itemShelves) {
        this.itemShelves = itemShelves;
    }
}
