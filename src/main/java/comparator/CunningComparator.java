package comparator;

import model.Card;

import java.util.Comparator;
import java.util.Map;

public class CunningComparator implements Comparator<Card> {
    @Override
    public int compare(Card o1, Card o2) {
        Map<String, Integer> o1CardStats = o1.getStats();
        Map<String, Integer> o2CardStats = o2.getStats();

        for (String stat : o1CardStats.keySet()) {
            if (stat.equals("Cunning")) {
                Integer o1Cunning = o1CardStats.get("Cunning");
                Integer o2Cunning = o2CardStats.get("Cunning");

                if (o1Cunning > o1Cunning) {
                    return 1;
                } else if (o1Cunning == o2Cunning) {
                    return  0;
                } else if (o1Cunning < o2Cunning) {
                    return -1;
                }
            }
        }

        return -10;
    }
}
