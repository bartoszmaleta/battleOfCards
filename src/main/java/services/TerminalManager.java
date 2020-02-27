package services;

import java.util.Scanner;

public class TerminalManager {
    private static Scanner scanner = new Scanner(System.in);

    public static String repeatString(String c, int times){
        StringBuffer b = new StringBuffer();

        for(int i = 0; i <= times + 1; i++){
            b.append(c);
        }

        return b.toString();
    }

    public static void pressAnyKeyToContinue() {
        System.out.println("\n\n-----------------------------");
        System.out.println("| Press any key to continue |");
        System.out.println("-----------------------------");
        scanner.nextLine();
    }

    public static void displayWelcomeScreen() {
        emptyLinesThree();
        System.out.println("\n\n\n\n\n\n");
        System.out.println("Produced by: ");
        System.out.println("Bartosz Maleta");
        System.out.println("Szymon Niemiec");
        System.out.println("Przemysław Buszek\n\n\n");
//        emptyLinesThree();
        pressAnyKeyToContinue();
//        clearScreen();
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void emptyLinesThree() {
        System.out.println("\n\n");
    }

    public static void thirtyLines() {
        for (int i = 0; i < 30; i++) {
            System.out.println();
        }
    }

    public static void showMenu() {
        System.out.println("\033[0;37;49mMenu");
        System.out.println("Choose option");

        System.out.println("1. Play PVP");
        System.out.println("2. Play PvAi");
        System.out.println("3. ");
        System.out.println("4. ");
        System.out.println("5. ");
        System.out.println("6. ");
        System.out.println("7. Exit program");

    }

    public static void blankLines(int numberOfBlankLines) {
        StringBuffer result = new StringBuffer();

        for (int i = 1; i < numberOfBlankLines; i++) {
            String blankLine = "\n";
            result.append(blankLine);
        }
        System.out.println(result);
        // return result;

    }
}