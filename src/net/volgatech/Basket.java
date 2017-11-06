package net.volgatech;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private List<Product> _products = new ArrayList<Product>();
    List<Product> getProducts() {
        return _products;
    }
    public void Add(Product product) {
        _products.add(product);
    }
}
