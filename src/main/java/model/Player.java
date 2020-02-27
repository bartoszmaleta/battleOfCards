package model;

import com.jakewharton.fliptables.FlipTable;
import com.jakewharton.fliptables.FlipTableConverters;
import comparator.CunningComparator;
import comparator.IntelligenceComparator;
import comparator.KnowledgeComparator;
import comparator.StrengthComparator;
import exception.RandomizeDeckException;
import parser.DeckDaoXML;
import repository.Deck;
import services.DataHandler;
import services.TerminalManager;

import java.io.FileNotFoundException;

public abstract class Player {
    private String name;
    private String apparel;
    private Deck deck; // Deck
    private int health;
    private int experience;
    private int level;
    private int coins;


    public Player(String name, String apparel) throws RandomizeDeckException {
        this.name = name;
        this.deck = new Deck(30);
        this.apparel = apparel;
        this.health = setStartHealth();
        this.experience = 0;
        this.level = 1;
        this.coins = 1000;
    }

    public abstract void attack(Player opponent) throws FileNotFoundException;

    public abstract int bet(int currentBet, Player player);

    public void checkWhoWon(int whoWin, int pot, Player opponent) {
        if (whoWin == 1) {
            System.out.println("Attacker " + this.getName() + " has higher attribute");
            this.addCoins(pot);
            System.out.println("Attacker " + this.getName() + " got " + pot / 2 + " coins");

        } else if (whoWin == 0) {
            // TODO: bets and cards move to another round

            System.out.println("Draw");
            addCoins(pot / 2);
            opponent.addCoins(pot / 2);
        } else if (whoWin == -1) {
            System.out.println("Opponent " + opponent.getName() + " has higher attribute");
            opponent.addCoins(pot);
            System.out.println("Opponent " + opponent.getName() + " got " + pot / 2 + " coins");
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
            this.setHealth();
            opponent.setHealth();
//            this.subtractHealth(1);

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
            this.setHealth();
            opponent.setHealth();
//            opponent.subtractHealth(1);
        }
    }


    public String getName() {
        return name;
    }

    public String getApparel() {
        return apparel;
    }

    public void setHealth() {
        int health = this.deck.getCardList().size();
        this.health = health;
    }

    public Deck getDeck() {
        return deck;
    }

    public int getHealth() {
        return health;
    }

    public void subtractHealth() {
        this.health -= 1;
    }

    public void subtractHealth(int healthToSubtract) {
        this.health -= healthToSubtract;
    }

    public int getExperience() {
        return experience;
    }

    public int getLevel() {
        return level;
    }

    public int getCoins() {
        return coins;
    }

    public int setStartHealth() {
//      TODO: health should depends on length of remaining Deck
        int health = deck.getCardList().size();
        return health;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addCoins(int amount) {
        this.coins += amount;
    }

    public void subtractCoins(int amount) {
        this.coins -= amount;
    }

    public void displayPlayerStatistics() {
//        TODO:
        String[] headers = {"Remaining Cards", "Coins", "Experience", "Level"};
        Object[][] data = {
                {this.health, this.coins, this.experience, this.level}
        };
        System.out.println(FlipTableConverters.fromObjects(headers, data));
    }

    public String toString() {
//        TODO:
        return null;
    }

    public void calculateLevel() {
        int exp = getExperience();
        if (exp < 100) {
            this.level = 1;
        }
        if (exp >= 100 && exp < 200) {
            this.level = 2;
        }
        if (exp >= 200 && exp < 400) {
            this.level = 3;
        }
        if (exp >= 400) {
            this.level = 4;
        }
    }

    public void strFightProcess(Card opponentCard, Card attackerCard, Player opponent, int attackerBet, int opponentBet, int pot, int whoWin) throws FileNotFoundException {
        Integer strengthOfOpponentCard = opponentCard.getStats().get(CardSpec.STRENGTH);
        Integer strengthOfAttackerCard = attackerCard.getStats().get(CardSpec.STRENGTH);

        TerminalManager.clearScreen();

        System.out.println("\n" + opponent.getName() + " ROUND! \n");

        DataHandler.printTableWithSpecifiedCard(opponentCard);
        opponent.displayPlayerStatistics();

        if (attackerBet > 0) {
            opponentBet = opponent.bet(attackerBet, opponent);
            if (opponentBet == 0) {
                addCoins(attackerBet);
                attackerBet = 0;
            }
        }

        TerminalManager.clearScreen();

        pot = attackerBet + opponentBet;

        System.out.println("Attacker Strength = " + strengthOfAttackerCard);
        System.out.println("Opponent Strength = " + strengthOfOpponentCard);

        StrengthComparator strengthComparator = new StrengthComparator();

        whoWin = strengthComparator.compare(attackerCard, opponentCard);

        checkWhoWon(whoWin, pot, opponent);
    }

    public void intFightProcess(Card opponentCard, Card attackerCard, Player opponent, int attackerBet, int opponentBet, int pot, int whoWin) throws FileNotFoundException {
        Integer intelligenceOfOpponentCard = opponentCard.getStats().get(CardSpec.INTELLIGENCE);
        Integer intelligenceOfAttackerCard = attackerCard.getStats().get(CardSpec.INTELLIGENCE);

        TerminalManager.clearScreen();

        System.out.println("\n" + opponent.getName() + " ROUND! \n");

        DataHandler.printTableWithSpecifiedCard(opponentCard);
        opponent.displayPlayerStatistics();

        if (attackerBet > 0) {
            opponentBet = opponent.bet(attackerBet, opponent);
            if (opponentBet == 0) {
                addCoins(attackerBet);
                attackerBet = 0;
            }
        }

        TerminalManager.clearScreen();

        pot = attackerBet + opponentBet;

        System.out.println("Attacker Intelligence = " + intelligenceOfAttackerCard);
        System.out.println("Opponent Intelligence = " + intelligenceOfOpponentCard);

        IntelligenceComparator intelligenceComparator = new IntelligenceComparator();

        whoWin = intelligenceComparator.compare(attackerCard, opponentCard);

        checkWhoWon(whoWin, pot, opponent);
    }

    public void cunFightProcess(Card opponentCard, Card attackerCard, Player opponent, int attackerBet, int opponentBet, int pot, int whoWin) throws FileNotFoundException {
        Integer cunningOfOpponentCard = opponentCard.getStats().get(CardSpec.CUNNING);
        Integer cunningOfAttackerCard = attackerCard.getStats().get(CardSpec.CUNNING);

        TerminalManager.clearScreen();

        System.out.println("\n" + opponent.getName() + " ROUND! \n");

        DataHandler.printTableWithSpecifiedCard(opponentCard);
        opponent.displayPlayerStatistics();

        if (attackerBet > 0) {
            opponentBet = opponent.bet(attackerBet, opponent);
            if (opponentBet == 0) {
                addCoins(attackerBet);
                attackerBet = 0;
            }
        }

        TerminalManager.clearScreen();

        pot = attackerBet + opponentBet;

        System.out.println("Attacker Cunning = " + cunningOfAttackerCard);
        System.out.println("Opponent Cunning = " + cunningOfOpponentCard);

        CunningComparator cunningComparator = new CunningComparator();

        whoWin = cunningComparator.compare(attackerCard, opponentCard);

        checkWhoWon(whoWin, pot, opponent);
    }

    public void knoFightProcess(Card opponentCard, Card attackerCard, Player opponent, int attackerBet, int opponentBet, int pot, int whoWin) throws FileNotFoundException {
        Integer knowledgeOfOpponentCard = opponentCard.getStats().get(CardSpec.KNOWLEDGE);
        Integer knowledgeOfAttackerCard = attackerCard.getStats().get(CardSpec.KNOWLEDGE);

        for (int i = 0; i < 30; i++) {
            System.out.println();
        }
        System.out.println("\n" + opponent.getName() + " ROUND! \n");

        DataHandler.printTableWithSpecifiedCard(opponentCard);
        opponent.displayPlayerStatistics();

        if (attackerBet > 0) {
            opponentBet = opponent.bet(attackerBet, opponent);
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
    }

}
