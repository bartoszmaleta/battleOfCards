package model;

import com.jakewharton.fliptables.FlipTable;
import exception.RandomizeDeckException;
import services.TerminalManager;

public class MainForEnumsTesting {
    public static void main(String[] args) throws RandomizeDeckException, InterruptedException {

//        Player player3 = new PlayerHuman();
//
//        String nameOfCard = player3.getDeck().getCardList().get(1).getName();
//
//        System.out.println(nameOfCard);
//
//        String strengthVal = CardSpec.STRENGTH.getSpecification();
//        System.out.println(strengthVal);
        // test

//
//        System.out.println("--------------");
//        Player player4 = new PlayerHuman("Bartosz");
//        System.out.println(player4.getDeck().getCardList().get(0).getName());;
//        System.out.println(player4.getDeck().getCardList().get(0).getStats().keySet().toString());;
//        System.out.println(player4.getDeck().getCardList().get(0).getStats().get("Strength"));
//        System.out.println(player4.getDeck().getCardList().get(0).getStats().get(CardSpec.STRENGTH.getSpecification()));
//        System.out.println(player4.getDeck().getCardList().get(0).getStats().get(CardSpec.STRENGTH));
//
//        Integer asd = player4.getDeck().getCardList().get(0).getStats().get(CardSpec.STRENGTH);
//        System.out.println(asd);
//        String qwe = Integer.toString(asd);
//
//        String[] headers = { "Test", "Header" };
//        String[][] data = {
//                { qwe, "Bar" },
//                { "Kit", "Kat" },
//        };
//
//        TerminalManager.pressAnyKeyToContinue();
//        TerminalManager.clearScreen();
//        System.out.println(FlipTable.of(headers, data));

        Player player = new PlayerHuman("Andrzej");
        String name = player.getDeck().getCardList().get(0).getName();
        System.out.println("name =" + name);
        System.out.println(player.getApparel());
        Player player12 = new PlayerHuman("qwe");
        Card card = player12.getDeck().getRandomCard();

        player.addCardToPotCards(card);

        System.out.println(player.potCardsToString());
//        System.out.println(🤠"\\uD83E\\uDD20");
//        System.out.println("\uD83E\uDD96");


//        String loader = "[";
//        for (int i = 0; i < 20; i++) {
//            System.out.println(loader);
//            loader += "=";
//            Thread.sleep(250);
//            TerminalManager.blankLines(100);
//            Thread.sleep(250);
////            TerminalManager.clearScreen();
//        }
//        System.out.println(loader + "]");

    }
}
