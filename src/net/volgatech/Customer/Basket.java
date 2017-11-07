package net.volgatech.Customer;

import net.volgatech.Product;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private List<Product> _products = new ArrayList<Product>();
    public List<Product> getProducts() {
        return _products;
    }
    public void Add(Product product) {
        _products.add(product);
    }
}
