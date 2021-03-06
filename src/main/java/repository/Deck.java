package repository;

import exception.RandomizeDeckException;
import model.Card;
import parser.DeckDaoXML;

import java.util.*;

public class Deck {
    private Iterator<Card> cardIterator;
    private List<Card> cardList;

    // parseWithEnums()
    public Deck(int sizeOfDeck) throws RandomizeDeckException {
        this.cardIterator = new CardIterator();
        this.cardList = new DeckDaoXML(sizeOfDeck).getCardsList();
    }


    public void addCard(Card card) {
        cardList.add(card);
    }

    public List<Card> getCardList() {
        return cardList;
    }

    public void shuffle(List<Card> listToShuffle) {
        Collections.shuffle(listToShuffle);
    }

    public Card getRandomCard() {
        Random rand = new Random();
        return this.getCardList().get(rand.nextInt(this.getCardList().size()));
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