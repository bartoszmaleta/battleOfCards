package model;

import repository.CardRepository;

public class Player {
    private String name;
    private CardRepository cardRepository;

    public Player(String name) {
        this.name = name;
        this.cardRepository = new CardRepository();
    }
}
