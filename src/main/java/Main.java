import comparator.StrengthComparator;
import controller.Game;
import exception.RandomizeDeckException;
import model.Card;
import model.CardSpec;
import model.Player;
import model.PlayerHuman;
import parser.DeckDaoXML;
import repository.Deck;

public class Main
{
    public static void main( String[] args ) throws RandomizeDeckException {
        Game game = new Game();
        game.init();
        game.play();


        //        Deck deck = new DeckDaoXML().randomizeDeck(30);
//        for (int i = 0; i < deck.getCardList().size(); i++) {
//            System.out.println(deck.getCardList().get(i).getName());
//
//        }


        Deck deck = new Deck(30);

//        System.out.println();
//        System.out.println();
//        Integer strengthOfFirstCard = deck.getCardList().get(0).getStats().get(CardSpec.STRENGTH);
//        System.out.println("1 card = " + strengthOfFirstCard);
//
//        Integer strengthOfSecondCard = deck.getCardList().get(1).getStats().get(CardSpec.STRENGTH);
//        System.out.println("2 card = " + strengthOfSecondCard);
//
//        Card firstCard = deck.getCardList().get(0);
//        Card secondCard = deck.getCardList().get(1);
//
//        StrengthComparator strengthComparator = new StrengthComparator();
//        int result = strengthComparator.compare(firstCard, secondCard);
//        System.out.println(result);
//
//        System.out.println("--------------------------------- Testing attacks");

        Player player1 = new PlayerHuman("Andrzej");
        Player player2 = new PlayerHuman("Stefan");

        player1.attack(player2);


    }
}
