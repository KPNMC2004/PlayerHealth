package com.pestano.player;

import com.pestano.data.SpellList;
import com.pestano.data.WeaponList;
import com.pestano.pkg.entities.Enemy;
import com.pestano.pkg.entities.Player;
import com.pestano.pkg.gameMechanics.ChooseWeapon;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Knight extends Player implements ChooseWeapon {

    @Override
    public void attack(Enemy target) {
        Scanner input = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.print("""
                        [1] Stab
                        [2] Slash
                        [3] Choose Weapon
                    """);
            System.out.print("How do you want to attack? >> ");

            try {
                choice = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Enter a number");
                continue;
            }

            switch (choice) {
                case 1:
                    stab(target);
                    break;
                case 2:
                    slash(target);
                    break;
                case 3:
                    chooseWeapon(this);
                default:
                    System.out.println("Invalid input!");
                    continue;
            }
            break;
        }
    }

    // Attack
    public void stab(Enemy target) {
        System.out.printf("\n%s have stabbed %s!, inflicting %.2f damage!\n", this.getName(), target.getName(), this.getWeapon().getWeaponDamage());
        target.getHealth().calculateHitPoints(this.getWeapon().getWeaponDamage());
    }

    public void slash(Enemy target) {
        System.out.printf("\n%s have slashed %s, inflicting %.2f damage!\n",this.getName(), target.getName(), this.getWeapon().getWeaponDamage());
        target.getHealth().calculateHitPoints(this.getWeapon().getWeaponDamage());
    }

    public Knight(String name) {
        super(name, "Knight", 2000);
        WeaponList weaponList = WeaponList.WeaponList();
        SpellList spellList = SpellList.SpellList();

        chooseWeapon(this);

        super.setSpell(spellList.getSpellMap().get("FIR"));
    }
}
