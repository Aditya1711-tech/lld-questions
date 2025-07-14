package states.concreteStates;

import contexts.VendingMachineContext;
import states.VendingMachineState;

public class HasMoneyState implements VendingMachineState {

    public HasMoneyState() {
        System.out.println("Vending machine is now in Has money State");
    }

    @Override
    public String getStateName() {
        return "HasMoneyState";
    }

    @Override
    public VendingMachineState next(VendingMachineContext context) {
        if (context.getInventory().isOutOfStock()) {
            return new OutOfItemsState();
        }

        if (context.getCoins().isEmpty()) {
            return new IdleState();
        }

        if (context.getCurrentState() instanceof HasMoneyState) {
            return new SelectionState();
        }
        return this;
    }
}
