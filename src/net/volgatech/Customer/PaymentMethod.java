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
    private Method _method;
    PaymentMethod(String method) {
        setMethod(method);
    }
    public Method getMethod() {
        return _method;
    }
    public void setMethod(String method) {
        switch (method.toLowerCase()) {
            case "card":
                _method = Method.CARD;
                break;
            case "cash":
                _method = Method.CASH;
                break;
            default:
                throw new IllegalArgumentException("Invalid type of payment method value");
        }
    }
}
