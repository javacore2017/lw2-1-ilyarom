package net.volgatech.Report;

import net.volgatech.Product;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Report {
    private List<Bill> _bills = new ArrayList<Bill>();
    private BigDecimal _total = new BigDecimal(0);
    public void setBill(Bill bill) {
        _bills.add(bill);
    }
    public void print() {
        System.out.println("[" + LocalDateTime.now() + "] REPORT:");
        for (int i = 0; i < _bills.size(); ++i) {
            System.out.println("[" + LocalDateTime.now() + "] Bill number " + i + ": ");
            for (Product product : _bills.get(i).getProductList()) {
                System.out.println("[" + LocalDateTime.now() + "] Product: " + product.getType() + " | " + product.getPrice() + " *" + product.getCount() + " | Price: " + (product.getPrice().multiply(new BigDecimal(product.getCount()))).setScale(0, BigDecimal.ROUND_FLOOR).toString());
            }
            System.out.println("[" + LocalDateTime.now() + "] Summary price: " + _bills.get(i).getAmount());
            _total = _total.add(_bills.get(i).getAmount());
        };
        System.out.println("[" + LocalDateTime.now() + "] The working day is over. Total: " + _total.setScale(0, BigDecimal.ROUND_FLOOR).toString());
    }
}
