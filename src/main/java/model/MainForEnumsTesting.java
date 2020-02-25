package model;

import exception.RandomizeDeckException;

public class MainForEnumsTesting {
    public static void main(String[] args) throws RandomizeDeckException {

        Player player3 = new PlayerHuman();

        String nameOfCard = player3.getDeck().getCardList().get(1).getName();

        System.out.println(nameOfCard);

        String strengthVal = CardSpec.STRENGTH.getSpecification();
        System.out.println(strengthVal);
        // test

    }
}
