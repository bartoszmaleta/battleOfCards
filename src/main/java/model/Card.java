package model;

import java.util.HashMap;
import java.util.Map;

public class Card {
    private String name;
    private Map<String, Integer> stats;

    public Card(String name, Map<String, Integer> stats) {
        this.name = name;
        this.stats = new HashMap<>();
    }

    public Map<String, Integer> getStats() {
        return this.stats;
    }

    public void setStatValueById(String id, int value) {
        this.stats.put(id, value);
    }
}
