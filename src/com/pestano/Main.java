package com.pestano;

import com.pestano.pkg.entities.Enemy;
import com.pestano.pkg.entities.Player;
import com.pestano.pkg.Weapon;

import java.util.Scanner;


public class Main {

    public static void playerChoice(Player player, Enemy enemy, Weapon[] weapons) {
        Scanner playerInput = new Scanner(System.in);

        while (true) {
            String choices =
                    """
                            \n
                    [1] Attack\s
                    [2] Switch Weapon\s
                    [3] Skip\s
                    [4] Shout out your name
                    """;

            System.out.printf(choices);
            System.out.print(">> ");
            int playerChoice = playerInput.nextInt();

            switch (playerChoice) {
                case 1:
                    player.attack(enemy);
                    System.out.printf("%s lost %fHP!\n", enemy.getName(), enemy.getWeapon().getWeaponDamage());
                    break;
                case 2:
                    Weapon prevousWeapon = player.getWeapon();
                    System.out.printf("Your weapon is %s!", player.getWeapon().getWeaponName() );
                    player.setWeapon(pickWeapon(weapons));
                    System.out.printf("You have swapped your %s for a %s!\n", prevousWeapon.getWeaponName(),player.getWeapon().getWeaponName());
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

    public static Weapon pickWeapon(Weapon[] weaponList) {
        Scanner input = new Scanner(System.in);
        Weapon weapon;

        for(int i = 0; i < weaponList.length; i++) {
            weapon = weaponList[i];
            System.out.println(i + ": " + weapon.getWeaponName() + ":" + weapon.getWeaponDamage());
        }

       return  weaponList[input.nextInt() - 1];
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        SampleData sampleData = new SampleData();

        // Create instances
        Player player = new Player(sampleData.getWeaponList()[0]);

        // Set variables

        // ask for player name
        System.out.print("Enter you name >> ");
        player.setName(input.nextLine());
        System.out.printf("Your name is : %s\n", player.getName());

        // ask for spell abliity

        // random enemy encounter
        Enemy enemy = sampleData.getTestEnemy();

        final double maxPlayerHealth = player.health.getHealthPoints();
        final double maxEnemyHealth = enemy.health.getHealthPoints();

        boolean isRunning = true;
        while (isRunning) {
            // player anim (weapon dependant)

            System.out.printf("%s: %.0f / %.0f\n",player.getName(),player.health.getHealthPoints(),maxPlayerHealth);
            System.out.printf("%s: %.0f / %.0f\n\n",enemy.getName(),enemy.health.getHealthPoints(), maxEnemyHealth);


            // player action
            playerChoice(player,enemy,sampleData.getWeaponList());



                // players wins when enemy health is depleted
            if (enemy.health.getHealthPoints() == 0) {
                System.out.flush();
                System.out.println(
                        """
                                Player Wins!
                        """
                );
                isRunning = false;
            }

            // enemy attack
            enemy.attack(player);
            System.out.printf("%s lost %fHP!\n", player.getName(), enemy.getWeapon().getWeaponDamage());

            // enemy anim


                // enemy wins when player health is depleted
            if(player.health.getHealthPoints() == 0) {
                System.out.println(
                        """
                                You Lost!
                        """);
                isRunning = false;
            }

            System.out.flush();
        }



    }
}
