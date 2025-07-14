package states.concreteStates;

import contexts.VendingMachineContext;
import states.VendingMachineState;

public class OutOfItemsState implements VendingMachineState {

    public OutOfItemsState() {
        System.out.println("Vending machine is now in Out Of Items State");
    }

    @Override
    public String getStateName() {
        return "OutOfItemsState";
    }

    @Override
    public VendingMachineState next(VendingMachineContext context) {
        if(!context.getInventory().isOutOfStock()){
            return new IdleState();
        }

        return this;
    }
}
