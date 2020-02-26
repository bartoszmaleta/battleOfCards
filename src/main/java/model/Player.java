package model;

import repository.Deck;

public abstract class Player {
    private String name;
    private String apparel;
    private Deck deck; // Deck
//    private Deck Deck; // Deck
    private int health;
    private int experience;
    private int level;
    private int coins;


    public Player(String name, String appeal) {
        this.name = name;
        this.apparel = appeal;
        this.deck = new Deck();
        this.health = setStartHealth();
        this.experience = 0;
        this.level = 1;
        this.coins = 1000;
    }

    public abstract void turn();

    public abstract int bet();

    public String getName() {
        return name;
    }

    public String getAppeal() {
        return apparel;
    }

    public Deck getDeck() {
        return deck;
    }

    public int getHealth() {
        return health;
    }

    public int getExperience() {
        return experience;
    }

    public int getLevel() {
        return level;
    }

    public int getCoins() {
        return coins;
    }

    public int setStartHealth() {
//      TODO: health should depends on length of remaining Deck
        int health = deck.getCardList().size();
        return health;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCoins(int amount) {
        this.coins += amount;
    }

    public void displayPlayerStatistics() {
//        TODO:

    }

    public String toString() {
//        TODO:
        return null;
    }

    public void calculateLevel() {
        int exp = getExperience();
        if (exp < 100) {
            this.level = 1;
        }
        if (exp >= 100 && exp < 200) {
            this.level = 2;
        }
        if (exp >= 200 && exp < 400) {
            this.level = 3;
        }
        if (exp >= 400) {
            this.level = 4;
        }
    }
}
