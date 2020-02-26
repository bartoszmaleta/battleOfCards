package model;

import exception.RandomizeDeckException;

public class MainForEnumsTesting {
    public static void main(String[] args) throws RandomizeDeckException {

//        Player player3 = new PlayerHuman();
//
//        String nameOfCard = player3.getDeck().getCardList().get(1).getName();
//
//        System.out.println(nameOfCard);
//
//        String strengthVal = CardSpec.STRENGTH.getSpecification();
//        System.out.println(strengthVal);
        // test


        System.out.println("--------------");
        Player player4 = new PlayerHuman("Bartosz");
        System.out.println(player4.getDeck().getCardList().get(0).getName());;
        System.out.println(player4.getDeck().getCardList().get(0).getStats().keySet().toString());;
        System.out.println(player4.getDeck().getCardList().get(0).getStats().get("Strength"));
        System.out.println(player4.getDeck().getCardList().get(0).getStats().get(CardSpec.STRENGTH.getSpecification()));
        System.out.println(player4.getDeck().getCardList().get(0).getStats().get(CardSpec.STRENGTH));

    }
}
