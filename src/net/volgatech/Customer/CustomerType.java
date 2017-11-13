package net.volgatech.Customer;

public enum CustomerType {
    CHILD,
    ADULT,
    RETIRED;
    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}