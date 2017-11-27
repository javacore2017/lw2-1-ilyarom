package net.volgatech.Discount;

import net.volgatech.Customer.Customer;
import net.volgatech.Customer.CustomerType;

public class DiscountForRetired extends DiscountType {
    public double getDiscountCoefficient(Customer customer, double value) {
        if (customer.getType() == CustomerType.RETIRED)
            return (1 - value);
        return 1;
    }
    @Override
    public String toString() {
        return "for retired";
    }
}
