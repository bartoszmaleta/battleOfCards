package controller;

import exception.RandomizeDeckException;
import model.Player;
import model.PlayerAI;
import model.PlayerHuman;

public class Table {
    Player player1;
    Player player2;
    Player ai = new PlayerAI();

    public Table() throws RandomizeDeckException {
        player1 = new PlayerHuman();

    }


    public void playPvP() throws RandomizeDeckException {
        player2 = new PlayerHuman();
//      TODO:

    }

    public void PvAI() throws RandomizeDeckException {
        ai = new PlayerAI();
//      TODO:

    }

    public void init() {
//      TODO:


    }

}
