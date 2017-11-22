package net.volgatech.Customer.PaymentMethod;

public class PaymentMethod {
    private MethodType method;
    public PaymentMethod(String method) {
        setMethod(method);
    }
    public MethodType getMethod() {
        return this.method;
    }
    private void setMethod(String method) {
        switch (method.toLowerCase()) {
            case "card":
                this.method = MethodType.CARD;
                break;
            case "cash":
                this.method = MethodType.CASH;
                break;
            default:
                throw new IllegalArgumentException("Invalid type of payment method value");
        }
    }
}
