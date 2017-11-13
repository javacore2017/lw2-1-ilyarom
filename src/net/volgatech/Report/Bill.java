package net.volgatech.Report;

import net.volgatech.Customer.PaymentMethod;
import net.volgatech.Discount;
import net.volgatech.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Bill {
    private BigDecimal _amount = new BigDecimal(0);
    private PaymentMethod.Method _paymentMethod;
    private List<Product> _productsInfo = new ArrayList<Product>();
    private Discount _discount;
    public Bill(BigDecimal amount, PaymentMethod.Method paymentMethod, List<Product> productList) {
        setPaymentMethod(paymentMethod);
        setAmount(amount);
        setProductList(productList);
    }
    public List<Product> getProductList() {
        return _productsInfo;
    }
    public BigDecimal getAmount() {
        return _amount;
    }
    public void setPaymentMethod(PaymentMethod.Method paymentMethod) {
        _paymentMethod = paymentMethod;
    }
    public void setProductList(List<Product> productsInfo) {
        _productsInfo = productsInfo;
    }
    public void setAmount(BigDecimal amount) {
        _amount = amount;
    }

}
