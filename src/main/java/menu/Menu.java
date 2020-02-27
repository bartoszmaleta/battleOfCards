package menu;

import java.util.Scanner;

import menu.*;

public class Menu {
    static Scanner scanner = new Scanner(System.in);

    public static void showMenu() {
        System.out.println("\033[0;37;49mMenu");
        System.out.println("Choose option:");

        System.out.println("1. Play Game with AI");
        System.out.println("2. Exit program");

        MenuFunctions.emptyLinesThree();
    }

    public static void startGame() {
        boolean isRunning = true;

        MenuFunctions.displayWelcomeScreen();

        while (isRunning) {

            showMenu();

            String choosedOption = scanner.nextLine();

            switch (choosedOption) {
            case "1":
                isRunning = false;
                break;
            case "2":
                System.exit(0);
                break;
            default:
                MenuFunctions.clearScreen();
                System.out.println("\nWrong input\n");
            }
        }
        MenuFunctions.clearScreen();
    }
}