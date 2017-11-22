package net.volgatech.Report;

import net.volgatech.Product;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Report {
    private final List<Bill> bills = new ArrayList<>();
    private BigDecimal total = new BigDecimal(0);
    public void setBill(Bill bill) {
        this.bills.add(bill);
    }
    public void print() {
        System.out.println("[" + LocalDateTime.now() + "] REPORT:");
        for (int i = 0; i < this.bills.size(); ++i) {
            System.out.println("[" + LocalDateTime.now() + "] Bill number " + i + ": ");
            for (Product product : this.bills.get(i).getProductList()) {
                System.out.println("[" + LocalDateTime.now() + "] Product: " + product.getType() + " | " + product.getPrice() + " *" + product.getCount() + " | Price: " + (product.getPrice().multiply(new BigDecimal(product.getCount()))).setScale(0, BigDecimal.ROUND_FLOOR).toString());
            }
            System.out.println("[" + LocalDateTime.now() + "] Summary price: " + this.bills.get(i).getAmount());
            this.total = this.total.add(this.bills.get(i).getAmount());
        }
        System.out.println("[" + LocalDateTime.now() + "] The working day is over. Total: " + this.total.setScale(0, BigDecimal.ROUND_FLOOR).toString());
    }
}
