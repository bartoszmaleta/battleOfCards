package controller;

import exception.RandomizeDeckException;
import model.Player;
import model.PlayerHuman;

import java.util.Scanner;

public class Table {
    Scanner scanner = new Scanner(System.in);
    Player player1;
    Player player2;
    Player playerAi;


    public Table(int numberOfPlayers) throws RandomizeDeckException {
        System.out.println("Welcome on the table");

        if (numberOfPlayers > 1) {
            playGame(numberOfPlayers);
        } else {
            playGame(numberOfPlayers);
        }

    }

    private void playGame(int numberOfPlayers) throws RandomizeDeckException {
        if (numberOfPlayers > 1) {
            String nameOfPlayer1 = scanner.nextLine();
            player1 = new PlayerHuman(nameOfPlayer1);

            String nameOfPlayer2 = scanner.nextLine();
            player2 = new PlayerHuman(nameOfPlayer2);
            playPvP(player1, player2);
        }
    }

    private void playPvP(Player player1, Player player2) {
        while (isPlayerAlive(player1) || isPlayerAlive(player2)) {

        }

    }

    private boolean isPlayerAlive(Player playerToLive) {
        if (playerToLive.getHealth() > 0) {
            return true;
        }
        return false;
    }


}
