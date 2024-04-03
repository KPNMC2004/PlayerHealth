package com.pestano.pkg.gameMechanics;

import com.pestano.data.WeaponList;
import com.pestano.pkg.Weapon;
import com.pestano.pkg.entities.Enemy;
import com.pestano.pkg.entities.Player;

import java.util.HashMap;
import java.util.Scanner;

public interface ChooseWeapon extends PlayerChoice {

    @Override
    default void playerChoice(Player player) {
        Scanner playerInput = new Scanner(System.in);

        while (true) {
            String choices =
                    """
                    \n
                    [1] Attack
                    [2] Change Weapon
                    [3] Skip
                    [4] Shout out your name
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
                    WeaponList weaponList = WeaponList.WeaponList();
                    chooseWeapon(player);
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
        };
    }

    default void chooseWeapon (Player player) {
        Scanner input = new Scanner(System.in);
        WeaponList weaponList = WeaponList.WeaponList();
        HashMap<String, Weapon> weaponMap = weaponList.getWeaponsMap();

        String choice = null;

        do {
            weaponList.printWeapons();
            System.out.print(">> ");
            try {
                choice = input.nextLine().substring(0,3).toUpperCase();
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("Input is too short");
            }
        } while (!weaponMap.containsKey(choice));

        player.setWeapon(weaponMap.get(choice));
    }
}
