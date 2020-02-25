package comparator;

import model.Card;

import java.util.Comparator;
import java.util.Map;

public class IntelligenceComparator implements Comparator<Card> {

    @Override
    public int compare(Card o1, Card o2) {
        Map<String, Integer> o1CardStats = o1.getStats();
        Map<String, Integer> o2CardStats = o2.getStats();

        for (String stat : o1CardStats.keySet()) {
            if (stat.equals("Intelligence")) {
                Integer o1Intelligence = o1CardStats.get("Intelligence");
                Integer o2Intelligence = o2CardStats.get("Intelligence");

                if (o1Intelligence > o1Intelligence) {
                    return 1;
                } else if (o1Intelligence == o2Intelligence) {
                    return  0;
                } else if (o1Intelligence < o2Intelligence) {
                    return -1;
                }
            }
        }

        return -10;
    }
}
