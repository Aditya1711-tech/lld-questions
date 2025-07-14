package states.concreteStates;

import contexts.VendingMachineContext;
import states.VendingMachineState;

public class IdleState implements VendingMachineState {

    public IdleState() {
        System.out.println("Vending machine is now in Idle State");
    }

    @Override
    public String getStateName() {
        return "IdleState";
    }

    @Override
    public VendingMachineState next(VendingMachineContext context) {
        if(context.getInventory().isOutOfStock()) {
            return new OutOfItemsState();
        }

        if(!context.getCoins().isEmpty()) {
            return new HasMoneyState();
        }

        return this;
    }
}
