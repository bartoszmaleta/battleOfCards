//package parser;
//
//import exception.RandomizeDeckException;
//import model.Card;
//import org.w3c.dom.Document;
//import org.w3c.dom.Element;
//import org.w3c.dom.Node;
//import org.w3c.dom.NodeList;
//import org.xml.sax.SAXException;
//import repository.Deck;
//
//import javax.xml.parsers.DocumentBuilder;
//import javax.xml.parsers.DocumentBuilderFactory;
//import javax.xml.parsers.ParserConfigurationException;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.*;
//import java.util.concurrent.ThreadLocalRandom;
//
//public class DeckDaoXMLBackUp {
//    private Document doc;
//    private Deck masterDeck;
//
//    public DeckDaoXMLBackUp() {
//        this.masterDeck = new Deck();
//        loadXmlDocument("src/main/resources/Cards.xml");
//        parse();
//    }
//
//    public void loadXmlDocument(String xmlPath) {
//        try {
//            File xmlFile = new File(xmlPath);
//            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
//            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
//            doc = dBuilder.parse(xmlFile);
//            doc.getDocumentElement().normalize();
//        } catch (FileNotFoundException e) {
//            System.out.println("File not found");
//        } catch (IOException e) {
//            System.out.println("Failed read attempt");
//        } catch (ParserConfigurationException | SAXException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public Deck getMasterDeck() {
//        return this.masterDeck;
//    }
//
//    private void parse() {
//        NodeList cardList = doc.getElementsByTagName("Card");
//        for (int i = 0; i < cardList.getLength(); i++) {
//            Node nNode = cardList.item(i);
//            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
//                Element eElement = (Element) nNode;
//
//                String cardID = eElement.getAttribute("name");
//
//                Card newCard = new Card(cardID);
//                NodeList stats = eElement.getElementsByTagName("Stat");
//                for (int j = 0; j < stats.getLength(); j++) {
//                    Element stat = (Element) stats.item(j);
//                    String cardStatId = stat.getAttribute("id");
//                    String cardStatValue = stat.getTextContent();
//                    newCard.setCardValueById(cardStatId, Integer.valueOf(cardStatValue));
//                }
//                masterDeck.addCard(newCard);
//            }
//        }
//    }
//
//    public Deck randomizeDeck(int numberOfCards) throws RandomizeDeckException {
//        List<Card> masterDeckList = masterDeck.getCardList();
//
//        if (numberOfCards > masterDeckList.size()) {
//            throw new RandomizeDeckException(numberOfCards, masterDeckList.size());
//        }
//
//        Deck deck = new Deck();
//
//        Collections.shuffle(masterDeckList);
//
//        for (int i = 0; i < numberOfCards; i++) {
//            deck.addCard(masterDeckList.get(i));
//        }
//        return deck;
//    }
//
////    public Deck randomizeDeck(int numberOfCards) {
////        List<Card> masterDeckList = masterDeck.getCardList();
////
////        Deck deck = new Deck();
////
////        Set<Integer> indexSet = new HashSet<>();
////
////        while (indexSet.size() < numberOfCards) {
////            int randomNum = ThreadLocalRandom.current().nextInt(0, masterDeckList.size());
////            indexSet.add(randomNum);
////        }
////
////        for (int index : indexSet) {
////            deck.addCard(masterDeckList.get(index));
////        }
////        return deck;
////    }
//
////    public Deck randomizeDeck(int numberOfCards) {
////        List<Card> masterDeckList = masterDeck.getCardList();
////
////        Deck deck = new Deck();
////
////        List<Integer> usedIndexList = new ArrayList<>();
////
////        while (deck.getCardList().size() < numberOfCards) {
////            int cardIndex = (int) (Math.random() * (masterDeckList.size() - 1) + 0);
////            if (!usedIndexList.contains(cardIndex)) {
////                usedIndexList.add(cardIndex);
////                deck.addCard(masterDeckList.get(cardIndex));
////            }
////        }
////        return deck;
////    }
//
////    public Deck randomizeDeck(int numberOfCards) {
////        List<Card> masterDeckList = masterDeck.getCardList();
////
////        Deck deck = new Deck();
////
////        List<Integer> usedIndexList = new ArrayList<>();
////
////        while (deck.getCardList().size() < numberOfCards) {
////            int cardIndex = (int) (Math.random() * (masterDeckList.size() - 1) + 0);
////            if (!usedIndexList.contains(cardIndex)) {
////                usedIndexList.add(cardIndex);
////            } else {
////                if (cardIndex == 100) {
////                    cardIndex = 0;
////                }
////                while (usedIndexList.contains(cardIndex)) {
////                    cardIndex++;
////                }
////            }
////            deck.addCard(masterDeckList.get(cardIndex));
////        }
////        return deck;
////    }
//}
