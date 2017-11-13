package net.volgatech.Report;

import net.volgatech.Customer.PaymentMethod.MethodType;
import net.volgatech.Discount.Discount;
import net.volgatech.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Bill {
    private BigDecimal amount = new BigDecimal(0);
    private MethodType paymentMethod;
    private List<Product> productsInfo = new ArrayList<Product>();
    private Discount discount;
    public Bill(BigDecimal amount, MethodType paymentMethod, List<Product> productList) {
        setPaymentMethod(paymentMethod);
        setAmount(amount);
        setProductList(productList);
    }
    public List<Product> getProductList() {
        return this.productsInfo;
    }
    public BigDecimal getAmount() {
        return this.amount;
    }
    public void setPaymentMethod(MethodType paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    public void setProductList(List<Product> productsInfo) {
        this.productsInfo = productsInfo;
    }
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

}
