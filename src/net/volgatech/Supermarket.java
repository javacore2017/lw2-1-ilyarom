package net.volgatech;

import net.volgatech.Customer.Customer;
import net.volgatech.Report.Report;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Supermarket {
    private List<Customer> customers = new ArrayList<Customer>();
    private List<Product> products = new ArrayList<Product>();
    private CashDesk cashDesk = new CashDesk();
    private Report report = new Report();
    private BigDecimal getPriceOfProduct(String type) {
        for(Product element : this.products) {
            if (element.getType().equals(type))
                return element.getPrice();
        }
        return new BigDecimal(0);
    }

    public Customer getCustomer(Integer index) {
        return this.customers.get(index);
    }

    public Integer getCustomersCount() {
        return this.customers.size();
    }

    public Integer getProductsCount() {
        return this.products.size();
    }

    public Product getProduct(Integer index) {
        return this.products.get(index);
    }

    public CashDesk getCashDesk() {
        return this.cashDesk;
    }

    public Report getReport() {
        return this.report;
    }

    public void addProduct(String type, Integer count, Integer price) {
        Product product = new Product(type, count, price);
        this.products.add(product);
    }

    public void addProduct(String type, Integer count, Integer price, boolean isAlcoholic) {
        Product product = new Product(type, count, price, isAlcoholic);
        this.products.add(product);
    }
    public void addCustomer(String type, String paymentMethod) {
        Customer customer = new Customer(type, paymentMethod);
        this.customers.add(customer);
        System.out.println("[" + LocalDateTime.now() + "] New customer ‘customer" + this.customers.indexOf(customer) + "’ arrived");
    }

    public void addCustomer(Customer.Type type, String paymentMethod) {
        Customer customer = new Customer(type, paymentMethod);
        this.customers.add(customer);
        System.out.println("[" + LocalDateTime.now() + "] New customer ‘customer" + this.customers.indexOf(customer) + "’ arrived");
    }

    public void changeProductCount(int value, int index) {
        Product product = this.products.get(index);
        product.setCount(value);
        this.products.set(index, product);
    }

    private Boolean isExistProduct(Product product) {
        for(Product element : this.products) {
            if (element.getType().equals(product.getType()))
                return true;
        }
        return false;
    }

    /*public void ProductToBasket(Customer customer, String type, Integer units) {
        if (units <= 0) throw new IllegalArgumentException("Invalid count of units");
        if (units < units) throw new IllegalArgumentException("Count of units more than count of products in supermarket");
        Product product = new Product(type, units, getPriceOfProduct(type));
        if (isExistProduct(product)) throw new IllegalArgumentException("Type of product is not available in supermarket");
        customer.PushToBasket(product);
    }*/
    public void CustomerToCashDesk(Integer customerIndex) {
        this.report.setBill(this.cashDesk.getCustomerBill(getCustomer(customerIndex)));
        this.customers.set(customerIndex, null);
    }
}
