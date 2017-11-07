package net.volgatech.Handler;

import net.volgatech.Discount;

import java.util.Arrays;
import java.util.List;

public class RandomValues {
    public static List<String> productTypes = Arrays.asList("milk", "bread", "cheese", "tea",
            "sugar", "salt", "butter", "coffee", "apple", "apricot", "bacon", "eggs",
            "banana", "beef", "biscuits", "berry", "bun", "cabbage", "cake", "candy", "carrot",
            "cherry", "chicken", "chocolate", "corn", "crab", "cucumber", "duck", "olive", "ham", "herring",
            "honey", "ice-cream", "lemon", "lobster", "meat", "nut", "noodle", "onion", "orange", "peach", "pear",
            "peas", "pepper", "pine-apple", "plum", "raisin", "radish", "rice", "roll", "salad", "sardine",
            "sausage", "beer", "whiskey", "vodka", "vine");
    public static List<String> customerTypes = Arrays.asList("child", "adult", "retired");
    public static List<String> paymentMethods = Arrays.asList("card", "cash");
    public static List<Discount.DiscountType> discountTypeList = Arrays.asList(Discount.DiscountType.ALL, Discount.DiscountType.FOR_CARD_PAYMENT, Discount.DiscountType.FOR_CASH_PAYMENT, Discount.DiscountType.FOR_RETIRED);
}
