package states.concreteStates;

import contexts.ATMStateContext;
import states.ATMState;

public class SelectOperationState implements ATMState {
    @Override
    public String getStateName() {
        return "SelectOperationState";
    }

    @Override
    public ATMState next(ATMStateContext context) {
        if (context.getCurrentCard() == null) {
            return context.getAtmStateFactory().createIdleState();
        }

        if (context.getSelectedTransectionType() != null) {
            return context.getAtmStateFactory().createTransactionState();
        }
        return this;
    }
}
