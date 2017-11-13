package net.volgatech.Customer.PaymentMethod;

public enum MethodType {
    CARD,
    CASH;

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}
