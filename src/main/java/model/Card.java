package model;

import java.util.HashMap;
import java.util.Map;

public class Card {
    // TODO: iterator for Map!!!!
    private String name;
    private Map<CardSpec, Integer> stats;

    public Card(String name) {
        this.name = name;
        this.stats = new HashMap<>();
    }

    public Map<CardSpec, Integer> getStats() {
        return this.stats;
    }

    public String getName() {
        return name;
    }

    public void setCardValueById(CardSpec cardSpec, Integer value) {
        this.stats.put(cardSpec, value);
    }

    public void displayStats() {
        for (CardSpec cardSpec : this.stats.keySet()) {
            String keyOfMap = cardSpec.getSpecification();
            String valueOfMap = stats.get(cardSpec).toString();
            System.out.println(keyOfMap + " " + valueOfMap);
        }
    }


}
