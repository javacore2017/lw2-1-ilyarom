package net.volgatech;

public class Product implements Cloneable {
    private String _type;
    private Integer _count;
    private Integer _price;
    private Boolean _isAlcoholic = false;
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
        _price = price;
    }
    public Product clone() throws CloneNotSupportedException{
        return (Product) super.clone();
    }
    public Boolean isAlcoholic() {
        return _isAlcoholic;
    }
    public Integer getCount() {
        return _count;
    }
    public Integer getPrice() {
        return _price;
    }
    public String getType() {
        return _type;
    }
    Product(String type, Integer count, Integer price) {
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
}
