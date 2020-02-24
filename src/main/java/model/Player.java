package model;

import repository.CardRepository;

public abstract class Player {
    private String name;
    private String appeal;
    private CardRepository cardRepository; // Deck
//    private Deck Deck; // Deck
    private int health;
    private int experience;
    private int level;


    public Player(String name, String appeal) {
        this.name = name;
        this.appeal = appeal;
        this.cardRepository = new CardRepository();
        this.health = setStartHealth();
        this.experience = 0;
        this.level = 1;
    }

    public abstract void turn();

    public abstract void bet();

    public String getName() {
        return name;
    }

    public String getAppeal() {
        return appeal;
    }

    public CardRepository getCardRepository() {
        return cardRepository;
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
        int health = cardRepository.getCardList().size();
        return health;
    }

    public void setLevel(int level) {
        this.level = level;
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
