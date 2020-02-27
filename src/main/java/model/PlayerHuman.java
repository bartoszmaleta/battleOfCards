package model;

import exception.RandomizeDeckException;
import repository.Deck;
import services.DataHandler;
import services.TerminalManager;

import java.io.FileNotFoundException;

import java.util.Scanner;

public class PlayerHuman extends Player {
    public PlayerHuman(String name) throws RandomizeDeckException {
        super(name, "\uD83E\uDD20");
    }

    // parseWithEnums()
//    public PlayerHuman(String justForEnums) throws RandomizeDeckException {
//        super("DefaultName", "\uD83E\uDD20");
//    }

    @Override
    public void displayPlayerStatistics() {
        super.displayPlayerStatistics();
    }

    @Override
    public void attack(Player opponent) throws FileNotFoundException {

        System.out.println("potCards : \n" + this.getPotCards());

        Deck attackerDeck = this.getDeck();
        Deck opponentDeck = opponent.getDeck();

        Card attackerCard = attackerDeck.getRandomCard();
        Card opponentCard = opponentDeck.getRandomCard();

        // Attacker
        System.out.println("\n" + this.getName() + " ROUND! \n");
//        attackerCard.displayStats();
        DataHandler.printTableWithSpecifiedCard(attackerCard);
        this.displayPlayerStatistics();

        int attackerBet = 0;

        if (opponent.getCoins() > 0) {
            attackerBet = this.bet(0, opponent);
        }

        System.out.println("\nWhich statistic You want to use?\nPress");
        System.out.println("(s) - STRENGTH");
        System.out.println("(k) - KNOWLEDGE");
        System.out.println("(i) - INTELLIGENCE");
        System.out.println("(c) - CUNNING");
        Scanner scanner = new Scanner(System.in);
        String markerOfStatToFight = scanner.nextLine();

        int opponentBet = 0;

        int pot = 0;

        int whoWin = 0;

        switch (markerOfStatToFight.toLowerCase()) {
            case "s":
                whoWin = strFightProcess(opponentCard, attackerCard, opponent, attackerBet, opponentBet, pot, whoWin);
                break;
            case "i":
                intFightProcess(opponentCard, attackerCard, opponent, attackerBet, opponentBet, pot, whoWin);
                break;
            case "c":
                cunFightProcess(opponentCard, attackerCard, opponent, attackerBet, opponentBet, pot, whoWin);
                break;
            case "k":
                knoFightProcess(opponentCard, attackerCard, opponent, attackerBet, opponentBet, pot, whoWin);
                break;
            default:
                System.out.println("Wrong choice ");
        }


        for (int i = 0; i < 5; i++) {
            System.out.println();
        }
//        System.out.println("\nafter fight process");
//        System.out.println(this.getName() + "attacker deck: \n" + this.getDeck().getCardList());
//        System.out.println(this.getName() + "attacker deck size: " + this.getDeck().getCardList().size());
//        System.out.println(this.getName() + "attacker health = " + this.getHealth());
//
//        System.out.println("opponent deck: \n" + opponent.getDeck().getCardList());
//        System.out.println("opponent deck size: " + opponent.getDeck().getCardList().size());
//        System.out.println("opponent health = " + opponent.getHealth());

        this.getDeck().getCardList().remove(attackerCard);
        opponent.getDeck().getCardList().remove(opponentCard);

//        System.out.println("\nafter first remove");
//        System.out.println(this.getName() + "attacker deck: \n" + this.getDeck().getCardList());
//        System.out.println(this.getName() + "attacker deck size: " + this.getDeck().getCardList().size());
//        System.out.println(this.getName() + "attacker health = " + this.getHealth());
//
//        System.out.println("opponent deck: \n" + opponent.getDeck().getCardList());
//        System.out.println("opponent deck size: " + opponent.getDeck().getCardList().size());
//        System.out.println("opponent health = " + opponent.getHealth());


        System.out.println("whoWin = " +  whoWin);

        if (whoWin == 1 || whoWin == -1) {
            this.getPotCards().add(attackerCard);
            this.getPotCards().add(opponentCard);
            opponent.getPotCards().add(attackerCard);
            opponent.getPotCards().add(opponentCard);

            System.out.println("qweqweqweqwe");
            calculateHealth(whoWin, attackerCard, opponentCard, opponent);
            this.getPotCards().clear();
            opponent.getPotCards().clear();
        } else if (whoWin == 0){
            System.out.println("whoWin = 0");
            calculateHealth(whoWin, attackerCard, opponentCard, opponent);

            this.getPotCards().add(attackerCard);
            this.getPotCards().add(opponentCard);
            opponent.getPotCards().add(attackerCard);
            opponent.getPotCards().add(opponentCard);
        }
//        this.calculateHealth(whoWin, attackerCard, opponentCard, opponent);
//        System.out.println("attacker health = " + this.getHealth());
//        System.out.println("opponent health = " + opponent.getHealth());

//        updateHealth(whoWin, attackerCard, opponentCard, opponent);


//        this.removeCard(attackerCard);
//        opponent.removeCard(opponentCard);
//        System.out.println("after second remove");
//        System.out.println("attacker deck: \n" + this.getDeck().getCardList());
//        System.out.println("attacker deck: \n" + this.getDeck().getCardList().size());
//        System.out.println("opponent deck: \n" + opponent.getDeck().getCardList());
//        System.out.println("opponent deck: \n" + opponent.getDeck().getCardList().size());

//        updateHealth(whoWin, attackerCard, opponentCard, opponent);
        // sumarize round
        System.out.println();
        System.out.println();

        System.out.println(this.getName() + " statistics");
        this.displayPlayerStatistics();

        System.out.println(opponent.getName() + " statistics");
        opponent.displayPlayerStatistics();

//        System.out.println(this.getName() + "attacker deck: \n" + this.getDeck().getCardList());
//        System.out.println(this.getName() + "attacker deck size: " + this.getDeck().getCardList().size());
//        System.out.println(this.getName() + "attacker health = " + this.getHealth());
//        System.out.println(opponent.getName() + "opponent deck: \n" + opponent.getDeck().getCardList());
//        System.out.println(opponent.getName() + "opponent deck size: " + opponent.getDeck().getCardList().size());
//        System.out.println(opponent.getName() + "opponent health = " + opponent.getHealth());

        TerminalManager.pressAnyKeyToContinue();

    }



    @Override
    public int bet(int currentBet, Player opponent) {
        Scanner s = new Scanner(System.in);
        if (currentBet > 0) {
            System.out.println("\nYour coins: " + getCoins() + "\n\nYour opponent placed " + currentBet + " coins.\n" +
                    "Do you want to respond? y/n");
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
                    return 0;
                }
            }
        }
        System.out.println();
        int coinsOfBettingPlayer = getCoins();
        if (coinsOfBettingPlayer == 0) {
            System.out.println("You cannot bet - not enough coins.");
            return 0;
        }
        int flag = 0;
        while (flag == 0) {
            System.out.println("Your coins: " + getCoins() + "\n");
            System.out.println("Do you want to place bet? y/n");
            switch (s.nextLine()) {
                case "y": {
                    System.out.println("Choose amount of coins you want to bet:");
                    int betAmount = s.nextInt();
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
            }
        }
        return 0;
    }


}
