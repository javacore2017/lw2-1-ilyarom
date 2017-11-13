package net.volgatech.Discount;

public enum DiscountType {
    FOR_CARD_PAYMENT, FOR_CASH_PAYMENT, FOR_RETIRED, ALL;
    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}