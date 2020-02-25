package comparator;

import model.Card;

import java.util.Comparator;
import java.util.Map;

public class KnowledgeComparator implements Comparator<Card> {

    @Override
    public int compare(Card o1, Card o2) {
        Map<String, Integer> o1CardStats = o1.getStats();
        Map<String, Integer> o2CardStats = o2.getStats();

        for (String stat : o1CardStats.keySet()) {
            if (stat.equals("Knowledge")) {
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
