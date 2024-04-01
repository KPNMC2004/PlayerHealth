package com.pestano.pkg.entities;

import com.pestano.data.WeaponList;
import com.pestano.pkg.Entity;
import com.pestano.pkg.Weapon;
import com.pestano.pkg.health.PlayerHealth;

import java.util.Scanner;

public abstract class Player extends Entity {
    protected PlayerHealth health = new PlayerHealth();
    protected Enemy target;

    public void setHealth(double health) {
        this.getHealth().setHealthPoints(health);
    }

    public PlayerHealth getHealth() {
        return health;
    }

    // Attack
    public void attack(Enemy enemy) {
        enemy.getHealth().calculateHitPoints(super.getWeapon().getWeaponDamage());
    }

    public static void playerChoice(Player player, Enemy enemy, WeaponList weaponList) {
        Scanner playerInput = new Scanner(System.in);

        while (true) {
            String choices =
                    """
                            \n
                    [1] Attack\s
                    [2] Skip\s
                    [3] Shout out your name
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



    public Player(String playerName, double healthPoints, Weapon weapon, Enemy enemy) {
        super(playerName, weapon);
        setHealth(healthPoints);

    }

    public Player(String playerName, double healthPoints) {
        super(playerName);
        setHealth(healthPoints);
    }

    public Player(Weapon weapon) {
        super(weapon);
    }

}