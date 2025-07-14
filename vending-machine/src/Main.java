import contexts.VendingMachineContext;
import entites.Item;
import entites.ItemShelf;
import enums.Coin;
import enums.ItemType;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        VendingMachineContext vendingMachine = new VendingMachineContext();
        try {
            System.out.println("|");
            System.out.println("Filling up the inventory");
            System.out.println("|");
            fillUpInventory(vendingMachine); // Fill up the inventory with items
            displayInventory(vendingMachine); // Display the current inventory
            System.out.println("|");
            System.out.println("Inserting coins");
            System.out.println("|");
            // Insert coins using the context methods
            vendingMachine.clickOnInsertCoinButton(Arrays.asList(Coin.TEN_RUPEES, Coin.FIVE_RUPEES));
            System.out.println("|");
            System.out.println("Clicking on ProductSelectionButton");
            System.out.println("|");
            // Start product selection and choose a product
            vendingMachine.clickOnSelectItemButton(102);
            // Display the updated inventory
            displayInventory(vendingMachine);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            displayInventory(vendingMachine);
        }
    }

    private static void fillUpInventory(VendingMachineContext vendingMachine) {
        for (int i = 0; i < 10; i++) {
            Item newItem = new Item();
            int codeNumber = 101 + i;
            if (i < 3) {
                newItem.setType(ItemType.COKE);
                newItem.setPrice(12);
            } else if (i < 5) {
                newItem.setType(ItemType.PEPSI);
                newItem.setPrice(9);
            } else if (i < 7) {
                newItem.setType(ItemType.JUICE);
                newItem.setPrice(13);
            } else {
                newItem.setType(ItemType.SODA);
                newItem.setPrice(7);
            }
            for (int j = 0; j < 5; j++) {
                vendingMachine.updateInventory(newItem, codeNumber);
            }
        }
    }

    private static void displayInventory(VendingMachineContext vendingMachine) {
        ItemShelf[] slots = vendingMachine.getInventory().getItemShelves();
        for (ItemShelf slot : slots) {
            List<Item> items = slot.getItems(); // Get the list of items in the shelf
            if (!items.isEmpty()) {
                System.out.println("CodeNumber: " + slot.getCode() + " Items: ");
                for (Item item : items) { // Display all items in the shelf
                    System.out.println(
                            "    - Item: " + item.getType().name() + ", Price: " + item.getPrice());
                }
                System.out.println("SoldOut: " + slot.isSoldOut());
            } else {
                // Display empty shelf information
                System.out.println("CodeNumber: " + slot.getCode() + " Items: EMPTY"
                        + " SoldOut: " + slot.isSoldOut());
            }
        }
    }
}