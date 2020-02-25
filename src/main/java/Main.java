import comparator.StrengthComparator;
import exception.RandomizeDeckException;
import model.Card;
import parser.DeckDao;
import repository.Deck;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args ) throws RandomizeDeckException {
        Deck deck = new DeckDao().randomizeDeck(30);
        for (int i = 0; i < deck.getCardList().size(); i++) {
            System.out.println(deck.getCardList().get(i).getName());

        }

//        deck.getCardList().get(i).getStats()

        System.out.println();
        System.out.println();
        Integer strengthOfFirstCard = deck.getCardList().get(0).getStats().get("Strength");
        System.out.println("1 card = " + strengthOfFirstCard);

        Integer strengthOfSecondCard = deck.getCardList().get(1).getStats().get("Strength");
        System.out.println("2 card = " + strengthOfSecondCard);

        Card firstCard = deck.getCardList().get(0);
        Card secondCard = deck.getCardList().get(1);

        StrengthComparator strengthComparator = new StrengthComparator();
        int result = strengthComparator.compare(firstCard, secondCard);
        System.out.println(result);

    }
}
