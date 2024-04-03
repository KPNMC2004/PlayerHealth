package com.pestano;

import com.pestano.data.EnemyList;
import com.pestano.pkg.entities.Enemy;
import com.pestano.pkg.entities.Player;
import com.pestano.player.Archer;
import com.pestano.player.Knight;

import java.util.Random;
import java.util.Scanner;


public class Main {
    private static int turns = 1;
    public static void enumerateTurn() {
        turns++;
    }
    public static Player classSelector(String name) {
        Scanner input = new Scanner(System.in);

        String classOptions = """
                                Pick your class:
                                    [1] Archer
                                    [2] Knight
                                """;

        while (true) {
            System.out.print(classOptions);
            System.out.print(">> ");
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("You have chosen the Archer!");
                    return new Archer(name);
                case 2:
                    System.out.println("You have chosen the Knight!");
                    return new Knight(name);
                default:
                    System.out.println("Not an option!");

            }
        }

    }

    public static void gameLoop(Player player, Enemy enemy) {

        player.setTarget(enemy);

        System.out.printf("A random %s as appeared!\n", enemy.getName());

        boolean isRunning = true;
        while (isRunning) {

            // Draw Game Info
            System.out.printf("Turn: %d", turns);

            // Draw Entity Names
            System.out.print("\n");
            System.out.printf("%-16s",player.getName());
            System.out.printf("%32s",enemy.getName());

            // Draw Health Info
            System.out.print("\n");
            System.out.printf("%4.2f / %4.2f",player.getHealth().getHealthPoints(),player.getHealth().getMaxHealthPoints());
            System.out.printf("%21.2f / %4.2f",enemy.getHealth().getHealthPoints(), enemy.getHealth().getMaxHealthPoints());

            // Draw Weapon info
            System.out.print("\n");
            System.out.printf("\tWeapon: %-8s", player.getWeapon().getName());
            System.out.printf("%8s :Weapon", enemy.getWeapon().getName());
            System.out.printf("\n\tSpell: %-8s", player.getSpell().getName());

            // player action
            player.playerChoice(player);



            // players wins when enemy health is depleted
            if (enemy.getHealth().getHealthPoints() <= 0) {
                System.out.println(
                        """
                                Player Wins!
                        """
                );
                isRunning = false;

            } else {

                // enemy attack
                enemy.attack(player);
                System.out.printf("The %s has inflicted %s with %.2f damage!\n", enemy.getName().toLowerCase(), player.getName(), enemy.getWeapon().getWeaponDamage());

            }

            // enemy anim


            // enemy wins when player health is depleted
            if(player.getHealth().getHealthPoints() <= 0) {
                System.out.println(
                        """
                                You Lost!
                        """);
                isRunning = false;
            }

            enumerateTurn();
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Create instances
        EnemyList enemyList = EnemyList.EnemyList();
        Random random = new Random();

        // Set variables
        String playerName;
        String choice;


        // print logo
        System.out.println("""
                 
                 ______  __ __   ____  ______       ___   ____     ___       ____   ____  ___ ___    ___\s
                |      ||  |  | /    ||      |     /   \\ |    \\   /  _]     /    | /    ||   |   |  /  _]
                |      ||  |  ||  o  ||      |    |     ||  _  | /  [_     |   __||  o  || _   _ | /  [_\s
                |_|  |_||  _  ||     ||_|  |_|    |  O  ||  |  ||    _]    |  |  ||     ||  \\_/  ||    _]
                  |  |  |  |  ||  _  |  |  |      |     ||  |  ||   [_     |  |_ ||  _  ||   |   ||   [_\s
                  |  |  |  |  ||  |  |  |  |      |     ||  |  ||     |    |     ||  |  ||   |   ||     |
                  |__|  |__|__||__|__|  |__|       \\___/ |__|__||_____|    |___,_||__|__||___|___||_____|
                                                                                                        \s
                """);
        System.out.println("""
                    ______          _   __       _       _    _                ______           _                      \s
                    | ___ \\        | | / /      (_)     | |  (_)               | ___ \\         | |                     \s
                    | |_/ / _   _  | |/ /  _ __  _  ___ | |_  _   __ _  _ __   | |_/ /___  ___ | |_  __ _  _ __    ___ \s
                    | ___ \\| | | | |    \\ | '__|| |/ __|| __|| | / _` || '_ \\  |  __// _ \\/ __|| __|/ _` || '_ \\  / _ \\\s
                    | |_/ /| |_| | | |\\  \\| |   | |\\__ \\| |_ | || (_| || | | | | |  |  __/\\__ \\| |_| (_| || | | || (_) |
                    \\____/  \\__, | \\_| \\_/|_|   |_||___/ \\__||_| \\__,_||_| |_| \\_|   \\___||___/ \\__|\\__,_||_| |_| \\___/\s
                             __/ |                                                                                     \s
                            |___/                                                                                      \s
                """);

        // ask for player name
        System.out.print("\nEnter you name >> ");
        playerName = input.nextLine();

        System.out.printf("Your name is : %s\n", playerName);

        //Create player
        Player player = classSelector(playerName);

        // Randomly select enemy
        Enemy enemy = enemyList.getEnemyTypes().get(random.nextInt(enemyList.getEnemyTypes().size()));

        // Game Loop
        while (true) {
            gameLoop(player, enemy);
            System.out.printf("You finished with %d turns!\n", turns);

            // Play again
            while (true) {
                System.out.print("Do you want to play again? [yes, no] >> ");
                choice = input.nextLine().toLowerCase();
                if (choice.equals("yes") | choice.equals("no")) {
                    break;
                }
                System.out.println("Invalid input!");
            }


            if (choice.equals("no")) {
                System.out.println("You have ended this game.");
                break;
            }
        }
    }
}
