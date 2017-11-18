package net.volgatech.Discount;

import net.volgatech.Customer.Customer;

public abstract class DiscountType {
    public abstract double getDiscountCoefficient(Customer customer, double value);
}