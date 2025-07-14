package contexts;

import entities.ATMInventory;
import entities.Account;
import entities.Card;
import enums.CashType;
import enums.TransectionType;
import factories.ATMStateFactory;
import states.ATMState;
import states.concreteStates.HasCardState;
import states.concreteStates.IdleState;
import states.concreteStates.SelectOperationState;
import states.concreteStates.TransactionState;

import java.util.HashMap;
import java.util.Map;

public class ATMStateContext {
    private ATMState currentState;
    private Card currentCard;
    private Account currentAccount;
    private ATMInventory atmInventory;
    private Map<String, Account> accounts;
    private ATMStateFactory atmStateFactory;
    private TransectionType selectedTransectionType;

    public ATMStateContext() {
        this.atmStateFactory = ATMStateFactory.getInstance();
        this.currentState = atmStateFactory.createIdleState();
        this.atmInventory = new ATMInventory();
        this.accounts = new HashMap<>();
        System.out.println("ATM initialized in: " + currentState.getStateName());
    }

    public void advanceState() {
        currentState = currentState.next(this);
        System.out.println("Current state: " + currentState.getStateName());
    }

    public void insertCard(Card card) {
        if (currentState instanceof IdleState) {
            System.out.println("Card inserted");
            this.currentCard = card;
            advanceState();
        } else {
            System.out.println(
                    "Cannot insert card in " + currentState.getStateName());
        }
    }

    public void enterPin(int pin) {
        if (currentState instanceof HasCardState) {
            if (currentCard.validatePin(pin)) {
                System.out.println("PIN authenticated successfully");
                currentAccount = accounts.get(currentCard.getAccountNumber());
                advanceState();
            } else {
                System.out.println("Invalid PIN. Please try again");
                // Could implement PIN retry logic here
            }
        } else {
            System.out.println("Cannot enter PIN in " + currentState.getStateName());
        }
    }

    public void selectOperation(TransectionType transactionType) {
        if (currentState instanceof SelectOperationState) {
            System.out.println("Selected operation: " + transactionType);
            this.selectedTransectionType = transactionType;
            advanceState();
        } else {
            System.out.println(
                    "Cannot select operation in " + currentState.getStateName());
        }
    }

    public void performTransaction(double amount) {
        if (currentState instanceof TransactionState) {
            try {
                if (selectedTransectionType == TransectionType.WITHDRAW_MONEY) {
                    performWithdrawal(amount);
                } else if (selectedTransectionType == TransectionType.CHECK_BALANCE) {
                    checkBalance();
                }
                // Ask if user wants another transaction
                advanceState();
            } catch (Exception e) {
                System.out.println("Transaction failed: " + e.getMessage());
                // Go back to select operation state
                currentState = atmStateFactory.createSelectOperationState();
            }
        } else {
            System.out.println(
                    "Cannot perform transaction in " + currentState.getStateName());
        }
    }

    public void performWithdrawal(double amount) throws Exception {
        if (!currentAccount.withdraw(amount)) {
            throw new Exception("Insufficient funds in account");
        }

        if (!atmInventory.hashSufficientBalance((int) amount)) {
            // Rollback the account withdrawal
            currentAccount.deposit(amount);
            throw new Exception("Insufficient cash in ATM");
        }

        Map<CashType, Integer> dispensedCash =
                atmInventory.withDrowCash((int) amount);
        if (dispensedCash == null) {
            // Rollback the account withdrawal
            currentAccount.deposit(amount);
            throw new Exception("Unable to dispense exact amount");
        }

        System.out.println("Transaction successful. Please collect your cash:");
        for (Map.Entry<CashType, Integer> entry : dispensedCash.entrySet()) {
            System.out.println(entry.getValue() + " x $" + entry.getKey().value);
        }
    }

    public void returnCard() {
        if (currentState instanceof HasCardState
                || currentState instanceof SelectOperationState
                || currentState instanceof TransactionState) {
            System.out.println("Card returned to customer");
            resetATM();
        } else {
            System.out.println("No card to return in " + currentState.getStateName());
        }
    }

    // Cancel current transaction
    public void cancelTransaction() {
        if (currentState instanceof TransactionState
                || currentState instanceof TransactionState) {
            System.out.println("Transaction cancelled");
            returnCard();
        } else {
            System.out.println(
                    "No transaction to cancel in " + currentState.getStateName());
        }
    }

    public void addAccount(Account account) {
        accounts.put(account.getAccountNumber(), account);
    }

    // Reset ATM state
    private void resetATM() {
        this.currentCard = null;
        this.currentAccount = null;
        this.selectedTransectionType = null;
        this.currentState = atmStateFactory.createIdleState();
    }

    public void checkBalance() {
        double balance = currentAccount.getBalance();
        System.out.println("Your current balance is: " + balance);
    }

    public ATMState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(ATMState currentState) {
        this.currentState = currentState;
    }

    public Card getCurrentCard() {
        return currentCard;
    }

    public void setCurrentCard(Card currentCard) {
        this.currentCard = currentCard;
    }

    public ATMStateFactory getAtmStateFactory() {
        return atmStateFactory;
    }

    public void setAtmStateFactory(ATMStateFactory atmStateFactory) {
        this.atmStateFactory = atmStateFactory;
    }

    public Account getCurrentAccount() {
        return currentAccount;
    }

    public void setCurrentAccount(Account currentAccount) {
        this.currentAccount = currentAccount;
    }

    public ATMInventory getAtmInventory() {
        return atmInventory;
    }

    public void setAtmInventory(ATMInventory atmInventory) {
        this.atmInventory = atmInventory;
    }

    public Map<String, Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Map<String, Account> accounts) {
        this.accounts = accounts;
    }

    public TransectionType getSelectedTransectionType() {
        return selectedTransectionType;
    }

    public void setSelectedTransectionType(TransectionType selectedTransectionType) {
        this.selectedTransectionType = selectedTransectionType;
    }
}
