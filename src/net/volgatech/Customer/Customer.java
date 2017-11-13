package net.volgatech.Customer;

import net.volgatech.Product;

public class Customer {
    private Basket basket = new Basket();
    private PaymentMethod paymentMethod;
    public enum Type {
        CHILD,
        ADULT,
        RETIRED;
        @Override
        public String toString() {
            return super.toString().toLowerCase();
        }
    }
    private Type type;
    public Customer(String type, String method) {
        setType(type);
        setPaymentMethod(method);
    }

    public Customer(Type type, String method) {
        setType(type);
        setPaymentMethod(method);
    }
    public Basket getBasket() {
        return this.basket;
    }

    public Type getType() {
        return this.type;
    }

    public PaymentMethod.Method getPaymentMethod() {
        return this.paymentMethod.getMethod();
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setType(String type) {
        switch (type.toLowerCase()) {
            case "child":
                this.type = Type.CHILD;
                break;
            case "adult":
                this.type = Type.ADULT;
                break;
            case "retired":
                this.type = Type.RETIRED;
                break;
            default:
                throw new IllegalArgumentException("Invalid type of customer value");
        }
    }

    public void setPaymentMethod(String method) {
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
