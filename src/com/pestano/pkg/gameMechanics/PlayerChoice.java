package com.pestano.pkg.gameMechanics;

import com.pestano.pkg.entities.Player;

import java.util.Scanner;

public interface PlayerChoice {
    default void playerChoice(Player player) {
        Scanner playerInput = new Scanner(System.in);

        while (true) {
            String choices =
                    """
                    \n
                    [1] Attack
                    [2] Skip
                    [3] Shout out your name
                    """;


            int playerChoice;
            while (true) {
                System.out.println(choices);
                System.out.print(">> ");

                try {
                    playerChoice = playerInput.nextInt();
                    break;
                } catch (Exception InputException) {
                    System.out.println("Enter a number!");
                    playerInput.next();
                }
            }

            switch (playerChoice) {
                case 1:
                    player.attack(player.getTarget());
                    break;
                case 2:
                    System.out.println("You skipped a turn!");
                    break;
                case 3:
                    System.out.printf("You shouted %s!\n", player.getName());
                    continue;
                default:
                    System.out.println("Invalid Input!");
                    continue;
            }
            break;
        }
    }
}
