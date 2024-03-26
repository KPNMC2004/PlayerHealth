package com.pestano;

import com.pestano.data.EnemyList;
import com.pestano.data.WeaponList;
import com.pestano.pkg.entities.Enemy;
import com.pestano.pkg.entities.Player;
import com.pestano.pkg.Weapon;


import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;



public class Main {

    public static void playerChoice(Player player, Enemy enemy, WeaponList weaponList) {
        Scanner playerInput = new Scanner(System.in);

        while (true) {
            String choices =
                    """
                            \n
                    [1] Attack\s
                    [2] Switch Weapon(s)\s
                    [3] Skip\s
                    [4] Shout out your name
                    """;


            int playerChoice;
            while (true) {
                System.out.printf(choices);
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
                    player.attack(enemy);
                    System.out.printf("%s lost %fHP!\n", enemy.getName(), enemy.getWeapon().getWeaponDamage());
                    break;
                case 2:
                    Weapon prevousWeapon = player.getWeapon();
                    System.out.printf("Your weapon is %s!\n", player.getWeapon().getName() );
                    player.setWeapon(pickWeapon(weaponList));
                    System.out.printf("You have swapped your %s for a %s!\n", prevousWeapon.getName(),player.getWeapon().getName());
                    break;
                case 3:
                    System.out.println("You skipped a turn!");
                    break;
                case 4:
                    System.out.printf("You shouted %s!\n", player.getName());
                    continue;
                default:
                    System.out.println("Invalid Input!");
                    continue;
            }
            break;
        }
    }

    public static Weapon pickWeapon(WeaponList weaponList) {
        Scanner input = new Scanner(System.in);
        HashMap<String, Weapon> weaponMap = weaponList.getWeaponsMap();

        String choice;

        do {
            weaponList.printWeapons();
            System.out.print(">> ");
            choice = input.nextLine();

        } while (!weaponMap.containsKey(choice));

        return weaponMap.get(choice);
    }



    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Create instances
        WeaponList weaponsList = new  WeaponList();
        Random random = new Random();

        // Set variables
        String playerName;


            // ask for player name
        System.out.print("Enter you name >> ");
        playerName = input.nextLine();

        System.out.printf("Your name is : %s\n", playerName);

            // ask for weapon
        Weapon playerWeapon = pickWeapon(weaponsList);
        System.out.printf("Your weapon is %s\n", playerWeapon.getName().toLowerCase());
            // ask for spell ability

        //Create player
        Player player = new Player(playerName, 2000, playerWeapon);

        // random enemy encounter
        Enemy enemy = EnemyList.getEnemyTypes().get(random.nextInt(EnemyList.getEnemyTypes().size()));
        System.out.printf("A random %s as appeared!\n", enemy.getName());

        final double maxPlayerHealth = player.health.getHealthPoints();
        final double maxEnemyHealth = enemy.health.getHealthPoints();



        boolean isRunning = true;
        while (isRunning) {
            // player anim (weapon dependant)

            System.out.printf("%s: %.0f / %.0f\n",player.getName(),player.health.getHealthPoints(),maxPlayerHealth);
            System.out.printf("\tPrimary Weapon: %s", player.getWeapon().getName());
            System.out.printf("\tSecondary Weapon: %s", player.getWeapon().getName());

            System.out.print("\n");

            System.out.printf("%s: %.0f / %.0f\n\n",enemy.getName(),enemy.health.getHealthPoints(), maxEnemyHealth);
            System.out.printf("Weapon: %s", enemy.getWeapon().getName());


            // player action
            playerChoice(player,enemy,weaponsList);



                // players wins when enemy health is depleted
            if (enemy.health.getHealthPoints() == 0) {
                System.out.println(
                        """
                                Player Wins!
                        """
                );
                isRunning = false;

            } else {

                // enemy attack
                enemy.attack(player);
                System.out.printf("%s lost %fHP!\n", player.getName(), enemy.getWeapon().getWeaponDamage());

            }

            // enemy anim


                // enemy wins when player health is depleted
            if(player.health.getHealthPoints() == 0) {
                System.out.println(
                        """
                                You Lost!
                        """);
                isRunning = false;
            }
        }



    }
}
