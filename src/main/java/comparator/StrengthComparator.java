package comparator;

import model.Card;
import model.CardSpec;

import java.util.Comparator;
import java.util.Map;

public class StrengthComparator implements Comparator<Card> {


    @Override
    public int compare(Card o1, Card o2) {
        Map<CardSpec, Integer> o1CardStats = o1.getStats();
        Map<CardSpec, Integer> o2CardStats = o2.getStats();

        for (CardSpec stat : o1CardStats.keySet()) {
            if (stat.getSpecification().equals("Strength")) {
                Integer o1Strength = o1CardStats.get(CardSpec.STRENGTH);
                Integer o2Strength = o2CardStats.get(CardSpec.STRENGTH);

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
