import parser.DeckDao;
import repository.Deck;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args )
    {
        Deck deck = new DeckDao().randomizeDeck(10);
        for (int i = 0; i < deck.getCardList().size(); i++) {
            System.out.println(deck.getCardList().get(i).getName());
        }
    }
}
