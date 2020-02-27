package model;

import exception.RandomizeDeckException;
import repository.Deck;
import services.DataHandler;
import services.TerminalManager;

import java.io.FileNotFoundException;

public class PlayerAI extends Player {

    private String aiMode;

    public PlayerAI(String aiMode) throws RandomizeDeckException {
        super("Ai", "&");
        // & -----> icon of enemyAI
        this.aiMode = aiMode;
    }

    @Override
    public void attack(Player opponent) throws FileNotFoundException {
        if (aiMode.equals("easy")) {
            Deck attackerDeck = this.getDeck();
            Deck opponentDeck = opponent.getDeck();

            Card attackerCard = attackerDeck.getRandomCard();
            Card opponentCard = opponentDeck.getRandomCard();

            // Attacker
            System.out.println("\n" + this.getName() + " ROUND! \n");

            DataHandler.printTableWithSpecifiedCard(attackerCard);
            this.displayPlayerStatistics();

            int attackerBet = 0;

            if (opponent.getCoins() > 0) {
                attackerBet = this.bet(0, opponent);
            }

            String markerOfStatToFight = easyChoice();

            int opponentBet = 0;

            int pot = 0;

            int whoWin = 0;

            switch (markerOfStatToFight.toLowerCase()) {
                case "s":
                    strFightProcess(opponentCard, attackerCard, opponent, attackerBet, opponentBet, pot, whoWin);
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

            calculateHealth(whoWin, attackerCard, opponentCard, opponent);

            System.out.println();
            System.out.println();


            System.out.println(this.getName() + " statistics");
            this.displayPlayerStatistics();

            System.out.println(opponent.getName() + " statistics");
            opponent.displayPlayerStatistics();

            TerminalManager.pressAnyKeyToContinue();

        } else if (aiMode.equals("hard")) {
            Deck attackerDeck = this.getDeck();
            Deck opponentDeck = opponent.getDeck();

            Card attackerCard = attackerDeck.getRandomCard();
            Card opponentCard = opponentDeck.getRandomCard();

            // Attacker
            System.out.println("\n" + this.getName() + " ROUND! \n");

            DataHandler.printTableWithSpecifiedCard(attackerCard);
            this.displayPlayerStatistics();

            int attackerBet = 0;

            if (opponent.getCoins() > 0) {
                attackerBet = this.bet(0, opponent);
            }

            String markerOfStatToFight = hardChoice();

            int opponentBet = 0;

            int pot = 0;

            int whoWin = 0;

            switch (markerOfStatToFight.toLowerCase()) {
                case "s":
                    strFightProcess(opponentCard, attackerCard, opponent, attackerBet, opponentBet, pot, whoWin);
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

            calculateHealth(whoWin, attackerCard, opponentCard, opponent);

            System.out.println();
            System.out.println();


            System.out.println(this.getName() + " statistics");
            this.displayPlayerStatistics();

            System.out.println(opponent.getName() + " statistics");
            opponent.displayPlayerStatistics();

            TerminalManager.pressAnyKeyToContinue();
        }
    }


    public String easyChoice() {
        int choice = (int) (Math.random() * 3 + 0);
        switch (choice) {
            case 0: {
                return "s";
            }
            case 1: {
                return "k";
            }
            case 2: {
                return "i";
            }
            case 3: {
                return "c";
            }
            default: {
                System.out.println("Something went wrong.");
                return null;
            }
        }
    }

    public String hardChoice() {
        Deck attackerDeck = this.getDeck();
        Card attackerCard = attackerDeck.getRandomCard();
        int maxStat = 0;
        for (Integer stat : attackerCard.getStats().values()) {
            if (maxStat < stat) {
                maxStat = stat;
            }
        }
        for (CardSpec cs : attackerCard.getStats().keySet()) {
            if (attackerCard.getStats().get(cs) == maxStat) {
                if (cs == CardSpec.STRENGTH) {
                    return "s";
                } else if (cs == CardSpec.KNOWLEDGE) {
                    return "k";
                } else if (cs == CardSpec.INTELLIGENCE) {
                    return "i";
                } else if (cs == CardSpec.CUNNING) {
                    return "c";
                }
            }
        }
        return "Something's wrong.";
    }


    @Override
    public int bet(int currentBet, Player player) {
        int playerCoins = player.getCoins();
        int aiCoins = getCoins();
        if (aiCoins == 0) {
            return 0;
        }
        int aiBetAmount;
        if (currentBet > 0) {
            boolean answerToBet = ((int) (Math.random() * 35 + 1)) % 2 == 0;
            if (answerToBet && currentBet > aiCoins) {
                aiBetAmount = currentBet;
                subtractCoins(aiBetAmount);
                return aiBetAmount;
            } else {
                return 0;
            }
        }
        boolean doesAIWantToBet = ((int) (Math.random() * 35 + 1)) % 2 == 0;
        if (!doesAIWantToBet) {
            return 0;
        } else {
            if (playerCoins < aiCoins) {
                aiBetAmount = (int) (Math.random() * playerCoins + 50);
                aiBetAmount -= aiBetAmount % 50;
                subtractCoins(aiBetAmount);
                return aiBetAmount;
            } else {
                aiBetAmount = (int) (Math.random() * aiCoins + 50);
                aiBetAmount -= aiBetAmount % 50;
                subtractCoins(aiBetAmount);
                return aiBetAmount;
            }
        }
    }

}
