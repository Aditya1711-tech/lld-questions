package states;

import contexts.ATMStateContext;

public interface ATMState {
    String getStateName();
    ATMState next(ATMStateContext context);
}
