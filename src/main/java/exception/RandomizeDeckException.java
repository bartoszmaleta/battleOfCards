package exception;

import java.util.Random;

public class RandomizeDeckException extends Throwable {

    private int numberOfCards;
    private int masterDeckSize;

    public RandomizeDeckException(int numberOfCards, int masterDeckSize) {
        this.numberOfCards = numberOfCards;
        this.masterDeckSize = masterDeckSize;
    }

    public String toString() {
        return "You cannot randomize deck of " + numberOfCards + " cards, because Master Deck has only " + masterDeckSize + " cards. Recalculate";
    }
}
