package services;

import com.github.tomaslanger.chalk.Chalk;
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
        // 21 signs max

        Scanner input = new Scanner(new File(filepath));

        String dataInString = "";

        while (input.hasNextLine()) {
            dataInString += input.nextLine() + "\n";
        }

        Integer strengthInt = card.getStats().get(CardSpec.STRENGTH);
        Integer knowledgeInt = card.getStats().get(CardSpec.KNOWLEDGE);
        Integer intelligenceInt = card.getStats().get(CardSpec.INTELLIGENCE);
        Integer cunningInt = card.getStats().get(CardSpec.CUNNING);
        String strengthOfCard;
        String knowledgeOfCard;
        String intelligenceOfCard;
        String cunningOfCard;

        if (strengthInt < 10) {
            strengthOfCard = "0" + Integer.toString(card.getStats().get(CardSpec.STRENGTH));
        } else {
            strengthOfCard = Integer.toString(card.getStats().get(CardSpec.STRENGTH));
        }

        if (knowledgeInt < 10) {
            knowledgeOfCard = "0" + Integer.toString(card.getStats().get(CardSpec.KNOWLEDGE));
        } else {
            knowledgeOfCard = Integer.toString(card.getStats().get(CardSpec.KNOWLEDGE));
        }

        if (intelligenceInt < 10) {
            intelligenceOfCard = "0" + Integer.toString(card.getStats().get(CardSpec.INTELLIGENCE));
        } else {
            intelligenceOfCard = Integer.toString(card.getStats().get(CardSpec.INTELLIGENCE));
        }

        if (cunningInt < 10) {
            cunningOfCard = "0" + Integer.toString(card.getStats().get(CardSpec.CUNNING));
        } else {
            cunningOfCard = Integer.toString(card.getStats().get(CardSpec.CUNNING));
        }
//
//        String strengthOfCard = Integer.toString(card.getStats().get(CardSpec.STRENGTH));
//        String knowledgeOfCard = Integer.toString(card.getStats().get(CardSpec.KNOWLEDGE));
//        String intelligenceOfCard = Integer.toString(card.getStats().get(CardSpec.INTELLIGENCE));
//        String cunningOfCard = Integer.toString(card.getStats().get(CardSpec.CUNNING));

        dataInString = dataInString.replaceAll("#", String.valueOf(Chalk.on("#").red().bgRed()));
        String nameOfCard = card.getName();
        dataInString = dataInString.replaceAll("88888888888888888888", String.valueOf(Chalk.on(nameOfCard).bold().green()));
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
//            System.out.print(Color.CYAN);
            System.out.println(input.nextLine());
        }
//        System.out.println(Color.RESET);
    }
}