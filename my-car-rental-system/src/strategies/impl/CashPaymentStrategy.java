package strategies.impl;

import strategies.PaymentStrategy;

public class CashPaymentStrategy implements PaymentStrategy {
    @Override
    public boolean processPayment(double amount) {
        System.out.println("Payment of " + amount + " processed via cash successfully");
        return true;
    }
}
