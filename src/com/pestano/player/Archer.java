package com.pestano.player;

import com.pestano.data.WeaponList;
import com.pestano.pkg.entities.Enemy;
import com.pestano.pkg.entities.Player;
import com.pestano.pkg.gameMechanics.ChooseSpell;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Archer extends Player implements ChooseSpell {

    @Override
    public void attack(Enemy target) {
      Scanner input = new Scanner(System.in);
      int choice;
        while (true) {
            System.out.printf("""
                        [1] Shoot
                        [2] Hit
                        [3] Use Spell
                        [4] Choose Spell
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
                    shoot(target);
                    break;
                case 2:
                    hit(target);
                    break;
                case 3:
                    useSpell(target);
                case 4:
                    chooseSpell(this);
                default:
                    System.out.println("Invalid input!");
                    continue;
            }
            break;
        }
    }

    // Attack
    public void shoot(Enemy target) {

        Random random = new Random();
        int randInt = random.nextInt(10);

        if (randInt == 1) {
            System.out.printf("\n%s have missed!\n", this.getName());
        } else {
            System.out.printf("\n%s have shot %s with %.2f damage!\n", this.getName(), target.getName(), this.getWeapon().getWeaponDamage());
            target.getHealth().calculateHitPoints(this.getWeapon().getWeaponDamage());
        }

    }

    public void hit(Enemy target) {

        System.out.printf("\n%s have have hitted %s with your bow, causing %d damage!\n", this.getName(), target.getName(), this.MELEE_DAMAGE);
        target.getHealth().calculateHitPoints(this.MELEE_DAMAGE);
    }

    public void useSpell(Enemy target) {
        System.out.printf("\n%s has attacked %s with the %s spell, causing %d damage!\n", this.getName(), target.getName(), this.getSpell().getName().toLowerCase(), this.getSpell().getDamage());
        target.getHealth().calculateHitPoints(this.spell.getDamage());
    }

    public Archer(String name) {
        super(name, "Archer", 1500);
        WeaponList weaponList = WeaponList.WeaponList();

        chooseSpell(this);
        super.setWeapon(weaponList.getWeaponsMap().get("BOW"));
    }
}
