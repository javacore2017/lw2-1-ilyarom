package net.volgatech;

import net.volgatech.Customer.Customer;
import net.volgatech.Report.Report;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Supermarket {
    private final List<Customer> customers = new ArrayList<>();
    private final List<Product> products = new ArrayList<>();
    private final CashDesk cashDesk = new CashDesk();
    private final Report report = new Report();

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

    public void addProduct(String type, Integer count, Integer price, boolean isAlcoholic) {
        Product product = new Product(type, count, price, isAlcoholic);
        this.products.add(product);
    }
    public void addCustomer(String type, String paymentMethod) {
        Customer customer = new Customer(type, paymentMethod);
        this.customers.add(customer);
        System.out.println("[" + LocalDateTime.now() + "] New customer #customer" + this.customers.indexOf(customer) + "# arrived");
    }

    public void changeProductCount(int value, int index) {
        Product product = this.products.get(index);
        product.setCount(value);
        this.products.set(index, product);
    }

    public void CustomerToCashDesk(Integer customerIndex) {
        this.report.setBill(this.cashDesk.getCustomerBill(getCustomer(customerIndex)));
        this.customers.set(customerIndex, null);
    }
}
