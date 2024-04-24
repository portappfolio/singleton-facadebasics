package model;

import java.util.HashMap;
import java.util.Map;

public class CreditCard {

    private static CreditCard instance = new CreditCard();

    private Map<String, Integer> stockOfCards;

    private CreditCard() {
        this.stockOfCards = new HashMap<>();

        stockOfCards.put("1111", 1000);
        stockOfCards.put("2222", 2000);
        stockOfCards.put("3333", 3000);
    }

    public static CreditCard getInstancia() {
        return instance;
    }

    public Map<String, Integer> getStockOfCards() {
        return stockOfCards;
    }
}
