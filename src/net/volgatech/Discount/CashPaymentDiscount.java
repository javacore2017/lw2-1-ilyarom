package net.volgatech.Discount;

import net.volgatech.Customer.Customer;
import net.volgatech.Customer.PaymentMethod.MethodType;
import net.volgatech.Customer.PaymentMethod.PaymentMethod;

public class CashPaymentDiscount extends DiscountType {
    public double getDiscountCoefficient(Customer customer, double value) {
        if (customer.getPaymentMethod() == MethodType.CASH)
            return (1 - value);
        return 1;
    }
    @Override
    public String toString() {
        return "for cash payment";
    }
}
