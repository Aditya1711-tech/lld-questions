package contexts;

import entites.Inventory;
import entites.Item;
import enums.Coin;
import states.VendingMachineState;
import states.concreteStates.DispenseState;
import states.concreteStates.HasMoneyState;
import states.concreteStates.IdleState;
import states.concreteStates.SelectionState;

import java.util.ArrayList;
import java.util.List;

public class VendingMachineContext {
    private VendingMachineState currentState;
    private Inventory inventory;
    private List<Coin> coins;
    private int selectedItemCode;

    public VendingMachineContext() {
        inventory = new Inventory(10); // Initialize inventory with 10 slots
        coins = new ArrayList<>(); // Initialize the coin list
        currentState = new IdleState(); // Set initial state to idle
        System.out.println("Initialized: " + currentState.getStateName());
    }

    public void advanceState() {
        currentState = currentState.next(this);
        System.out.println("Current state: " + currentState.getStateName());
    }

    public void updateInventory(Item item, int codeNumber) {
        if (currentState instanceof IdleState) {
            try {
                inventory.addItem(item, codeNumber);
                System.out.println("Added " + item.getType() + " to slot " + codeNumber);
            } catch (Exception e) {
                System.out.println("Error updating inventory: " + e.getMessage());
            }
        } else {
            System.out.println("Inventory can only be updated in Idle state");
        }
    }

    public void clickOnInsertCoinButton (List<Coin> insertedCoins) {
        if (currentState instanceof IdleState) {
            for (Coin coin : insertedCoins) {
                System.out.println("Inserted " + coin.name() + " worth " + coin.value);
                coins.add(coin);
            }
            advanceState();
        } else {
            System.out.println("Cannot insert coin in " + currentState.getStateName());
        }
    }

    public void clickOnSelectItemButton(int itemNumber) throws Exception {
        if (currentState instanceof HasMoneyState) {
            advanceState(); // Move to selection state
            selectProduct(itemNumber); // Select the product
        } else {
            System.out.println("Product selection button can only be clicked in HasMoney state");
        }
    }

    public void selectProduct(int itemNumber) throws Exception {
        if(currentState instanceof SelectionState){
            int balance = getBalance();
            Item itemToSelect = inventory.getItem(itemNumber);

            if (balance < itemToSelect.getPrice()) {
                System.out.println(
                        "Insufficient amount. Product price: " + itemToSelect.getPrice() + ", paid: " + balance);
                return;
            }
            setSelectedItemCode(itemNumber);
            advanceState();
            int change = balance - itemToSelect.getPrice();
            if(change > 0) System.out.println("Your change is " + change);
            dispatchItem(itemNumber);
        }else{
            System.out.println("Products can only be selected in Selection state");
        }
    }

    public void dispatchItem(int itemNumber) throws Exception {
        if(currentState instanceof DispenseState){
            inventory.removeItem(itemNumber);
            inventory.updateSoldOutItem(itemNumber);
            resetBalance();
            resetSelection();
            advanceState();
        }else{
            System.out.println("Products can only be dispatched in Dispense State");
        }
    }

    public int getBalance() {
        if(coins == null || coins.isEmpty()) return 0;
        int balance = 0;
        for (Coin coin : coins) {
            balance += coin.value;
        }
        return balance;
    }

    public void resetBalance() {
        setCoins(new ArrayList<>());
    }

    public void resetSelection() {
        setSelectedItemCode(0);
    }

    public VendingMachineState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(VendingMachineState currentState) {
        this.currentState = currentState;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public List<Coin> getCoins() {
        return coins;
    }

    public void setCoins(List<Coin> coins) {
        this.coins = coins;
    }

    public int getSelectedItemCode() {
        return selectedItemCode;
    }

    public void setSelectedItemCode(int selectedItemCode) {
        this.selectedItemCode = selectedItemCode;
    }
}
