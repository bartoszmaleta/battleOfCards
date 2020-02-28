package model;

import exception.RandomizeDeckException;
import repository.Deck;
import services.DataHandler;
import services.TerminalManager;

import java.io.FileNotFoundException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PlayerHuman extends Player {
    public PlayerHuman(String name) throws RandomizeDeckException {
        super(name, "\uD83E\uDD20");
    }

    @Override
    public void displayPlayerStatistics() {
        super.displayPlayerStatistics();
    }

    @Override
    public void attack(Player opponent) throws FileNotFoundException {

        Deck attackerDeck = this.getDeck();
        Deck opponentDeck = opponent.getDeck();

        Card attackerCard = attackerDeck.getRandomCard();
        Card opponentCard = opponentDeck.getRandomCard();

        // Attacker
        System.out.println("\n" + this.getName() + " ROUND! " + this.getApparel() + "\n");
        DataHandler.printTableWithSpecifiedCard(attackerCard);
        this.displayPlayerStatistics();

        int attackerBet = 0;
        int opponentBet = 0;
        int pot = 0;
        int whoWin = -10; // value does not matter, just to initialize!

        if (opponent.getCoins() > 0) {
            attackerBet = this.bet(0, opponent);
        }

        System.out.println("\nWhich statistic You want to use?\nPress");
        System.out.println("(s) - STRENGTH\n(k) - KNOWLEDGE\n(i) - INTELLIGENCE\n(c) - CUNNING\n");

        Scanner scanner = new Scanner(System.in);
        String markerOfStatToFight = scanner.nextLine();
        boolean isCorrectInput = true;
        while (isCorrectInput) {
            switch (markerOfStatToFight.toLowerCase()) {
                case "s":
                    whoWin = strFightProcess(opponentCard, attackerCard, opponent, attackerBet, opponentBet, pot, whoWin);
                    isCorrectInput = false;
                    break;
                case "i":
                    whoWin = intFightProcess(opponentCard, attackerCard, opponent, attackerBet, opponentBet, pot, whoWin);
                    isCorrectInput = false;
                    break;
                case "c":
                    whoWin = cunFightProcess(opponentCard, attackerCard, opponent, attackerBet, opponentBet, pot, whoWin);
                    isCorrectInput = false;
                    break;
                case "k":
                    whoWin = knoFightProcess(opponentCard, attackerCard, opponent, attackerBet, opponentBet, pot, whoWin);
                    isCorrectInput = false;
                    break;
                default:
                    System.out.println("Wrong choice ");
            }
        }

        for (int i = 0; i < 5; i++) {
            System.out.println();
        }

        this.getDeck().getCardList().remove(attackerCard);
        opponent.getDeck().getCardList().remove(opponentCard);

        if (whoWin == 1 || whoWin == -1) {
            this.getPotCards().add(attackerCard);
            this.getPotCards().add(opponentCard);
            opponent.getPotCards().add(attackerCard);
            opponent.getPotCards().add(opponentCard);

            calculateHealth(whoWin, attackerCard, opponentCard, opponent);

            this.getPotCards().clear();
            opponent.getPotCards().clear();

        } else if (whoWin == 0){
            calculateHealth(whoWin, attackerCard, opponentCard, opponent);

            this.getPotCards().add(attackerCard);
            this.getPotCards().add(opponentCard);

            opponent.getPotCards().add(attackerCard);
            opponent.getPotCards().add(opponentCard);
        }

        TerminalManager.clearScreen();


        System.out.println("\n\n" + this.getName() + " statistics");
        this.displayPlayerStatistics();

        System.out.println(opponent.getName() + " statistics");
        opponent.displayPlayerStatistics();

//        TerminalManager.pressAnyKeyToContinue();
        TerminalManager.pressAnyKeyToContinueWithMenu();
    }




    @Override
    public int bet(int currentBet, Player opponent) {
        Scanner s = new Scanner(System.in);
        int flag = 0;
        if (currentBet > 0) {
            System.out.println("Your coins: " + getCoins() + "\n\nYour opponent placed " + currentBet + " coins.\n" +
                    "Do you want to respond? y/n");
            while (flag == 0) {
                switch (s.nextLine()) {
                    case "y": {
                        subtractCoins(currentBet);
                        return currentBet;
                    }
                    case "n": {
                        return 0;
                    }
                    default: {
                        System.out.println("Wrong operation.");
                    }
                }
            }
        }
        System.out.println();
        int coinsOfBettingPlayer = getCoins();
        if (coinsOfBettingPlayer == 0) {
            System.out.println("You cannot bet - not enough coins.");
            return 0;
        }
        while (flag == 0) {
            System.out.println("Your coins: " + getCoins() + "\n");
            System.out.println("Do you want to place bet? y/n");
            switch (s.nextLine()) {
                case "y": {
                    boolean isDone = false;
                    int betAmount = 0;
                    while (!isDone) {
                        System.out.println("Choose amount of coins you want to bet:");
                        try {
                            betAmount = s.nextInt();
                            if (betAmount > 0) {
                                isDone = true;
                            }
                        } catch (InputMismatchException ex) {
                            for (int i = 0; i < 30; i++) {
                                System.out.println();
                            }
                            System.out.println("Wrong operation\n");
                            s.nextLine();
                        }
                    }
                    if (betAmount > coinsOfBettingPlayer) {
                        for (int i = 0; i < 30; i++) {
                            System.out.println();
                        }
                        System.out.println("Not enough coins to place that bet. Try again or quit betting section.\n");
                        s.nextLine();
                    } else if (opponent.getCoins() < betAmount) {
                        for (int i = 0; i < 30; i++) {
                            System.out.println();
                        }
                        System.out.println("Your opponent cannot respond to this bet. Try again or quit betting section.");
                        s.nextLine();
                    } else {
                        subtractCoins(betAmount);
                        return betAmount;
                    }
                    break;
                }
                case "n": {
                    return 0;
                }
                default: {
                    System.out.println("Wrong choice! Try again!");
                }
            }
        }
        return 0;
    }


}
