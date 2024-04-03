package com.pestano.data;

import com.pestano.pkg.Weapon;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class WeaponList {
    private static WeaponList singleInstance = null;
    private final ArrayList<Weapon> weaponList = new ArrayList<>();

    private final LinkedHashMap<String, Weapon> weaponsMap = new LinkedHashMap<>();

    public LinkedHashMap<String, Weapon> getWeaponsMap() {
        return weaponsMap;
    }

    public void printWeapons(){
        int colWidth = 12;

        System.out.printf("%s%s%s"," ID\t", "  Name\t",  "\t   Damage\n");
        System.out.println("=".repeat(colWidth * 2));
        for (Weapon i: this.weaponsMap.values()) {
            System.out.printf("[%s] ", String.format(i.getWeaponId()));
            System.out.printf("%s%s", i.getName(), ".".repeat( colWidth - i.getName().length()));
            System.out.printf(" %.2f\n",i.getWeaponDamage());
        }
    }

    private void createMap() {
        for (Weapon i: weaponList) {
            weaponsMap.put(i.getWeaponId(),i);
        }
    }

    private WeaponList() {
        weaponList.add(new Weapon("Fist", 7.5));
        weaponList.add(new Weapon("Sword", 8.5));
        weaponList.add(new Weapon("Axe", 10));
        weaponList.add(new Weapon("Mace", 6.75));
        weaponList.add(new Weapon("Bow", 15));

        createMap();
        weaponList.clear();
    }

    public static WeaponList WeaponList() {
        if (singleInstance == null) {
            singleInstance = new WeaponList();
        }
        return singleInstance;
    }
}

