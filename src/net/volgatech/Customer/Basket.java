package net.volgatech.Customer;

import net.volgatech.Product;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private List<Product> products = new ArrayList<Product>();
    public List<Product> getProducts() {
        return this.products;
    }
    public void Add(Product product) {
        this.products.add(product);
    }
}
