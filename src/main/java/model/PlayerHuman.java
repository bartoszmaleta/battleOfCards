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

//        showAttackerHisRandomCard();
//        askWhichStatWillFight();
//        statToFight();

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
    public void bet() {
//        TODO:
    }
}
