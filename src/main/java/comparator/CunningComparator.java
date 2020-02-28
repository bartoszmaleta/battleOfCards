package comparator;

import model.Card;
import model.CardSpec;

import java.util.Comparator;
import java.util.Map;

public class CunningComparator implements Comparator<Card> {

    @Override
    public int compare(Card o1, Card o2) {
        Map<CardSpec, Integer> o1CardStats = o1.getStats();
        Map<CardSpec, Integer> o2CardStats = o2.getStats();

        Integer o1Cunning = o1CardStats.get(CardSpec.CUNNING);
        Integer o2Cunning = o2CardStats.get(CardSpec.CUNNING);

        if (o1Cunning > o2Cunning) {
            return 1;
        } else if (o1Cunning == o2Cunning) {
            return 0;
        } else if (o1Cunning < o2Cunning) {
            return -1;
        }
        return 10;
    }
}
