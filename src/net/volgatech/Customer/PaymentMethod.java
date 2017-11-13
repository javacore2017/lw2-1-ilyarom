package net.volgatech.Customer;

public class PaymentMethod {
    public enum Method {
        CARD,
        CASH;

        @Override
        public String toString() {
            return super.toString().toLowerCase();
        }
    }
    private Method method;
    PaymentMethod(String method) {
        setMethod(method);
    }
    public Method getMethod() {
        return this.method;
    }
    public void setMethod(String method) {
        switch (method.toLowerCase()) {
            case "card":
                this.method = Method.CARD;
                break;
            case "cash":
                this.method = Method.CASH;
                break;
            default:
                throw new IllegalArgumentException("Invalid type of payment method value");
        }
    }
}
