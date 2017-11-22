package net.volgatech.Report;

import net.volgatech.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Bill {
    private BigDecimal amount = new BigDecimal(0);
    private List<Product> productsInfo = new ArrayList<>();
    public Bill(BigDecimal amount, List<Product> productList) {
        setAmount(amount);
        setProductList(productList);
    }
    List<Product> getProductList() {
        return this.productsInfo;
    }
    BigDecimal getAmount() {
        return this.amount;
    }
    private void setProductList(List<Product> productsInfo) {
        this.productsInfo = productsInfo;
    }
    private void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

}
