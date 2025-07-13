package strategies.impl;

import strategies.PaymentStrategy;

public class UPIPaymentStrategy implements PaymentStrategy {
    @Override
    public boolean processPayment(double amount) {
        System.out.println("Payment of " + amount + " processed via UPI successfully");
        return true;
    }
}
