package controller;

import exception.RandomizeDeckException;
import model.Player;
import model.PlayerAI;
import model.PlayerHuman;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Table {
    Scanner scanner = new Scanner(System.in);
    Player player1;
    Player player2;
    Player playerAi;


    public Table(int numberOfPlayers) throws RandomizeDeckException, FileNotFoundException {
        System.out.println("Welcome on the table");

        if (numberOfPlayers > 1) {
            playGame(numberOfPlayers);
        } else {
            playGame(numberOfPlayers);
        }

    }

    private void playGame(int numberOfPlayers) throws RandomizeDeckException, FileNotFoundException {
        System.out.println("playGame()");
        if (numberOfPlayers > 1) {
            System.out.println("What is the name of the Player 1?");
            String nameOfPlayer1 = scanner.nextLine();
            player1 = new PlayerHuman(nameOfPlayer1);

            System.out.println("What is the name of the Player 2?");
            String nameOfPlayer2 = scanner.nextLine();
            player2 = new PlayerHuman(nameOfPlayer2);

            playPvP(player1, player2);
        } else {
            System.out.println("What is the name of the Player?");
            String nameOfPlayer1 = scanner.nextLine();
            player1 = new PlayerHuman(nameOfPlayer1);

            String aiMode = "";
            boolean isGoodModeChoice = true;
            while (isGoodModeChoice) {
                System.out.println("Choose ai level?\n(e) - easy\n(h) - hard");
                aiMode = scanner.nextLine().toLowerCase();
                switch (aiMode) {
                    case "e":
                        aiMode = "easy";
                        isGoodModeChoice = false;
                        break;
                    case "h":
                        aiMode = "hard";
                        isGoodModeChoice = false;
                        break;
                    default:
                        System.out.println("Wrong level choosed!");
                }
            }

            playerAi = new PlayerAI(aiMode);
            playPvAi(player1, playerAi);
        }
    }

    private void playPvP(Player player1, Player player2) throws FileNotFoundException {
        System.out.println("playPvP");

        while (isPlayerAlive(player1) || isPlayerAlive(player2)) {
            System.out.println("playPvP while loop");

            if (player1.getPotCards().size() > 0) {
                player1.attack(player2);
                player2.attack(player1);
            } else {
                player1.setEmptyPotCards();
                player2.setEmptyPotCards();

                player1.attack(player2);
                player2.attack(player1);
            }

//            player1.attack(player2);
//            player2.attack(player1);
        }
    }

    private void playPvAi(Player player1, Player playerAi) throws FileNotFoundException {
        while (isPlayerAlive(player1) || isPlayerAlive(playerAi)) {
            System.out.println("playPvAi");

                // TODO: playPvAi draw!
            player1.attack(playerAi);
            playerAi.attack(player1);
        }
    }

    private boolean isPlayerAlive(Player playerToLive) {
        if (playerToLive.getHealth() > 0) {
            return true;
        }
        return false;
    }
}
