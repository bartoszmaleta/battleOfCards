package controller;

import exception.RandomizeDeckException;
import model.Player;
import model.PlayerAI;
import model.PlayerHuman;

// TODO: revert commit ==> fix bug "-10"...

public class Game {
    Player player1;
    Player player2;
    Player ai;

    public Game() throws RandomizeDeckException {



    }


    public void playPvP() throws RandomizeDeckException {
        player1 = new PlayerHuman("Andrzej");
        player2 = new PlayerHuman("Stefan");
//      TODO:

    }

    public void PvAI() throws RandomizeDeckException {
        player1 = new PlayerHuman("Andrzej");
        ai = new PlayerAI();
//      TODO:

    }

    public void init() {
//      TODO:

    }

    public void play() {

    }
}
