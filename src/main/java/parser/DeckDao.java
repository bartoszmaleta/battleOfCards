package parser;

import model.Card;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import repository.Deck;

public class DeckDao extends  XMLParser {
    private Deck deck;

    public DeckDao() {
        this.deck = new Deck();
        loadXmlDocument("src/main/resources/Cards.xml");
        parse();
    }

    public Deck getDeck() {
        return this.deck;
    }

    private void parse() {
        NodeList cardList = doc.getElementsByTagName("Card");
        for (int i = 0; i < cardList.getLength(); i++) {
            Node nNode = cardList.item(i);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;

                String cardID = eElement.getAttribute("name");

                // TODO: Done
                Card newCard = new Card(cardID);
                NodeList stats = eElement.getElementsByTagName("Stat");
                for(int j=0; j < stats.getLength(); j++) {
                    Element stat = (Element) stats.item(j);
                    String cardStatId = stat.getAttribute("id");
                    String cardStatValue = stat.getTextContent();
                    newCard.setCardValueById(cardStatId, Integer.valueOf(cardStatValue));
                }
                deck.addCard(newCard);
            }
        }
    }
}
