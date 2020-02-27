package menu;

import java.util.Scanner;

import menu.*;

public class Menu {
    static Scanner scanner = new Scanner(System.in);

    public static void showMenu() {
        System.out.println("\033[0;37;49mMenu");
        System.out.println("Choose option:");

        System.out.println("a. Play Game with easy AI");
        System.out.println("b. Play game with hard AI");
        System.out.println("c. Exit program");

        MenuFunctions.emptyLinesThree();
    }

    public static void startGame() {
        boolean isRunning = true;

        MenuFunctions.displayWelcomeScreen();

        while (isRunning) {

            showMenu();

            String choosedOption = scanner.nextLine();

            switch (choosedOption) {
            case "a":
                isRunning = false;
                break;
            case "b":
                isRunning = false;
            case "c":
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