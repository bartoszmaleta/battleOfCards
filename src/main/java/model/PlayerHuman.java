package model;

import comparator.CunningComparator;
import comparator.IntelligenceComparator;
import comparator.KnowledgeComparator;
import comparator.StrengthComparator;
import exception.RandomizeDeckException;
import repository.Deck;
import services.DataHandler;
import services.TerminalManager;

import javax.xml.crypto.Data;
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
    public void attack(Player opponent) throws FileNotFoundException {
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
            attackerBet = this.bet(0);
        }

        System.out.println("\nWhich statistic You want to use?");
        Scanner scanner = new Scanner(System.in);
        String markerOfStatToFight = scanner.nextLine();

        int opponentBet = 0;

        int pot;

        int whoWin = 0;

        switch (markerOfStatToFight.toLowerCase()) {
            case "s":
                Integer strengthOfOpponentCard = opponentCard.getStats().get(CardSpec.STRENGTH);
                Integer strengthOfAttackerCard = attackerCard.getStats().get(CardSpec.STRENGTH);

//                for (int i = 0; i < 30; i++) {
//                    System.out.println();
//                }

                TerminalManager.clearScreen();

                System.out.println("\n" + opponent.getName() + " ROUND! \n");
//                opponentCard.displayStats();
                DataHandler.printTableWithSpecifiedCard(opponentCard);
                opponent.displayPlayerStatistics();

                if (attackerBet > 0) {
                    opponentBet = opponent.bet(attackerBet);
                    if (opponentBet == 0) {
                        addCoins(attackerBet);
                        attackerBet = 0;
                    }
                }

                TerminalManager.clearScreen();

//                for (int i = 0; i < 30; i++) {
//                    System.out.println();
//                }

                pot = attackerBet + opponentBet;

                System.out.println("Attacker Strength = " + strengthOfAttackerCard);
                System.out.println("Opponent Strength = " + strengthOfOpponentCard);

                StrengthComparator strengthComparator = new StrengthComparator();

                whoWin = strengthComparator.compare(attackerCard, opponentCard);

                checkWhoWon(whoWin, pot, opponent);
                break;
            case "i":
                Integer intelligenceOfOpponentCard = opponentCard.getStats().get(CardSpec.INTELLIGENCE);
                Integer intelligenceOfAttackerCard = attackerCard.getStats().get(CardSpec.INTELLIGENCE);

//                for (int i = 0; i < 30; i++) {
//                    System.out.println();
//                }

                TerminalManager.clearScreen();

                System.out.println("\n" + opponent.getName() + " ROUND! \n");
//                opponentCard.displayStats();
                DataHandler.printTableWithSpecifiedCard(opponentCard);
                opponent.displayPlayerStatistics();

                if (attackerBet > 0) {
                    opponentBet = opponent.bet(attackerBet);
                    if (opponentBet == 0) {
                        addCoins(attackerBet);
                        attackerBet = 0;
                    }
                }

                TerminalManager.clearScreen();

//                for (int i = 0; i < 30; i++) {
//                    System.out.println();
//                }

                pot = attackerBet + opponentBet;

                System.out.println("Attacker Intelligence = " + intelligenceOfAttackerCard);
                System.out.println("Opponent Intelligence = " + intelligenceOfOpponentCard);

                IntelligenceComparator intelligenceComparator = new IntelligenceComparator();

                whoWin = intelligenceComparator.compare(attackerCard, opponentCard);

                checkWhoWon(whoWin, pot, opponent);
                break;
            case "c":
                Integer cunningOfOpponentCard = opponentCard.getStats().get(CardSpec.CUNNING);
                Integer cunningOfAttackerCard = attackerCard.getStats().get(CardSpec.CUNNING);

//                for (int i = 0; i < 30; i++) {
//                    System.out.println();
//                }

                TerminalManager.clearScreen();

                System.out.println("\n" + opponent.getName() + " ROUND! \n");
//                opponentCard.displayStats();
                DataHandler.printTableWithSpecifiedCard(opponentCard);
                opponent.displayPlayerStatistics();

                if (attackerBet > 0) {
                    opponentBet = opponent.bet(attackerBet);
                    if (opponentBet == 0) {
                        addCoins(attackerBet);
                        attackerBet = 0;
                    }
                }

                TerminalManager.clearScreen();


//                for (int i = 0; i < 30; i++) {
//                    System.out.println();
//                }

                pot = attackerBet + opponentBet;

                System.out.println("Attacker Cunning = " + cunningOfAttackerCard);
                System.out.println("Opponent Cunning = " + cunningOfOpponentCard);

                CunningComparator cunningComparator = new CunningComparator();

                whoWin = cunningComparator.compare(attackerCard, opponentCard);

                checkWhoWon(whoWin, pot, opponent);
                break;
            case "k":
                Integer knowledgeOfOpponentCard = opponentCard.getStats().get(CardSpec.KNOWLEDGE);
                Integer knowledgeOfAttackerCard = attackerCard.getStats().get(CardSpec.KNOWLEDGE);

                for (int i = 0; i < 30; i++) {
                    System.out.println();
                }
                System.out.println("\n" + opponent.getName() + " ROUND! \n");
//                opponentCard.displayStats();
                DataHandler.printTableWithSpecifiedCard(opponentCard);
                opponent.displayPlayerStatistics();

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

                pot = attackerBet + opponentBet;

                System.out.println("Attacker Knowledge = " + knowledgeOfAttackerCard);
                System.out.println("Opponent Knowledge = " + knowledgeOfOpponentCard);

                KnowledgeComparator knowledgeComparator = new KnowledgeComparator();

                whoWin = knowledgeComparator.compare(attackerCard, opponentCard);

                checkWhoWon(whoWin, pot, opponent);

                break;
            default:
                System.out.println("Wrong choice ");
        }

        updateHealth(whoWin, attackerCard, opponentCard, opponent);
        // sumarize round
        System.out.println();
        System.out.println();

        System.out.println(this.getName() + " Your health = " + this.getHealth());
        System.out.println("Your coins = " + this.getCoins());

        System.out.println(opponent.getName() + " Your health = " + opponent.getHealth());
        System.out.println("Opponent coins = " + opponent.getCoins());

        TerminalManager.pressAnyKeyToContinue();

    }

    public void checkWhoWon(int whoWin, int pot, Player opponent) {
        if (whoWin == 1) {
            System.out.println("Attacker " + this.getName() + " has higher attribute");
            this.addCoins(pot);
            System.out.println("Attacker " + this.getName() + " got " + pot/2 + " coins");

        } else if (whoWin == 0) {
            // TODO: bets and cards move to another round

            System.out.println("Draw");
            addCoins(pot/2);
            opponent.addCoins(pot/2);
        } else if (whoWin == -1) {
            System.out.println("Opponent " + opponent.getName() + " has higher attribute");
            opponent.addCoins(pot);
            System.out.println("Opponent " + opponent.getName() + " got " + pot/2 + " coins");
        } else {
            System.out.println("else");
        }
    }

    public void updateHealth(int whowin, Card cardAttacker, Card cardOpponent, Player opponent) {
        if (whowin == 1) {
            this.getDeck().getCardList().add(cardOpponent);

            for (int i = 0; i < opponent.getDeck().getCardList().size(); i++) {
                Card card = opponent.getDeck().getCardList().get(i);
                if (card.equals(cardOpponent)) {
                    opponent.getDeck().getCardList().remove(card);
                }
            }
            this.subtractHealth(1);

        } else if (whowin == 0) {
            // TODO:
        } else if (whowin == -1) {
            opponent.getDeck().getCardList().add(cardAttacker);

            for (int i = 0; i < this.getDeck().getCardList().size(); i++) {
                Card card = this.getDeck().getCardList().get(i);
                if (card.equals(cardAttacker)) {
                    this.getDeck().getCardList().remove(card);
                }
            }
            opponent.subtractHealth(1);
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
