package factories;

import states.ATMState;
import states.concreteStates.HasCardState;
import states.concreteStates.IdleState;
import states.concreteStates.SelectOperationState;
import states.concreteStates.TransactionState;

public class ATMStateFactory {
    private static ATMStateFactory instance = null;

    private ATMStateFactory() {}

    public static ATMStateFactory getInstance() {
        if (instance == null) {
            instance = new ATMStateFactory();
        }
        return instance;
    }

    public ATMState createIdleState() {
        return new IdleState();
    }

    public ATMState createHasCardState() {
        return new HasCardState();
    }

    public ATMState createSelectOperationState() {
        return new SelectOperationState();
    }

    public ATMState createTransactionState() {
        return new TransactionState();
    }
}
