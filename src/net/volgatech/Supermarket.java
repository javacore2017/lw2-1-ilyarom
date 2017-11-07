package net.volgatech;

import net.volgatech.Customer.Customer;
import net.volgatech.Report.Report;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Supermarket {
    private List<Customer> _customers = new ArrayList<Customer>();
    private List<Product> _products = new ArrayList<Product>();
    private CashDesk _cashDesk = new CashDesk();
    private Report _report = new Report();
    public Supermarket() {

    }
    public void addProduct(String type, Integer count, Integer price) {
        Product product = new Product(type, count, price);
        _products.add(product);
    }

    public void addProduct(String type, Integer count, Integer price, boolean isAlcoholic) {
        Product product = new Product(type, count, price, isAlcoholic);
        _products.add(product);
    }
    public void addCustomer(String type, String paymentMethod) {
        Customer customer = new Customer(type, paymentMethod);
        _customers.add(customer);
        System.out.println("[" + LocalDateTime.now() + "] New customer ‘customer" + _customers.indexOf(customer) + "’ arrived");
    }

    public void addCustomer(Customer.Type type, String paymentMethod) {
        Customer customer = new Customer(type, paymentMethod);
        _customers.add(customer);
        System.out.println("[" + LocalDateTime.now() + "] New customer ‘customer" + _customers.indexOf(customer) + "’ arrived");
    }

    public void changeProductCount(int value, int index) {
        Product product = _products.get(index);
        product.setCount(value);
        _products.set(index, product);
    }

    public void addDiscount(Double value, String productType, Discount.DiscountType discountType) {
        _cashDesk.addDiscount(value, productType, discountType);
    }

    private Boolean isExistProduct(Product product) {
        for(Product element : _products) {
            if (element.getType().equals(product.getType()))
                return true;
        }
        return false;
    }

    private Integer getPriceOfProduct(String type) {
        for(Product element : _products) {
            if (element.getType().equals(type))
                return element.getPrice();
        }
        return -1;
    }

    public Customer getCustomer(Integer index) {
        return _customers.get(index);
    }

    public Integer getCustomersCount() {
        return _customers.size();
    }

    public Integer getProductsCount() {
        return _products.size();
    }

    public Product getProduct(Integer index) {
        return _products.get(index);
    }

    public CashDesk getCashDesk() {
        return _cashDesk;
    }

    public Report getReport() {
        return _report;
    }

   /* public static List<Product> getProductList() {
        return _products;
    }*/

    public void ProductToBasket(Customer customer, String type, Integer units) {
        if (units <= 0) throw new IllegalArgumentException("Invalid count of units");
        if (units < units) throw new IllegalArgumentException("Count of units more than count of products in supermarket");
        Product product = new Product(type, units, getPriceOfProduct(type));
        if (isExistProduct(product)) throw new IllegalArgumentException("Type of product is not available in supermarket");
        customer.PushToBasket(product);
    }
    public void CustomerToCashDesk(Integer customerIndex) {
        _report.setBill(_cashDesk.getCustomerBill(getCustomer(customerIndex)));
        _customers.set(customerIndex, null);
    }
}
