package net.volgatech.Handler;

import net.volgatech.Customer.Customer;
import net.volgatech.Discount;
import net.volgatech.Product;
import net.volgatech.Supermarket;

import java.time.LocalDateTime;
import java.util.*;

public class Main {

    private static Boolean isCustomersBuyUp(Supermarket supermarket) {
        for (int i = 0; i < supermarket.getCustomersCount(); ++i) {
            if (supermarket.getCustomer(i) != null)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        RandomValues values = new RandomValues();
        System.out.println("[" + LocalDateTime.now() + "] Supermarket products have been formed:");
        Random random = new Random();
        Supermarket supermarket = new Supermarket();
        boolean isAlcoholic = false;
        for (String element : values.productTypes) {
            if (values.productTypes.indexOf(element) >= values.productTypes.size() - 4) {
                isAlcoholic = true;
            }
            if (random.nextInt(5) == 0)
                continue;
            Integer units = random.nextInt(100) + 50;
            Integer price = random.nextInt(20) + 10;
            System.out.println("[" + LocalDateTime.now() + "] product " + element + ". Units:" + units + "; Price:" + price);
            supermarket.addProduct(element, units, price, isAlcoholic);
        }
        System.out.println("[" + LocalDateTime.now() + "] Supermarket is opened");
        Timer timer = new Timer();

        /*for (Integer i = 0; i < random.nextInt(5) + 2; ++i) {
            timer.schedule(new TimerTask() {
                public void run() {
                    supermarket.AddCustomer(values.customerTypes.get(random.nextInt(2)), values.paymentMethods.get(random.nextInt(1)));
                    Timer timer2 = new Timer();
                    for (Integer j = 0; j < random.nextInt(5); ++j) {
                        timer2.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                Customer customer = supermarket.getCustomer(i);
                                List<Product> products = Supermarket.getProductList();
                                customer.PushToBasket(products.get(random.nextInt(products.size() - 1)));
                            }
                        }, random.nextInt(4) * 1000);
                    }
                }
            }, random.nextInt(8) * 1000);
        }*/
        supermarket.addCustomer(values.customerTypes.get(random.nextInt(2)), values.paymentMethods.get(random.nextInt(1)));
        for (int i = 0; i < 5; ++i)
        {
            double discountValue = ((random.nextInt(75) + 5) * 0.01);
            String productValue = supermarket.getProduct(random.nextInt(supermarket.getProductsCount())).getType();
            Discount.DiscountType discountType = values.discountTypeList.get(random.nextInt(4));
            supermarket.getCashDesk().addDiscount(discountValue, productValue, discountType);
            System.out.println("[" + LocalDateTime.now() + "] Discount in the supermarket! " + discountValue * 100 + "% on " + productValue + " " + discountType.ToString());
        }
        for (Integer i = 0; true; ++i) {
            if (isCustomersBuyUp(supermarket))
                break;
            if (random.nextInt(supermarket.getCustomersCount()) > 0 || supermarket.getCustomersCount() > 5) {
                Integer productIndex = random.nextInt(supermarket.getProductsCount() - 1);
                Product product = supermarket.getProduct(productIndex);
                Integer customerIndex = random.nextInt(supermarket.getCustomersCount() - 1);
                Customer customer = supermarket.getCustomer(customerIndex);
                while (customer == null) {
                    customerIndex++;
                    if (customerIndex >= supermarket.getCustomersCount())
                        customerIndex = 0;
                    customer = supermarket.getCustomer(customerIndex);
                }
                Integer unitsToPush = random.nextInt(4) + 1;
                if (product.getCount() >= unitsToPush) {
                    supermarket.changeProductCount(product.getCount() - unitsToPush, productIndex);
                    product.setCount(unitsToPush);
                }
                else {
                    System.out.println("[" + LocalDateTime.now() + "] Too much units taked customer#" + customerIndex + " of " + product.getType());
                    continue;
                }
                customer.PushToBasket(product);
                System.out.println("[" + LocalDateTime.now() + "] customer#" + customerIndex + " push to basket " + product.getCount() + " units of " + product.getType());
            }
            else {
                supermarket.addCustomer(values.customerTypes.get(random.nextInt(3)), values.paymentMethods.get(random.nextInt(2)));
            }
            for (Integer j = 0; j < supermarket.getCustomersCount(); ++j) {
                Customer customer = supermarket.getCustomer(j);
                if (customer != null) {
                    if (supermarket.getCustomer(j).getBasket().getProducts().size() > random.nextInt(4) + 3) {
                        supermarket.CustomerToCashDesk(j);
                        System.out.println("[" + LocalDateTime.now() + "] Customer " + j + " go to cash desk. Amount: " + supermarket.getCashDesk().getAmount());
                        System.out.println("[" + LocalDateTime.now() + "] Customer pays with " + customer.getPaymentMethod().toString() + " and go out from supermarket");

                    }
                }
            }
        }
        System.out.println("[" + LocalDateTime.now() + "] Supermarket is closed");
        supermarket.getReport().print();
        return;
    }
}
