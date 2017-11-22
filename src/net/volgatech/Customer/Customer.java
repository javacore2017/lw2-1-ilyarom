package net.volgatech.Customer;

import net.volgatech.Customer.PaymentMethod.MethodType;
import net.volgatech.Customer.PaymentMethod.PaymentMethod;
import net.volgatech.Product;

public class Customer {
    private final Basket basket = new Basket();
    private PaymentMethod paymentMethod;
    private CustomerType type;
    public Customer(String type, String method) {
        setType(type);
        setPaymentMethod(method);
    }

    public Basket getBasket() {
        return this.basket;
    }

    public CustomerType getType() {
        return this.type;
    }

    public MethodType getPaymentMethod() {
        return this.paymentMethod.getMethod();
    }

    private void setType(String type) {
        switch (type.toLowerCase()) {
            case "child":
                this.type = CustomerType.CHILD;
                break;
            case "adult":
                this.type = CustomerType.ADULT;
                break;
            case "retired":
                this.type = CustomerType.RETIRED;
                break;
            default:
                throw new IllegalArgumentException("Invalid type of customer value");
        }
    }

    private void setPaymentMethod(String method) {
        this.paymentMethod = new PaymentMethod(method);
    }

    public void PushToBasket(Product product) {
        for (Product element : this.basket.getProducts()) {
            if (element.getType().equals(product.getType())) {
                element.setCount(element.getCount() + product.getCount());
                return;
            }
        }
        try {
            this.basket.Add(product.clone());
        }
        catch(CloneNotSupportedException ex){

            System.out.println("Product clone is not supported");
        }
    }
}
