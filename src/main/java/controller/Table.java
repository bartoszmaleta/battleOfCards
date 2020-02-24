package controller;

import model.Player;
import model.PlayerAI;
import model.PlayerHuman;

public class Table {
    Player player1;
    Player player2;
    Player ai = new PlayerAI();

    public Table() {
        player1 = new PlayerHuman();

    }


    public void playPvP() {
        player2 = new PlayerHuman();
//      TODO:

    }

    public void PvAI() {
        ai = new PlayerAI();
//      TODO:

    }

    public void init() {
//      TODO:


    }

}
