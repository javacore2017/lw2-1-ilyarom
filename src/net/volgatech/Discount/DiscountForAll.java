package net.volgatech.Discount;

import net.volgatech.Customer.Customer;
import net.volgatech.Customer.PaymentMethod.PaymentMethod;

public class DiscountForAll extends DiscountType {
    public double getDiscountCoefficient(Customer customer, double value) {
        return (1 - value);
    }
    @Override
    public String toString() {
        return "";
    }
}
