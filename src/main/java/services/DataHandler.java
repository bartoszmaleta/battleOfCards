package services;

import model.Card;
import model.CardSpec;
import model.Player;
import model.PlayerStat;
import repository.Deck;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DataHandler {
    public static void main(String[] args) throws FileNotFoundException {
        displayTable();
    }

    public static String stringFromFileWithSpecifiedCard(String filepath, Card card) throws FileNotFoundException {
        TerminalManager.clearScreen();

        Scanner input = new Scanner(new File(filepath));

        String dataInString = "";

        while (input.hasNextLine()) {
            dataInString += input.nextLine() + "\n";
        }

//        System.out.println(dataInString);
        String strengthOfCard = Integer.toString(card.getStats().get(CardSpec.STRENGTH));
        String knowledgeOfCard = Integer.toString(card.getStats().get(CardSpec.KNOWLEDGE));
        String intelligenceOfCard = Integer.toString(card.getStats().get(CardSpec.INTELLIGENCE));
        String cunningOfCard = Integer.toString(card.getStats().get(CardSpec.CUNNING));

        dataInString = dataInString.replaceAll("11", strengthOfCard);
        dataInString = dataInString.replaceAll("22", knowledgeOfCard);
        dataInString = dataInString.replaceAll("33", intelligenceOfCard);
        dataInString = dataInString.replaceAll("44", cunningOfCard);

        return dataInString;
    }

    public static void printTableWithSpecifiedCard(Card card) throws FileNotFoundException {
        String filepath = "src/main/resources/table.txt";
        String tableWithCard = stringFromFileWithSpecifiedCard(filepath, card);

        System.out.println(tableWithCard);
    }


    public static void displayTable() throws FileNotFoundException {
        String filepath = "src/main/resources/table.txt";
//        String table = stringFromFile(filepath);

//        System.out.println(table);
    }

    public static void printFromFile(String filepath) throws FileNotFoundException {
        TerminalManager.clearScreen();

        Scanner input = new Scanner(new File(filepath));

        while (input.hasNextLine()) {
            System.out.print(Color.CYAN);
            System.out.println(input.nextLine());
        }
        System.out.println(Color.RESET);
    }
}