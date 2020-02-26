package model;

import java.util.Scanner;

public class PlayerHuman extends Player {
    public PlayerHuman() {
        super("DefaultName", "\uD83E\uDD20");
    }

    @Override
    public void turn() {
//        TODO:
    }

    @Override
    public int bet() {
        int coinsOfBettingPlayer = getCoins();
        if (coinsOfBettingPlayer == 0) {
            System.out.println("You cannot bet - not enough coins.");
            return 0;
        }
        int flag = 0;
        Scanner s = new Scanner(System.in);
        while (flag == 0) {
            System.out.println("Do you want to place bet? y/n");
            switch (s.nextLine()) {
                case "y": {
                    System.out.println("Choose amount of coins you want to bet:");
                    int betAmount = s.nextInt();
                    if (betAmount > coinsOfBettingPlayer) {
                        System.out.println("Not enough coins to place that bet. Try again or quit betting section.\n");
                    } else {
                        return betAmount;
                    }
                }
                case "n": {
                    return 0;
                }
            }
        }
        return 0;
    }
}
