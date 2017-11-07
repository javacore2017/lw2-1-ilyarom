package net.volgatech;

import net.volgatech.Customer.Customer;
import net.volgatech.Customer.PaymentMethod;
import net.volgatech.Report.Report;
import net.volgatech.Report.Bill;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CashDesk {
    Double _cashMachineAmount;
    private List<Discount> _discounts = new ArrayList<Discount>();
    private List<Product> _products = new ArrayList<Product>();
    public void addDiscount(Double value, String productType, Discount.DiscountType discountType) {
        Discount discount = new Discount(value, productType, discountType);
        _discounts.add(discount);
    }

    private Double getDiscountCoefficient(Customer customer, Product product) {
        double coefficient = 1;
        for (Discount element : _discounts) {
            if (element.getProductType().equals(product.getType())) {
                switch (element.getDiscountType()) {
                    case FOR_CARD_PAYMENT:
                        if (customer.getPaymentMethod() == PaymentMethod.Method.CARD)
                            coefficient *= (1 - element.getValue());
                        break;
                    case FOR_CASH_PAYMENT:
                        if (customer.getPaymentMethod() == PaymentMethod.Method.CASH)
                            coefficient *= (1 - element.getValue());
                        break;
                    case FOR_RETIRED:
                        if (customer.getType() == Customer.Type.RETIRED)
                            coefficient *= (1 - element.getValue());
                        break;
                    case ALL:
                        coefficient *= (1 - element.getValue());
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid type of discount");
                }
            }
        }
        return coefficient;
    }

    public Bill getCustomerBill(Customer customer) {
        _cashMachineAmount = 0.0;
        if (!customer.getBasket().getProducts().isEmpty()) {
            for (Product product : customer.getBasket().getProducts()) {
                if (product.isAlcoholic() && customer.getType() == Customer.Type.CHILD) {
                    System.out.println("[" + LocalDateTime.now() + "] Try to buy alcholic product by child!");
                    break;
                }
                Double discountCoefficient = getDiscountCoefficient(customer, product);
                Double price = product.getPrice().doubleValue() * discountCoefficient;
               // System.out.println("[" + LocalDateTime.now() + "] price:" + price);
                int productIndex = customer.getBasket().getProducts().indexOf(product);
                product.setPrice(price.intValue());
                customer.getBasket().getProducts().set(productIndex, product);
                _cashMachineAmount += product.getCount() * (product.getPrice());
            }
        }
        else {
            _cashMachineAmount = 0.0;
        }
        return new Bill(_cashMachineAmount.intValue(), customer.getPaymentMethod(), customer.getBasket().getProducts());
    }

    public Integer getAmount() {
        return _cashMachineAmount.intValue() ;
    }
}
