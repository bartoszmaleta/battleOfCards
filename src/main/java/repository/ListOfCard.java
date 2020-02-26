package repository;

import model.Card;

import java.util.ArrayList;
import java.util.List;

public class ListOfCard {
    private List<Card> cardsList;

    public ListOfCard() {
        this.cardsList = new ArrayList<>();
        fillList();
    }

    public void fillList() {
        this.cardsList.add(new Card("TestCard"));
    }
}
