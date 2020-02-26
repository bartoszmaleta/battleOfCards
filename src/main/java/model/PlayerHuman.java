package model;

import comparator.StrengthComparator;
import exception.RandomizeDeckException;
import repository.Deck;

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
    public void attack(Player opponent) {
        Deck attackerDeck = this.getDeck();
        Deck opponentDeck = opponent.getDeck();

        Card attackerCard = attackerDeck.getRandomCard();
        Card opponentCard = opponentDeck.getRandomCard();

        System.out.println("\nAttacker Card: \n");
        attackerCard.displayStats();

        int attackerBet = 0;

        if (opponent.getCoins() > 0) {
            attackerBet = this.bet(0);
        }

        System.out.println("\nWhich statistic You want to use?");
        Scanner scanner = new Scanner(System.in);
        String markerOfStatToFight = scanner.nextLine();

        switch (markerOfStatToFight.toLowerCase()) {
            case "s":
                Integer strengthOfOpponentCard = opponentCard.getStats().get(CardSpec.STRENGTH);
                Integer strengthOfAttackerCard = attackerCard.getStats().get(CardSpec.STRENGTH);

                for (int i = 0; i < 30; i++) {
                    System.out.println();
                }

                System.out.println(opponent.getName() + "\nOpponent Card: \n");
                opponentCard.displayStats();

                int opponentBet = 0;

                if (attackerBet > 0) {
                    opponentBet = opponent.bet(attackerBet);
                    if (opponentBet == 0) {
                        addCoins(attackerBet);
                        attackerBet = 0;
                    }
                }

                for (int i = 0; i < 30; i++) {
                    System.out.println();
                }

                int pot = attackerBet + opponentBet;

                System.out.println("Attacker Strength = " + strengthOfAttackerCard);
                System.out.println("Opponent Strength = " + strengthOfOpponentCard);

                StrengthComparator strengthComparator = new StrengthComparator();

                int whoWin = strengthComparator.compare(attackerCard, opponentCard);

                checkWhoWon(whoWin, pot, opponent);

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
                System.out.println("Wrong choice ");
        }
        // sumarize round
        System.out.println();
        System.out.println();
        System.out.println("Your coins = " + this.getCoins());
        System.out.println("Opponent coins = " + opponent.getCoins());
    }

    public void checkWhoWon(int whoWin, int pot, Player opponent) {
        if (whoWin == 1) {
            System.out.println("Attacker " + this.getName() + " has higher strength");
            this.addCoins(pot);
            System.out.println("Attacker " + this.getName() + " got " + pot/2 + " coins");
        } else if (whoWin == 0) {
            // TODO: bets and cards move to another round

            System.out.println("Draw");
            addCoins(pot/2);
            opponent.addCoins(pot/2);
        } else if (whoWin == -1) {
            System.out.println("Opponent " + opponent.getName() + " has higher strength");
            opponent.addCoins(pot);
            System.out.println("Opponent " + opponent.getName() + " got " + pot/2 + " coins");
        } else {
            System.out.println("else");
        }
    }

    @Override
    public void displayPlayerStatistics() {
        super.displayPlayerStatistics();
    }

    public int bet(int currentBet) {
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

    @Override
    public void resolveBet() {

    }

}
