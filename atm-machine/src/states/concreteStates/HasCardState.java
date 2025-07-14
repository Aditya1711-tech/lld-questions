package states.concreteStates;

import contexts.ATMStateContext;
import states.ATMState;

public class HasCardState implements ATMState {
    @Override
    public String getStateName() {
        return "HasCardState";
    }

    @Override
    public ATMState next(ATMStateContext context) {
        if (context.getCurrentCard() == null) {
            return context.getAtmStateFactory().createIdleState();
        }
        if (context.getCurrentAccount() != null) {
            return context.getAtmStateFactory().createSelectOperationState();
        }
        return this;
    }
}
