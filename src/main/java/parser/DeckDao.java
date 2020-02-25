package parser;

import model.Card;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import repository.Deck;

import java.util.ArrayList;
import java.util.List;

public class DeckDao extends XMLParser {

    private Deck masterDeck;

    public DeckDao() {
        this.masterDeck = new Deck();
        loadXmlDocument("src/main/resources/Cards.xml");
        parse();
    }

    public Deck getMasterDeck() {
        return this.masterDeck;
    }

    private void parse() {
        NodeList cardList = doc.getElementsByTagName("Card");
        for (int i = 0; i < cardList.getLength(); i++) {
            Node nNode = cardList.item(i);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;

                String cardID = eElement.getAttribute("id");

                // TODO: Done
                Card newCard = new Card(cardID);
                NodeList stats = eElement.getElementsByTagName("Stat");
                for (int j = 0; j < stats.getLength(); j++) {
                    Element stat = (Element) stats.item(j);
                    String cardStatId = stat.getAttribute("id");
                    String cardStatValue = stat.getTextContent();
                    newCard.setCardValueById(cardStatId, Integer.parseInt(cardStatValue));
                }
                masterDeck.addCard(newCard);
            }
        }
    }

    public Deck randomizeDeck(int numberOfCards) {
        List<Card> masterDeckList = masterDeck.getCardList();

        Deck deck = new Deck();

        List<Integer> usedIndexList = new ArrayList<>();

        while (deck.getCardList().size() < numberOfCards) {
            int cardIndex = (int) (Math.random() * (masterDeckList.size() - 1) + 0);
            if (!usedIndexList.contains(cardIndex)) {
                usedIndexList.add(cardIndex);
                deck.addCard(masterDeckList.get(cardIndex));
            }
        }
        return deck;
    }

//    public Deck randomizeDeck(int numberOfCards) {
//        List<Card> masterDeckList = masterDeck.getCardList();
//
//        Deck deck = new Deck();
//
//        List<Integer> usedIndexList = new ArrayList<>();
//
//        while (deck.getCardList().size() < numberOfCards) {
//            int cardIndex = (int) (Math.random() * (masterDeckList.size() - 1) + 0);
//            if (!usedIndexList.contains(cardIndex)) {
//                usedIndexList.add(cardIndex);
//            } else {
//                if (cardIndex == 100) {
//                    cardIndex = 0;
//                }
//                while (usedIndexList.contains(cardIndex)) {
//                    cardIndex++;
//                }
//            }
//            deck.addCard(masterDeckList.get(cardIndex));
//        }
//        return deck;
//    }
}
