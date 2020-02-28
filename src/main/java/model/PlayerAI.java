package model;

import exception.RandomizeDeckException;
import repository.Deck;
import services.DataHandler;
import services.TerminalManager;

import java.io.FileNotFoundException;

public class PlayerAI extends Player {

    private String aiMode;

    public PlayerAI(String aiMode) throws RandomizeDeckException {
        super("Ai", "\\uD83E\\uDD21");
        // & -----> icon of enemyAI
        this.aiMode = aiMode;
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
        int whoWin = 0;

        if (opponent.getCoins() > 0) {
            attackerBet = this.bet(0, opponent);
        }

        if (aiMode.equals("easy")) {

            String markerOfStatToFight = easyChoice();
            switch (markerOfStatToFight.toLowerCase()) {
                case "s":
                    whoWin = strFightProcess(opponentCard, attackerCard, opponent, attackerBet, opponentBet, pot, whoWin);
                case "i":
                    whoWin = intFightProcess(opponentCard, attackerCard, opponent, attackerBet, opponentBet, pot, whoWin);
                    break;
                case "c":
                    whoWin = cunFightProcess(opponentCard, attackerCard, opponent, attackerBet, opponentBet, pot, whoWin);
                    break;
                case "k":
                    whoWin = knoFightProcess(opponentCard, attackerCard, opponent, attackerBet, opponentBet, pot, whoWin);
                    break;
                default:
                    System.out.println("Wrong choice ");
            }

        } else if (aiMode.equals("hard")) {

            String markerOfStatToFight = hardChoice(attackerCard);
            switch (markerOfStatToFight.toLowerCase()) {
                case "s":
                    whoWin = strFightProcess(opponentCard, attackerCard, opponent, attackerBet, opponentBet, pot, whoWin);
                case "i":
                    whoWin = intFightProcess(opponentCard, attackerCard, opponent, attackerBet, opponentBet, pot, whoWin);
                    break;
                case "c":
                    whoWin = cunFightProcess(opponentCard, attackerCard, opponent, attackerBet, opponentBet, pot, whoWin);
                    break;
                case "k":
                    whoWin = knoFightProcess(opponentCard, attackerCard, opponent, attackerBet, opponentBet, pot, whoWin);
                    break;
                default:
                    System.out.println("Wrong choice ");
            }
        }

//        for (int i = 0; i < 5; i++) {
//            System.out.println();
//        }

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

        } else if (whoWin == 0) {
            calculateHealth(whoWin, attackerCard, opponentCard, opponent);

            this.getPotCards().add(attackerCard);
            this.getPotCards().add(opponentCard);

            opponent.getPotCards().add(attackerCard);
            opponent.getPotCards().add(opponentCard);
        }

        System.out.println();
        System.out.println();

        System.out.println(this.getName() + " statistics");
        this.displayPlayerStatistics();

        System.out.println(opponent.getName() + " statistics");
        opponent.displayPlayerStatistics();

        TerminalManager.pressAnyKeyToContinue();
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

    public String hardChoice(Card attackerCard) {
//        Deck attackerDeck = this.getDeck();
//        Card attackerCard = attackerDeck.getRandomCard();
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
