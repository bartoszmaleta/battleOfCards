package comparator;

import model.Card;

import java.util.Comparator;
import java.util.Map;

public class StrengthComparator implements Comparator<Card> {


    @Override
    public int compare(Card o1, Card o2) {
        Map<String, Integer> o1CardStats = o1.getStats();
        Map<String, Integer> o2CardStats = o2.getStats();

        for (String stat : o1CardStats.keySet()) {
            if (stat.equals("Strength")) {
                Integer o1Strength = o1CardStats.get("Strength");
                Integer o2Strength = o2CardStats.get("Strength");

                if (o1Strength > o2Strength) {
                    return 1;
                } else if (o1Strength == o2Strength) {
                    return  0;
                } else if (o1Strength < o2Strength) {
                    return -1;
                }
            }
        }

        return -10;
    }

}
