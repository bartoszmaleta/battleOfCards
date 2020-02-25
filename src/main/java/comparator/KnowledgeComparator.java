package comparator;

import model.Card;
import model.CardSpec;

import java.util.Comparator;
import java.util.Map;

public class KnowledgeComparator implements Comparator<Card> {

    @Override
    public int compare(Card o1, Card o2) {
        Map<CardSpec, Integer> o1CardStats = o1.getStats();
        Map<CardSpec, Integer> o2CardStats = o2.getStats();

        for (CardSpec stat : o1CardStats.keySet()) {
            if (stat.getSpecification().equals("Knowledge")) {
                Integer o1Knowledge = o1CardStats.get("Knowledge");
                Integer o2Knowledge = o2CardStats.get("Knowledge");

                if (o1Knowledge > o1Knowledge) {
                    return 1;
                } else if (o1Knowledge == o2Knowledge) {
                    return  0;
                } else if (o1Knowledge < o2Knowledge) {
                    return -1;
                }
            }
        }

        return -10;
    }
}
