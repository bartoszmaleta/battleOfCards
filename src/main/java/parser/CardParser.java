package parser;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import repository.CardRepository;

public class CardParser extends  XMLParser {
    private CardRepository cardRepository;

    public CardParser() {
        this.cardRepository = new CardRepository();
        loadXmlDocument("src/main/resources/Facts.xml");
        parse();
    }

    public CardRepository getCardRepository() {
        return this.cardRepository;
    }

    private void parse() {
        NodeList factList = doc.getElementsByTagName("Fact");
        for (int i = 0; i < factList.getLength(); i++) {
            Node nNode = factList.item(i);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;

                String factID = eElement.getAttribute("id");
                String factDescription = eElement.getChildNodes()
                        .item(1)
                        .getAttributes()
                        .item(0)
                        .getTextContent();

                // Another option
//                String factDescription2 = eElement.getElementsByTagName("Description")
//                        .item(0)
//                        .getAttributes()
//                        .getNamedItem("value")
//                        .getTextContent();
//

                // TODO
                Fact newFact = new Fact(factID, factDescription);
                NodeList evals = eElement.getElementsByTagName("Eval");
                for(int j=0;j<evals.getLength();j++) {
                    Element eval = (Element) evals.item(j);
                    String factEvalId = eval.getAttribute("id");
                    String factEvalValue = eval.getTextContent();
                    newFact.setFactValueById(factEvalId, Boolean.valueOf(factEvalValue));
                }
                factRepository.addFact(newFact);
            }
        }
    }
}
