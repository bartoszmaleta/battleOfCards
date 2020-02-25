package model;

import exception.RandomizeDeckException;
import parser.DeckDao;
import repository.Deck;

public abstract class Player {
    private String name;
    private String appeal;
    private Deck deck; // Deck
//    private Deck Deck; // Deck
    private int health;
    private int experience;
    private int level;


    public Player(String name, String appeal) throws RandomizeDeckException {
        this.name = name;
        this.appeal = appeal;
        this.deck = new DeckDao().randomizeDeck(30);
        this.health = setStartHealth();
        this.experience = 0;
        this.level = 1;
    }

    public abstract void attack(Player opoonent);

    public abstract void bet();

    public String getName() {
        return name;
    }

    public String getAppeal() {
        return appeal;
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
