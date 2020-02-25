package repository;

import model.Card;

import java.util.*;

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

    public Card getRandomCard() {
        Random rand = new Random();
        return this.getCardList().get(rand.nextInt(this.getCardList().size()));
    }
}