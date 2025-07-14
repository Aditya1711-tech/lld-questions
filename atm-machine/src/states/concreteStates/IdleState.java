package states.concreteStates;

import contexts.ATMStateContext;
import states.ATMState;

public class IdleState implements ATMState {
    @Override
    public String getStateName() {
        return "IdleState";
    }

    @Override
    public ATMState next(ATMStateContext context) {
        if(context.getCurrentCard() != null) {
            return context.getAtmStateFactory().createHasCardState();
        }
        return this;
    }
}
