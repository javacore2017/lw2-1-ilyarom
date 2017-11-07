package net.volgatech.Report;

import net.volgatech.Customer.PaymentMethod;
import net.volgatech.Discount;
import net.volgatech.Product;

import java.util.ArrayList;
import java.util.List;

public class Bill {
    private Integer _amount = 0;
    private PaymentMethod.Method _paymentMethod;
    private List<Product> _productsInfo = new ArrayList<Product>();

    public void setPaymentMethod(PaymentMethod.Method paymentMethod) {
        _paymentMethod = paymentMethod;
    }
    public void setProductList(List<Product> productsInfo) {
        _productsInfo = productsInfo;
    }
    public List<Product> getProductList() {
        return _productsInfo;
    }
    public Integer getAmount() {
        return _amount;
    }
    public void setAmount(Integer amount) {
        _amount = amount;
    }
    private Discount _discount;
    public void ToString() {

    }
    public Bill(Integer amount, PaymentMethod.Method paymentMethod, List<Product> productList) {
        setPaymentMethod(paymentMethod);
        setAmount(amount);
        setProductList(productList);
    }

}
