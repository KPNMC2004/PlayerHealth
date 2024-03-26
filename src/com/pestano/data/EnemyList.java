package com.pestano.data;

import com.pestano.pkg.Weapon;
import com.pestano.pkg.entities.Enemy;

import java.util.ArrayList;
import java.util.HashMap;

public class EnemyList {
    private static ArrayList<Enemy> enemyTypes = new ArrayList<>();

    public static ArrayList<Enemy> getEnemyTypes() {
        return enemyTypes;
    }

    public EnemyList() {
        WeaponList weaponList = new WeaponList();
        HashMap<String, Weapon> weaponMap = weaponList.getWeaponsMap();

        enemyTypes.add(new Enemy("Brute", 5, weaponMap.get("FIS")));
        enemyTypes.add(new Enemy("Macero", 5, weaponMap.get("MAC")));
        enemyTypes.add(new Enemy("Knight", 5, weaponMap.get("SWO")));
        enemyTypes.add(new Enemy("Archer", 5, weaponMap.get("BOW")));
    }
}
