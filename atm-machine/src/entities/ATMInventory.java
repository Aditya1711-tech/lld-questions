package entities;

import enums.CashType;

import java.util.HashMap;
import java.util.Map;

public class ATMInventory {
    private Map<CashType, Integer> cashInventory;

    public ATMInventory() {
        this.cashInventory = new HashMap<>();
        initializeInventory();
    }

    public void initializeInventory() {
        cashInventory.put(CashType.BILL_100, 10);
        cashInventory.put(CashType.BILL_50, 10);
        cashInventory.put(CashType.BILL_20, 20);
        cashInventory.put(CashType.BILL_10, 30);
        cashInventory.put(CashType.BILL_5, 20);
        cashInventory.put(CashType.BILL_1, 50);
    }

    public int getTotalCash() {
        int totalCash = 0;
        for(Map.Entry<CashType, Integer> cashTypeIntegerEntry : cashInventory.entrySet()) {
            totalCash += cashTypeIntegerEntry.getValue();
        }
        return totalCash;
    }

    public boolean hashSufficientBalance(int amount) {
        return amount <= this.getTotalCash();
    }

    public Map<CashType, Integer> withDrowCash(int amount) {
        if(!hashSufficientBalance(amount)) {
            System.out.println("Insufficient balance " + getTotalCash());
            return null;
        }

        Map<CashType, Integer> dispensedCash = new HashMap<>();
        int remainingAmount = amount;

        for (CashType cashType : CashType.values()) {
            int count = Math.min(
                    remainingAmount / cashType.value, cashInventory.get(cashType));
            if (count > 0) {
                dispensedCash.put(cashType, count);
                remainingAmount -= count * cashType.value;
                cashInventory.put(cashType, cashInventory.get(cashType) - count);
            }
        }

        if (remainingAmount > 0) {
            // Rollback the transaction
            for (Map.Entry<CashType, Integer> entry : dispensedCash.entrySet()) {
                cashInventory.put(entry.getKey(),
                        cashInventory.get(entry.getKey()) + entry.getValue());
            }
            return null;
        }
        return dispensedCash;
    }

    public void addCash(CashType cashType, int count) {
        cashInventory.put(cashType, cashInventory.get(cashType) + count);
    }

    public Map<CashType, Integer> getCashInventory() {
        return cashInventory;
    }

    public void setCashInventory(Map<CashType, Integer> cashInventory) {
        this.cashInventory = cashInventory;
    }
}
