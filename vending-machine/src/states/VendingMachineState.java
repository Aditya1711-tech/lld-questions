package states;

import contexts.VendingMachineContext;

public interface VendingMachineState {
    String getStateName();
    VendingMachineState next(VendingMachineContext context);
}
