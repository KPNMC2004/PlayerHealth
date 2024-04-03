package com.pestano.pkg.gameMechanics;

import com.pestano.data.SpellList;
import com.pestano.pkg.Spell;
import com.pestano.pkg.entities.Player;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public interface ChooseSpell extends PlayerChoice {

    @Override
    default void playerChoice(Player player) {
        Scanner input = new Scanner(System.in);
        int choice;

        while (true) {
            String choices =
                    """
                    \n
                    [1] Attack
                    [2] Change Spell
                    """;

            while (true) {
                System.out.println(choices);
                System.out.print(">> ");

                try {
                    choice = input.nextInt();
                    break;
                } catch (Exception InputException) {
                    System.out.println("Enter a number!");
                    input.next();
                }
            }

            switch (choice) {
                case 1:
                    player.attack(player.getTarget());
                    break;
                case 2:
                    chooseSpell(player);
                    break;
                default:
                    System.out.println("Invalid Input!");
                    continue;
            }
            break;
        }
    }

    default void chooseSpell (Player player) {
        Scanner input = new Scanner(System.in);
        SpellList spellList = SpellList.SpellList();
        HashMap<String, Spell> spellMap = spellList.getSpellMap();

        String choice = null;

        do {
            spellList.printSpells();
            System.out.print(">> ");
            try {
                choice = input.nextLine().substring(0,3).toUpperCase();
            } catch (Exception StringIndexOutOfBoundsException) {
                System.out.println("Input is too short");
            }

        } while (!spellMap.containsKey(choice));

        player.setSpell(spellMap.get(choice));
    }
}
