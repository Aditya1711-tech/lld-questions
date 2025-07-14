package states.concreteStates;

import contexts.VendingMachineContext;
import states.VendingMachineState;

public class DispenseState implements VendingMachineState {

    public DispenseState() {
        System.out.println("Vending machine is now in Dispense State");
    }

    @Override
    public String getStateName() {
        return "DispenseState";
    }

    @Override
    public VendingMachineState next(VendingMachineContext context) {
        return new IdleState();
    }
}
