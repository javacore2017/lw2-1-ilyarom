package net.volgatech;

import net.volgatech.Customer.Customer;
import net.volgatech.Customer.CustomerType;
import net.volgatech.Discount.Discount;
import net.volgatech.Discount.DiscountType;
import net.volgatech.Report.Bill;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CashDesk {
    private BigDecimal cashMachineAmount = new BigDecimal(0);
    private final List<Discount> discounts = new ArrayList<>();
    private Double getDiscountCoefficient(Customer customer, Product product) {
        double coefficient = 1;
        for (Discount element : this.discounts) {
            if (element.getProductType().equals(product.getType())) {
                coefficient *= element.getDiscountType().getDiscountCoefficient(customer, element.getValue());
            }
        }
        return coefficient;
    }

    public Bill getCustomerBill(Customer customer) {
        this.cashMachineAmount = new BigDecimal(0);
        if (!customer.getBasket().getProducts().isEmpty()) {
            for (Product product : customer.getBasket().getProducts()) {
                if (product.isAlcoholic() && customer.getType() == CustomerType.CHILD) {
                    System.out.println("[" + LocalDateTime.now() + "] Try to buy alcoholic product by child!");
                    break;
                }
                Double discountCoefficient = getDiscountCoefficient(customer, product);
                Double price = product.getPrice().doubleValue() * discountCoefficient;
                // System.out.println("[" + LocalDateTime.now() + "] price:" + price);
                int productIndex = customer.getBasket().getProducts().indexOf(product);
                product.setPrice(price.intValue());
                customer.getBasket().getProducts().set(productIndex, product);
                this.cashMachineAmount = this.cashMachineAmount.add((product.getPrice()).multiply(new BigDecimal(product.getCount())));
            }
        }
        else {
            this.cashMachineAmount = new BigDecimal(0);
        }
        return new Bill(this.cashMachineAmount, customer.getBasket().getProducts());
    }

    public Integer getAmount() {
        return this.cashMachineAmount.intValue() ;
    }
    public void addDiscount(Double value, String productType, DiscountType discountType) {
        Discount discount = new Discount(value, productType, discountType);
        this.discounts.add(discount);
    }
}
