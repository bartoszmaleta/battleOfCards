package model;

import comparator.StrengthComparator;
import exception.RandomizeDeckException;
import repository.Deck;

import java.util.Scanner;

public class PlayerHuman extends Player {
    public PlayerHuman() throws RandomizeDeckException {
        super("DefaultName", "\uD83E\uDD20");
    }

    // parseWithEnums()
    public PlayerHuman(String justForEnums) throws RandomizeDeckException {
        super("DefaultName", "\uD83E\uDD20");
    }

    @Override
    public void attack(Player opponent) {
//        TODO:
        System.out.println("I am here");
        Deck attackerDeck = this.getDeck();
        Deck opponentDeck = opponent.getDeck();


        Card attackerCard = attackerDeck.getRandomCard();
        Card opponentCard = opponentDeck.getRandomCard();

        System.out.println("\nAttacker Card: \n");
        attackerCard.displayStats();

        System.out.println("\nOpponent Card: \n");
        opponentCard.displayStats();

//        showAttackerHisRandomCard();
//        statToFight();

//        askWhichStatWillFight();
        System.out.println("\nWhich statistic You want to use?");
        Scanner scanner = new Scanner(System.in);
        String markerOfStatToFight = scanner.nextLine();

        switch (markerOfStatToFight.toLowerCase()) {
            case "s":
                Integer strengthOfOpponentCard = opponentCard.getStats().get(CardSpec.STRENGTH);
                Integer strengthOfAttackerCard = attackerCard.getStats().get(CardSpec.STRENGTH);

                System.out.println("Attacker Strength = " + strengthOfAttackerCard);
                System.out.println("Opponent Strength = " + strengthOfOpponentCard);

                StrengthComparator strengthComparator = new StrengthComparator();

                int whoWin = strengthComparator.compare(attackerCard, opponentCard);
                if (whoWin == 1) {
                    System.out.println("Attacker has higher strength");
                } else if (whoWin == 0) {
                    System.out.println("Draw");
                } else if (whoWin == -1) {
                    System.out.println("Opponent has higher strength");
                } else {
                    System.out.println("else");
                }

//                TODO
                break;
            case "i":
//                TODO
                break;
            case "c":
//                TODO
                break;
            case "k":
//                TODO
                break;
            default:
                System.out.println("Default value");
        }
    }

    @Override
    public int bet() {
        int coinsOfBettingPlayer = getCoins();
        if (coinsOfBettingPlayer == 0) {
            System.out.println("You cannot bet - not enough coins.");
            return 0;
        }
        int flag = 0;
        Scanner s = new Scanner(System.in);
        while (flag == 0) {
            System.out.println("Do you want to place bet? y/n");
            switch (s.nextLine()) {
                case "y": {
                    System.out.println("Choose amount of coins you want to bet:");
                    int betAmount = s.nextInt();
                    if (betAmount > coinsOfBettingPlayer) {
                        System.out.println("Not enough coins to place that bet. Try again or quit betting section.\n");
                    } else {
                        return betAmount;
                    }
                }
                case "n": {
                    return 0;
                }
            }
        }
        return 0;
    }

}
