package net.volgatech;

import java.math.BigDecimal;

public class Product implements Cloneable {
    private String _type;
    private Integer _count;
    private BigDecimal _price = new BigDecimal(0);
    private Boolean _isAlcoholic = false;
    Product(String type, Integer count, Integer price) {
        setType(type);
        setCount(count);
        setPrice(price);
    }
    Product(String type, Integer count, BigDecimal price) {
        setType(type);
        setCount(count);
        setPrice(price);
    }
    Product(String type, Integer count, Integer price, Boolean isAlcoholic) {
        setType(type);
        setCount(count);
        setPrice(price);
        _isAlcoholic = isAlcoholic;
    }
    Product(String type, Integer count, BigDecimal price, Boolean isAlcoholic) {
        setType(type);
        setCount(count);
        setPrice(price);
        _isAlcoholic = isAlcoholic;
    }
    public Integer getCount() {
        return _count;
    }
    public BigDecimal getPrice() {
        return _price;
    }
    public String getType() {
        return _type;
    }
    public void setType(String type) {
        if (type.isEmpty()) throw new IllegalArgumentException("Invalid type value");
        _type = type;
    }
    public void setCount(Integer count) {
        if (count < 0) throw new IllegalArgumentException("Invalid count value");
        _count = count;
    }
    public void setPrice(Integer price) {
        if (price <= 0) throw new IllegalArgumentException("Invalid price value");
        _price = new BigDecimal(price);
    }
    public void setPrice(BigDecimal price) {
        _price = price;
    }
    public Product clone() throws CloneNotSupportedException{
        return (Product) super.clone();
    }
    public Boolean isAlcoholic() {
        return _isAlcoholic;
    }
}
