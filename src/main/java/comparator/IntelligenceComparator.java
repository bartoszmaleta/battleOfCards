package comparator;

import model.Card;
import model.CardSpec;

import java.util.Comparator;
import java.util.Map;

public class IntelligenceComparator implements Comparator<Card> {

    @Override
    public int compare(Card o1, Card o2) {
        Map<CardSpec, Integer> o1CardStats = o1.getStats();
        Map<CardSpec, Integer> o2CardStats = o2.getStats();

        Integer o1Intelligence = o1CardStats.get(CardSpec.INTELLIGENCE);
        Integer o2Intelligence = o2CardStats.get(CardSpec.INTELLIGENCE);

        if (o1Intelligence > o2Intelligence) {
            return 1;
        } else if (o1Intelligence == o2Intelligence) {
            return 0;
        } else if (o1Intelligence < o2Intelligence) {
            return -1;
        }
        return 10;
    }
}
