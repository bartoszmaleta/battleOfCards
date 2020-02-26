package model;

import com.jakewharton.fliptables.FlipTable;
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

        Integer asd = player4.getDeck().getCardList().get(0).getStats().get(CardSpec.STRENGTH);
        System.out.println(asd);
        String qwe = Integer.toString(asd);

        String[] headers = { "Test", "Header" };
        String[][] data = {
                { qwe, "Bar" },
                { "Kit", "Kat" },
        };
        System.out.println(FlipTable.of(headers, data));

    }
}
