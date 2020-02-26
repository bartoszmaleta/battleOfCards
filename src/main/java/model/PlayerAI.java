package model;

import exception.RandomizeDeckException;

public class PlayerAI extends Player {

    public PlayerAI() throws RandomizeDeckException {
        super("Ai", "&");
        // & -----> icon of enemyAI
    }

    @Override
    public void attack(Player opponent) {
//        TODO:
    }

    @Override
    public int bet() {
//        TODO:
        return 0;
    }
}
