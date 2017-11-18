package net.volgatech.Discount;

import net.volgatech.Customer.Customer;
import net.volgatech.Customer.PaymentMethod.MethodType;

public class CardPaymentDiscount extends DiscountType {
    public double getDiscountCoefficient(Customer customer, double value) {
        if (customer.getPaymentMethod() == MethodType.CARD)
            return (1 - value);
        return 1;
    }
    @Override
    public String toString() {
        return "for card payment";
    }
}
