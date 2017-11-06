package net.volgatech;

public class Customer {
    private Basket _basket = new Basket();
    private PaymentMethod _paymentMethod;
    public enum Type {
        CHILD, ADULT, RETIRED
    }
    private Type _type;
    public void setType(String type) {
        switch (type.toLowerCase()) {
            case "child":
                _type = Type.CHILD;
                break;
            case "adult":
                _type = Type.ADULT;
                break;
            case "retired":
                _type = Type.RETIRED;
                break;
            default:
                throw new IllegalArgumentException("Invalid type of customer value");
        }
    }

    public void setType(Type type) {
        _type = type;
    }

    public Basket getBasket() {
        return _basket;
    }

    public Type getType() {
        return _type;
    }

    public void setPaymentMethod(String method) {
        _paymentMethod = new PaymentMethod(method);
    }

    public PaymentMethod.Method getPaymentMethod() {
        return _paymentMethod.getMethod();
    }

    Customer(String type, String method) {
        setType(type);
        setPaymentMethod(method);
    }

    Customer(Type type, String method) {
        setType(type);
        setPaymentMethod(method);
    }


    public void PushToBasket(Product product) {
        for (Product element : _basket.getProducts()) {
            if (element.getType().equals(product.getType())) {
                element.setCount(element.getCount() + product.getCount());
                return;
            }
        }
        try {
            _basket.Add(product.clone());
        }
        catch(CloneNotSupportedException ex){

            System.out.println("Product clone is not supported");
        }
    }
}
