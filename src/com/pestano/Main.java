package com.pestano;

import com.pestano.data.EnemyList;
import com.pestano.data.WeaponList;
import com.pestano.pkg.Weapon;
import com.pestano.pkg.entities.Enemy;
import com.pestano.pkg.entities.Player;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;



public class Main {

    public static Weapon pickWeapon(WeaponList weaponList) {
        Scanner input = new Scanner(System.in);
        HashMap<String, Weapon> weaponMap = weaponList.getWeaponsMap();

        String choice;

        do {
            weaponList.printWeapons();
            System.out.print(">> ");
            choice = input.nextLine().substring(0,3).toUpperCase();

        } while (!weaponMap.containsKey(choice));

        return weaponMap.get(choice);
    }

    public static Player classSelector() {

    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Create instances
        WeaponList weaponsList = new  WeaponList();
        EnemyList enemyList = new EnemyList();
        Random random = new Random();

        // Set variables
        String playerName;
w

            // ask for player name
        System.out.print("\n\nEnter you name >> ");
        playerName = input.nextLine();

        System.out.printf("Your name is : %s\n", playerName);

            // ask for weapon
        Weapon playerWeapon = pickWeapon(weaponsList);
        System.out.printf("Your weapon is %s\n", playerWeapon.getName().toLowerCase());
            // ask for spell ability

        //Create player
        Player player = classSelector();

        // random enemy encounter
        Enemy enemy = enemyList.getEnemyTypes().get(random.nextInt(enemyList.getEnemyTypes().size()));
        System.out.printf("A random %s as appeared!\n", enemy.getName());

        boolean isRunning = true;
        while (isRunning) {
            // player anim (weapon dependant)

            // Draw Entity Names
            System.out.print("\n");
            System.out.printf("%-16s",player.getName());
            System.out.printf("%32s",enemy.getName());

            // Draw Health Info
            System.out.print("\n");
            System.out.printf("%4.2f / %4.2f",player.getHealth().getHealthPoints(),player.getHealth().getMaxHealth());
            System.out.printf("%21.2f / %4.2f",enemy.getHealth().getHealthPoints(), player.getHealth().getMaxHealth());

            // Draw Weapon info
            System.out.print("\n");
            System.out.printf("\tPrimary Weapon: %-8s", player.getWeapon().getName());
            System.out.printf("%8s :Weapon", enemy.getWeapon().getName());
            System.out.printf("\n\tSecondary Weapon: %-8s", player.getWeapon().getName());



            // player action
            player.playerChoice(player,enemy,weaponsList);



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
                System.out.printf("%s lost %.2fHP!\n", player.getName(), enemy.getWeapon().getWeaponDamage());

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
        }



    }
}
