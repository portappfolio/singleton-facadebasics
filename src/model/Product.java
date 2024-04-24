package model;

import java.util.HashMap;
import java.util.Map;

public class Product {

    private static Product instance = new Product();

    private Map<String, Integer> stock;

    private Product() {
        this.stock = new HashMap<>();

        stock.put("Bag", 10);
        stock.put("Book", 20);
        stock.put("Pen", 20);
    }

    public static Product getInstancia() {
        return instance;
    }

    public Map<String, Integer> getStock() {
        return stock;
    }

}
