package model;

import com.jakewharton.fliptables.FlipTableConverters;
import comparator.CunningComparator;
import comparator.IntelligenceComparator;
import comparator.KnowledgeComparator;
import comparator.StrengthComparator;
import exception.RandomizeDeckException;
import repository.Deck;
import services.DataHandler;
import services.TerminalManager;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public abstract class Player {
    private String name;
    private String apparel;
    private Deck deck; // Deck
    private int health;
    private int experience;
    private int level;
    private int coins;
    private int potCoins;
    private List<Card> potCards;


    public Player(String name, String apparel) throws RandomizeDeckException {
        this.name = name;
        this.deck = new Deck(30);
        this.apparel = apparel;
        this.health = setStartHealth();
        this.experience = 0;
        this.level = 1;
        this.coins = 1000;
        this.potCoins = 0;
        this.potCards = new ArrayList<>();
    }

    public abstract void attack(Player opponent) throws FileNotFoundException;

    public abstract int bet(int currentBet, Player player);


    public String getName() {
        return name;
    }

    public String getApparel() {
        return apparel;
    }

    public void updateHealth() {
//        int health = this.deck.getCardList().size();
//        this.health = health;

        this.health = this.deck.getCardList().size();
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

    public void removeCard(Card card) {
        for (int i = 0; i < this.getDeck().getCardList().size(); i++) {
            if (this.getDeck().getCardList().get(i).equals(card)) {
                this.getDeck().getCardList().remove(card);
            }
        }
    }

    public int getCoins() {
        return coins;
    }

    public int setStartHealth() {
//      TODO: health should depends on length of remaining Deck
        int health = this.deck.getCardList().size();
        return health;
    }


    public int getPotCoins() {
        return potCoins;
    }

    public void setPotCoins(int potCoins) {
        this.potCoins = potCoins;
    }

    public List<Card> getPotCards() {
        return potCards;
    }

    public void setPotCards(List<Card> potCards) {
        this.potCards = potCards;
    }

    public void setEmptyPotCards() {
        this.potCards.clear();
    }

    public void addCardToPotCards(Card cardToAdd) {
        this.potCards.add(cardToAdd);
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

    public String toString() {
//        TODO:
        return null;
    }

    public void displayPlayerStatistics() {
//        TODO:
        String[] headers = {"Remaining Cards", "Coins", "Experience", "Level", "Cards in pot"};
        Object[][] data = {
                {this.health, this.coins, this.experience, this.level, this.potCards}
        };
        System.out.println(FlipTableConverters.fromObjects(headers, data));
    }


    public void checkWhoWon(int whoWin, int pot, Player opponent) {
        if (whoWin == 1) {
            System.out.println("Attacker " + this.getName() + " has higher attribute");
            this.addCoins(pot);
            System.out.println("Attacker " + this.getName() + " got " + pot / 2 + " coins");

        } else if (whoWin == 0) {
            // TODO: bets and cards move to another round
            System.out.println("Draw");
//            addCoins(pot / 2);
//            opponent.addCoins(pot / 2);

        } else if (whoWin == -1) {
            System.out.println("Opponent " + opponent.getName() + " has higher attribute");
            opponent.addCoins(pot);
            System.out.println("Opponent " + opponent.getName() + " got " + pot / 2 + " coins");
        } else {
            System.out.println("else");
        }
    }

    public void calculateHealth(int whowin, Card cardAttacker, Card cardOpponent, Player opponent) {
        if (whowin == 1) {
            for (int i = 0; i < this.potCards.size(); i++) {
                this.getDeck().getCardList().add(this.potCards.get(i));
            }
            this.updateHealth();
            opponent.updateHealth();

        } else if (whowin == 0) {
            this.updateHealth();
            opponent.updateHealth();

        } else if (whowin == -1) {
            for (int i = 0; i < opponent.potCards.size(); i++) {
                opponent.getDeck().getCardList().add(opponent.potCards.get(i));
            }
            this.updateHealth();
            opponent.updateHealth();
        }
    }

    public int strFightProcess(Card opponentCard, Card attackerCard, Player opponent, int attackerBet, int opponentBet, int pot, int whoWin) throws FileNotFoundException {
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

        System.out.println(this.getName() + " strength = " + strengthOfAttackerCard);
        System.out.println(opponent.getName() + " strength = " + strengthOfOpponentCard);

        StrengthComparator strengthComparator = new StrengthComparator();

        whoWin = strengthComparator.compare(attackerCard, opponentCard);

        checkWhoWon(whoWin, pot, opponent);

        return whoWin;
    }

    public int intFightProcess(Card opponentCard, Card attackerCard, Player opponent, int attackerBet, int opponentBet, int pot, int whoWin) throws FileNotFoundException {
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

        System.out.println(this.getName() + " intelligence = " + intelligenceOfAttackerCard);
        System.out.println(opponent.getName() + " intelligence = " + intelligenceOfOpponentCard);

        IntelligenceComparator intelligenceComparator = new IntelligenceComparator();

        whoWin = intelligenceComparator.compare(attackerCard, opponentCard);

        checkWhoWon(whoWin, pot, opponent);
        return whoWin;
    }

    public int cunFightProcess(Card opponentCard, Card attackerCard, Player opponent, int attackerBet, int opponentBet, int pot, int whoWin) throws FileNotFoundException {
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

        System.out.println(this.getName() + " cunning = " + cunningOfAttackerCard);
        System.out.println(opponent.getName() + " cunning = " + cunningOfOpponentCard);

        CunningComparator cunningComparator = new CunningComparator();

        whoWin = cunningComparator.compare(attackerCard, opponentCard);

        checkWhoWon(whoWin, pot, opponent);
        return whoWin;
    }

    public int knoFightProcess(Card opponentCard, Card attackerCard, Player opponent, int attackerBet, int opponentBet, int pot, int whoWin) throws FileNotFoundException {
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

        System.out.println(this.getName() + " knowledge = " + knowledgeOfAttackerCard);
        System.out.println(opponent.getName() + " knowledge = " + knowledgeOfOpponentCard);

        KnowledgeComparator knowledgeComparator = new KnowledgeComparator();

        whoWin = knowledgeComparator.compare(attackerCard, opponentCard);

        checkWhoWon(whoWin, pot, opponent);
        return whoWin;
    }

}
