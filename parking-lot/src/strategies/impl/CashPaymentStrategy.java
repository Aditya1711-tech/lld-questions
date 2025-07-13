package strategies.impl;

import strategies.PaymentStrategy;

public class CashPaymentStrategy implements PaymentStrategy {
    @Override
    public boolean processPayment(double amount) {
        System.out.println("Payment in cash has been successful for amount: " + amount);
        return true;
    }
}
