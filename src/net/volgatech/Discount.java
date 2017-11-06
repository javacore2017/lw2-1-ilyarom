package net.volgatech;

public class Discount {
    private Double _value;
    public enum DiscountType {
        FOR_CARD_PAYMENT, FOR_CASH_PAYMENT, FOR_RETIRED, ALL;
        String ToString() {
            switch (this) {
                case FOR_CARD_PAYMENT:
                    return "for card payment";
                case FOR_CASH_PAYMENT:
                    return "for cash payment";
                case FOR_RETIRED:
                    return "for retired";
                case ALL:
                    return "";
                default:
                    throw new IllegalArgumentException("Invalid type of discount type value");
            }
        }
    }
    private DiscountType _discountType;
    private String _productType;
    public void setValue(Double value) {
        if (value < 1 && value > 0) {
            _value = value;
            return;
        }
        throw new IllegalArgumentException("Invalid discount value");
    }
    public Double getValue() {
        return _value;
    }
    public String getProductType() {
        return _productType;
    }
    public void setProductType(String productType) {
        _productType = productType;
    }

    public DiscountType getDiscountType() {
        return _discountType;
    }
    public void setDiscountType(DiscountType discountType) {
        _discountType = discountType;
    }

    public Discount(Double value, String productType, DiscountType discountType) {
        setValue(value);
        setProductType(productType);
        setDiscountType(discountType);
    }
}
