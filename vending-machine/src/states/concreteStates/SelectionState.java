package states.concreteStates;

import contexts.VendingMachineContext;
import states.VendingMachineState;

public class SelectionState implements VendingMachineState {

    public SelectionState() {
        System.out.println("Vending machine is now in Selection State");
    }

    @Override
    public String getStateName() {
        return "SelectionState";
    }

    @Override
    public VendingMachineState next(VendingMachineContext context) {
        if (context.getInventory().isOutOfStock()) {
            return new OutOfItemsState();
        }

        if (context.getCoins().isEmpty()) {
            return new IdleState();
        }

        if(context.getSelectedItemCode() > 0) {
            return new DispenseState();
        }

        return null;
    }
}
