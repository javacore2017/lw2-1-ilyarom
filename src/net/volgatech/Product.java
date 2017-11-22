package net.volgatech;

import java.math.BigDecimal;

public class Product implements Cloneable {
    private String type;
    private Integer count;
    private BigDecimal price = new BigDecimal(0);
    private Boolean isAlcoholic = false;
    Product(String type, Integer count, Integer price, Boolean isAlcoholic) {
        setType(type);
        setCount(count);
        setPrice(price);
        this.isAlcoholic = isAlcoholic;
    }
    public Integer getCount() {
        return this.count;
    }
    public BigDecimal getPrice() {
        return this.price;
    }
    public String getType() {
        return this.type;
    }
    private void setType(String type) {
        if (type.isEmpty()) throw new IllegalArgumentException("Invalid type value");
        this.type = type;
    }
    public void setCount(Integer count) {
        if (count < 0) throw new IllegalArgumentException("Invalid count value");
        this.count = count;
    }
    void setPrice(Integer price) {
        if (price <= 0) throw new IllegalArgumentException("Invalid price value");
        this.price = new BigDecimal(price);
    }

    public Product clone() throws CloneNotSupportedException{
        return (Product) super.clone();
    }
    Boolean isAlcoholic() {
        return this.isAlcoholic;
    }
}
