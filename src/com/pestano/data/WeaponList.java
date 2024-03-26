package com.pestano.data;

import com.pestano.pkg.Weapon;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class WeaponList {
    private final ArrayList<Weapon> weapons = new ArrayList<>();

    private final LinkedHashMap<String, Weapon> weaponsMap = new LinkedHashMap<>();

    public LinkedHashMap<String, Weapon> getWeaponsMap() {
        return weaponsMap;
    }

    public void printWeapons(){
        int colWidth = 12;

        System.out.printf("%s%s%s"," ID\t", "  Name\t",  "\t   Damage\n");
        System.out.println("=".repeat(colWidth * 2));
        for (Weapon i: this.weaponsMap.values()) {
            System.out.printf("[%s] ", String.format(i.getId()));
            System.out.printf("%s%s", i.getName(), ".".repeat( colWidth - i.getName().length()));
            System.out.printf(" %.2f\n",i.getWeaponDamage());
        }
    }

    private void createMap() {
        for (Weapon i: weapons) {
            weaponsMap.put(i.getId(),i);
        }
    }

    public WeaponList() {
        weapons.add(new Weapon("Fist", 5));
        weapons.add(new Weapon("Sword", 15));
        weapons.add(new Weapon("Axe", 20));
        weapons.add(new Weapon("Mace", 12));
        weapons.add(new Weapon("Bow", 8));
        weapons.add(new Weapon("Long Bow", 8));



        createMap();
        weapons.clear();
    }

}


