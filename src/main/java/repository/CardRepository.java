package repository;

import model.Card;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CardRepository {
    private Iterator<Card> cardIterator;
    private List<Card> cardList;

    public CardRepository() {
        this.cardIterator = new CardIterator();
        this.cardList = new ArrayList<>();
    }

    public void addCard(Card card) {
        cardList.add(card);
    }

    private class CardIterator implements Iterator<Card> {
        int index = 0;


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
