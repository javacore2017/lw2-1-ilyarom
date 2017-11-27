package net.volgatech.Discount;

public class Discount {
    private Double value;
    private DiscountType discountType;
    private String productType;
    public Discount(Double value, String productType, DiscountType discountType) {
        setValue(value);
        setProductType(productType);
        setDiscountType(discountType);
    }
    public Double getValue() {
        return this.value;
    }
    public String getProductType() {
        return this.productType;
    }
    public DiscountType getDiscountType() {
        return this.discountType;
    }
    private void setValue(Double value) {
        if (value < 1 && value > 0) {
            this.value = value;
            return;
        }
        throw new IllegalArgumentException("Invalid discount value");
    }
    private void setProductType(String productType) {
        this.productType = productType;
    }
    private void setDiscountType(DiscountType discountType) {
        this.discountType = discountType;
    }

}
