package states.concreteStates;

import contexts.ATMStateContext;
import states.ATMState;

public class TransactionState implements ATMState {
    @Override
    public String getStateName() {
        return "TransactionState";
    }

    @Override
    public ATMState next(ATMStateContext context) {
        if (context.getCurrentCard() == null) {
            return context.getAtmStateFactory().createIdleState();
        }

        // After transaction completion, go back to select operation
        return context.getAtmStateFactory().createSelectOperationState();
    }
}
