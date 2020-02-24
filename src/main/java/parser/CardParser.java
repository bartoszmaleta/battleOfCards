package parser;

import model.Card;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import repository.CardRepository;

public class CardParser extends  XMLParser {
    private CardRepository cardRepository;

    public CardParser() {
        this.cardRepository = new CardRepository();
        loadXmlDocument("src/main/resources/Cards.xml");
        parse();
    }

    public CardRepository getCardRepository() {
        return this.cardRepository;
    }

    private void parse() {
        NodeList cardList = doc.getElementsByTagName("Card");
        for (int i = 0; i < cardList.getLength(); i++) {
            Node nNode = cardList.item(i);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;

                String cardID = eElement.getAttribute("id");

                // Another option
//                String factDescription2 = eElement.getElementsByTagName("Description")
//                        .item(0)
//                        .getAttributes()
//                        .getNamedItem("value")
//                        .getTextContent();
//

                // TODO: Done???
                Card newCard = new Card(cardID);
                NodeList stats = eElement.getElementsByTagName("Stat");
                for(int j=0; j < stats.getLength(); j++) {
                    Element stat = (Element) stats.item(j);
                    String cardStatId = stat.getAttribute("id");
                    String cardStatValue = stat.getTextContent();
                    newCard.setCardValueById(cardStatId, Integer.valueOf(cardStatValue));
                }
                cardRepository.addCard(newCard);
            }
        }
    }
}
