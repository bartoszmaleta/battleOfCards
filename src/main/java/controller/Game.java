package controller;

import exception.RandomizeDeckException;
import services.DataHandler;
import services.TerminalManager;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Game {
    private Table table;

    public Game() throws RandomizeDeckException, FileNotFoundException {
        init();
    }

    public void optionPvP() throws RandomizeDeckException, FileNotFoundException {
        table = new Table(2);

    }

    public void optionPvAi() throws RandomizeDeckException, FileNotFoundException {
        table = new Table(1);
    }

    public void init() throws RandomizeDeckException, FileNotFoundException {
        boolean isRunning = true;

        TerminalManager.displayWelcomeScreen();
        DataHandler.printFromFile("src/main/java/graphic.txt/WelcomeScreen.txt");
        // Menu
        Scanner scanner = new Scanner(System.in);

        while (isRunning) {
            System.out.println("while (isRunning)");

            TerminalManager.showMenu();

            String chooseOption = scanner.nextLine();

            switch (chooseOption) {
                case "1":
                    optionPvP();
                    break;
                case "2":
                    optionPvAi();
                    break;
                case "7":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong input");

            }
        }
    }
}
