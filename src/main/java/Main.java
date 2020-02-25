import exception.RandomizeDeckException;
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
    }
}
