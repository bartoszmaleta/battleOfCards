package model;

import java.util.HashMap;
import java.util.Map;

public class Card {
    private String name;
    private Map<String, Integer> stats;

    public Card(String name) {
        this.name = name;
        this.stats = new HashMap<>();
    }

    public Map<String, Integer> getStats() {
        return this.stats;
    }

    public void setCardValueById(String id, int value) {
        this.stats.put(id, value);
    }
}
