package repository;

import model.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Deck {
    private Iterator<Card> cardIterator;
    private List<Card> cardList;

    public Deck() {
        this.cardIterator = new CardIterator();
        this.cardList = new ArrayList<>();
    }

    public void addCard(Card card) {
        cardList.add(card);
    }

    public List<Card> getCardList() {
        return cardList;
    }

    public void shuffle() {
        Collections.shuffle(cardList);
    }

    private class CardIterator implements Iterator<Card> {
        int index = 0;

        @Override
        public void remove() {

        }

        @Override
        public boolean hasNext() {
            return index < cardList.size();
        }

        @Override
        public Card next() {
            return hasNext() ? cardList.get(index++) : null;
        }
    }
}
